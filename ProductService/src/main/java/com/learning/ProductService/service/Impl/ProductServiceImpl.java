package com.learning.ProductService.service.Impl;

import com.learning.ProductService.entity.Product;
import com.learning.ProductService.exception.ProductServiceCustomException;
import com.learning.ProductService.model.ProductRequest;
import com.learning.ProductService.repository.ProductRepository;
import com.learning.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        Product product =
                Product.builder()
                        .productName(productRequest.getProductName())
                        .price(productRequest.getPrice())
                        .quantity(productRequest.getQuantity())
                        .build();
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductRequest getProductById(Long id) {
        Product product= productRepository.findById(id)
                .orElseThrow(() -> new ProductServiceCustomException("Product Id: " + id + "not found","ID_NOT_FOUND"));
         ProductRequest productRequest=ProductRequest.builder()
                 .productId(product.getProductId())
                 .productName(product.getProductName())
                 .price(product.getPrice())
                 .quantity(product.getQuantity())
                 .build();
        return productRequest;
    }
}
