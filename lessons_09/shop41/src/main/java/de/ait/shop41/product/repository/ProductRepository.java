package de.ait.shop41.product.repository;

import de.ait.shop41.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // метод для фильтрации товаров на стороне базы данных
    List<Product> findProductByActiv(boolean activ); // связано с названием колонки в базе данных

}
