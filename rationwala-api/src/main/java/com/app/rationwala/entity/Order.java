package com.app.rationwala.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

public @Entity @Data class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile buyerProfile;

	@ManyToOne(fetch = FetchType.LAZY)
	private ItemInventory itemInventory;

	private double price;

	private int quantity;

	private String unit;

	private Date date;

}
