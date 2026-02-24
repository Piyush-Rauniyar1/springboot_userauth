package org.piyush.userauthentication.controller;

import org.springframework.web.bind.annotation.*;

import org.piyush.userauthentication.dto.RegisterRequest;
import org.piyush.userauthentication.dto.RegisterResponse;
import org.piyush.userauthentication.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RegisterResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }
}
