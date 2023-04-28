package com.demo.sandbox.service;

import java.util.List;

import com.demo.sandbox.model.Order;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}
