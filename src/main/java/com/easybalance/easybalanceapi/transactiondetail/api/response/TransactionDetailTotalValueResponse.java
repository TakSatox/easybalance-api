package com.easybalance.easybalanceapi.transactiondetail.api.response;

import com.easybalance.easybalanceapi.transactiondetail.model.dto.TransactionDetailTotalValueDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionDetailTotalValueResponse {

    private Float balanceValue;
    private Float incomeTotalValue;
    private Float expenseTotalValue;


    public static TransactionDetailTotalValueResponse from(TransactionDetailTotalValueDto dto) {
        return TransactionDetailTotalValueResponse.builder()
                .balanceValue(dto.getIncomeTotalValue() - dto.getExpenseTotalValue())
                .incomeTotalValue(dto.getIncomeTotalValue())
                .expenseTotalValue(dto.getExpenseTotalValue())
            .build();
    }



}
