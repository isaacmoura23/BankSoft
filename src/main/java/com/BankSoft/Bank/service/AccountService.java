package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.AccountRequestDTO;
import com.BankSoft.Bank.dto.AccountResponseDTO;
import com.BankSoft.Bank.dto.UserResponseDTO;
import com.BankSoft.Bank.model.Account;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.AccountRepository;
import com.BankSoft.Bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
        User user = userRepository.findById(accountRequestDTO.userId())
                    .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        Account account = user.getAccount();

        if (account != null){
            throw new RuntimeException("Usuario ja cadastradio");
        }

        account = Account.builder()
                .balance(BigDecimal.ZERO)
                .user(user) .build();

        user.setAccount(account);
        userRepository.save(user);
        return null;
    }

    private AccountResponseDTO toResponseDTO(Account account) {
        return new AccountResponseDTO(
                account.getId(),
                account.getBalance(),
                account.getUser().getId()
        );
    }

}
