package com.microservices.training.service;

import com.microservices.training.domain.entity.Order;
import com.microservices.training.domain.entity.OrderItem;
import com.microservices.training.domain.repository.OrderRepository;
import com.microservices.training.dto.CreateOrderDTO;
import com.microservices.training.dto.OrderItemDTO;
import com.microservices.training.outbound.OutboundMessagingAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OutboundMessagingAdapter outboundMessagingAdapter;

    @Autowired
    public OrderService(OrderRepository orderRepository, OutboundMessagingAdapter outboundMessagingAdapter) {
        this.orderRepository = orderRepository;
        this.outboundMessagingAdapter = outboundMessagingAdapter;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrder(CreateOrderDTO createOrderDTO) {
        final List<OrderItemDTO> orderItemsDTOs = createOrderDTO.getOrderItems();
        LOGGER.info("Creating an order for the customer with the ID {}, having {} order items...",
                createOrderDTO.getCustomerId(), orderItemsDTOs.size());

        Order order = new Order(createOrderDTO.getCustomerId(), "A first order");
        order.setOrderItems(convertDTOs(orderItemsDTOs, order));

        orderRepository.save(order);
        LOGGER.info("The order was saved");

        outboundMessagingAdapter.publishRequestCreditCommand(createOrderDTO);
        LOGGER.info("The RequestCredit command was published");
    }

    private List<OrderItem> convertDTOs(List<OrderItemDTO> orderItemsDTOs, Order order) {
        return orderItemsDTOs.stream()
                             .map(item -> new OrderItem(item.getName(), item.getPrice(), order))
                             .collect(Collectors.toList());
    }
}
