package com.example.bankingapp.repository;

import com.example.bankingapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByFromIdOrToId(UUID fromAccountId, UUID toAccountId);

    List<Transaction> findByFromIdOrToIdOrderByTransactionDateDesc(UUID fromAccountId, UUID toAccountId);
}
