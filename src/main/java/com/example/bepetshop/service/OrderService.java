package com.example.bepetshop.service;



import com.example.bepetshop.models.Order;
import com.example.bepetshop.models.request.AddOrderRequest;
import com.example.bepetshop.models.request.ChangeStatusRequest;
import com.example.bepetshop.models.response.OrderDto;

import java.util.List;

public interface OrderService {

    Order generateOrder(AddOrderRequest request);

    Order updateStatus(ChangeStatusRequest request);


    List<Order> getListOrderByOrderSuccess();

    List<Order> getListOrderByOrderDelivery();

    List<Order> getListOrderByOrderWaitingForProgressing();

    List<Order> getListOrderByOrderCancelled();


    List<Order> findOrderByUserId();

}
