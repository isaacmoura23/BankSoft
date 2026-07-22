package com.BankSoft.Bank.service;

import com.BankSoft.Bank.dto.DepositDTO;
import com.BankSoft.Bank.dto.DepositResponseDTO;
import com.BankSoft.Bank.dto.TransferDTO;
import com.BankSoft.Bank.enums.TransactionType;
import com.BankSoft.Bank.model.Account;
import com.BankSoft.Bank.model.Transaction;
import com.BankSoft.Bank.model.User;
import com.BankSoft.Bank.repository.AccountRepository;
import com.BankSoft.Bank.repository.TransactionRepository;
import com.BankSoft.Bank.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public DepositResponseDTO deposit(Long userId, DepositDTO depositDTO){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Account account = user.getAccount();
        if (account == null){
            throw new RuntimeException("Usuário não possui conta");
        }

        account.setBalance(account.getBalance().add(depositDTO.amount()));

        accountRepository.save(account);

        Transaction transaction = Transaction.builder()
                .id(userId)
                .amount(depositDTO.amount())
                .type(TransactionType.DEPOSIT)
                .account(account)
                .build();

        transactionRepository.save(transaction);

        return new DepositResponseDTO(account.getId(), depositDTO.amount() ,account.getBalance());
    }


}
