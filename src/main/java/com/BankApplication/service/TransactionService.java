package com.BankApplication.service;

import com.BankApplication.model.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByAccountId(Integer accountId);

    Transaction getTransactionById(Integer id);

    Transaction createTransaction(Transaction transaction);
}



