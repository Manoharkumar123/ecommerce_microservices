package com.microservice.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.product.dto.ProductRequest;
import com.microservice.product.dto.ProductResponse;
import com.microservice.product.model.Product;
import com.microservice.product.model.Product.ProductBuilder;
import com.microservice.product.repository.ProductRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	public void createproduct(ProductRequest productrequest) {
	
		Product product=Product.builder()
				.name(productrequest.getName())
				.description(productrequest.getDescription())
				.price(productrequest.getPrice()).build();
		         productrepository.save(product);
		
	}
	   public List<ProductResponse> getAllProducts(){
		List<Product> products=(List<Product>) productrepository.findAll();
		 System.out.println(products);
		return products.stream().map(this::mapToProductResponse).toList();
		
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.productid(product.getProductid())
				.name(product.getName())
				.description(product.getDescription())
				 .price(product.getPrice())
				.build();
	}

}
