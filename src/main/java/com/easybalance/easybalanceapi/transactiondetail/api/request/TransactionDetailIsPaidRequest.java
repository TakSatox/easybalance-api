package com.easybalance.easybalanceapi.transactiondetail.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionDetailIsPaidRequest {
    
    private Boolean isPaid;

}
