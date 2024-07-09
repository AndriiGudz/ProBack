package de.ait.shop41.product.service;

import de.ait.shop41.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product save(Product product);
    Product getById(Long id);
    Product update(Long id, Product product);
    List<Product> getAllProducts();
    List<Product> getAllAktiveProducts();
    List<Product> getAllNotAktiveProducts();
    Product deleteById(Long id);
}
