package com.app.rationwala.dto;

import com.app.rationwala.model.PurchaseOrder;

import lombok.Data;

public @Data class ChangeOrderStatusRequest {
	private PurchaseOrder purchaseOrder;
}
