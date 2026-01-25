package com.example.springbootwebh2.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootwebh2.model.Order;
import com.example.springbootwebh2.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

//	@Autowired
//    private OrderService orderService;

    // build create User REST API
//    @PostMapping
//    public ResponseEntity<Order> createOrder(@RequestBody Order order){
//        Order savedOrder = orderService.createOrder(order);
//        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
//    }

//    // build get user by id REST API
//    // http://localhost:8080/api/orders/1
//    @GetMapping("{id}")
//    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId){
//        Order order = orderService.getOrderById(orderId);
//        return new ResponseEntity<>(order, HttpStatus.OK);
//    }
//
//    // Build Get All Users REST API
//    // http://localhost:8080/api/users
//    @GetMapping
//    public ResponseEntity<List<Order>> getAllUsers(){
//        List<Order> orders = orderService.getAllOrders();
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }
//
//    // Build Update User REST API
//    @PutMapping("{id}")
//    // http://localhost:8080/api/orders/1
//    public ResponseEntity<Order> updateUser(@PathVariable("id") Long orderId,
//                                           @RequestBody Order order){
//        //order.setId(orderId);
//        Order updatedOrder = orderService.updateOrder(order);
//        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
//    }
//
//    // Build Delete User REST API
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
//        orderService.deleteOrder(orderId);
//        return new ResponseEntity<>("Order successfully deleted!", HttpStatus.OK);
//    }
}
