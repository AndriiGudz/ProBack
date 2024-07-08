package de.ait.shop41.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String customerName;
    private String customerEmail;
    private int phone;
}
