package com.microservices.order.order.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItemdto {

	private Long id;
    private String skucode;
    private BigDecimal price;
    private Integer quantity;
}
