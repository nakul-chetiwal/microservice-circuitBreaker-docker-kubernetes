package com.learning.OrderService.service.Impl;

import com.learning.OrderService.entity.Order;
import com.learning.OrderService.model.OrderRequest;
import com.learning.OrderService.repository.OrderRepository;
import com.learning.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Log4j2
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Long save(OrderRequest orderRequest) {
        // Save order details in Order table
        Order order= Order.builder()
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getTotalAmount())
                .build();
      order= orderRepository.save(order);
      log.info("Order saved successfully in the with order ID " + order.getId());



        return order.getId();
    }
}
