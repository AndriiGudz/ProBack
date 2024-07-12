package de.ait.shop41.customer.service;

import de.ait.shop41.cart.entity.Cart;
import de.ait.shop41.customer.dto.CustomerRequestDTO;
import de.ait.shop41.customer.dto.CustomerResponseDTO;
import de.ait.shop41.customer.entity.Customer;
import de.ait.shop41.customer.repository.CustomerRepository;
import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    private final ProductService productService;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        // dto -> entity
        // new Cart
        // save entity
        // entity -> dto
        // получаем с помощью ModelMapper
        Customer customer = modelMapper.map(dto, Customer.class);
        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer saved = customerRepository.save(customer);
        return modelMapper.map(saved, CustomerResponseDTO.class);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        modelMapper.map(customerRequestDTO, existingCustomer);

        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return modelMapper.map(updatedCustomer, CustomerResponseDTO.class);
    }


    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer entity = customerRepository.findById(id).orElse(null);
        return modelMapper.map(entity, CustomerResponseDTO.class);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer with ID " + id + " not found");
        }
    }

    @Override
    public void addProductToCustomerCart(Long customerId, Long productId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + customerId + " not found"));
        Product product = productService.getEntityById(productId);
        customer.getCart().addProduct(product);
    }
}
