package com.microservices.training.inbound;

import com.microservices.training.channel.InboundChannels;
import com.microservices.training.message.RequestCreditResponse;
import com.microservices.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(InboundChannels.class)
public class InboundMessagingAdapter {

    private final OrderService orderService;

    @Autowired
    public InboundMessagingAdapter(OrderService customerService) {
        this.orderService = customerService;
    }

    @StreamListener("request_credit_response")
    public void requestCreditResponse(final RequestCreditResponse requestCreditResponse) {
        orderService.handleRequestCreditResponse(requestCreditResponse);
    }
}
