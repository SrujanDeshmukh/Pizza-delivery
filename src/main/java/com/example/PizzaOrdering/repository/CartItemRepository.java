package com.example.PizzaOrdering.repository;

import com.example.PizzaOrdering.entity.Cart;
import com.example.PizzaOrdering.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);
}

