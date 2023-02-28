package com.example.bepetshop.service.impl;



import com.example.bepetshop.models.Order;
import com.example.bepetshop.models.User;
import com.example.bepetshop.models.request.AddOrderRequest;
import com.example.bepetshop.models.request.ChangeStatusRequest;
import com.example.bepetshop.repository.*;
import com.example.bepetshop.service.CustomUserDetailService;
import com.example.bepetshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceimpl implements OrderService {

    private final CustomUserDetailService userDetailsService;
    private final ProductRepository productRepository;
    private final OrderDeatailRepository orderDeatailRepository;
    private final OrderRepository orderRepository;
    private final CustomUserDetailService userDetailService;
    private final CartRepository cartRepository;
    private final ProductCartRepository productCartRepository;

    public OrderServiceimpl(CustomUserDetailService userDetailsService, ProductRepository productRepository, OrderDeatailRepository orderDeatailRepository, OrderRepository orderRepository, CustomUserDetailService userDetailService, CartRepository cartRepository, ProductCartRepository productCartRepository) {
        this.userDetailsService = userDetailsService;
        this.productRepository = productRepository;
        this.orderDeatailRepository = orderDeatailRepository;
        this.orderRepository = orderRepository;
        this.userDetailService = userDetailService;
        this.cartRepository = cartRepository;
        this.productCartRepository = productCartRepository;
    }

    @Override
    public Order generateOrder(AddOrderRequest request) {
        var user = new User();
        user.setUsername(userDetailService.getPrincipal().getUsername());
        user.setPassword(userDetailService.getPrincipal().getPassword());
        user.setId(userDetailService.getPrincipal().getId());
        var order = new Order();
        order.setNameofreceiver(request.getNameofreceiver());
        order.setNumberofreceiver(request.getNumberofreceiver());
        order.setAddressofrecevicer(request.getAddressofrecevicer());
        order.setStatus("Chờ xử lí");
        order.setOrderDate(new Date());
        order.setUser(user);
        return orderRepository.save(order);
    }




    @Override
    public Order updateStatus(ChangeStatusRequest request) {

        var order = orderRepository.findOrderById(request.getId());
        order.setStatus(request.getStatus());

        return orderRepository.save(order);
    }



    @Override
    public List<Order> getListOrderByOrderSuccess(String status) {
        return orderRepository.findByStatus("Order Success");
    }

    @Override
    public List<Order> getListOrderByOrderComplete(String status) {
        return orderRepository.findByStatus("Order Complete");
    }

    @Override
    public List<Order> findOrderByUserId() {
        var user = new User();
        user.setUsername(userDetailsService.getPrincipal().getUsername());
        user.setPassword(userDetailsService.getPrincipal().getPassword());
        user.setId(userDetailsService.getPrincipal().getId());
        user.setCart(userDetailsService.getPrincipal().getCart());
        return orderRepository.findByUserId(user.getId());
    }



}
