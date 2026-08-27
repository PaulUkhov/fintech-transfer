package org.fintechtransfer.controller;

import org.fintechtransfer.dto.TransferDto;
import org.fintechtransfer.dto.TransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {
    private TransferService transferService;
    private IdempotencyService idempotencyService;
    private RateLimitService rateLimitService;
    private LedgerProperties properties;

    public TransferController(TransferService transferService, IdempotencyService idempotencyService, RateLimitService rateLimitService, LedgerProperties properties) {
        this.transferService = transferService;
        this.idempotencyService = idempotencyService;
        this.rateLimitService = rateLimitService;
        this.properties = properties;
    }

    public ResponseEntity<?> transfer(User, TransferRequest, String) {
    }

    public ResponseEntity<List<TransferDto>> list(User) {
    }

    public ResponseEntity<TransferDto> get(User, Long) {
    }
}
