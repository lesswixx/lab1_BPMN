package com.example.lab1_BPMN.Controllers;

import com.example.lab1_BPMN.Entities.Product;
import com.example.lab1_BPMN.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam int offset, @RequestParam int limit) {
        return productService.getAll(offset, limit);
    }
}

