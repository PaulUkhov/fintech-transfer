package org.fintechtransfer.controller;

import org.fintechtransfer.dto.CreateWalletRequest;
import org.fintechtransfer.dto.LedgerEntryDto;
import org.fintechtransfer.dto.PageResponse;
import org.fintechtransfer.dto.WalletDto;
import org.fintechtransfer.repository.LedgerEntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    private WalletService walletService;
    private LedgerEntryRepository ledgerEntryRepository;

    public WalletController(WalletService walletService, LedgerEntryRepository ledgerEntryRepository) {
        this.walletService = walletService;
        this.ledgerEntryRepository = ledgerEntryRepository;
    }

    public ResponseEntity<WalletDto> create(User, CreateWalletRequest createWalletRequest) {
    }

    public ResponseEntity<List<WalletDto>> list(User) {
    }

    public ResponseEntity<WalletDto> get(User, Long) {
    }

    public ResponseEntity<PageResponse<LedgerEntryDto>> ledger(User, Long, int, int) {
    }
}
