package com.example.PizzaOrdering.controller.admin;

import com.example.PizzaOrdering.dto.admin.CreateCategoryRequest;
import com.example.PizzaOrdering.service.admin.AdminCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminCategoryController {

    private final AdminCategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(
            @RequestBody CreateCategoryRequest request) {

        return ResponseEntity.ok(
                categoryService.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(
                categoryService.getAllCategories());
    }
}

