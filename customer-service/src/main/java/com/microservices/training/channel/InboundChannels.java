package com.microservices.training.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InboundChannels {
    @Input("request_credit")
    MessageChannel requestCredit();
}