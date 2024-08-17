package com.easybalance.easybalanceapi.transaction.service;

import org.springframework.stereotype.Service;

import com.easybalance.easybalanceapi.category.service.CategoryService;
import com.easybalance.easybalanceapi.transaction.api.request.CreateTransactionRequest;
import com.easybalance.easybalanceapi.transaction.model.entity.Transaction;
import com.easybalance.easybalanceapi.transactiondetail.service.CreateTransactionDetailService;
import com.easybalance.easybalanceapi.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateTransactionService {

    private final TransactionService service;

    private final CategoryService categoryService;
    private final CreateTransactionDetailService createTransactionDetailService;
    private final UserService userService;
    
    
    public Transaction create(CreateTransactionRequest content, Long id) {
        Transaction newTransaction = service.save(
            Transaction.builder()
                .title(content.getTitle())
                .description(content.getDescription())
                .initialDate(content.getInitialDate())
                .endDate(content.getEndDate())
                .paymentMethod(content.getPaymentMethod())
                .type(content.getType())
                .category(categoryService.getById(content.getCategoryId()))
                .user(userService.getById(id))
            .build()
        );


        if (content.getTotalInstallment() != null) {
            createTransactionDetailService.createByInstallment(content.getInitialDate(), content.getTotalInstallment(), content.getValue(), newTransaction);

            return newTransaction;
        }

        createTransactionDetailService.createByEndDate(content.getInitialDate(), content.getEndDate(), content.getValue(), newTransaction);

        return newTransaction;
    }
}
