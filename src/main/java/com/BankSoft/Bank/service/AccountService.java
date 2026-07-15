package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.AccountRequestDTO;
import com.BankSoft.Bank.dto.AccountResponseDTO;
import com.BankSoft.Bank.model.Account;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.AccountRepository;
import com.BankSoft.Bank.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountResponseDTO createAccount( AccountRequestDTO accountRequestDTO) {
        User user = userRepository.findById(accountRequestDTO.userId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Account account = user.getAccount();

        if (account != null){
            throw new RuntimeException("Usuário já possui uma conta");
        }

        account = Account.builder()
                .balance(BigDecimal.ZERO)
                .user(user)
                .build();

        user.setAccount(account);
        User savedUser = userRepository.save(user);
        return toResponseDTO(savedUser.getAccount());
    }

    public AccountResponseDTO getAccountByUserId(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Account account= user.getAccount();

        if (account == null){
            throw new RuntimeException("Usuário não possui conta");
        }

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
