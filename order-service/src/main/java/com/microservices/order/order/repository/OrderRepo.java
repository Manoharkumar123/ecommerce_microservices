package com.microservices.order.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.order.order.model.Order;

public interface OrderRepo extends CrudRepository<Order,Long>{

}
