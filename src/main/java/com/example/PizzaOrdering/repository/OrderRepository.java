package com.example.PizzaOrdering.repository;

import com.example.PizzaOrdering.entity.Order;
import com.example.PizzaOrdering.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}

