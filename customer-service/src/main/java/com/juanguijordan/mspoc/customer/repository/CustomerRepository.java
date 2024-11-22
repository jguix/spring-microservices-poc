package com.juanguijordan.mspoc.customer.repository;

import com.juanguijordan.mspoc.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
