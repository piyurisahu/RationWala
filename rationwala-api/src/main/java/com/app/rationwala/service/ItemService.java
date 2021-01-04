package com.app.rationwala.service;

import com.app.rationwala.dto.GetSellerInventoryRequest;
import com.app.rationwala.dto.GetSellerInventoryResponse;
import com.app.rationwala.dto.UpdateSellerInventoryRequest;
import com.app.rationwala.dto.UpdateSellerInventoryResponse;

public interface ItemService {

	public GetSellerInventoryResponse getAllSellerItems(GetSellerInventoryRequest getAllSellerItemsRequest);

	public UpdateSellerInventoryResponse addSellerInventory(UpdateSellerInventoryRequest updateSellerInventoryRequest);

}
