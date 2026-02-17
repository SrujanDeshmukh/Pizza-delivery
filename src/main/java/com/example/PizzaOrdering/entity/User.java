package com.example.PizzaOrdering.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.example.PizzaOrdering.entity.Role;


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

    private boolean emailVerified;
    private String otp;
}

