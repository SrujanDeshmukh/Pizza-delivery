package com.example.PizzaOrdering.repository;

import com.example.PizzaOrdering.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}

