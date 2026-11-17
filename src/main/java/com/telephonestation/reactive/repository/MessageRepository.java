package com.telephonestation.reactive.repository;

import com.telephonestation.reactive.entity.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}