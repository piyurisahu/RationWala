package com.app.rationwala.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;
import com.app.rationwala.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderContoller extends AbstractController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		return "Please go to order methods";
	}

	@PostMapping(value = "placeOrder", produces = "application/json")
	public ResponseEntity<PlaceOrderResponse> getSellerInventory(@RequestBody PlaceOrderRequest placeOrderRequest) {
		ResponseEntity<PlaceOrderResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(placeOrderRequest));
			if (placeOrderRequest.getBuyerProfileId() == null || placeOrderRequest.getItemInventoryList() == null
					|| placeOrderRequest.getItemInventoryList().isEmpty()) {
				throw new Exception();
			}
			PlaceOrderResponse pres = orderService.placeOrder(placeOrderRequest);
			HttpStatus status = HttpStatus.OK;
			res = new ResponseEntity<PlaceOrderResponse>(pres, status);
		} catch (Exception e) {
			res = new ResponseEntity<PlaceOrderResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}