package com.example.lab1_BPMN.Controllers.dto;

import com.example.lab1_BPMN.Entities.OrderStatus;

public class NewStatus {
    private final OrderStatus newStatus;

    public NewStatus(OrderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }
}
