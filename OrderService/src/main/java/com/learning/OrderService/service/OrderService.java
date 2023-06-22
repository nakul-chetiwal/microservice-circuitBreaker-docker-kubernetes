package com.learning.OrderService.service;

import com.learning.OrderService.model.OrderRequest;

public interface OrderService {
    public Long save(OrderRequest orderRequest);
}
