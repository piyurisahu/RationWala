package com.app.rationwala.model;

import java.util.List;

import lombok.Data;

public @Data class PurchaseOrder {
	private Long id;
	private UserProfile buyerProfile;
	private double totalPrice;
	private String purchaseDate;
	private String orderStatus;
	private List<ItemInventory> inventoryItemList;
}
