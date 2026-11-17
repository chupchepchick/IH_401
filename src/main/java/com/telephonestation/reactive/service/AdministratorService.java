package com.telephonestation.reactive.service;

import com.telephonestation.reactive.entity.Administrator;
import com.telephonestation.reactive.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public Flux<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    public Mono<Administrator> findById(Long id) {
        return administratorRepository.findById(id);
    }

    public Mono<Administrator> create(Administrator administrator) {
        administrator.setId(null);
        return administratorRepository.save(administrator);
    }

    public Mono<Administrator> update(Long id, Administrator updated) {
        return administratorRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(updated.getName());
                    existing.setEmail(updated.getEmail());
                    return administratorRepository.save(existing);
                });
    }

    public Mono<Void> delete(Long id) {
        return administratorRepository.deleteById(id);
    }
}