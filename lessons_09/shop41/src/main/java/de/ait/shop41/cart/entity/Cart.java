package de.ait.shop41.cart.entity;

import de.ait.shop41.customer.entity.Customer;
import de.ait.shop41.product.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    анатация связи корзины с пользователем
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    анатация связи многие ко многим
    @ManyToMany
        @JoinTable(name = "cart_product",
                joinColumns = @JoinColumn(name = "cart_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

}
