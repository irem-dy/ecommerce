package com.ecommerceapp.ecommerce.controller;

import com.ecommerceapp.ecommerce.entity.User;
import com.ecommerceapp.ecommerce.service.CustomUserDetailsService;
import com.ecommerceapp.ecommerce.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    // Manuel constructor
    public AuthController(CustomUserDetailsService userDetailsService,
                          JwtUtil jwtUtil,
                          AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Şifreyi encode et
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userDetailsService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            String jwt = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Kullanıcı adı veya şifre hatalı");
        }
    }

    // Basit JWT response DTO
    private record JwtResponse(String token) {}
}
