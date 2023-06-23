package com.example.sqbtask.repository;

import com.example.sqbtask.domain.User;
import com.example.sqbtask.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findByUserId(Long userId);
}
