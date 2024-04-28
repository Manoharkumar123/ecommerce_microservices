package com.microservices.order.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import com.microservices.order.order.dto.InventoryResponse;
import com.microservices.order.order.dto.OrdderRequest;
import com.microservices.order.order.dto.OrderLineItemdto;
import com.microservices.order.order.model.Order;
import com.microservices.order.order.model.OrderLineItem;
import com.microservices.order.order.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	
	private final OrderRepo orderrepo;
	private WebClient webclient;
	public void placeOrder(OrdderRequest orderRequest) {
		Order order=new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
	    List<OrderLineItem> orderlinelItemlist=orderRequest.getOrderLineItemdtolist().stream()
	    		          .map(this::mapToDto).toList();
	     order.setOrderLineItemlist(orderlinelItemlist);
	     
	  List<String> skuCodes=  order.getOrderLineItemlist().stream().map(orderlineitem->orderlineitem.getSkucode()).toList();
	  InventoryResponse[] inventoryresponses= webclient.get().uri("http://localhost:8082/api/inventory",
	    	uriBuilder->uriBuilder.queryParam("skucodes", skuCodes).build())
	            .retrieve()
	            .bodyToMono(InventoryResponse[].class).block();
	           
	            
	        boolean allInInstock= Arrays.stream(inventoryresponses).allMatch(inventoryresponse->inventoryresponse.isISInstock());
	    
	     if(allInInstock) {
	    	 orderrepo.save(order); 
	     }
	     else {
	    	throw new IllegalStateException("order is not avilable in the stock");
	     }
	     
	}
	
   private OrderLineItem mapToDto(OrderLineItemdto orderlistdto) {
	    OrderLineItem   orderLineitem=new  OrderLineItem();
	     orderLineitem.setPrice(orderlistdto.getPrice());
	     orderLineitem.setId(orderlistdto.getId());
	     orderLineitem.setQuantity(orderlistdto.getQuantity());
	     orderLineitem.setSkucode(orderlistdto.getSkucode());
	       return orderLineitem;
   }
}
