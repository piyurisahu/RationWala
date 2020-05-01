package com.app.rationwala.dto;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.itemPackageType;

import lombok.Data;

public @Data class Item {
	private Long id;
	private String itemName;
	private String itemBrand;
	private ItemCategoryType itemCategory;
	private itemPackageType packageType;
	private String itemType;
}
