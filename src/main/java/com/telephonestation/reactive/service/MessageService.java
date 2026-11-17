package com.telephonestation.reactive.service;

import com.telephonestation.reactive.entity.Message;
import com.telephonestation.reactive.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Flux<Message> list() {
        return messageRepository.findAll();
    }

    public Mono<Message> addOne(Message message) {
        message.setId(null);
        return messageRepository.save(message);
    }
}