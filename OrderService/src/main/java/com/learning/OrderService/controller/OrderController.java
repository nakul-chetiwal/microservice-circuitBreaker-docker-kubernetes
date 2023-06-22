package com.learning.OrderService.controller;

import com.learning.OrderService.model.OrderRequest;
import com.learning.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.save(orderRequest), HttpStatus.CREATED);
    }
}