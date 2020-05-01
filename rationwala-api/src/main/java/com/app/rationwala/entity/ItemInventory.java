package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class ItemInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile sellerProfile;

	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	private String description;

	private Double price;

	private Integer quantity;

	private String unit;

	public ItemInventory() {
	}

	public ItemInventory(UserProfile userProfile, Item item, String description, Double price, Integer quantity,
			String unit) {
		this.sellerProfile = userProfile;
		this.item = item;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.unit = unit;
	}
}
