package com.microservices.training.dto;

import java.io.Serializable;
import java.util.List;

public class CreateOrderDTO implements Serializable {

    private int customerId;

    private List<OrderItemDTO> orderItems;

    private int orderId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
