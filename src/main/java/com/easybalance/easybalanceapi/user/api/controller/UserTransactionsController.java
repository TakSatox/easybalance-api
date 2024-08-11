package com.easybalance.easybalanceapi.user.api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybalance.easybalanceapi.transaction.api.controller.CreateTransactionRequest;
import com.easybalance.easybalanceapi.transaction.api.response.TransactionResponse;
import com.easybalance.easybalanceapi.transaction.service.CreateTransactionService;
import com.easybalance.easybalanceapi.transaction.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Transactions")
@Validated
public class UserTransactionsController {
    
    private final TransactionService service;
    private final CreateTransactionService createService;


    @Operation(summary = "List User Transactions", description = "List User Transactions")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/{id}/transactions")
    public List<TransactionResponse> list(
        @Parameter(name = "id", description = "user id", schema = @Schema(type = "integer"))
        @PathVariable("id") Long id
    ) {
        return TransactionResponse.fromList(service.getByUserId(id));
    }


    @Operation(summary = "Create User Transaction")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "CREATED")
    })
    @PostMapping("/{id}/transactions")
    public TransactionResponse create(
        @Parameter(name = "id", description = "user id", schema = @Schema(type = "integer"))
        @PathVariable("id") Long id,
        @Parameter(name = "Create Request", description = "Creation Data", schema = @Schema(implementation = CreateTransactionRequest.class)) 
        @RequestBody CreateTransactionRequest request
    ) {
        return TransactionResponse.from(createService.create(request, id));
    }




}
