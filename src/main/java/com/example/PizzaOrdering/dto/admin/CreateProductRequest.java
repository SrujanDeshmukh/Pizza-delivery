package com.example.PizzaOrdering.dto.admin;

import lombok.Data;

@Data
public class CreateProductRequest {

    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Long shopId;
    private Long categoryId;
}

