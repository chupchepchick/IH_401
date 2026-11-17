package com.telephonestation.reactive.repository;

import com.telephonestation.reactive.entity.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {
}