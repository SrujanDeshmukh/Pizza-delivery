package com.example.PizzaOrdering.repository;

import com.example.PizzaOrdering.entity.Cart;
import com.example.PizzaOrdering.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}

