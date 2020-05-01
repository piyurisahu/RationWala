package com.app.rationwala.dto;

import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.model.Item;

import lombok.Data;

public @Data class ItemInventory {
	private Item item;
	private String description;
	private Double price;
	private Integer quantity;
	private ItemUnitType unit;
}
