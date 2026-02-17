package com.example.PizzaOrdering.service.user;

import com.example.PizzaOrdering.entity.Product;
import com.example.PizzaOrdering.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;

    public List<Product> getByShop(Long shopId) {
        return productRepo.findByShopId(shopId);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

