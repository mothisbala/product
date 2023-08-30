package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

@Service
public class ProductServiceImpl implements ProductService {

 

    @Autowired
    private ProductRepository productRepository;

 

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

 

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

 

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

 

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

 

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}