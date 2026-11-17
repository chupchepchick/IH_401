package com.telephonestation.reactive.controller;

import com.telephonestation.reactive.entity.Product;
import com.telephonestation.reactive.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return productService.delete(id);
    }
}