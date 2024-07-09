package de.ait.shop41.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity // класс Энтити и будет храниться в БД
@Table(name = "product") // анатация для связки с таблицей в БД
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id // анатация для БД primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // говорит спрингу, что не ты занимаешься ID, а база данных
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "activ")
    private boolean activ;
}
