package com.BankSoft.Bank.dto;

import com.BankSoft.Bank.model.Transaction;
import com.BankSoft.Bank.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record AccountRequestDTO (
        @NotNull
        Long userId
){
}
