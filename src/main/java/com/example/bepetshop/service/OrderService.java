package com.example.bepetshop.service;



import com.example.bepetshop.models.Order;
import com.example.bepetshop.models.request.AddOrderRequest;
import com.example.bepetshop.models.request.ChangeStatusRequest;

import java.util.List;

public interface OrderService {

    Order generateOrder(AddOrderRequest request);

    Order updateStatus(ChangeStatusRequest request);


    List<Order> getListOrderByOrderSuccess(String status);

    List<Order> getListOrderByOrderComplete(String status);


    List<Order> findOrderByUserId();
}
