package com.example.bepetshop.service;


import com.example.bepetshop.models.Cart;
import com.example.bepetshop.models.request.AddToCartRequest;
import com.example.bepetshop.models.request.UpdateCartRequest;

import java.util.Optional;

public interface CartService {
    Optional<Cart> findCartByUserId();


    Cart addToCart(AddToCartRequest request);

    Cart findCartByUser();

    String updateCart(UpdateCartRequest request);

    boolean deleteFormCart(long productId);

}
