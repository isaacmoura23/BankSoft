package com.BankSoft.Bank.dto;


import com.BankSoft.Bank.model.Transaction;
import com.BankSoft.Bank.model.User;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record AccountResponseDTO(
        Long id,

        BigDecimal balance,

        Long userId
) {
}
