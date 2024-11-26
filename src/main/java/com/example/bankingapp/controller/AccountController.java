package com.example.bankingapp.controller;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping
    public List<Account> searchAccounts(@RequestParam(required = false) String number,
                                        @RequestParam(required = false) String name) {
        return accountService.search(number, name);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable String id, @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.delete(id);
    }

    @GetMapping("/{id}")
    public Account getAccountDetails(@PathVariable String id) {
        return accountService.getDetails(id);
    }
}
