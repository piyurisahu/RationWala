package com.app.rationwala.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;
	private String password;

	@OneToOne(mappedBy = "userLogin")
	private UserProfile userProfile;

	protected UserLogin() {
	}

	public UserLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserLogin(Long userLoginId) {
		this.id = userLoginId;
	}

}