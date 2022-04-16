package com.example.waaonlineminimarketbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String orderDate;
    private String orderTime;

    @OneToMany()
    @JoinColumn(name = "order_id")
    List<Item> itemList;

    @OneToOne
    private OrderStatus orderStatus;
}
