package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DepositResponseDTO(

    Long accountId,

    BigDecimal amount,

    BigDecimal balance
) {
}
