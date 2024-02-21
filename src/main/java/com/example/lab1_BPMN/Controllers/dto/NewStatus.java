package com.example.lab1_BPMN.Controllers.dto;

import com.example.lab1_BPMN.Entities.OrderStatus;

public class NewStatus {
    private OrderStatus newStatus;

    public NewStatus(){};

    public NewStatus(OrderStatus newStatus) {
        this.newStatus = newStatus;
    }

    public OrderStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(OrderStatus newStatus) {
        this.newStatus = newStatus;
    }
}
