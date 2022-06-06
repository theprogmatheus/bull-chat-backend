package com.github.theprogmatheus.bullchat.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bullchat_users")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "unique_id", nullable = false)
	private UUID uniqueID;

	@Column(nullable = false)
	private String username;

	@Column(name = "display_name", nullable = false)
	private String displayName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(name = "verified_email", nullable = false)
	private int verifiedEmail;

	@Column(name = "registration_time", nullable = false)
	private Date registrationTime;

}
