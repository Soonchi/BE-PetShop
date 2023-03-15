package com.example.bepetshop.models.response;

import lombok.Data;

@Data
public class AddCommentResponse {

    private long id;

    private String content;

    private String name;
}