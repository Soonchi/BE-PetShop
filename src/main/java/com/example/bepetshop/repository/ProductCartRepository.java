package com.example.bepetshop.repository;



import com.example.bepetshop.models.Cart;
import com.example.bepetshop.models.Product;
import com.example.bepetshop.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    ProductCart findByCartAndProduct(Cart cart, Product product);

    List<ProductCart> findByCart(Cart cart);
}
