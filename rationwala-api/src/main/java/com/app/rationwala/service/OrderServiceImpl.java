package com.app.rationwala.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.dto.ChangeOrderStatusRequest;
import com.app.rationwala.dto.ChangeOrderStatusResponse;
import com.app.rationwala.dto.GetOrderRequest;
import com.app.rationwala.dto.GetOrderResponse;
import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;
import com.app.rationwala.dto.enums.OrderStatusType;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.OrderItem;
import com.app.rationwala.entity.PurchaseOrder;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.ItemInventory;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.modeller.OrderModeller;
import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.repository.OrderItemRepository;
import com.app.rationwala.repository.PurchaseOrderRepository;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ItemInventoryRepository itemInventoryRepository;

	@Autowired
	private OrderModeller orderModeller;

	@Override
	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
		PlaceOrderResponse res = new PlaceOrderResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		double totalPrice = 0;
		for (ItemInventory ii : placeOrderRequest.getItemInventoryList()) {
			totalPrice += (ii.getPrice() * ii.getOrderCount());
		}
		Date date = Calendar.getInstance().getTime();
		PurchaseOrder po = purchaseOrderRepository
				.save(new PurchaseOrder(new UserProfile(placeOrderRequest.getBuyerProfileId()), totalPrice, date,
						OrderStatusType.PLACED.name()));
		placeOrderRequest.getItemInventoryList().forEach(itemInventory -> {
			orderItemRepository.save(new OrderItem(new com.app.rationwala.entity.ItemInventory(itemInventory.getId()),
					po, itemInventory.getPrice(), itemInventory.getOrderCount()));

		});
		placeOrderRequest.getItemInventoryList().forEach(itemInventory->{
			com.app.rationwala.entity.ItemInventory itinv = itemInventoryRepository.findById(itemInventory.getId()).get();
			itinv.setCountInStock(itinv.getCountInStock() - itemInventory.getOrderCount());
			itemInventoryRepository.save(itinv);
		});
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

	@Override
	public GetOrderResponse getOrdersByBuyer(GetOrderRequest getOrderRequest) {
		GetOrderResponse res = new GetOrderResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		List<PurchaseOrder> po = purchaseOrderRepository.findByBuyerId(getOrderRequest.getUserId());
		res.setPurchaseOrderList(orderModeller.marshallPurchaseOrder(po));
		if (res.getPurchaseOrderList() == null || res.getPurchaseOrderList().isEmpty())
			return res;
		res.getPurchaseOrderList().forEach(order -> {
			order.setInventoryItemList(
					orderModeller.marshallOrderItem(orderItemRepository.findByPurchaseOrder(order.getId())));
		});
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

	@Override
	public GetOrderResponse getOrdersBySeller(GetOrderRequest placeOrderRequest) {
		GetOrderResponse res = new GetOrderResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		res.setPurchaseOrderList(orderModeller.marshallPurchaseOrderToPurchaseOrder(
				orderItemRepository.findBySellerId(placeOrderRequest.getUserId())));
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

	@Override
	public ChangeOrderStatusResponse changeOrderStatus(ChangeOrderStatusRequest changeOrderStatusRequest) {
		ChangeOrderStatusResponse res = new ChangeOrderStatusResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		PurchaseOrder po = purchaseOrderRepository.findById(changeOrderStatusRequest.getPurchaseOrder().getId()).get();
		po.setOrderStatus(changeOrderStatusRequest.getPurchaseOrder().getOrderStatus());
		purchaseOrderRepository.save(po);
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

}
