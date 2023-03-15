package com.example.bepetshop.models.response;

import com.example.bepetshop.models.User;
import lombok.Data;

import java.util.List;

@Data
public class CommentDto {
    private String content;
    private String name;
    private long productId;
}
