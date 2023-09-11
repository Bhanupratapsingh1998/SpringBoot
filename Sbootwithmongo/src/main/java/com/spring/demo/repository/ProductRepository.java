package com.spring.demo.repository;

import com.spring.demo.model.Product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query(value = "{'price': { $lte: ?0 }}", fields = "{'name': 1, 'price': 1}")
    List<Product> findNameAndPriceWherePriceLessThanEqual(int price);
}