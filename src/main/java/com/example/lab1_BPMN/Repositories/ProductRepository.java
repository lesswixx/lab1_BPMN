package com.example.lab1_BPMN.Repositories;

import com.example.lab1_BPMN.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
