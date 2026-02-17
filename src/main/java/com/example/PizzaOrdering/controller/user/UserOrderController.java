package com.example.PizzaOrdering.controller.user;

import com.example.PizzaOrdering.dto.user.PlaceOrderRequest;
import com.example.PizzaOrdering.entity.Order;
import com.example.PizzaOrdering.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/orders")
@RequiredArgsConstructor
public class UserOrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Order> place(
            @RequestParam Long userId,
            @RequestBody PlaceOrderRequest req) {

        return ResponseEntity.ok(
                orderService.placeOrder(userId, req)
        );
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                orderService.getUserOrders(userId)
        );
    }
}
