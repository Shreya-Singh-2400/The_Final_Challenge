package com.Bank.creditcard.banking.dao;


import com.Bank.creditcard.banking.entity.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDALMongoRepository extends MongoRepository<Transaction, ObjectId>{
    List<Transaction> findTransactionsByJob(String job);
    List<Transaction> findTransactionByGender(String gender);

}
