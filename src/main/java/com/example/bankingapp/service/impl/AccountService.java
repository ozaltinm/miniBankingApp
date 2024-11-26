package com.example.bankingapp.service.impl;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.repository.AccountRepository;
import com.example.bankingapp.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> search(String number, String name) {
        if (number != null) {                                      
            return accountRepository.findByNumber(number);
        } else if (name != null) {
            return accountRepository.findByName(name);
        }
        return accountRepository.findAll();
    }

    public Account update(String id, Account account) {
        UUID accountId = UUID.fromString(id);
        Account existingAccount = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
        existingAccount.setName(account.getName());
        existingAccount.setBalance(account.getBalance());
        return accountRepository.save(existingAccount);
    }

    public void delete(String id) {
        UUID accountId = UUID.fromString(id);
        accountRepository.deleteById(accountId);
    }

    public Account getDetails(String id) {
        UUID accountId = UUID.fromString(id); 
        return accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
