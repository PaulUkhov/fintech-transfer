package org.fintechtransfer.dto;

import jakarta.validation.constraints.Pattern;

public record CreateWalletRequest(
        @Pattern(regexp = "[A-Z]{3}", message = "Currency must be 3 uppercase letters")
        String currency
) {}
