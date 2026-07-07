package com.BankSoft.Bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Builder
public record UserRequestDTO(
        @NotBlank(message = "Nome é obrigatorio")
        String name,

        @NotBlank(message = "Email é obrigatorio")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha esta incorreta")
        @Size(min = 8, message = "Senha deve possuir no minimo 8 caracteres")
        String password

        ) {
}
