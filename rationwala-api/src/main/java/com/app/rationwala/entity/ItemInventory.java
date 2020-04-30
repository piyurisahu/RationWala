package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

public @Entity @Data class ItemInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	private UserProfile userProfile;
//
//	private Item item;
//
//	private double price;
//
//	private int quantity;
//
//	private String unit;
}
