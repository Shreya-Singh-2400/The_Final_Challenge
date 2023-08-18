package com.Bank.creditcard.banking.service;

import com.Bank.creditcard.banking.dao.TransactionDALMongoRepository;
import com.Bank.creditcard.banking.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionDALMongoRepository repo;
    public List<Transaction> getTransactionsbyGender(String gender)
    {return repo.findTransactionByGender(gender);}

}
