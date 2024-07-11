package de.ait.shop41.product.dto;

import de.ait.shop41.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
//    Исходящаяя, из сущности получаю DTO

    @Schema(description = "product unique identifier", example = "100")
    private Long id;

    @Schema(description = "product title", example = "Milk")
    private String title;

    @Schema(description = "product price", example = "9.99")
    private BigDecimal price;

    @Schema(description = "product aktivity status", example = "true")
    private boolean activ;

    public static ProductResponseDTO of(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getTitle(),
                product.getPrice(),
                product.isActiv()
        );
    }

    public static List<ProductResponseDTO> of(List<Product> products) {
        return products.stream().map(ProductResponseDTO::of).toList();
    }
}
