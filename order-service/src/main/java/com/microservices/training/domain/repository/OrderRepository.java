package com.microservices.training.domain.repository;

import com.microservices.training.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
