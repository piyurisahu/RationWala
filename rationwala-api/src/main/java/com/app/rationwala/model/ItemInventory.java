package com.app.rationwala.model;

import com.app.rationwala.dto.enums.ItemUnitType;

import lombok.Data;

public @Data class ItemInventory {
	private Long Id;
	private UserProfile sellerProfile;
	private Item item;
	private String description;
	private double price;
	private int countInStock;
	private int quantity;
	private int orderCount;
	private ItemUnitType unit;
}
