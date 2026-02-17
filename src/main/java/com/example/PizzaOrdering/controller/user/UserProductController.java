package com.example.PizzaOrdering.controller.user;

import com.example.PizzaOrdering.entity.Product;
import com.example.PizzaOrdering.service.user.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/products")
@RequiredArgsConstructor
public class UserProductController {

    private final ProductService productService;

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Product>> getByShop(
            @PathVariable Long shopId) {

        return ResponseEntity.ok(
                productService.getByShop(shopId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.getProduct(id)
        );
    }
}

