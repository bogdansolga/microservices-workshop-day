package com.microservices.training.outbound;

import com.microservices.training.channel.OutboundChannels;
import com.microservices.training.dto.CreateOrderDTO;
import com.microservices.training.message.MessageCreator;
import com.microservices.training.message.RequestCreditCommand;
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

    public void publishRequestCreditCommand(CreateOrderDTO createOrderDTO) {
        final Message<RequestCreditCommand> message = MessageCreator.create(new RequestCreditCommand(createOrderDTO));
        outboundChannels.requestCredit()
                        .send(message);
    }
}
