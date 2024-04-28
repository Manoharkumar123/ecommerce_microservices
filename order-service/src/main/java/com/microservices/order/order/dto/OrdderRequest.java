package com.microservices.order.order.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrdderRequest {
	private String orderNumber;
	private List<OrderLineItemdto> orderLineItemdtolist;

}
