package com.example.bepetshop.service.impl;

import com.example.bepetshop.models.Comment;
import com.example.bepetshop.models.User;
import com.example.bepetshop.models.request.AddCommentRequest;
import com.example.bepetshop.models.response.CommentDto;
import com.example.bepetshop.repository.CommentRepository;
import com.example.bepetshop.repository.ProductRepository;
import com.example.bepetshop.service.CommentService;
import com.example.bepetshop.service.CustomUserDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {

    private final ProductRepository productRepository;

    private final CustomUserDetailService userDetailsService;

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceimpl(ProductRepository productRepository, CustomUserDetailService userDetailsService, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.userDetailsService = userDetailsService;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Comment addComment(AddCommentRequest request) {
        var product = productRepository.findById(request.getProductId());
        var user = new User();
        user.setUsername(userDetailsService.getPrincipal().getUsername());
        user.setPassword(userDetailsService.getPrincipal().getPassword());
        user.setId(userDetailsService.getPrincipal().getId());
        user.setCart(userDetailsService.getPrincipal().getCart());

        var comment = new Comment();
        comment.setProduct(product.get());
        comment.setUser(user);
        comment.setContent(request.getContent());
        comment.setProductId(request.getProductId());
        comment.setUserId(user.getId());
        comment.setName(user.getUsername());

        return commentRepository.save(comment);
    }


}