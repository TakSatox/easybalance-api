package com.easybalance.easybalanceapi.transaction.api.response;

import java.time.LocalDate;
import java.util.List;

import com.easybalance.easybalanceapi.transaction.model.entity.Transaction;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionResponse {
    
    @Schema(description = "Transaction ID", example = "1")
    private Long id;

    @Schema(description = "Transaction Title", example = "Netflix")
    private String title;

    @Schema(description = "Transaction Description", example = "Netflix Subscription")
    private String description;

    @Schema(description = "Transaction Payment Method", example = "credit card")
    private String paymentMethod;

    @Schema(description = "Transaction Type", example = "expense")
    private String type;

    @Schema(description = "Transaction Initial Date", example = "2024-04-01")
    private LocalDate initialDate;

    @Schema(description = "Transaction End Date", example = "2024-07-01")
    private LocalDate endDate;
    
    @Schema(description = "Transaction Category", example = "recurring-bill")
    private String category;
    

    public static TransactionResponse from(Transaction transaction) {
        return TransactionResponse.builder()
            .id(transaction.getId())
            .title(transaction.getTitle())
            .description(transaction.getDescription())
            .paymentMethod(transaction.getPaymentMethod())
            .type(transaction.getType())
            .initialDate(transaction.getInitialDate())
            .endDate(transaction.getEndDate())
            .category(transaction.getCategory().getTitle())
            .build();
    }

    public static List<TransactionResponse> fromList(List<Transaction> transactions) {
        return transactions.stream().map(TransactionResponse::from).toList();
    }

}
