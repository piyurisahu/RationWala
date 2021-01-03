package com.app.rationwala.service;

import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;

public interface OrderService {
	public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}
