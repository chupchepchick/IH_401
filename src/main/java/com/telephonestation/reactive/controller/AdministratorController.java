package com.telephonestation.reactive.controller;

import com.telephonestation.reactive.entity.Administrator;
import com.telephonestation.reactive.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/administrators")
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;

    @GetMapping
    public Flux<Administrator> getAll() {
        return administratorService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Administrator> getById(@PathVariable Long id) {
        return administratorService.findById(id);
    }

    @PostMapping
    public Mono<Administrator> create(@RequestBody Administrator administrator) {
        return administratorService.create(administrator);
    }

    @PutMapping("/{id}")
    public Mono<Administrator> update(@PathVariable Long id, @RequestBody Administrator administrator) {
        return administratorService.update(id, administrator);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return administratorService.delete(id);
    }
}