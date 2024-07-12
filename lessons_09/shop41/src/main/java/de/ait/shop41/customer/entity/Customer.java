package de.ait.shop41.customer.entity;

import de.ait.shop41.cart.entity.Cart;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Schema(description = "Customer Entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the customer", example = "1")
    private Long id;

    @Column(name = "name", nullable = false)
    @Schema(description = "Name of the customer", example = "John Doe")
    private String name;

    @Column(name = "email", nullable = false)
    @Schema(description = "Email of the customer", example = "john.doe@example.com")
    private String email;

    @Column(name = "phone")
    @Schema(description = "Phone number of the customer", example = "1234567890")
    private int phone;

    @OneToOne(mappedBy = "customer")
    private Cart cart;
}
