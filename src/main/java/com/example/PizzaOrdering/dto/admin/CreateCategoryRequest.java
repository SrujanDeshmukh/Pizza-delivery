package com.example.PizzaOrdering.dto.admin;

import lombok.Data;

@Data
public class CreateCategoryRequest {
    private String name;
    private String description;
}
