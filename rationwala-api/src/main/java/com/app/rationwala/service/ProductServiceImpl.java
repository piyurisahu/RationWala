package com.app.rationwala.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.rationwala.model.Product;
import com.app.rationwala.modeller.UserProfileModeller;
import com.app.rationwala.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;

	private UserProfileModeller userProfileModeller;

	public ProductServiceImpl() {
		userProfileModeller = new UserProfileModeller();
	}

	@Override
	public Product getProduct(String productName) {
		return userProfileModeller.marshall(productRepository.findByProductId(productName));
	}

	@Override
	public List<Product> listProducts() {
		return productRepository.listProducts().stream().map(userProfileModeller::marshall)
				.collect(Collectors.toList());
	}

	@Override
	public Product addProduct(Product product) {
		return userProfileModeller.marshall(
				productRepository.save(new com.app.rationwala.entity.Product(product.getId(), product.getProductName(),
						product.getProductDescription(), product.getProductPrice(), product.getAvailable())));
	}
}
