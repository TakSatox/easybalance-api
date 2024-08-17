package com.easybalance.easybalanceapi.transaction.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.transaction.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transactions")
@RequiredArgsConstructor
@Tag(name = "Transactions")
@Validated
public class TransactionController {
    
    private final TransactionService service;

    @Operation(summary = "Delete transaction", description = "Delete transaction and all details related to it")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "NO CONTENT")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") void updateIsPaid(
        @PathVariable("id") Long id
    ) {
        service.deleteById(id);
    }

}
