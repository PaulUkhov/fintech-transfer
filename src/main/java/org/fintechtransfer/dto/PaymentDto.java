package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.PaymentTransactionEntity;

import java.math.BigDecimal;
import java.time.Instant;
@Builder
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
        Instant updatedAt

) {
    public static PaymentDto from(PaymentTransactionEntity paymentTransactionEntity){
        return PaymentDto.builder()
                .id(paymentTransactionEntity.getId())
                .walletId(paymentTransactionEntity.getWallet().getId())
                .type(paymentTransactionEntity.getType().name())
                .amount(paymentTransactionEntity.getAmount())
                .currency(paymentTransactionEntity.getCurrency())
                .status(paymentTransactionEntity.getStatus().name())
                .externalPaymentId(paymentTransactionEntity.getExternalPaymentId())
                .failureReason(paymentTransactionEntity.getFailureReason())
                .createdAt(paymentTransactionEntity.getCreatedAt())
                .updatedAt(paymentTransactionEntity.getUpdatedAt())
                .build();
    }
}
