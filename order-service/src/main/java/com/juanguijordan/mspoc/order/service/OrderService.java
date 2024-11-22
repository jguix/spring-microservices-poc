package com.juanguijordan.mspoc.order.service;

import java.util.List;

import com.juanguijordan.mspoc.order.dto.OrderDTO;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
}
