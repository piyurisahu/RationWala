package com.app.rationwala.service;

import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.TransactionResponse;
import com.app.rationwala.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    public TransactionResponse add(Transaction transaction);
    ListEntity<TransactionResponse> getTransaction(String userId);
}
