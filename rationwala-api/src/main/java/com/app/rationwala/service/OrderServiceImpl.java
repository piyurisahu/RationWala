package com.app.rationwala.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.OrderItem;
import com.app.rationwala.entity.PurchaseOrder;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.modeller.ItemModeller;
import com.app.rationwala.repository.OrderItemRepository;
import com.app.rationwala.repository.PurchaseOrderRepository;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ItemModeller itemModeller;

	@Override
	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
		PlaceOrderResponse res = new PlaceOrderResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		double totalPrice = 0;
		Date date = Calendar.getInstance().getTime();
		PurchaseOrder po = purchaseOrderRepository
				.save(new PurchaseOrder(new UserProfile(placeOrderRequest.getBuyerProfileId()), totalPrice, date));
		placeOrderRequest.getItemInventoryList().forEach(itemInventory -> {
			orderItemRepository
					.save(new OrderItem(itemModeller.unMarshallItemInventory(itemInventory), po, itemInventory.getPrice(), itemInventory.getOrderCount()));

		});
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

}
