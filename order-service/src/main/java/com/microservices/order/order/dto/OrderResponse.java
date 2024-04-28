package com.microservices.order.order.dto;

import java.util.List;

import com.microservices.order.order.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
	private long id;
	private String orderNumber;
	private List<OrderLineItemdto> orderLineItemdto;
}
