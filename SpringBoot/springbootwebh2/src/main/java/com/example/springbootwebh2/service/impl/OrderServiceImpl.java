package com.example.springbootwebh2.service.impl;

import com.example.springbootwebh2.model.Order;
import com.example.springbootwebh2.repository.OrderRepository;
import com.example.springbootwebh2.service.OrderService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalUser = orderRepository.findById(orderId);
        return optionalUser.get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).get();
        //existingOrder.setFirstName(user.getFirstName());
        Order updatedOrder = orderRepository.save(existingOrder);
        return updatedOrder;
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    
}
