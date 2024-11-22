package com.juanguijordan.mspoc.customer.config;

import com.juanguijordan.mspoc.customer.entity.Customer;
import com.juanguijordan.mspoc.customer.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CustomerRepository customerRepository;

    public DataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void init() {
        customerRepository.save(new Customer(null, "John", "Doe", "123 Main St"));
        customerRepository.save(new Customer(null, "Jane", "Smith", "456 Elm St"));
        customerRepository.save(new Customer(null, "Alice", "Johnson", "789 Oak St"));
        System.out.println("Customer data initialized.");
    }
}
