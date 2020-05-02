package com.app.rationwala.model;

import com.app.rationwala.dto.enums.ItemUnitType;

import lombok.Data;

public @Data class ItemInventory {
	private Item item;
	private String description;
	private Double price;
	private Integer quantity;
	private ItemUnitType unit;
}
