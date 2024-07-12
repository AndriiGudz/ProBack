package de.ait.shop41.customer.dto;

import de.ait.shop41.customer.entity.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
    // Приходит на создание или обновление клиента

    @Schema(description = "Customer name", example = "John Doe")
    private String name;

    @Schema(description = "Customer email", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Customer phone", example = "1234567890")
    private int phone;

    public static Customer toEntity(CustomerRequestDTO customerDTO) {
        return new Customer(null, customerDTO.name, customerDTO.email, customerDTO.phone, null);
    }
}
