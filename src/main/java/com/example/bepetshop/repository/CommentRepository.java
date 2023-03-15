package com.example.bepetshop.repository;

import com.example.bepetshop.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long > {

}