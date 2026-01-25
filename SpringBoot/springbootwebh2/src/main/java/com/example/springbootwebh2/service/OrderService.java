package com.example.springbootwebh2.service;

import java.util.List;

import com.example.springbootwebh2.model.Order;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}
