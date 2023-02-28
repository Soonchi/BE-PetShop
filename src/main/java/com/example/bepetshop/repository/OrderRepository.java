package com.example.bepetshop.repository;


import com.example.bepetshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(String status);
    List<Order> findByUserId(long userId);

    Order findOrderById(long orderId);
}
