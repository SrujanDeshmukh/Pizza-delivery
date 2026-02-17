package com.example.PizzaOrdering.service.user;

import com.example.PizzaOrdering.entity.Shop;
import com.example.PizzaOrdering.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepo;

    public List<Shop> getAllShops() {
        return shopRepo.findAll();
    }

    public Shop getShop(Long id) {
        return shopRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
    }
}
