package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class AddCommentRequest {
    private long productId;

    private String content;
}