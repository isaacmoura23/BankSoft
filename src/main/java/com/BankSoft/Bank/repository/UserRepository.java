package com.BankSoft.Bank.repository;

import com.BankSoft.Bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findeByEmail(String email);
}
