package de.ait.shop41.customer.dto;

import de.ait.shop41.cart.dto.CartResponseDto;
import de.ait.shop41.cart.entity.Cart;
import de.ait.shop41.customer.entity.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    // Исходящая DTO для отправки данных клиенту

    @Schema(description = "Customer unique identifier", example = "100")
    private Long id;

    @Schema(description = "Customer name", example = "John Doe")
    private String name;

    @Schema(description = "Customer email", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Customer phone", example = "1234567890")
    private int phone;

    private CartResponseDto cart;


//    public static CustomerResponseDTO fromEntity(Customer customer) {
//        return new CustomerResponseDTO(
//                customer.getId(),
//                customer.getName(),
//                customer.getEmail(),
//                customer.getPhone()
//        );
//    }
//
//    public static List<CustomerResponseDTO> fromEntities(List<Customer> customers) {
//        return customers.stream().map(CustomerResponseDTO::fromEntity).toList();
//    }


}
