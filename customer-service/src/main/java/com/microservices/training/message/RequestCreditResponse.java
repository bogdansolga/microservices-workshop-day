package com.microservices.training.message;

import java.io.Serializable;

public class RequestCreditResponse implements Serializable {

    private boolean successful;

    public RequestCreditResponse(boolean successful) {
        this.successful = successful;
    }

    public RequestCreditResponse() {
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
