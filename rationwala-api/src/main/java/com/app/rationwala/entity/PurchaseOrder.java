package com.app.rationwala.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserProfile buyerProfile;

	@OneToMany(mappedBy = "purchaseOrder")
	private Set<OrderItem> orderItems;

	private double totalPrice;

	private Date purchaseDate;

	private String orderStatus;
	
	public PurchaseOrder() {}
	public PurchaseOrder(UserProfile buyerProfile, double totalPrice, Date date, String orderStatus) {
		this.buyerProfile = buyerProfile;
		this.totalPrice = totalPrice;
		this.purchaseDate = date;
		this.orderStatus = orderStatus;
	}
}
