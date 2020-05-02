package com.app.rationwala.model;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemPackageType;

import lombok.Data;

public @Data class Item {
	private Long itemId;
	private String itemName;
	private String itemBrand;
	private ItemCategoryType itemCategory;
	private ItemPackageType packageType;
	private String itemType;
}
