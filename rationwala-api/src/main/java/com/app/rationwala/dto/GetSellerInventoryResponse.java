package com.app.rationwala.dto;

import java.util.List;

import com.app.rationwala.model.ItemInventory;
import com.app.rationwala.model.StatusInfo;

import lombok.Data;

public @Data class GetSellerInventoryResponse {
	private List<ItemInventory> itemInventoryList;
	private StatusInfo statusInfo;
}
