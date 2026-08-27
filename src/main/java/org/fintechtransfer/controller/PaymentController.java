package org.fintechtransfer.controller;

import org.fintechtransfer.dto.PaymentDto;
import org.fintechtransfer.dto.TopUpRequest;
import org.fintechtransfer.dto.WithdrawRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private PaymentSagaService sagaService;
    private IdempotencyService idempotencyService;
    private RateLimitService rateLimitService;
    private LedgerProperties properties;

    public PaymentController(IdempotencyService idempotencyService, PaymentSagaService sagaService, LedgerProperties properties, RateLimitService rateLimitService) {
        this.idempotencyService = idempotencyService;
        this.sagaService = sagaService;
        this.properties = properties;
        this.rateLimitService = rateLimitService;
    }

    public ResponseEntity<?> topUp(User, Long, TopUpRequest, String) {
    }

    public ResponseEntity<?> withdraw(User, Long, WithdrawRequest, String) {
    }

    public ResponseEntity<List<PaymentDto>> list(User) {
    }

    public ResponseEntity<PaymentDto> get(User, Long) {
    }
}