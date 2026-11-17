package com.telephonestation.reactive.service;

import com.telephonestation.reactive.entity.Product;
import com.telephonestation.reactive.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Mono<Product> update(Long id, Product updated) {
        return productRepository.findById(id)
                .flatMap(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setDescription(updated.getDescription());
                    existing.setPrice(updated.getPrice());
                    existing.setStock(updated.getStock());
                    return productRepository.save(existing);
                });
    }

    public Mono<Void> delete(Long id) {
        return productRepository.deleteById(id);
    }
}