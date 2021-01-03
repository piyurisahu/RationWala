package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.GetSellerInventoryRequest;
import com.app.rationwala.dto.GetSellerInventoryResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("item")
@Slf4j
public class ItemContoller extends AbstractController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		return "Please go to item methods";
	}
	
	@PostMapping(value = "sellerInventory", produces = "application/json")
	public ResponseEntity<GetSellerInventoryResponse> getSellerInventory(@RequestBody GetSellerInventoryRequest getAllSellerItemsRequest) {
		ResponseEntity<GetSellerInventoryResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(getAllSellerItemsRequest));
			if(getAllSellerItemsRequest.getSellerProfileId() == null) {
				throw new Exception();
			}
			GetSellerInventoryResponse sres = itemService.getAllSellerItems(getAllSellerItemsRequest);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(sres.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<GetSellerInventoryResponse>(sres, status);
		} catch (Exception e) {
			res = new ResponseEntity<GetSellerInventoryResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}