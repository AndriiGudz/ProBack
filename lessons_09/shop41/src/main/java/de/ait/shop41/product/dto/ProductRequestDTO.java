package de.ait.shop41.product.dto;

import de.ait.shop41.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    //    Приходит на создание нового товара
//    Этот класс предназначен для получения данных при создании или обновлении продукта.
//    Он используется, когда клиент отправляет запрос на создание нового продукта.
//    ProductRequestDTO используется для получения данных от клиента при создании или обновлении продукта.

    @NotNull(message = "product title should be not null") // не null
    // валидация полей
    @NotBlank(message = "product title should be not blank") // не пустая строка
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "not valid pattern")
    // Pattern - помагает создавать регулярные выражения для валидации
//    @Email - анатация для валидации email
    @Schema(description = "product title", example = "Milk")
    private String title;

    @DecimalMin(value = "0.01")
//    @DecimalMin(value = "0.01") - анатация для валидации минимального размера цены
    @Schema(description = "product price", example = "9.99")
    private BigDecimal price;

    @Schema(description = "product aktivity status", example = "true")
    private boolean activ;

    public static Product of(ProductRequestDTO productDTO) {
        return new Product(null, productDTO.title, productDTO.price, productDTO.activ);
    }

}
