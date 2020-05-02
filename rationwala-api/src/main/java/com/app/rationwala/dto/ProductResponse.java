package com.app.rationwala.dto;

import com.app.rationwala.model.StatusInfo;
import lombok.Data;

public @Data class ProductResponse {
    private Long id;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private boolean available;
    private StatusInfo statusInfo;
}
