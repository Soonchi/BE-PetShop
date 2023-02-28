package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class AddRoletoUserRequest {
    private String username;
    private String rolename;
}
