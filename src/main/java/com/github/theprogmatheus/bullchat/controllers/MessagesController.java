package com.github.theprogmatheus.bullchat.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.theprogmatheus.bullchat.entities.MessageEntity;
import com.github.theprogmatheus.bullchat.repositories.MessageRepository;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessagesController {

	@Autowired
	private MessageRepository messageRepository;

	// enviar, alterar, recuperar, e excluir mensagens

	@GetMapping("/list")
	public List<MessageEntity> listMessages() {
		return this.messageRepository.findAll();
	}

	/*
	 * Required payload { author_id, raw_message }
	 */
	@PostMapping("/send_message")
	public MessageEntity sendMessage(@RequestBody MessageEntity messageEntity) {

		messageEntity.setWasSent(new Date());
		messageEntity.setLastChange(messageEntity.getWasSent());

		return messageRepository.save(messageEntity);
	}

	/*
	 * Required payload { id, raw_message }
	 */
	@PostMapping("/change_message")
	public MessageEntity changeMessage(@RequestBody MessageEntity messageEntity) {

		Optional<MessageEntity> actualMessageOptional = this.messageRepository.findById(messageEntity.getId());
		if (actualMessageOptional != null) {
			MessageEntity actualMessage = actualMessageOptional.get();

			actualMessage.setRawMessage(messageEntity.getRawMessage());
			return this.messageRepository.save(actualMessage);
		}

		return null;
	}

	@PostMapping("/delete_message/{id}")
	public void deleteMessage(@PathVariable long id) {
		this.messageRepository.deleteById(id);
	}

}
