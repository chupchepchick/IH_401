package com.telephonestation.reactive.repository;

import com.telephonestation.reactive.entity.Administrator;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AdministratorRepository extends ReactiveCrudRepository<Administrator, Long> {
}