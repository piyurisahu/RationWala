package com.app.rationwala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter @Entity class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String itemName;
	private String itemBrand;
	private String itemCategory;
	private String packageType;
	private String itemType;

	public Item() {
	}

	public Item(String itemName, String itemBrand, String itemCategory, String packageType, String itemType) {
		super();
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.itemCategory = itemCategory;
		this.packageType = packageType;
		this.itemType = itemType;
	}

	public Item(Long id) {
		this.id = id;
	}

}
