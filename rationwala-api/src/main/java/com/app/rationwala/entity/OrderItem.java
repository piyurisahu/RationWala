package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemInventory itemInventory;

	@ManyToOne(fetch = FetchType.LAZY)
	private PurchaseOrder purchaseOrder;

	private double price;

	private int orderCount;
	
	public OrderItem(ItemInventory itemInventory, PurchaseOrder purchaseOrder, double price,
			int orderCount) {
		this.itemInventory = itemInventory;
		this.purchaseOrder = purchaseOrder;
		this.price = price;
		this.orderCount = orderCount;
	}

	public OrderItem(com.app.rationwala.model.ItemInventory itemInventory2, PurchaseOrder po, double price2,
			int orderCount2) {
		// TODO Auto-generated constructor stub
	}

}
