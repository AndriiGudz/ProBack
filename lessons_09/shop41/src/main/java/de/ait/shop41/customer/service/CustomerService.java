package de.ait.shop41.customer.service;

import de.ait.shop41.customer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    void deleteCustomerById(Long id);
}
