package lessons_03.app.service;

import lessons_03.app.model.Product;
import lessons_03.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository; // зависимость внедряем из вне - Dependency injection

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(Long id) {
        return repository
                .findAll()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

}
