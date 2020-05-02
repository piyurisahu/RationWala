package com.app.rationwala.service;

import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.ProductResponse;
import com.app.rationwala.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ProductResponse getProduct(String productId);

    public ListEntity<Product> listProducts();

    public ProductResponse addProduct(Product product);
}
