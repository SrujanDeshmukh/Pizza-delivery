package com.example.PizzaOrdering.dto.admin;

import lombok.Data;

@Data
public class AdminOrderResponse {
    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String deliveryAddress;
    private String orderStatus;
    private String orderDate;
    private String totalAmount;
}
