package com.microservices.training.message;

import java.io.Serializable;

public class RequestCreditResponse implements Serializable {

    private int orderId;

    private boolean successful;

    public RequestCreditResponse(int orderId, boolean successful) {
        this.orderId = orderId;
        this.successful = successful;
    }

    public RequestCreditResponse() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
