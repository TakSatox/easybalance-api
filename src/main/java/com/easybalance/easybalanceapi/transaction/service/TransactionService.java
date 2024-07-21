package com.easybalance.easybalanceapi.transaction.service;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.transaction.model.TransactionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

}
