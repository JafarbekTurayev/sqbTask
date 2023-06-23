package com.example.sqbtask.repository;

import com.example.sqbtask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
