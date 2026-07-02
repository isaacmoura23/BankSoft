package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferDTO(

        Long sourceAccountId,

        Long destinationAccountId,

        @Positive
        BigDecimal amount

) {
}
