package com.easybalance.easybalanceapi.transactiondetail.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.transactiondetail.model.TransactionDetail;
import com.easybalance.easybalanceapi.transactiondetail.model.TransactionDetailRepository;
import com.easybalance.easybalanceapi.transactiondetail.model.dto.TransactionDetailTotalValueDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TransactionDetailService {
    
    private final TransactionDetailRepository repository;

    
    public TransactionDetail save(TransactionDetail transactionDetail) {
        return repository.save(transactionDetail);
    }

    public List<TransactionDetail> saveAll(List<TransactionDetail> transactionDetails) {
        return repository.saveAll(transactionDetails);
    }
    
    
    public TransactionDetail findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public List<TransactionDetail> getAllByUserIdAndMonthAndYear(Long id, Integer month, Integer year) {
        return repository.findByTransaction_User_IdAndMonthAndYear(id, month, year);
    }
    
    public List<TransactionDetail> getAllByUserIdAndMonthAndYearAndIsPaid(Long id, Integer month, Integer year, Boolean isPaid) {
        return repository.findByTransaction_User_IdAndMonthAndYearAndIsPaid(id, month, year, isPaid);
    }
    
    public TransactionDetailTotalValueDto getTotalValueByUserIdAndMonthAndYear(Long id, Integer month, Integer year) {
        List<TransactionDetail> transactionDetails = getAllByUserIdAndMonthAndYear(id, month, year);
        
        Float incomeTotalValue = transactionDetails.stream()
        .filter(td -> td.getTransaction().getType().equals("income"))
        .map(TransactionDetail::getValue)
        .reduce(0f, Float::sum);
        
        Float expenseTotalValue = transactionDetails.stream()
        .filter(td -> td.getTransaction().getType().equals("expense"))
        .map(TransactionDetail::getValue)
        .reduce(0f, Float::sum);
        
        return TransactionDetailTotalValueDto.builder()
        .incomeTotalValue(incomeTotalValue)
        .expenseTotalValue(expenseTotalValue)
        .build();
        
    }

    public List<LocalDate> getAvailablePeriodsByUserId(Long id) {
        return repository.findByTransaction_User_Id(id).stream()
                .map(td -> LocalDate.of(td.getYear(), td.getMonth(), 1))
                .distinct()
                .sorted(Comparator.comparing(LocalDate::getYear).thenComparing(LocalDate::getMonthValue))
            .collect(Collectors.toList());
    }

    public void updateIsPaid(Long id, Boolean isPaid) {
        TransactionDetail transactionDetail = findById(id);
        transactionDetail.setIsPaid(isPaid);
        repository.save(transactionDetail);
    }
}
