package com.BankSoft.Bank.repository;

import com.BankSoft.Bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
