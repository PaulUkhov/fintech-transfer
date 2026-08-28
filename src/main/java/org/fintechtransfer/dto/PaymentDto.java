package org.fintechtransfer.dto;

import java.math.BigDecimal;
import java.time.Instant;

import org.fintechtransfer.model.PaymentTransactionEntity;
public record PaymentDto(
        Long id,
        Long walletId,
        String type,
        BigDecimal amount,
        String currency,
        String status,
        String externalPaymentId,
        String failureReason,
        Instant createdAt,
        Instant updatedAt) {

    public static PaymentDto from(PaymentTransactionEntity p) {
        return new PaymentDto(
                p.getId(),
                p.getWallet().getId(),
                p.getType().name(),
                p.getAmount(),
                p.getCurrency(),
                p.getStatus().name(),
                p.getExternalPaymentId(),
                p.getFailureReason(),
                p.getCreatedAt(),
                p.getUpdatedAt());
    }
}
