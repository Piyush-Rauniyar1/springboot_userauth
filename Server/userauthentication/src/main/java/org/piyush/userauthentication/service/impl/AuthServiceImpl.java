package org.piyush.userauthentication.service.impl;

import org.springframework.stereotype.Service;

import org.piyush.userauthentication.dto.RegisterRequest;
import org.piyush.userauthentication.dto.RegisterResponse;
import org.piyush.userauthentication.entity.User;
import org.piyush.userauthentication.repository.UserRepository;
import org.piyush.userauthentication.service.AuthService;
import org.piyush.userauthentication.service.PasswordService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public AuthServiceImpl(UserRepository userRepository,
            PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {

        User user = new User();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        // Hash password
        user.setPasswordHash(passwordService.hash(request.getPassword()));

        // Set role (required by entity)
        user.setRole("USER");

        // Save UNVERIFIED
        user.setVerified(false);

        userRepository.save(user);

        return new RegisterResponse("User registered successfully");
    }
}
