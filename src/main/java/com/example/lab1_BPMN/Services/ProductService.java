package com.example.lab1_BPMN.Services;

import com.example.lab1_BPMN.Entities.Product;
import com.example.lab1_BPMN.Ex.ResourceNotFoundException;
import com.example.lab1_BPMN.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
