package com.BankSoft.Bank.dto;

import lombok.Builder;

@Builder
public record UserResponseDTO(
        Long id,
        String name,
        String email
) {
}
