package com.example.bankingapp.repository;

import com.example.bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    // Hesap numarasına göre hesap arama
    List<Account> findByNumber(String number);

    // Hesap adına göre hesap arama
    List<Account> findByName(String name);

    // Kullanıcıya ait tüm hesapları getirme
    List<Account> findByUserId(UUID userId);

    // Hesap numarasına ve adına göre filtreleme
    List<Account> findByNumberAndName(String number, String name);
}
