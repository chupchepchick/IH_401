package com.telephonestation.reactive.controller;

import com.telephonestation.reactive.entity.Client;
import com.telephonestation.reactive.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public Flux<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Client> getById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Mono<Client> create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    public Mono<Client> update(@PathVariable Long id, @RequestBody Client client) {
        return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return clientService.delete(id);
    }
}