package com.easybalance.easybalanceapi.transaction.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
    List<Transaction> findByUser_Email(String email);

    List<Transaction> findByUser_Id(Long id);

}
