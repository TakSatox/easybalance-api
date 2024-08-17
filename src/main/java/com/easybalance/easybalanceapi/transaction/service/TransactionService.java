package com.easybalance.easybalanceapi.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.transaction.model.entity.Transaction;
import com.easybalance.easybalanceapi.transaction.model.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionService {
    
    private final TransactionRepository repository;


    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getByUserId(Long id) {
        return repository.findByUser_Id(id);
    }

    public List<Transaction> getByUserEmail(String email) {
        return repository.findByUser_Email(email);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
