package com.juanguijordan.mspoc.customer.service;

import java.util.List;

import com.juanguijordan.mspoc.customer.dto.CustomerDTO;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
}
