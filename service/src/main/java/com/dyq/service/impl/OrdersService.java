package com.dyq.service.impl;

import com.dyq.domain.Orders;

public interface OrdersService {
    Orders findOrdersById(Long Id);

    Orders findOrdersByUserId(Long userId);

    void insertOrders(Long Id,Long userId, Double price, String content);

    int deleteOrders(Long id);

    int updateOrdersById(String content, Long Id);

    int updateOrdersByUserId(String content, Long userId);
}
