package lessons_03.app.repository;

import lessons_03.app.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();
    public Product save(Product product);
}
