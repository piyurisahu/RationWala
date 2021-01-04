package com.app.rationwala.dto;

import java.util.List;

import com.app.rationwala.model.PurchaseOrder;
import com.app.rationwala.model.StatusInfo;

import lombok.Data;

public @Data class GetOrderResponse {
	private List<PurchaseOrder> purchaseOrderList;
	private StatusInfo statusInfo;
}
