package com.telephonestation.reactive.service;

import com.telephonestation.reactive.entity.RolesHasUsers;
import com.telephonestation.reactive.entity.User;
import com.telephonestation.reactive.repository.RoleRepository;
import com.telephonestation.reactive.repository.RolesHasUsersRepository;
import com.telephonestation.reactive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;
    private final RolesHasUsersRepository rolesHasUsersRepository;
    private final RoleRepository roleRepository;

    public Flux<GrantedAuthority> getAuthorities(Long userId) {
        return rolesHasUsersRepository.findRoleIdsByUserId(userId)
                .flatMap(roleRepository::findById)
                .cast(GrantedAuthority.class);
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .flatMap(user ->
                        getAuthorities(user.getId())
                                .collectList()
                                .map(authorities -> {
                                    user.setAuthorities(new HashSet<>(authorities));
                                    return (UserDetails) user;
                                })
                );
    }

    public Mono<User> register(User newUser) {
        return userRepository.findByUsername(newUser.getUsername())
                .flatMap(existing -> Mono.<User>error(new RuntimeException("Користувач вже існує")))
                .switchIfEmpty(Mono.defer(() -> {
                    newUser.setId(null);
                    return userRepository.save(newUser)
                            .flatMap(savedUser -> roleRepository.findByName("ROLE_User")
                                    .flatMap(role -> rolesHasUsersRepository.save(new RolesHasUsers(role.getId(), savedUser.getId())))
                                    .thenReturn(savedUser)
                            );
                }));
    }
}