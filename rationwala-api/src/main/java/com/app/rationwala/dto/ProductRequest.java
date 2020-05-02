package com.app.rationwala.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public @Data class ProductRequest {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String productName;
        private String productDescription;
        private Double productPrice;
        private Boolean available;
}
