package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.TransferEntity;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record TransferDto(
        Long id,
        Long fromWalletId,
        Long toWalletId,
        String currency,
        BigDecimal amount,
        BigDecimal convertedAmount,
        BigDecimal fxRate,
        BigDecimal fee,
        String status,
        String errorMessage,
        Instant createAt,
        Instant completedAt
) {
    public static TransferDto from(TransferEntity transferEntity) {
        return TransferDto.builder()
                .id(transferEntity.getId())
                .fromWalletId(transferEntity.getFromWallet().getId())
                .toWalletId(transferEntity.getToWallet().getId())
                .currency(transferEntity.getCurrency())
                .amount(transferEntity.getAmount())
                .convertedAmount(transferEntity.getConvertedAmount())
                .fxRate(transferEntity.getFxRate())
                .fee(transferEntity.getFee())
                .status(transferEntity.getStatus().name())
                .errorMessage(transferEntity.getErrorMessage())
                .createAt(transferEntity.getCreatedAt())
                .completedAt(transferEntity.getCompletedAt())
                .build();
    }
}
