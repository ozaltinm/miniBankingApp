package com.example.bankingapp.service;

import com.example.bankingapp.model.User;

public interface IUserService {

    User register(User user);

    boolean login(String username, String password);
}
