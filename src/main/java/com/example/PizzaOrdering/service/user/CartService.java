package com.example.PizzaOrdering.service.user;

import com.example.PizzaOrdering.dto.user.AddToCartRequest;
import com.example.PizzaOrdering.entity.Cart;
import com.example.PizzaOrdering.entity.CartItem;
import com.example.PizzaOrdering.entity.Product;
import com.example.PizzaOrdering.entity.User;
import com.example.PizzaOrdering.repository.CartItemRepository;
import com.example.PizzaOrdering.repository.CartRepository;
import com.example.PizzaOrdering.repository.ProductRepository;
import com.example.PizzaOrdering.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public void addToCart(Long userId,
                          AddToCartRequest req) {

        User user = userRepo.findById(userId).orElseThrow();

        Cart cart = cartRepo.findByUser(user)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUser(user);
                    return cartRepo.save(c);
                });

        Product product = productRepo.findById(req.getProductId())
                .orElseThrow();

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(req.getQuantity());

        itemRepo.save(item);
    }

    public List<CartItem> getCart(Long userId) {

        User user = userRepo.findById(userId).orElseThrow();
        Cart cart = cartRepo.findByUser(user).orElseThrow();

        return itemRepo.findByCart(cart);
    }
}
