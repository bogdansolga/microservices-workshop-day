package com.microservices.training.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutboundChannels {
    @Output("request_credit_response")
    MessageChannel requestCreditResponse();
}