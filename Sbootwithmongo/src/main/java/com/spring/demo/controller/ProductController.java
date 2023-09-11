package com.spring.demo.controller;

import com.spring.demo.model.Product;
import com.spring.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

     @GetMapping("/getByPrice")
    public Map<String, List<Product>> getByPrice() {
        int price = 30000;

        List<Product> geProducts = productRepository.findNameAndPriceWherePriceLessThanEqual(price);
        // List<Product> geProducts = productRepository.findAll();
        List<Product> products = geProducts.stream().filter(product->product.getPrice()<= price).peek(System.out::println).collect(Collectors.toList());

        // Map<Double, List<Product>> groupedProducts = products.stream()
        // .collect(Collectors.groupingBy(Product::getPrice));

        Map<String,List<Product>> groupedProductsByName = products.stream().collect(Collectors.groupingBy(Product::getName));
        return  groupedProductsByName;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}
