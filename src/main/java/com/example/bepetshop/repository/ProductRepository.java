package com.example.bepetshop.repository;


import com.example.bepetshop.models.Category;
import com.example.bepetshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findProductByCategory(Category category);
}
