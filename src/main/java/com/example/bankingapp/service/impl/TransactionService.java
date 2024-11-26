package com.example.bankingapp.service.impl;


import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.repository.TransactionRepository;
import com.example.bankingapp.service.ITransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction transfer(Transaction transaction) {
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setStatus(Transaction.Status.SUCCESS);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getHistory(String accountId) {
        UUID id = UUID.fromString(accountId);
        return transactionRepository.findByFromIdOrToId(id, id);
    }
}
