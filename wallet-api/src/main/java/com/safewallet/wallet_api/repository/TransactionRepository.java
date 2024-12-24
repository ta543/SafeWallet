package com.safewallet.walletapi.repository;

import com.safewallet.walletapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserUsername(String username);
}
