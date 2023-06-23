package com.example.sqbtask.repository;

import com.example.sqbtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserNameAndPassword(String username,String password);
    boolean existsByUserNameAndPassword(String username,String password);
}
