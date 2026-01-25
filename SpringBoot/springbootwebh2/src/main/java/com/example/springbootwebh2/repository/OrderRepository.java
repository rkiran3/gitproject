package com.example.springbootwebh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwebh2.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
