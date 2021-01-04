package com.app.rationwala.service;

import com.app.rationwala.dto.ChangeOrderStatusRequest;
import com.app.rationwala.dto.ChangeOrderStatusResponse;
import com.app.rationwala.dto.GetOrderRequest;
import com.app.rationwala.dto.GetOrderResponse;
import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;

public interface OrderService {
	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);

	public GetOrderResponse getOrdersBySeller(GetOrderRequest placeOrderRequest);

	public GetOrderResponse getOrdersByBuyer(GetOrderRequest getOrderRequest);

	public ChangeOrderStatusResponse changeOrderStatus(ChangeOrderStatusRequest changeOrderStatusRequest);
}
