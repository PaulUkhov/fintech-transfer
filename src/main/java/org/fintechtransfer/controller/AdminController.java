package org.fintechtransfer.controller;

import org.fintechtransfer.dto.ExchangeRateDto;
import org.fintechtransfer.dto.ExchangeRateUpdateRequest;
import org.fintechtransfer.dto.PaymentDto;
import org.fintechtransfer.dto.TransferDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private ExchangeRateService exchangeRateService;
    private TransferService transferService;
    private PaymentSagaService paymentSagaService;

    public AdminController(ExchangeRateService exchangeRateService, TransferService transferService, PaymentSagaService paymentSagaService) {
        this.exchangeRateService = exchangeRateService;
        this.transferService = transferService;
        this.paymentSagaService = paymentSagaService;
    }

    public ResponseEntity<ExchangeRateDto> upsertRate(ExchangeRateUpdateRequest exchangeRateUpdateRequest) {
    }

    public ResponseEntity<Void> deleteRate(String, String) {
    }

    public ResponseEntity<List<TransferDto>> allTransfers() {
    }

    public ResponseEntity<List<PaymentDto>> allPayments() {
    }
}


