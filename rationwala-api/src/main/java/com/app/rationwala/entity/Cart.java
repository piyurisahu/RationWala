package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile buyerProfile;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemInventory itemInventory;

	private int quantity;

}
