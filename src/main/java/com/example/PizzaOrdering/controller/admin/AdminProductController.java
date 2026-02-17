package com.example.PizzaOrdering.controller.admin;

import com.example.PizzaOrdering.dto.admin.CreateProductRequest;
import com.example.PizzaOrdering.service.admin.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")

public class AdminProductController {

    private final AdminProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(
            @RequestBody CreateProductRequest request) {

        return ResponseEntity.ok(
                productService.createProduct(request));
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateStock(
            @PathVariable Long id,
            @RequestParam Integer quantity) {

        return ResponseEntity.ok(
                productService.updateStock(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
