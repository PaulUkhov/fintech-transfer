package org.fintechtransfer.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

public record WithdrawRequest(
        @DecimalMin(value = "0.01", message = "Amount must be at least 0.01")
        @Digits(integer = 10, fraction = 2, message = "Amount must have up to 10 digits and 2 decimal places")
        BigDecimal amount,
        String bankAccount
) {
}
