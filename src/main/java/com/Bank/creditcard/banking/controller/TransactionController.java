package com.Bank.creditcard.banking.controller;

import com.Bank.creditcard.banking.entity.Transaction;
import com.Bank.creditcard.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @GetMapping("/{gender}")
    public List<Transaction> getTransactionByGender(@PathVariable String gender){
        System.out.println(gender);
        return service.getTransactionsbyGender(gender);
    }

}
