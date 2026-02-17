package com.example.PizzaOrdering.controller.user;

import com.example.PizzaOrdering.entity.Shop;
import com.example.PizzaOrdering.service.user.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/shops")
@RequiredArgsConstructor
public class UserShopController {

    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<List<Shop>> getAll() {
        return ResponseEntity.ok(
                shopService.getAllShops()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> get(@PathVariable Long id) {
        return ResponseEntity.ok(
                shopService.getShop(id)
        );
    }
}

