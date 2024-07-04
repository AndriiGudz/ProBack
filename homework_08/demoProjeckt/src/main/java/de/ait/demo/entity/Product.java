package de.ait.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String productName;
    private String productBrand;
    private int yearManufacture;
    private int productPrice;
}
