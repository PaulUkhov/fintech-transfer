package org.fintechtransfer.dto;

import java.math.BigDecimal;
import java.time.Instant;

import org.fintechtransfer.model.WalletEntity;

public record WalletDto(Long id, String currency, String status, BigDecimal balance, Instant createdAt) {

    public static WalletDto of(WalletEntity w, BigDecimal balance) {
        return new WalletDto(w.getId(), w.getCurrency(), w.getStatus().name(), balance, w.getCreatedAt());
    }
}
