package com.app.rationwala.api;

import com.app.rationwala.dto.AuthorizeStaffResponse;
import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.ProductResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.model.Product;
import com.app.rationwala.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@Slf4j
public class ProductController extends AbstractController {

	@Autowired
	private ProductService productService;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String index() {
		return "Please go to product methods";
	}

	@GetMapping(value = "product/{productName}", produces = "application/json")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable String productName) {
		ResponseEntity<ProductResponse> result = null;
		try {
			ProductResponse productRes = productService.getProduct(productName);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(productRes.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			result = new ResponseEntity<ProductResponse>(productRes, status);
		} catch (Exception e) {
			result = new ResponseEntity<ProductResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return result;
	}

	@GetMapping(value = "listAll", produces = "application/json")
	public ResponseEntity<ListEntity<Product>> listProducts() {
		ResponseEntity<ListEntity<Product>> res = null;
		try {
			ListEntity<Product> productRes = productService.listProducts();
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(productRes.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<ListEntity<Product>>(productRes, status);
		} catch (Exception e) {
			res = new ResponseEntity<ListEntity<Product>>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}

	@PostMapping(value = "add", produces = "application/json")
	public ResponseEntity<ProductResponse> add(@RequestBody Product productRequest) {
		ResponseEntity<ProductResponse> res = null;
		try {
			log.debug(mapper.writeValueAsString(productRequest));
			ProductResponse productRes = productService.addProduct(productRequest);
			HttpStatus status = HttpStatus.OK;
			if (Status.FAILURE.equals(productRes.getStatusInfo().getStatus()))
				status = HttpStatus.NOT_FOUND;
			res = new ResponseEntity<ProductResponse>(productRes, status);
		} catch (JsonProcessingException e) {
			res = new ResponseEntity<ProductResponse>(HttpStatus.BAD_REQUEST);
			log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
			log.error(e.getStackTrace().toString());
		}
		return res;
	}
}



