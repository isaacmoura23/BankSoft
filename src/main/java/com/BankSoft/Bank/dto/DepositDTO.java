package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositDTO(
        @Positive
        BigDecimal amount
) {
}
