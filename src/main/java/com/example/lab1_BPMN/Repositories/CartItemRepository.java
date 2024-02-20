package com.example.lab1_BPMN.Repositories;

import com.example.lab1_BPMN.Entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}