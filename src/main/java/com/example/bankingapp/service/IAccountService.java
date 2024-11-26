package com.example.bankingapp.service;

import com.example.bankingapp.model.Account;

import java.util.List;

public interface IAccountService {
    Account create(Account account);

    List<Account> search(String number, String name);

    Account update(String id, Account account);

    void delete(String id);

    Account getDetails(String id);
}
