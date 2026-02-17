package com.example.PizzaOrdering.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Role;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}

