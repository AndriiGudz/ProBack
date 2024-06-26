package lessons_03.app.controller;

import lessons_03.app.model.Product;
import lessons_03.app.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public List<Product> getAllProducts() {
        return service.getAllProduct();
    }

    public Product getProductById(Long id) {
        return service.findById(id);
    }
}
