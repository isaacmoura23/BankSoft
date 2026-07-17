package com.BankSoft.Bank.controller;

import com.BankSoft.Bank.dto.AccountRequestDTO;
import com.BankSoft.Bank.dto.AccountResponseDTO;
import com.BankSoft.Bank.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponseDTO getAccountByUserId(@PathVariable Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @GetMapping("/balance/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getBalance(@PathVariable Long userId) {
        return accountService.getBalance(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO creatAccount(@Valid @RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.createAccount(accountRequestDTO);
    }

    @GetMapping("/accountAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponseDTO> findAll(){
        return accountService.findAll();
    }
}
