package com.example.bepetshop.models.response;

import lombok.Data;

@Data
public class AddProductResponse {

    private long id;

    private String name;

    private long quantity;

    private long price;

    private String description;

    private String ageRange;

    private String categoryName;

    private String image;


}
