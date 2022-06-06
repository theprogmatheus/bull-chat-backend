package com.github.theprogmatheus.bullchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.theprogmatheus.bullchat.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
