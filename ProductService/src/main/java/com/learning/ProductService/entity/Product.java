package com.learning.ProductService.entity;

import lombok.*;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
   @Column(name="PRODUCT_NAME")
    private String productName;
   @Column(name="PRICE")
    private Long price;
   @Column(name="QUANTITY")
    private Long quantity;


}
