package com.github.theprogmatheus.bullchat.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bullchat_messages")
@Data
public class MessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "author_id", nullable = false)
	private long authorId;

	@Column(name = "raw_message", nullable = false)
	private String rawMessage;

	@Column(name = "was_sent", nullable = false)
	private Date wasSent;

	@Column(name = "last_change", nullable = false)
	private Date lastChange;

}
