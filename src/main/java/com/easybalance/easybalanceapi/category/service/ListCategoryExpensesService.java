package com.easybalance.easybalanceapi.category.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.category.model.dto.UserCategoryExpensesDto;
import com.easybalance.easybalanceapi.transactiondetail.model.TransactionDetail;
import com.easybalance.easybalanceapi.transactiondetail.service.TransactionDetailService;
import com.easybalance.easybalanceapi.user.service.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ListCategoryExpensesService {

    private final TransactionDetailService transactionDetailService;
    private final UserService userService;
 
    
    public List<UserCategoryExpensesDto> getCategoryExpensesByUser(Long id, Integer month, Integer year) {
        return transactionDetailService.getAllByUserIdAndMonthAndYear(id, month, year).stream()
                .collect(Collectors.groupingBy(td -> td.getTransaction().getCategory()))
                .entrySet().stream()
                .map(entry -> UserCategoryExpensesDto.builder()
                        .id(entry.getKey().getId())
                        .title(entry.getKey().getTitle())
                        .totalValue((float) entry.getValue().stream().mapToDouble(TransactionDetail::getValue).sum())
                        .user(userService.getById(id))
                    .build())
            .collect(Collectors.toList());
    }
}
