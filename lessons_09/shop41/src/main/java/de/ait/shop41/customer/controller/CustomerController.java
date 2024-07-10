package de.ait.shop41.customer.controller;

import de.ait.shop41.customer.entity.Customer;
import de.ait.shop41.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

//    private static List<Customer> customers = new ArrayList<Customer>(List.of(
//            new Customer(1L, "Nikolas", "nikolas@mail.com", 123009915),
//            new Customer(2L, "Anna", "anna@mail.com", 123007819),
//            new Customer(3L, "Alex", "alex@mail.com", 123007823),
//            new Customer(4L, "Bob", "bob@mail.com", 123007824),
//            new Customer(5L, "David", "david@mail.com", 123007825),
//            new Customer(6L, "John", "john@mail.com", 123007826),
//            new Customer(7l, "Jane", "jane@mail.com", 123007827),
//            new Customer(8L, "Marija", "marija@mail.com", 123005416),
//            new Customer(9L, "John", "john12@mail.com", 123005417),
//            new Customer(10L, "Max", "max@mail.com", 123006767)
//    ));

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
