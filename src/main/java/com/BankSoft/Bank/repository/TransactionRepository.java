package com.BankSoft.Bank.repository;

import com.BankSoft.Bank.model.Transaction;
import com.BankSoft.Bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
