package com.microservice.product.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.product.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	

}
