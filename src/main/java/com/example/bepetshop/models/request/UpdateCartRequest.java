package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class UpdateCartRequest {

    private long productId;
    private long quantity;
}
