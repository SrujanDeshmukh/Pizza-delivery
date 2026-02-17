package com.example.PizzaOrdering.dto.user;

import lombok.Data;

@Data
public class AddToCartRequest {

    private Long productId;

    private Integer quantity;
}

