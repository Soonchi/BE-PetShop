package com.example.bepetshop.controller;

import com.example.bepetshop.models.Comment;
import com.example.bepetshop.models.request.AddCommentRequest;
import com.example.bepetshop.models.response.AddCommentResponse;
import com.example.bepetshop.models.response.CommentDto;
import com.example.bepetshop.repository.CommentRepository;
import com.example.bepetshop.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;

    public CommentController(CommentService commentService, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("addComment")
    public ResponseEntity<AddCommentResponse> addComment(@RequestBody AddCommentRequest request){
        var comment = commentService.addComment( request);
        var commentResponse = modelMapper.map(comment, AddCommentResponse.class);
        return new ResponseEntity(commentResponse, HttpStatus.OK);
    }

}