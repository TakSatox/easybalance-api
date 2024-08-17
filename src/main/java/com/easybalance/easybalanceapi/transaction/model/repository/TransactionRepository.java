package com.easybalance.easybalanceapi.transaction.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybalance.easybalanceapi.transaction.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    List<Transaction> findByUser_Email(String email);

    List<Transaction> findByUser_Id(Long id);

}
