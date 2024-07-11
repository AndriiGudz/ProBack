package de.ait.shop41.product.dto;

import de.ait.shop41.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    //    Приходит на создание нового товара

    @Schema(description = "product title", example = "Milk")
    private String title;

    @Schema(description = "product price", example = "9.99")
    private BigDecimal price;

    @Schema(description = "product aktivity status", example = "true")
    private boolean activ;

    public static Product of(ProductRequestDTO productDTO) {
        return new Product(null, productDTO.title, productDTO.price, productDTO.activ);
    }

}
