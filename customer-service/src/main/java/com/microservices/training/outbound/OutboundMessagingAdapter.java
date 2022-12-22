package com.microservices.training.outbound;

import com.microservices.training.channel.OutboundChannels;
import com.microservices.training.dto.CreateOrderDTO;
import com.microservices.training.message.MessageCreator;
import com.microservices.training.message.RequestCreditCommand;
import com.microservices.training.message.RequestCreditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(OutboundChannels.class)
public class OutboundMessagingAdapter {

    private final OutboundChannels outboundChannels;

    @Autowired
    public OutboundMessagingAdapter(OutboundChannels outboundChannels) {
        this.outboundChannels = outboundChannels;
    }

    public void publishRequestCreditResponse(RequestCreditResponse requestCreditResponse) {
        final Message<RequestCreditResponse> message = MessageCreator.create(requestCreditResponse);
        outboundChannels.requestCreditResponse()
                        .send(message);
    }
}
