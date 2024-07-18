package de.ait.shop41.product.service;

import de.ait.shop41.exception_handling.exceptions.ProductNotFoundException;
import de.ait.shop41.logging.Profiler;
import de.ait.shop41.product.dto.ProductRequestDTO;
import de.ait.shop41.product.dto.ProductResponseDTO;
import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    // объект логирования
    private final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Override
    public ProductResponseDTO save(ProductRequestDTO productDTO) {
        Product product = ProductRequestDTO.of(productDTO);
        return ProductResponseDTO.of(repository.save(product));
    }

    @Override
    public Product getById(Long id) { // Todo return
        logger.error("PRODUCT, GET, AUTH get by id start with {}", id);
        logger.warn("get by id start with {}", id);
        logger.info("get by id start with {}", id);

        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product %d not found", id)));
    }

    @Override
    public Product getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product %d not found", id)));
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
    @Profiler // нами написанная анотация
    public List<ProductResponseDTO> getAllProducts() {
        return ProductResponseDTO.of(repository.findAll());
    }

    @Override
    public List<ProductResponseDTO> getAllAktiveProducts() {
        return ProductResponseDTO.of(repository.findProductByActiv(true));
    }

    @Override
    public List<ProductResponseDTO> getAllNotAktiveProducts() {
        return ProductResponseDTO.of(repository.findProductByActiv(false));
    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }
}
