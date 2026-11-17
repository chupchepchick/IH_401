package com.telephonestation.reactive.repository;

import com.telephonestation.reactive.entity.Role;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {

    @Query("SELECT * FROM roles WHERE id = :id")
    Mono<Role> findById(Long id);

    @Query("SELECT * FROM roles WHERE name = :name")
    Mono<Role> findByName(String name);
}