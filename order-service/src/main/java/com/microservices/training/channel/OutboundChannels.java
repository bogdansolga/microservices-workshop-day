package com.microservices.training.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutboundChannels {
    @Output("request_credit")
    MessageChannel requestCredit();

    @Output("request_payment")
    MessageChannel requestPayment();
}