package com.example.PizzaOrdering.controller.admin;

import com.example.PizzaOrdering.entity.Shop;
import com.example.PizzaOrdering.service.admin.AdminShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/shops")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminShopController {

    private final AdminShopService shopService;

    @PostMapping
    public ResponseEntity<?> createShop(@RequestBody Shop shop) {
        return ResponseEntity.ok(shopService.createShop(shop));
    }

    @GetMapping
    public ResponseEntity<?> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }
}

