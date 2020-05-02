package com.app.rationwala.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private boolean available;

    public Product() {}

    public Product(Long id, String productName, String productDescription, Double productPrice, Boolean available) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.available = available;
    }
}
