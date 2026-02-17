package com.example.PizzaOrdering.service.admin;

import com.example.PizzaOrdering.dto.admin.CreateCategoryRequest;
import com.example.PizzaOrdering.entity.Category;
import com.example.PizzaOrdering.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CreateCategoryRequest request) {

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
