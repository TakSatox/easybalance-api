package com.easybalance.easybalanceapi.transactiondetail.api.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionDetailUpdateIsPaidRequest {
    
    private Boolean isPaid;

}
