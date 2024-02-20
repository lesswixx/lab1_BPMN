package com.example.lab1_BPMN.Repositories;

import com.example.lab1_BPMN.Entities.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTable, Long> {
}
