package org.fintechtransfer.exeption;

import org.fintechtransfer.model.WalletEntity;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    private String walletEntity;
    public InsufficientFundsException(Long walletId,BigDecimal balance, BigDecimal requestedAmount) {
        super(String.format("Insufficient funds for wallet %d. Balance: %.2f, Requested: %.2f",
                walletId, balance, requestedAmount));
    }
    public String getErrorCode() {
        return walletEntity.toUpperCase() + "_NOT_FOUND";
    }
}
