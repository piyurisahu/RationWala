package com.app.rationwala.service;

import org.springframework.stereotype.Service;

import com.app.rationwala.dto.GetAllSellersRequest;
import com.app.rationwala.dto.GetAllSellersResponse;

@Service
public interface UserService {
	public GetAllSellersResponse getAllSellers(GetAllSellersRequest getAllSellersRequest);

}
