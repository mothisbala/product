package com.example.demo;

import java.util.List;
import java.util.Optional;

 

public interface ProductService {

 

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);
}