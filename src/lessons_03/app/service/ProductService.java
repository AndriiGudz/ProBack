package lessons_03.app.service;

import lessons_03.app.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    List<Product> getAllProduct();
}
