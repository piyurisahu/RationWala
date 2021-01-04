package com.app.rationwala.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rationwala.dto.ChangeOrderStatusRequest;
import com.app.rationwala.dto.ChangeOrderStatusResponse;
import com.app.rationwala.dto.GetOrderRequest;
import com.app.rationwala.dto.GetOrderResponse;
import com.app.rationwala.dto.PlaceOrderRequest;
import com.app.rationwala.dto.PlaceOrderResponse;
import com.app.rationwala.service.OrderService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("order")
@Slf4j
@Api(tags = { "Order API"}, value="ItemContoller", description="This controller contains all APIs realted to order management such as place order or get order.")
public class OrderContoller extends AbstractController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Environment env;

	@ApiOperation(value="This is health check for api")
	@GetMapping("/")
	public String index() {
		return "Please go to order methods";
	}

	@ApiOperation(value="This api is used to place order by user")
	@PostMapping(value = "placeOrder", produces = "application/json")
	public ResponseEntity<PlaceOrderResponse> placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
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

	@ApiOperation(value="This API fetch order placed by buyer")
	@PostMapping(value = "buyer", produces = "application/json")
	public ResponseEntity<GetOrderResponse> getOrdersbyBuyer(@RequestBody GetOrderRequest getOrderRequest) {
		ResponseEntity<GetOrderResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(getOrderRequest));
			if (getOrderRequest.getUserId() == null) {
				throw new Exception();
			}
			GetOrderResponse gres = orderService.getOrdersByBuyer(getOrderRequest);
			HttpStatus status = HttpStatus.OK;
			res = new ResponseEntity<GetOrderResponse>(gres, status);
		} catch (Exception e) {
			res = new ResponseEntity<GetOrderResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}

	@ApiOperation(value="This API fetch the orders made by seller")
	@PostMapping(value = "seller", produces = "application/json")
	public ResponseEntity<GetOrderResponse> getOrdersbySeller(@RequestBody GetOrderRequest getOrderRequest) {
		ResponseEntity<GetOrderResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(getOrderRequest));
			if (getOrderRequest.getUserId() == null) {
				throw new Exception();
			}
			GetOrderResponse gres = orderService.getOrdersBySeller(getOrderRequest);
			HttpStatus status = HttpStatus.OK;
			res = new ResponseEntity<GetOrderResponse>(gres, status);
		} catch (Exception e) {
			res = new ResponseEntity<GetOrderResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}

	@ApiOperation(value="Seller updates order status")
	@PostMapping(value = "status/change", produces = "application/json")
	public ResponseEntity<ChangeOrderStatusResponse> changeOrderStatus(@RequestBody ChangeOrderStatusRequest changeOrderStatusRequest) {
		ResponseEntity<ChangeOrderStatusResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(changeOrderStatusRequest));
			if (changeOrderStatusRequest.getPurchaseOrder() == null) {
				throw new Exception();
			}
			ChangeOrderStatusResponse gres = orderService.changeOrderStatus(changeOrderStatusRequest);
			HttpStatus status = HttpStatus.OK;
			res = new ResponseEntity<ChangeOrderStatusResponse>(gres, status);
		} catch (Exception e) {
			res = new ResponseEntity<ChangeOrderStatusResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
	
}