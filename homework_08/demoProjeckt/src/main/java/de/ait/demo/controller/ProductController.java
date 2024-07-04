package de.ait.demo.controller;

import de.ait.demo.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "Laptop", "Dell", 2022, 1200),
                new Product(2L, "Smartphone", "Apple", 2023, 999),
                new Product(3L, "Tablet", "Samsung", 2021, 600),
                new Product(4L, "Smartwatch", "Garmin", 2020, 350),
                new Product(5L, "Camera", "Sony", 2019, 1500),
                new Product(6L, "Headphones", "Bose", 2022, 300),
                new Product(7L, "Monitor", "LG", 2023, 450),
                new Product(8L, "Printer", "HP", 2021, 200)
        );
    }
}
