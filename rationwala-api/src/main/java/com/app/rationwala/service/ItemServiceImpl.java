package com.app.rationwala.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.app.rationwala.dto.GetSellerInventoryRequest;
import com.app.rationwala.dto.GetSellerInventoryResponse;
import com.app.rationwala.dto.UpdateSellerInventoryRequest;
import com.app.rationwala.dto.UpdateSellerInventoryResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.ItemInventory;
import com.app.rationwala.model.Message;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.modeller.ItemModeller;
import com.app.rationwala.repository.ItemInventoryRepository;
import com.app.rationwala.repository.ItemRepository;
import com.app.rationwala.repository.UserProfileRepository;

public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemInventoryRepository itemInventoryRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	ItemModeller itemModeller;
	
	@Autowired
	Environment env;
	
	@Override
	public GetSellerInventoryResponse getAllSellerItems(GetSellerInventoryRequest getAllSellerItemsRequest) {
		GetSellerInventoryResponse res = new GetSellerInventoryResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		List<ItemInventory> itemInventory = itemInventoryRepository.getInventoryBySellerId(getAllSellerItemsRequest.getSellerProfileId());
		if (null == itemInventory) {
			res.getStatusInfo().setStatus(Status.FAILURE);
			res.getStatusInfo().getMessages().add(new Message("ER000", env.getProperty("ER000")));
			return res;
		}
		res.setItemInventoryList(itemModeller.marshallItemInventory(itemInventory));
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

	@Override
	public UpdateSellerInventoryResponse addSellerInventory(UpdateSellerInventoryRequest updateSellerInventoryRequest) {
		UpdateSellerInventoryResponse res = new UpdateSellerInventoryResponse();
		res.setStatusInfo(new StatusInfo());
		res.getStatusInfo().setMessages(new ArrayList<>());
		itemModeller.unMarshallItemInventory(updateSellerInventoryRequest.getItemInventoryList()).forEach(itemInv->{
			itemInv.setItem(itemRepository.findById(itemInv.getItem().getId()).get());
			itemInv.setSellerProfile(userProfileRepository.findById(itemInv.getSellerProfile().getId()).get());
			itemInventoryRepository.save(itemInv);
		});
		res.getStatusInfo().setStatus(Status.SUCCESS);
		return res;
	}

}
