package com.example.PizzaOrdering.dto.auth;

import lombok.Data;

@Data
public class VerifyOtpRequest {

    private String email;
    private String otp;
}
