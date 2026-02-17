package com.example.PizzaOrdering.service.admin;

import com.example.PizzaOrdering.entity.Order;
import com.example.PizzaOrdering.entity.OrderStatus;
import com.example.PizzaOrdering.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Object updateStatus(Long id, OrderStatus status) {
        Order order =orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }
}
