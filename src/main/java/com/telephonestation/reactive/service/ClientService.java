package com.telephonestation.reactive.service;

import com.telephonestation.reactive.entity.Client;
import com.telephonestation.reactive.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    public Mono<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> create(Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    public Mono<Client> update(Long id, Client updated) {
        return clientRepository.findById(id)
                .flatMap(existing -> {
                    existing.setFirstName(updated.getFirstName());
                    existing.setLastName(updated.getLastName());
                    existing.setAge(updated.getAge());
                    return clientRepository.save(existing);
                });
    }

    public Mono<Void> delete(Long id) {
        return clientRepository.deleteById(id);
    }
}