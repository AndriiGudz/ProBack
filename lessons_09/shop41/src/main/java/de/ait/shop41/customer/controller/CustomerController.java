package de.ait.shop41.customer.controller;

import de.ait.shop41.customer.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private static List<Customer> customers = new ArrayList<Customer>(List.of(
            new Customer(1L, "Nikolas", "nikolas@mail.com", 123009915),
            new Customer(2L, "Anna", "anna@mail.com", 123007819),
            new Customer(3L, "Alex", "alex@mail.com", 123007823),
            new Customer(4L, "Bob", "bob@mail.com", 123007824),
            new Customer(5L, "David", "david@mail.com", 123007825),
            new Customer(6L, "John", "john@mail.com", 123007826),
            new Customer(7l, "Jane", "jane@mail.com", 123007827),
            new Customer(8L, "Marija", "marija@mail.com", 123005416),
            new Customer(9L, "John", "john12@mail.com", 123005417),
            new Customer(10L, "Max", "max@mail.com", 123006767)
    ));

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customers.stream()
                .filter(c -> c.getId() == id).findFirst().orElse(null);
    }

}
