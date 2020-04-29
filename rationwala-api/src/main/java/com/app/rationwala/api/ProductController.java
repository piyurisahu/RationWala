package com.app.rationwala.api;

import com.app.rationwala.model.Product;
import com.app.rationwala.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController extends AbstractController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String index() {
		return "Please go to product methods";
	}

	@GetMapping(value = "product/{productName}", produces = "application/json")
	public String getProduct(@PathVariable String productName) {
		String result = null;
		try {
			result = mapper.writeValueAsString(productService.getProduct(productName));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "listAll", produces = "application/json")
	public String listProducts() {
		String result = null;
		try {
			result = mapper.writeValueAsString(productService.listProducts());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping(value = "add", produces = "application/json")
	public String register(@RequestBody Product product) {
		String result = null;
		try {
			result = mapper.writeValueAsString(productService.addProduct(product));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
