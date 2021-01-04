package com.app.rationwala.modeller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.dto.enums.ItemCategoryType;
import com.app.rationwala.dto.enums.ItemPackageType;
import com.app.rationwala.dto.enums.ItemUnitType;
import com.app.rationwala.model.Item;
import com.app.rationwala.model.ItemInventory;
import com.app.rationwala.model.PurchaseOrder;

public class OrderModeller extends AbstractModeller {

	@Autowired
	private ProfileModeller profileModeller;

	public List<PurchaseOrder> marshallPurchaseOrder(List<com.app.rationwala.entity.PurchaseOrder> purchaseOrder) {
		final List<PurchaseOrder> purchaseOrderList;
		if (isNotNull(purchaseOrder) && !purchaseOrder.isEmpty()) {
			purchaseOrderList = new ArrayList<>();
			purchaseOrder.forEach(purOrder -> {
				PurchaseOrder order = marshallPurchaseOrder(purOrder);
				purchaseOrderList.add(order);
			});
		} else {
			purchaseOrderList = null;
		}
		return purchaseOrderList;
	}

	private PurchaseOrder marshallPurchaseOrder(com.app.rationwala.entity.PurchaseOrder purOrder) {
		PurchaseOrder order = new PurchaseOrder();
		order.setPurchaseDate(new SimpleDateFormat("dd MMM yy").format(purOrder.getPurchaseDate()));
		order.setId(purOrder.getId());
		order.setOrderStatus(purOrder.getOrderStatus());
		order.setTotalPrice(purOrder.getTotalPrice());
		order.setBuyerProfile(profileModeller.marshallUserProfile(purOrder.getBuyerProfile()));
		return order;
	}

	public List<ItemInventory> marshallOrderItem(List<com.app.rationwala.entity.OrderItem> orderItem) {
		final List<ItemInventory> itemInventoryList;
		if (isNotNull(orderItem) && !orderItem.isEmpty()) {
			itemInventoryList = new ArrayList<>();
			orderItem.forEach(orderI -> {
				if (isNotNull(orderI.getItemInventory())) {
					ItemInventory itemInventory = new ItemInventory();
					itemInventory.setId(orderI.getItemInventory().getId());
					itemInventory.setDescription(orderI.getItemInventory().getDescription());
					itemInventory.setPrice(orderI.getItemInventory().getPrice());
					itemInventory.setCountInStock(orderI.getItemInventory().getCountInStock());
					itemInventory.setQuantity(orderI.getItemInventory().getQuantity());
					itemInventory.setUnit(ItemUnitType.valueOf(orderI.getItemInventory().getUnit()));
					itemInventory.setOrderCount(orderI.getOrderCount());
					itemInventory.setSellerProfile(
							profileModeller.marshallUserProfile(orderI.getItemInventory().getSellerProfile()));
					if (isNotNull(orderI.getItemInventory().getItem())) {
						itemInventory.setItem(new Item());
						itemInventory.getItem().setItemId(orderI.getItemInventory().getItem().getId());
						itemInventory.getItem().setItemBrand(orderI.getItemInventory().getItem().getItemBrand());
						itemInventory.getItem().setItemCategory(
								ItemCategoryType.valueOf(orderI.getItemInventory().getItem().getItemCategory()));
						itemInventory.getItem().setItemName(orderI.getItemInventory().getItem().getItemName());
						itemInventory.getItem().setItemType(orderI.getItemInventory().getItem().getItemType());
						itemInventory.getItem().setPackageType(
								ItemPackageType.valueOf(orderI.getItemInventory().getItem().getPackageType()));
					}
					itemInventoryList.add(itemInventory);
				}
			});
		} else {
			itemInventoryList = null;
		}
		return itemInventoryList;
	}
	
	public List<PurchaseOrder> marshallPurchaseOrderToPurchaseOrder(List<com.app.rationwala.entity.OrderItem> orderItem) {
		Map<Long, PurchaseOrder> purchaseOrders = new HashMap<>();
		if (isNotNull(orderItem) && !orderItem.isEmpty()) {
			orderItem.forEach(orderI -> {
				PurchaseOrder po;
				if(!purchaseOrders.containsKey(orderI.getPurchaseOrder().getId())) {
					po = marshallPurchaseOrder(orderI.getPurchaseOrder());
					purchaseOrders.put(orderI.getPurchaseOrder().getId(), po);
				}else {
					po = purchaseOrders.get(orderI.getPurchaseOrder().getId());
				}
				if(po.getInventoryItemList() == null) {
					po.setInventoryItemList(new ArrayList<>());
				}
				
				if (isNotNull(orderI.getItemInventory())) {
					ItemInventory itemInventory = new ItemInventory();
					itemInventory.setId(orderI.getItemInventory().getId());
					itemInventory.setDescription(orderI.getItemInventory().getDescription());
					itemInventory.setPrice(orderI.getItemInventory().getPrice());
					itemInventory.setCountInStock(orderI.getItemInventory().getCountInStock());
					itemInventory.setQuantity(orderI.getItemInventory().getQuantity());
					itemInventory.setUnit(ItemUnitType.valueOf(orderI.getItemInventory().getUnit()));
					itemInventory.setOrderCount(orderI.getOrderCount());
					itemInventory.setSellerProfile(
							profileModeller.marshallUserProfile(orderI.getItemInventory().getSellerProfile()));
					if (isNotNull(orderI.getItemInventory().getItem())) {
						itemInventory.setItem(new Item());
						itemInventory.getItem().setItemId(orderI.getItemInventory().getItem().getId());
						itemInventory.getItem().setItemBrand(orderI.getItemInventory().getItem().getItemBrand());
						itemInventory.getItem().setItemCategory(
								ItemCategoryType.valueOf(orderI.getItemInventory().getItem().getItemCategory()));
						itemInventory.getItem().setItemName(orderI.getItemInventory().getItem().getItemName());
						itemInventory.getItem().setItemType(orderI.getItemInventory().getItem().getItemType());
						itemInventory.getItem().setPackageType(
								ItemPackageType.valueOf(orderI.getItemInventory().getItem().getPackageType()));
					}
					po.getInventoryItemList().add(itemInventory);
				}
			});
		}
		return new ArrayList<PurchaseOrder>(purchaseOrders.values());
	}
}
