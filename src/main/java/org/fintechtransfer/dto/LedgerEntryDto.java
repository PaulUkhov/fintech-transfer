package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.LedgerEntryEntity;

import java.math.BigDecimal;
import java.time.Instant;
@Builder
public record LedgerEntryDto(
        Long id,
        Long walletId,
        Long transferId,
        Long paymentId,
        String entryType,
        BigDecimal amount,
        BigDecimal balanceAfter,
        String currency,
        String description,
        String operationKey,
        Instant createdAt
) {
    public static LedgerEntryDto from(LedgerEntryEntity ledgerEntryEntity) {
        return  LedgerEntryDto.builder()
                .id(ledgerEntryEntity.getId())
                .walletId(ledgerEntryEntity.getId())
                .transferId(ledgerEntryEntity.getId())
                .paymentId(ledgerEntryEntity.getId())
                .entryType(ledgerEntryEntity.getEntryType().name())
                .amount(ledgerEntryEntity.getAmount())
                .balanceAfter(ledgerEntryEntity.getBalanceAfter())
                .currency(ledgerEntryEntity.getCurrency())
                .description(ledgerEntryEntity.getDescription())
                .operationKey(ledgerEntryEntity.getOperationKey())
                .createdAt(ledgerEntryEntity.getCreatedAt())
                .build();
    }
}
