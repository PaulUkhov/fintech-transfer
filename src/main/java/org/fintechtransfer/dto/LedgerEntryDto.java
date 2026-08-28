package org.fintechtransfer.dto;

import java.math.BigDecimal;
import java.time.Instant;

import org.fintechtransfer.model.LedgerEntryEntity;
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
        Instant createdAt) {

    public static LedgerEntryDto from(LedgerEntryEntity e) {
        return new LedgerEntryDto(
                e.getId(),
                e.getWallet().getId(),
                e.getTransfer() == null ? null : e.getTransfer().getId(),
                e.getPayment() == null ? null : e.getPayment().getId(),
                e.getEntryType().name(),
                e.getAmount(),
                e.getBalanceAfter(),
                e.getCurrency(),
                e.getDescription(),
                e.getOperationKey(),
                e.getCreatedAt());
    }
}
