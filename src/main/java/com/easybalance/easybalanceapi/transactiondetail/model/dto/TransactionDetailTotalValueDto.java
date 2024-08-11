package com.easybalance.easybalanceapi.transactiondetail.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionDetailTotalValueDto {
    
    private Float incomeTotalValue;
    private Float expenseTotalValue;

}
