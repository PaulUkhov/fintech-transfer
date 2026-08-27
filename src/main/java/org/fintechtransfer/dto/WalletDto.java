package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.WalletEntity;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record WalletDto(
        Long id,
        String currency,
        String status,
        BigDecimal balance,
        Instant createdAt

) {
    public static WalletDto of(WalletEntity walletEntity, BigDecimal balance) {
        return WalletDto.builder()
                .id(walletEntity.getId())
                .currency(walletEntity.getCurrency())
                .status(walletEntity.getStatus().name())
                .balance(balance)
                .createdAt(walletEntity.getCreatedAt())
                .build();
    }
}
