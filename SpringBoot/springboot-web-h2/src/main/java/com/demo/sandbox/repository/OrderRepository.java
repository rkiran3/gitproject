package com.demo.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.sandbox.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
