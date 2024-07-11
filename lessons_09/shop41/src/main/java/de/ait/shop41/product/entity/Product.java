package de.ait.shop41.product.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Product Entity")
@Entity // класс Энтити и будет храниться в БД
@Table(name = "product") // анатация для связки с таблицей в БД
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id // анатация для БД primary KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // говорит спрингу, что не ты занимаешься ID, а база данных
    @Schema(description = "product unique identifier", example = "100")
    @Column(name = "id")
    private Long id;

    @Schema(description = "product title", example = "Milk")
    @Column(name = "title", nullable = false)
    private String title;

    @Schema(description = "product price", example = "9.99")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Schema(description = "product aktivity status", example = "true")
    @Column(name = "activ")
    private boolean activ;
}
