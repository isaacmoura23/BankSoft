package com.BankSoft.Bank.repository;

import com.BankSoft.Bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
