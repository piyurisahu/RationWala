package com.app.rationwala.modeller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemPackageType;
import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.model.Item;
import com.app.rationwala.model.ItemInventory;

public class ItemModeller extends AbstractModeller {
	public List<ItemInventory> marshallItemInventory(Set<com.app.rationwala.entity.ItemInventory> itemInvent) {
		final List<ItemInventory> itemInventoryList;
		if (isNotNull(itemInvent) && !itemInvent.isEmpty()) {
			itemInventoryList = new ArrayList<>();
			itemInvent.forEach(itemInv -> {
				ItemInventory itemInventory = new ItemInventory();
				itemInventory.setDescription(itemInv.getDescription());
				itemInventory.setPrice(itemInv.getPrice());
				itemInventory.setQuantity(itemInv.getQuantity());
				itemInventory.setUnit(ItemUnitType.valueOf(itemInv.getUnit()));
				if (isNotNull(itemInv.getItem())) {
					itemInventory.setItem(new Item());
					itemInventory.getItem().setItemId(itemInv.getItem().getId());
					itemInventory.getItem().setItemBrand(itemInv.getItem().getItemBrand());
					itemInventory.getItem()
							.setItemCategory(ItemCategoryType.valueOf(itemInv.getItem().getItemCategory()));
					itemInventory.getItem().setItemName(itemInv.getItem().getItemName());
					itemInventory.getItem().setItemType(itemInv.getItem().getItemType());
					itemInventory.getItem().setPackageType(ItemPackageType.valueOf(itemInv.getItem().getPackageType()));
				}
				itemInventoryList.add(itemInventory);
			});
		} else {
			itemInventoryList = null;
		}
		return itemInventoryList;
	}
	
	public List<ItemInventory> marshallItemInventory(List<com.app.rationwala.entity.ItemInventory> itemInvent) {
		final List<ItemInventory> itemInventoryList;
		if (isNotNull(itemInvent) && !itemInvent.isEmpty()) {
			itemInventoryList = new ArrayList<>();
			itemInvent.forEach(itemInv -> {
				ItemInventory itemInventory = new ItemInventory();
				itemInventory.setDescription(itemInv.getDescription());
				itemInventory.setPrice(itemInv.getPrice());
				itemInventory.setQuantity(itemInv.getQuantity());
				itemInventory.setUnit(ItemUnitType.valueOf(itemInv.getUnit()));
				if (isNotNull(itemInv.getItem())) {
					itemInventory.setItem(new Item());
					itemInventory.getItem().setItemId(itemInv.getItem().getId());
					itemInventory.getItem().setItemBrand(itemInv.getItem().getItemBrand());
					itemInventory.getItem()
							.setItemCategory(ItemCategoryType.valueOf(itemInv.getItem().getItemCategory()));
					itemInventory.getItem().setItemName(itemInv.getItem().getItemName());
					itemInventory.getItem().setItemType(itemInv.getItem().getItemType());
					itemInventory.getItem().setPackageType(ItemPackageType.valueOf(itemInv.getItem().getPackageType()));
				}
				itemInventoryList.add(itemInventory);
			});
		} else {
			itemInventoryList = null;
		}
		return itemInventoryList;
	}
}
