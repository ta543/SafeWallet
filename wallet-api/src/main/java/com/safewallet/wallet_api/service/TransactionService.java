package com.safewallet.walletapi.service;

import com.safewallet.walletapi.model.Transaction;
import com.safewallet.walletapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction, String username) {
        transaction.setUserUsername(username);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findByUser(String username) {
        return transactionRepository.findByUserUsername(username);
    }
}
