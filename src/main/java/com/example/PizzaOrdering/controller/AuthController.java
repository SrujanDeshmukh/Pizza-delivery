package com.example.PizzaOrdering.controller;

import com.example.PizzaOrdering.dto.auth.AuthResponse;
import com.example.PizzaOrdering.dto.auth.LoginRequest;
import com.example.PizzaOrdering.dto.auth.RegisterRequest;
import com.example.PizzaOrdering.dto.auth.VerifyOtpRequest;

import com.example.PizzaOrdering.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(
            @RequestBody VerifyOtpRequest request) {

        return ResponseEntity.ok(authService.verifyOtp(request));
    }
}
