package org.fintechtransfer.dto;

import lombok.Builder;
import org.fintechtransfer.model.ExchangeRateEntity;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record ExchangeRateDto(
        String baseCurrency,
        String quoteCurrency,
        BigDecimal rate,
        Instant updatedAt
) {
    public static ExchangeRateDto from(ExchangeRateEntity exchangeRateEntity) {
        return ExchangeRateDto.builder()
                .baseCurrency(exchangeRateEntity.getBaseCurrency())
                .quoteCurrency(exchangeRateEntity.getQuoteCurrency())
                .rate(exchangeRateEntity.getRate())
                .updatedAt(exchangeRateEntity.getUpdatedAt())
                .build();
    }

}
