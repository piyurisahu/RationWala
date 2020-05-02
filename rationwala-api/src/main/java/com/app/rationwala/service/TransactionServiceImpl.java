package com.app.rationwala.service;

import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.ProductResponse;
import com.app.rationwala.dto.TransactionResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.entity.UserLogin;
import com.app.rationwala.entity.UserProfile;
import com.app.rationwala.model.Product;
import com.app.rationwala.model.StatusInfo;
import com.app.rationwala.model.Transaction;
import com.app.rationwala.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    public TransactionRepository transactionRepository;

    @Override
    public ListEntity<TransactionResponse> getTransaction(String userId) {
        log.error("In Transaction Service user id"+ userId);
        UserProfile val = new UserProfile();
        UserLogin userLogin = new UserLogin("", "");
        userLogin.setId(Long.parseLong(userId));
        val.setUserLogin(userLogin);
        val.setId(Long.parseLong(userId));

        List<com.app.rationwala.entity.Transaction> resList = transactionRepository.getTransactionForUser(val);
        ListEntity<TransactionResponse> resListVal = new ListEntity<>();
        resListVal.setItems(resList.stream().map(
               res -> {
                   log.error("In Transaction Service Loop " + res);
                   TransactionResponse transactionResponse = new TransactionResponse();
                   transactionResponse.setId(res.getId());
                   transactionResponse.setUserProfile(res.getUserProfile());
                   transactionResponse.setProduct(res.getProduct());
                   transactionResponse.setQuantity(res.getQuantity());
                   return transactionResponse;
               }
        ).collect(Collectors.toList()));
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setStatus(Status.SUCCESS);
        resListVal.setStatusInfo(statusInfo);
        return resListVal;
    }

    @Override
    public TransactionResponse add(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        com.app.rationwala.entity.Transaction res = transactionRepository
                .save(new com.app.rationwala.entity.Transaction(
                        transaction.getId(), transaction.getUserProfile(),
                        transaction.getProduct(), transaction.getQuantity())
                );
        transactionResponse.setId(res.getId());
        transactionResponse.setUserProfile(res.getUserProfile());
        transactionResponse.setProduct(res.getProduct());
        transactionResponse.setQuantity(res.getQuantity());
        StatusInfo statusInfo = new StatusInfo();
        statusInfo.setStatus(Status.SUCCESS);
        transactionResponse.setStatusInfo(statusInfo);
        return transactionResponse;

    }
}
