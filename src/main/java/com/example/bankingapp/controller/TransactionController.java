package com.example.bankingapp.controller;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/transfer")
    public Transaction transferMoney(@RequestBody Transaction transaction) {
        return transactionService.transfer(transaction);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactionHistory(@PathVariable String accountId) {
        return transactionService.getHistory(accountId);
    }
}
