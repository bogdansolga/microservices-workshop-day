package com.microservices.training.inbound;

import com.microservices.training.dto.CreateOrderDTO;
import com.microservices.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InboundRestAdapter {

    private final OrderService orderService;

    @Autowired
    public InboundRestAdapter(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        orderService.createOrder(createOrderDTO);
        return ResponseEntity.ok("The order was created");
    }
}
