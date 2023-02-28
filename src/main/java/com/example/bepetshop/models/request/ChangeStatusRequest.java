package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class ChangeStatusRequest {
    private long id;
    private String status;
}
