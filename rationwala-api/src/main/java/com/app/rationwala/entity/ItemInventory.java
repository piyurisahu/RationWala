package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

public @Entity @Data class ItemInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile sellerProfile;

	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	private String description;

	private double price;

	private int quantity;

	private String unit;
}
