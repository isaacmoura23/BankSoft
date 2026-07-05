package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record TransferDTO(

        Long sourceAccountId,

        Long destinationAccountId,

        @Positive
        BigDecimal amount

) {
}
