package org.fintechtransfer.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ExchangeRateUpdateRequest(
        @Positive(message = "Amount must be positive")
        BigDecimal rate,
        @Pattern(regexp = "[A-Z]{3}", message = "Currency must be 3 uppercase letters")
        String baseCurrency,
        @Pattern(regexp = "[A-Z]{3}", message = "Currency must be 3 uppercase letters")
        String quoteCurrency

) {
}
