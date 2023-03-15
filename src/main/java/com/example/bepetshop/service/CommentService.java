package com.example.bepetshop.service;

import com.example.bepetshop.models.Comment;
import com.example.bepetshop.models.request.AddCommentRequest;

import java.util.List;

public interface CommentService {

    Comment addComment(AddCommentRequest request);

}