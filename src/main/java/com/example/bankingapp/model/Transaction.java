package com.example.bankingapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account from;

    @ManyToOne
    private Account to;

    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        SUCCESS, FAILED
    }
}
