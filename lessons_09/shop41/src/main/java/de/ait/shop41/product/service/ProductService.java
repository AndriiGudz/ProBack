package de.ait.shop41.product.service;

import de.ait.shop41.product.dto.ProductRequestDTO;
import de.ait.shop41.product.dto.ProductResponseDTO;
import de.ait.shop41.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO product);
    Product getById(Long id);
    Product update(Long id, Product product);
    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> getAllAktiveProducts();
    List<ProductResponseDTO> getAllNotAktiveProducts();
    Product deleteById(Long id);
}
