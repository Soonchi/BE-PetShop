package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class AddOrderRequest {

    private String addressofrecevicer , numberofreceiver, nameofreceiver;

    private long quantityProduct;
}
