package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	protected UserLogin() {
	}

	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

}