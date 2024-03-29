package com.example.lab1_BPMN.Entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_table")
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "orderTable")
//    private List<CartItem> items;

    private String address;
    private OrderStatus status; // Например, "В обработке", "Отправлен", "Доставлен"

    // Конструкторы, геттеры и сеттеры
    public OrderTable() {}

    public OrderTable(List<CartItem> items, String address, OrderStatus status) {
        this.address = address;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    // Standard getters and setters
}
