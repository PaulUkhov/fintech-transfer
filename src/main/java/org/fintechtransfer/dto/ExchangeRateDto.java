package org.fintechtransfer.dto;

import java.math.BigDecimal;
import java.time.Instant;

import org.fintechtransfer.model.ExchangeRateEntity;

public record ExchangeRateDto(String baseCurrency, String quoteCurrency, BigDecimal rate, Instant updatedAt) {

    public static ExchangeRateDto from(ExchangeRateEntity r) {
        return new ExchangeRateDto(r.getBaseCurrency(), r.getQuoteCurrency(), r.getRate(), r.getUpdatedAt());
    }
}
