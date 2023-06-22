package com.learning.OrderService.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="order_")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name="PRODUCT_ID")
    private Long productId;

    @Column(name="QUANTITY")
    private Long quantity;
    @Column(name="ORDER_DATE")
    private Instant orderDate;
    @Column(name="STATUS")
    private String orderStatus;
    @Column(name="TOTAL_AMOUNT")
    private Long amount;
}
