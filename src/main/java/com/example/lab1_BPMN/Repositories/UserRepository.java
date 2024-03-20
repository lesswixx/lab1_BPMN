package com.example.lab1_BPMN.Repositories;

import com.example.lab1_BPMN.Entities.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
