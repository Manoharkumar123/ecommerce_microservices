package com.microservices.order.order.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_oder_Line_item")

public class OrderLineItem {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
    private String skucode;
    private BigDecimal price;
    private Integer quantity;
    

}
