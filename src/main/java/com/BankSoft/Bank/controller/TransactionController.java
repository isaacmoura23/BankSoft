package com.BankSoft.Bank.controller;

import com.BankSoft.Bank.dto.DepositDTO;
import com.BankSoft.Bank.dto.DepositResponseDTO;
import com.BankSoft.Bank.service.AccountService;
import com.BankSoft.Bank.service.TransactionService;
import com.BankSoft.Bank.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController{

    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;


    @PostMapping("/deposit/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public DepositResponseDTO deposit(@PathVariable Long userId,
                                      @Valid @RequestBody DepositDTO depositDTO) {
        return transactionService.deposit(userId, depositDTO);
    }

}
