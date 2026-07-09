package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.AccountRequestDTO;
import com.BankSoft.Bank.dto.AccountResponseDTO;
import com.BankSoft.Bank.dto.UserResponseDTO;
import com.BankSoft.Bank.model.Account;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.AccountRepository;
import com.BankSoft.Bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountResponseDTO findById(Long id) {
        Account account = accountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        return toResponseDTO(account);
    }

    private AccountResponseDTO toResponseDTO(Account account) {
        return new AccountResponseDTO(
                account.getId(),
                account.getBalance(),
                account.getUser().getId()
        );
    }

}
