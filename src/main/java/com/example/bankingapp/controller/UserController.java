package com.example.bankingapp.controller;

import com.example.bankingapp.model.User;
import com.example.bankingapp.service.IJwtService;
import com.example.bankingapp.service.IUserService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IJwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        if (userService.login(loginRequest.getUsername(), loginRequest.getPassword())) {
            String token = jwtService.generateToken(loginRequest.getUsername()); // Token oluşturuluyor
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
