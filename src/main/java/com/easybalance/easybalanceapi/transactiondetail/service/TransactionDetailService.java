package com.easybalance.easybalanceapi.transactiondetail.service;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.transactiondetail.model.TransactionDetailRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionDetailService {
    
    private final TransactionDetailRepository transactionDetailRepository;

}
