package com.app.rationwala.service;

import java.util.List;
import java.util.stream.Collectors;

import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.ProductResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.model.StatusInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.model.Product;
import com.app.rationwala.modeller.ProfileModeller;
import com.app.rationwala.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;

	private ProfileModeller userProfileModeller;

	public ProductServiceImpl() {
		userProfileModeller = new ProfileModeller();
	}

	@Override
	public ProductResponse getProduct(String productName) {
		Product res = userProfileModeller.marshall(productRepository.findByProductId(productName));
		ProductResponse prodResp = new ProductResponse();
		prodResp.setId(res.getId());
		prodResp.setProductName(res.getProductName());
		prodResp.setProductDescription(res.getProductDescription());
		prodResp.setProductPrice(res.getProductPrice());
		prodResp.setAvailable(res.isAvailable());
		return prodResp;
	}

	@Override
	public ListEntity<Product> listProducts() {
		List<Product> prodList = productRepository.listProducts().stream().map(userProfileModeller::marshall)
				.collect(Collectors.toList());
		ListEntity<Product> res = new ListEntity<Product>();
		res.setItems(prodList);
		StatusInfo statusInfo = new StatusInfo();
		statusInfo.setStatus(Status.SUCCESS);
		res.setStatusInfo(statusInfo);
		return res;
	}

	@Override
	public ProductResponse addProduct(Product product) {
		Product res = userProfileModeller.marshall(
				productRepository.save(new com.app.rationwala.entity.Product(product.getId(), product.getProductName(),
						product.getProductDescription(), product.getProductPrice(), product.isAvailable())));
		ProductResponse prodResp = new ProductResponse();
		prodResp.setId(res.getId());
		prodResp.setProductName(res.getProductName());
		prodResp.setProductDescription(res.getProductDescription());
		prodResp.setProductPrice(res.getProductPrice());
		prodResp.setAvailable(res.isAvailable());
		StatusInfo statusInfo = new StatusInfo();
		statusInfo.setStatus(Status.SUCCESS);
		prodResp.setStatusInfo(statusInfo);
		return prodResp;
	}
}
