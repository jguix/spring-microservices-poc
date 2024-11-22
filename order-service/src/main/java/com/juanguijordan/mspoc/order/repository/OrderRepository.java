package com.juanguijordan.mspoc.order.repository;


import com.juanguijordan.mspoc.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
