package com.example.PizzaOrdering.repository;

import com.example.PizzaOrdering.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {}

