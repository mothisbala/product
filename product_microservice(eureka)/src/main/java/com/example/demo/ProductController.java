
package com.example.demo;

import java.util.List;

import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 

@RestController

@RequestMapping("/product")

public class ProductController {

 

    @Autowired

    private ProductService productService;

 

    @GetMapping("/all")

    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);

    }

 

    @GetMapping("/{id}")

    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        Optional<Product> product = productService.getProductById(id);

        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

 

    @PostMapping

    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product createdProduct = productService.createProduct(product);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }

 

    @PutMapping("/{id}")

    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {

        Product product = productService.updateProduct(id, updatedProduct);

        if (product != null) {

            return new ResponseEntity<>(product, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

 

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
