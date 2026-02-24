package org.piyush.userauthentication.service;

import org.piyush.userauthentication.dto.RegisterRequest;
import org.piyush.userauthentication.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
}
