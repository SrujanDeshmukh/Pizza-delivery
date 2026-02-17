package com.example.PizzaOrdering.service.user;

import com.example.PizzaOrdering.dto.user.PlaceOrderRequest;
import com.example.PizzaOrdering.entity.*;
import com.example.PizzaOrdering.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final OrderItemRepository itemRepo;
    private final CartRepository cartRepo;
    private final CartItemRepository cartItemRepo;
    private final UserRepository userRepo;

    public Order placeOrder(Long userId,
                            PlaceOrderRequest req) {

        User user = userRepo.findById(userId).orElseThrow();
        Cart cart = cartRepo.findByUser(user).orElseThrow();

        List<CartItem> items = cartItemRepo.findByCart(cart);

        double total = items.stream()
                .mapToDouble(i ->
                        i.getProduct().getPrice() * i.getQuantity())
                .sum();

        Order order = new Order();

        order.setUser(user);
        order.setShop(items.get(0).getProduct().getShop());
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setStatus(OrderStatus.PLACED);
        order.setTotalAmount(total);
        order.setDeliveryAddress(req.getDeliveryAddress());

        order = orderRepo.save(order);

        for (CartItem ci : items) {

            OrderItem oi = new OrderItem();

            oi.setOrder(order);
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(ci.getProduct().getPrice());

            itemRepo.save(oi);
        }

        cartItemRepo.deleteAll(items);

        return order;
    }

    public List<Order> getUserOrders(Long userId) {

        User user = userRepo.findById(userId).orElseThrow();
        return orderRepo.findByUser(user);
    }
}
