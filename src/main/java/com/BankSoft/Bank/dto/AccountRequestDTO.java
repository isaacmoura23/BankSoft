package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record AccountRequestDTO (
        @NotNull
        Long userId
){
}
