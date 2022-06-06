package com.github.theprogmatheus.bullchat.controllers;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.theprogmatheus.bullchat.entities.UserEntity;
import com.github.theprogmatheus.bullchat.repositories.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin // remove this annotation...
public class UserController {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Payload has not required, only id on Path
	 */
	@GetMapping("/find_user/{id}")
	public UserEntity findUser(@PathVariable long id) {

		Optional<UserEntity> optional = this.userRepository.findById(id);

		if (optional != null)
			return optional.get();

		return null;
	}

	/*
	 * Required payload { username, email, password }
	 */
	@PostMapping("/create_account")
	public UserEntity createAccount(@RequestBody UserEntity userEntity) {

		// This is a simple create account method.

		userEntity.setUniqueID(UUID.randomUUID());
		userEntity.setDisplayName(userEntity.getUsername());
		userEntity.setVerifiedEmail(0);
		userEntity.setRegistrationTime(new Date());

		return userRepository.save(userEntity);
	}

}
