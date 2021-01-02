package com.app.rationwala.service;

import com.app.rationwala.dto.GetSellerInventoryRequest;
import com.app.rationwala.dto.GetSellerInventoryResponse;

public interface ItemService {

	public GetSellerInventoryResponse getAllSellerItems(GetSellerInventoryRequest getAllSellerItemsRequest);

}
