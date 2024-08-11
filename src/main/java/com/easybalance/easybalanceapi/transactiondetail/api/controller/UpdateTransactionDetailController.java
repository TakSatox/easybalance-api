package com.easybalance.easybalanceapi.transactiondetail.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.transactiondetail.service.TransactionDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transactions/details")
@RequiredArgsConstructor
@Tag(name = "Transactions Detail")
@Validated
public class UpdateTransactionDetailController {

    private final TransactionDetailService service;

    @Operation(summary = "Update is paid")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "NO CONTENT")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/paid") void updateIsPaid(
        @PathVariable("id") Long id,
        @RequestBody TransactionDetailUpdateIsPaidRequest request
    ) {
        service.updateIsPaid(id, request.getIsPaid());
    }
}
