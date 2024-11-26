package com.example.bankingapp.service;

import com.example.bankingapp.model.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction transfer(Transaction transaction);

    List<Transaction> getHistory(String accountId);
}
