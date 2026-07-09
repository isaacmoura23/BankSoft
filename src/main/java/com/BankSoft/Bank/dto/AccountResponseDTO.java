package com.BankSoft.Bank.dto;


import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountResponseDTO(
        Long id,
        BigDecimal balance,
        Long userId
) {
}
