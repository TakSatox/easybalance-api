package com.easybalance.easybalanceapi.transactiondetail.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.transaction.model.Transaction;
import com.easybalance.easybalanceapi.transactiondetail.model.TransactionDetail;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class CreateTransactionDetailService {

    private final TransactionDetailService service;


    public List<TransactionDetail> createByInstallment(LocalDate initialDate, Integer totalInstallment, Float value, Transaction newTransaction) {
        List<TransactionDetail> transactionDetails = new ArrayList<>();
        Integer installment = 1;
        Float installmentValue = value / totalInstallment;
        
        for(LocalDate date = initialDate; date.isBefore(initialDate.plusMonths(totalInstallment)); date = date.plusMonths(1)) {
            transactionDetails.add(
                TransactionDetail.builder()
                    .month(date.getMonthValue())
                    .year(date.getYear())
                    .installment(installment++)
                    .value(installmentValue)
                    .isPaid(false)
                    .transaction(newTransaction)
                .build()
            );
        }

        return service.saveAll(transactionDetails);
    }

    public List<TransactionDetail> createByEndDate(LocalDate initialDate, LocalDate endDate, Float value, Transaction newTransaction) {
        List<TransactionDetail> transactionDetails = new ArrayList<>();
        Integer installment = 1;


        for(LocalDate date = initialDate; !date.isAfter(endDate); date = date.plusMonths(1)) {
            transactionDetails.add(
                TransactionDetail.builder()
                    .month(date.getMonthValue())
                    .year(date.getYear())
                    .installment(installment++)
                    .value(value)
                    .isPaid(false)
                    .transaction(newTransaction)
                .build()
            );
        }

        return service.saveAll(transactionDetails);
    }


}
