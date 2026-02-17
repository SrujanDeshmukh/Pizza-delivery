package com.example.PizzaOrdering.service;

import com.example.PizzaOrdering.dto.auth.*;
import com.example.PizzaOrdering.entity.Role;
import com.example.PizzaOrdering.entity.User;
import com.example.PizzaOrdering.repository.UserRepository;
import com.example.PizzaOrdering.security.CustomUserDetailsService;
import com.example.PizzaOrdering.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final CustomUserDetailsService userDetailsService;

    // 🔐 LOGIN
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!user.isEmailVerified()) {
            throw new RuntimeException("Email not verified!");
        }

        // Load UserDetails for JWT
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(user.getEmail());

        String token = jwtUtil.generateToken(userDetails);

        return new AuthResponse(
                token,
                user.getRole().name(),
                user.getEmail()
        );
    }

    // 📝 REGISTER (THIS WAS MISSING)
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists!";
        }

        // Generate OTP
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER); // default role
        user.setOtp(otp);
        user.setEmailVerified(false);

        userRepository.save(user);

        emailService.sendOtpEmail(user.getEmail(), otp);

        return "OTP sent to email!";
    }

    // ✅ VERIFY OTP
    public String verifyOtp(VerifyOtpRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (user.getOtp() == null ||
                !user.getOtp().equals(request.getOtp())) {
            return "Invalid OTP!";
        }

        user.setEmailVerified(true);
        user.setOtp(null);

        userRepository.save(user);

        return "Account verified successfully!";
    }
}
