package com.microservices.training.service;

import com.microservices.training.domain.entity.Customer;
import com.microservices.training.domain.repository.CustomerRepository;
import com.microservices.training.message.RequestCreditCommand;
import com.microservices.training.message.RequestCreditResponse;
import com.microservices.training.outbound.OutboundMessagingAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final OutboundMessagingAdapter outboundMessagingAdapter;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, OutboundMessagingAdapter outboundMessagingAdapter) {
        this.customerRepository = customerRepository;
        this.outboundMessagingAdapter = outboundMessagingAdapter;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requestCredit(RequestCreditCommand requestCreditCommand) {
        final int orderId = requestCreditCommand.getCreateOrder()
                                                .getOrderId();
        LOGGER.info("Processing a RequestCredit command for the order with the ID {}...", orderId);

        final int customerId = requestCreditCommand.getCreateOrder()
                                                   .getCustomerId();
        LOGGER.info("Requesting a credit for the customer with the ID {}...", customerId);
        Customer customer = getCustomerOrThrow(customerId);
        LOGGER.info("The customer with the ID {} is '{}'", customerId, customer.getName());

        outboundMessagingAdapter.publishRequestCreditResponse(new RequestCreditResponse(orderId, true));
        LOGGER.info("The RequestCredit response for the orderId {} was published", orderId);
    }

    private Customer getCustomerOrThrow(int customerId) {
        return customerRepository.findByCustomerId(customerId)
                                 .orElseThrow(() -> new IllegalArgumentException("There is no customer with the ID " + customerId));
    }
}
