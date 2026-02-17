package com.example.PizzaOrdering.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

    private String orderNumber;
    private Double totalAmount;
    private String status;
}

