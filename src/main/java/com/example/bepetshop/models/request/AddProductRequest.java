package com.example.bepetshop.models.request;

import lombok.Data;

@Data
public class AddProductRequest {

    private String categoryName;

    private String name;

    private long quantity;

    private long price;

    private String description;

    private String ageRange;

}
