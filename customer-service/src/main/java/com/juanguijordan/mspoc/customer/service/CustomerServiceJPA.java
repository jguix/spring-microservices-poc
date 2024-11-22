package com.juanguijordan.mspoc.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.juanguijordan.mspoc.customer.dto.CustomerDTO;
import com.juanguijordan.mspoc.customer.entity.Customer;
import com.juanguijordan.mspoc.customer.repository.CustomerRepository;

@Service
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceJPA(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(this::mapToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToCustomerDTO(customer);
    }

    private CustomerDTO mapToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }
}
