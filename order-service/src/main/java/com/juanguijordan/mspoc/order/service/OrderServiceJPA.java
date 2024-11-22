package com.juanguijordan.mspoc.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.juanguijordan.mspoc.order.client.CustomerClient;
import com.juanguijordan.mspoc.order.dto.CustomerDTO;
import com.juanguijordan.mspoc.order.dto.OrderDTO;
import com.juanguijordan.mspoc.order.entity.Order;
import com.juanguijordan.mspoc.order.repository.OrderRepository;

@Service
public class OrderServiceJPA implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public OrderServiceJPA(OrderRepository orderRepository, CustomerClient customerClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToOrderDTO)
                .collect(Collectors.toList());
    }


    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToOrderDTO(order);
    }

    private OrderDTO mapToOrderDTO(Order order) {
        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setSku(order.getSku());
        orderDTO.setProductName(order.getProductName());
        orderDTO.setUnits(order.getUnits());
        orderDTO.setCustomer(customer);
        return orderDTO;
    }
}
