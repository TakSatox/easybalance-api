package com.easybalance.easybalanceapi.transactiondetail.api.response;

import java.util.List;

import com.easybalance.easybalanceapi.transaction.model.entity.Transaction;
import com.easybalance.easybalanceapi.transactiondetail.model.entity.TransactionDetail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Schema(description = "Transaction Detail Response")
public class TransactionDetailResponse {
    
    @Schema(description = "Transaction Detail ID", example = "1")
    private Long id;

    @Schema(description = "Transaction Detail Month", example = "4")
    private Integer month;

    @Schema(description = "Transaction Detail Year", example = "2024")
    private Integer year;

    @Schema(description = "Transaction Detail Installment", example = "1")
    private Integer installment;

    @Schema(description = "Transaction Detail Paid", example = "true")
    private Boolean isPaid;

    @Schema(description = "Transaction Detail Value", example = "10.0")
    private Float value;

    @Schema(description = "Transaction Detail Transaction", contentSchema = Transaction.class)
    private Transaction transaction;


    public static TransactionDetailResponse from(TransactionDetail entity) {
        return TransactionDetailResponse.builder()
            .id(entity.getId())
            .month(entity.getMonth())
            .year(entity.getYear())
            .installment(entity.getInstallment())
            .isPaid(entity.getIsPaid())
            .value(entity.getValue())
            .transaction(entity.getTransaction())
            .build();
    }

    public static List<TransactionDetailResponse> fromList(List<TransactionDetail> entities) {
        return entities.stream().map(TransactionDetailResponse::from).toList();
    }

}
