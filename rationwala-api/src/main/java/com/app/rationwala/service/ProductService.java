package com.app.rationwala.service;

import com.app.rationwala.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product getProduct(String productId);

    public List<Product> listProducts();

    public Product addProduct(Product product);
}
