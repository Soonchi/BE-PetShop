package com.example.bepetshop.repository;


import com.example.bepetshop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    Optional<Category> findCategoriesById(Long id);
}
