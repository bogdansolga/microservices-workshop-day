package com.microservices.training.inbound;

import com.microservices.training.channel.InboundChannels;
import com.microservices.training.message.RequestCreditCommand;
import com.microservices.training.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(InboundChannels.class)
public class InboundMessagingAdapter {

    private final CustomerService customerService;

    @Autowired
    public InboundMessagingAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    @StreamListener("request_credit")
    public void requestCredit(final RequestCreditCommand requestCreditCommand) {
        customerService.requestCredit(requestCreditCommand);
    }
}
