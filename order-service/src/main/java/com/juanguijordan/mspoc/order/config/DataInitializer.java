package com.juanguijordan.mspoc.order.config;

import com.juanguijordan.mspoc.order.entity.Order;
import com.juanguijordan.mspoc.order.repository.OrderRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final OrderRepository orderRepository;

    public DataInitializer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void init() {
        orderRepository.save(new Order(null, "SKU12345", "Metal Gloves", 10, 1L));
        orderRepository.save(new Order(null, "SKU67890", "Liquid Sandbox", 5, 2L));
        orderRepository.save(new Order(null, "SKU11121", "Flashy Light", 20, 3L));
        System.out.println("Order data initialized.");
    }
}
