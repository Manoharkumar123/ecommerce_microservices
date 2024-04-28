package com.microservices.order.order.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="t_order")
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String orderNumber;
	@OneToMany(cascade=CascadeType.ALL)
	private List<OrderLineItem> orderLineItemlist;
	
}
