package com.app.rationwala.api;

import com.app.rationwala.dto.ListEntity;
import com.app.rationwala.dto.ProductResponse;
import com.app.rationwala.dto.TransactionResponse;
import com.app.rationwala.dto.enums.Status;
import com.app.rationwala.model.Product;
import com.app.rationwala.model.Transaction;
import com.app.rationwala.service.ProductService;
import com.app.rationwala.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transaction")
@RestController
@Slf4j
public class TransactionController  extends AbstractController{

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String index() {
        return "Please go to transaction methods";
    }

    @PostMapping(value = "add", produces = "application/json")
    public ResponseEntity<TransactionResponse> add(@RequestBody Transaction transactionRequest) {
        ResponseEntity<TransactionResponse> res = null;
        try {
            System.out.println(mapper.writeValueAsString(transactionRequest));
            TransactionResponse transactionResponse = transactionService.add(transactionRequest);
            HttpStatus status = HttpStatus.OK;
            if (Status.FAILURE.equals(transactionResponse.getStatusInfo().getStatus()))
                status = HttpStatus.NOT_FOUND;
            res = new ResponseEntity<TransactionResponse>(transactionResponse, status);
        } catch (JsonProcessingException e) {
            res = new ResponseEntity<TransactionResponse>(HttpStatus.BAD_REQUEST);
            log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
            log.error(e.getStackTrace().toString());
        }
        return res;
    }

    @GetMapping(value = "listAll/{userId}", produces = "application/json")
    public ResponseEntity<ListEntity<TransactionResponse>> listTransactionsUser(@PathVariable String userId) {
        ResponseEntity<ListEntity<TransactionResponse>> res = null;
        try {
            log.error("The Debug message userId"+ userId);
            log.error("The Debug message transactionService"+ transactionService);
            ListEntity<TransactionResponse> transResp = transactionService.getTransaction(userId);
            HttpStatus status = HttpStatus.OK;
            if (Status.FAILURE.equals(transResp.getStatusInfo().getStatus()))
                status = HttpStatus.NOT_FOUND;
            res = new ResponseEntity<ListEntity<TransactionResponse>>(transResp, status);
        } catch (Exception e) {
            res = new ResponseEntity<ListEntity<TransactionResponse>>(HttpStatus.BAD_REQUEST);
            log.warn(env.getProperty("warn.exception.occurred"), ": ", e.getMessage());
            System.err.println(e.getStackTrace());
        }
        return res;
    }

}
