package de.ait.shop41.product.service;

import de.ait.shop41.exceptions.ProductNotFoundException;
import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    }

    @Override
    public Product update(Long id, Product product) {
        Product updateProduct = getById(id);
        updateProduct.setTitle(product.getTitle());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setActiv(product.isActiv());
        return repository.save(updateProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllAktiveProducts() {
        return repository.findProductByActiv(true);
    }

    @Override
    public List<Product> getAllNotAktiveProducts() {
        return repository.findProductByActiv(false);
    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }
}
