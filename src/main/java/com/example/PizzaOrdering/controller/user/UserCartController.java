package com.example.PizzaOrdering.controller.user;

import com.example.PizzaOrdering.dto.user.AddToCartRequest;
import com.example.PizzaOrdering.entity.CartItem;
import com.example.PizzaOrdering.service.user.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/cart")
@RequiredArgsConstructor
public class UserCartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> add(
            @RequestParam Long userId,
            @RequestBody AddToCartRequest req) {

        cartService.addToCart(userId, req);
        return ResponseEntity.ok("Added to cart");
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> get(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                cartService.getCart(userId)
        );
    }
}

