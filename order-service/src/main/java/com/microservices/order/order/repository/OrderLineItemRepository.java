package com.microservices.order.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.order.order.model.OrderLineItem;

public interface OrderLineItemRepository extends CrudRepository <OrderLineItem,Long> {

}
