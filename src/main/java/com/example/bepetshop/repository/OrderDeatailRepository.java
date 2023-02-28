package com.example.bepetshop.repository;

import com.example.bepetshop.models.Order;
import com.example.bepetshop.models.OrderDetail;
import com.example.bepetshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDeatailRepository extends JpaRepository<OrderDetail, Long> {
    OrderDetail findByProductAndAndOrder(Product product, Order order);

}
