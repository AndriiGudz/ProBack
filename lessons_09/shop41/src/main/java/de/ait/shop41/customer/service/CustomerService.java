package de.ait.shop41.customer.service;

import de.ait.shop41.customer.dto.CustomerRequestDTO;
import de.ait.shop41.customer.dto.CustomerResponseDTO;
import de.ait.shop41.customer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customer);
    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customer);
    CustomerResponseDTO getCustomerById(Long id);
    List<CustomerResponseDTO> getAllCustomers();
    void deleteCustomerById(Long id);

    void addProductToCustomerCart(Long customerId, Long productId);
}
