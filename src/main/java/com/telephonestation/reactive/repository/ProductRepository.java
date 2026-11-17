package com.telephonestation.reactive.repository;

import com.telephonestation.reactive.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}