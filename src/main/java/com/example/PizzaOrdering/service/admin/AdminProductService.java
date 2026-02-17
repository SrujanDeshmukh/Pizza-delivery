package com.example.PizzaOrdering.service.admin;

import com.example.PizzaOrdering.dto.admin.CreateProductRequest;
import com.example.PizzaOrdering.entity.Category;
import com.example.PizzaOrdering.entity.Product;
import com.example.PizzaOrdering.entity.Shop;
import com.example.PizzaOrdering.repository.CategoryRepository;
import com.example.PizzaOrdering.repository.ProductRepository;
import com.example.PizzaOrdering.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(CreateProductRequest request) {

        Shop shop = shopRepository.findById(request.getShopId())
                .orElseThrow(() -> new RuntimeException("Shop not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setShop(shop);
        product.setCategory(category);
        product.setIsAvailable(true);

        return productRepository.save(product);
    }

    public Product updateStock(Long id, Integer quantity) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStockQuantity(quantity);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}


