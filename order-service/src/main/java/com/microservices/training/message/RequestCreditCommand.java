package com.microservices.training.message;

import com.microservices.training.dto.CreateOrderDTO;

import java.io.Serializable;

public class RequestCreditCommand implements Serializable {

    private CreateOrderDTO createOrder;

    public RequestCreditCommand(CreateOrderDTO createOrder) {
        this.createOrder = createOrder;
    }

    public RequestCreditCommand() {
    }

    public CreateOrderDTO getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(CreateOrderDTO createOrder) {
        this.createOrder = createOrder;
    }
}
