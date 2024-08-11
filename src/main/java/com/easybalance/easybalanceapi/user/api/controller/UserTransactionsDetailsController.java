package com.easybalance.easybalanceapi.user.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.transactiondetail.api.response.TransactionDetailResponse;
import com.easybalance.easybalanceapi.transactiondetail.api.response.TransactionDetailTotalValueResponse;
import com.easybalance.easybalanceapi.transactiondetail.service.TransactionDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Transaction Details")
@Validated
public class UserTransactionsDetailsController {
    
    private final TransactionDetailService service;


    @Operation(summary = "List User Transactions", description = "List User Transactions")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{id}/transactions/details")
    public List<TransactionDetailResponse> list(
        @PathVariable("id") Long id,
        @RequestParam("month") Integer month,
        @RequestParam("year") Integer year,
        @RequestParam(name = "paid", required = false) Boolean isPaid
    ) {
        if(isPaid == null) {
            return TransactionDetailResponse.fromList(service.getAllByUserIdAndMonthAndYear(id, month, year));
        }

        return TransactionDetailResponse.fromList(service.getAllByUserIdAndMonthAndYearAndIsPaid(id, month, year, isPaid));
    }

    @Operation(summary = "List Total Values", description = "List total values by user, month and year")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{id}/transactions/details/totals")
    public TransactionDetailTotalValueResponse getTotalValue(
        @PathVariable("id") Long id,
        @RequestParam("month") Integer month,
        @RequestParam("year") Integer year
    ) {
        return TransactionDetailTotalValueResponse.from(service.getTotalValueByUserIdAndMonthAndYear(id, month, year));
    }


    @Operation(summary = "List Available Periods")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{id}/transactions/details/periods")
    public List<LocalDate> getAvailablePeriods(
        @PathVariable("id") Long id
    ) {
        return service.getAvailablePeriodsByUserId(id);
    }
    

}
