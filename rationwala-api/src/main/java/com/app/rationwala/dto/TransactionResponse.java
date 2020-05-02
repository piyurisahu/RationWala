package com.app.rationwala.dto;

import com.app.rationwala.entity.Product;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.StatusInfo;
import lombok.Data;

import javax.persistence.*;

public @Data class TransactionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UserProfile userProfile;

    private Product product;

    private int quantity;

    private StatusInfo statusInfo;

    public double getTotalPurchase() {
        if(this.product != null && this.product.getProductPrice() != null) {
            return this.quantity * (this.product.getProductPrice());
        } else
            return 0;

    }

    private double totalPurchase;


}
