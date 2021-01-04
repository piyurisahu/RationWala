package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.GetSellerInventoryRequest;
import com.app.rationwala.dto.GetSellerInventoryResponse;
import com.app.rationwala.dto.UpdateSellerInventoryRequest;
import com.app.rationwala.dto.UpdateSellerInventoryResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("item")
@Slf4j
@Api(tags = { "Item API"}, value="ItemContoller", description="This controller contains all APIs realted to item such as get item inventory, get item etc.")
public class ItemContoller extends AbstractController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private Environment env;

	@ApiOperation(value="This is health check for api")
	@GetMapping("/")
	public String index() {
		return "Please go to item methods";
	}

	@ApiOperation(value="Get item inventory of a specific seller")
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
	
	@ApiOperation(value="Add item inventory for a specific seller")
	@PostMapping(value = "sellerInventory/add", produces = "application/json")
	public ResponseEntity<UpdateSellerInventoryResponse> addSellerInventory(@RequestBody UpdateSellerInventoryRequest updateSellerInventoryRequest) {
		ResponseEntity<UpdateSellerInventoryResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(updateSellerInventoryRequest));
			if(updateSellerInventoryRequest.getItemInventoryList() == null) {
				throw new Exception();
			}
			UpdateSellerInventoryResponse sres = itemService.addSellerInventory(updateSellerInventoryRequest);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(sres.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<UpdateSellerInventoryResponse>(sres, status);
		} catch (Exception e) {
			res = new ResponseEntity<UpdateSellerInventoryResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
	
	@ApiOperation(value="Update item inventory for a specific seller")
	@PostMapping(value = "sellerInventory/update", produces = "application/json")
	public ResponseEntity<UpdateSellerInventoryResponse> updateSellerInventory(@RequestBody UpdateSellerInventoryRequest updateSellerInventoryRequest) {
		ResponseEntity<UpdateSellerInventoryResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(updateSellerInventoryRequest));
			if(updateSellerInventoryRequest.getItemInventoryList() == null) {
				throw new Exception();
			}
			UpdateSellerInventoryResponse sres = itemService.addSellerInventory(updateSellerInventoryRequest);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(sres.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<UpdateSellerInventoryResponse>(sres, status);
		} catch (Exception e) {
			res = new ResponseEntity<UpdateSellerInventoryResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}