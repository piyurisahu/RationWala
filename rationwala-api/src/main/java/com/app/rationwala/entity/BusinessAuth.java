package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

public @Entity @Data class BusinessAuth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private UserProfile businessProfile;

	@ManyToOne
	private UserProfile staff;

	private String businessAuthType;
}
