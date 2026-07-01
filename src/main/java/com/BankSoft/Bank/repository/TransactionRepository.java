package com.BankSoft.Bank.repository;

import com.BankSoft.Bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
