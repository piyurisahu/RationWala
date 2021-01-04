package com.app.rationwala.dto;

import java.util.List;

import com.app.rationwala.model.ItemInventory;

import lombok.Data;

public @Data class UpdateSellerInventoryRequest {
	private List<ItemInventory> itemInventoryList;
}
