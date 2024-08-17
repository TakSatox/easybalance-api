package com.easybalance.easybalanceapi.transactiondetail.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybalance.easybalanceapi.transactiondetail.model.entity.TransactionDetail;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long>{
    
    List<TransactionDetail> findByTransaction_User_IdAndMonthAndYear(Long id, Integer month, Integer year);

    List<TransactionDetail> findByTransaction_User_IdAndMonthAndYearAndIsPaid(Long id, Integer month, Integer year, Boolean isPaid);

    List<TransactionDetail> findByTransaction_User_Id(Long id);
    
}
