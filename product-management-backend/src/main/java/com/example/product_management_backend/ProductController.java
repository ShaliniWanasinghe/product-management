package com.example.product_management_backend;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4300")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("1", "Laptop", "Lightweight business laptop with 16GB RAM.", 150000.0, "Electronics",
                12, "https://images.unsplash.com/photo-1496181133206-80ce9b88a853", "2026-01-10"));
        products.add(new Product("2", "Wireless Mouse", "Ergonomic wireless mouse with silent clicks.", 5000.0,
                "Accessories", 40, "https://images.unsplash.com/photo-1527814050087-3793815479db", "2026-01-12"));
        products.add(new Product("3", "Mechanical Keyboard", "RGB backlit keyboard for gaming and typing.", 8000.0,
                "Accessories", 22, "https://images.unsplash.com/photo-1511467687858-23d96c32e4ae", "2026-01-15"));
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(UUID.randomUUID().toString());
        }
        products.add(product);
        return product;
    }
}
