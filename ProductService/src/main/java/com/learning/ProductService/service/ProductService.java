package com.learning.ProductService.service;

import com.learning.ProductService.model.ProductRequest;

public interface ProductService {
    public Long addProduct(ProductRequest productRequest);

    ProductRequest getProductById(Long id);
}
