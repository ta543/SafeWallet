package com.safewallet.walletapi.controller;

import com.safewallet.walletapi.model.Transaction;
import com.safewallet.walletapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@PreAuthorize("hasRole('USER')")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction, Principal principal) {
        return ResponseEntity.ok(transactionService.save(transaction, principal.getName()));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(Principal principal) {
        return ResponseEntity.ok(transactionService.findByUser(principal.getName()));
    }
}
