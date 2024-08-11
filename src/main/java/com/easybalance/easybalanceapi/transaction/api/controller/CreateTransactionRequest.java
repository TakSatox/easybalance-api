package com.easybalance.easybalanceapi.transaction.api.controller;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateTransactionRequest {
    
    @Schema(description = "Transaction title", example = "Title")
    private String title;

    @Schema(description = "Transaction description", example = "Description")
    private String description;

    @Schema(description = "Transaction payment method", example = "credit-card, debit-card or cash")
    private String paymentMethod;

    @Schema(description = "Transaction type", example = "income or expense")
    private String type;

    @Schema(description = "Transaction initial date", example = "YYYY-MM-DD")
    private LocalDate initialDate;

    @Schema(description = "Transaction end date", example = "YYYY-MM-DD")
    private LocalDate endDate;

    @Schema(description = "Installment", example = "3")
    private Integer totalInstallment;

    @Schema(description = "Transaction value", example = "100.00")
    private Float value;

    @Schema(description = "Transaction category id", example = "1")
    private Long categoryId;

}
