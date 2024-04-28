package com.microservice.product.repo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.dto.ProductRequest;
import com.microservice.product.dto.ProductResponse;
import com.microservice.product.service.ProductService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
	private ProductService productservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void CreateProduct(@RequestBody ProductRequest productrequest) {
		productservice.createproduct(productrequest);
		
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getProduct(Long id) {
		return productservice.getAllProducts();
		
	}

}
