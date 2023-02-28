package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
