package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record WithdrawDTO(
        @Positive
        BigDecimal amount

) {
}
