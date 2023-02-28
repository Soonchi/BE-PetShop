package com.example.bepetshop.models.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer ";



    public LoginResponse(String token) {
        this.accessToken = token;
    }
}
