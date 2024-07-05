package de.ait.shop41.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private boolean aktive;
}
