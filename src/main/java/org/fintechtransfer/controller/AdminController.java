package org.fintechtransfer.controller;

import org.fintechtransfer.dto.ExchangeRateDto;
import org.fintechtransfer.dto.ExchangeRateUpdateRequest;
import org.fintechtransfer.dto.PaymentDto;
import org.fintechtransfer.dto.TransferDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin", description = "Admin operations: FX rates management and audit views")
public class AdminController {
    private ExchangeRateService exchangeRateService;
    private TransferService transferService;
    private PaymentSagaService paymentSagaService;

    public AdminController(ExchangeRateService exchangeRateService, TransferService transferService, PaymentSagaService paymentSagaService) {
        this.exchangeRateService = exchangeRateService;
        this.transferService = transferService;
        this.paymentSagaService = paymentSagaService;
    }

    @PutMapping("/exchange-rates")
    @Operation(summary = "Create or update an exchange rate")
    public ResponseEntity<ExchangeRateDto> upsertRate(@Valid @RequestBody ExchangeRateUpdateRequest request) {
        return ResponseEntity.ok(exchangeRateService.upsert(request));
    }

    @DeleteMapping("/exchange-rates/{base}/{quote}")
    @Operation(summary = "Delete an exchange rate")
    public ResponseEntity<Void> deleteRate(@PathVariable String base, @PathVariable String quote) {
        exchangeRateService.delete(base, quote);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/transfers")
    @Operation(summary = "All transfers (audit)")
    public ResponseEntity<List<TransferDto>> allTransfers() {
        return ResponseEntity.ok(transferService.listAll());
    }

    @GetMapping("/payments")
    @Operation(summary = "All payments (audit)")
    public ResponseEntity<List<PaymentDto>> allPayments() {
        return ResponseEntity.ok(paymentSagaService.listAll());
    }
}


