package com.example.sqbtask.repository;

import com.example.sqbtask.domain.Transaction;
import com.example.sqbtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
