package lessons_03.app.repository;

import lessons_03.app.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryMapImpl implements ProductRepository {
    private final Map<Long, Product> db = new HashMap<>();

    public ProductRepositoryMapImpl() {
        init();
    }

    private void init() {
        db.put(1l, new Product(1L, "Banana", new BigDecimal("0.90")));
        db.put(2l, new Product(2L, "Tomato", new BigDecimal("1.90")));
        db.put(3l, new Product(3L, "Apple", new BigDecimal("0.80")));
        db.put(4l, new Product(4L, "Milk", new BigDecimal("1.20")));
    }

    // CRUD - create read update delete

    public List<Product> findAll() {
        return db.values().stream().collect(Collectors.toList());
    }

    public Product save(Product product) {
        db.put(product.getId(), product);
        return product;
    }


}
