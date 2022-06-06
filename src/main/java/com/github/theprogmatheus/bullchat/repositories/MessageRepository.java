package com.github.theprogmatheus.bullchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.theprogmatheus.bullchat.entities.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
