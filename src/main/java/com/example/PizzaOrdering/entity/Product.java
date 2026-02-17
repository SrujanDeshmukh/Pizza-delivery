package com.example.PizzaOrdering.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Boolean isAvailable;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private Category category;
}
