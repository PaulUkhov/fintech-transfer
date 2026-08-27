package org.fintechtransfer.controller;

import org.fintechtransfer.dto.*;
import org.fintechtransfer.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
   private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public ResponseEntity<AuthResponse> register(RegisterRequest registerRequest){

    }
public ResponseEntity<AuthResponse> login(LoginRequest loginRequest){}
public ResponseEntity<AuthResponse> refresh(RefreshRequest refreshRequest){}
public ResponseEntity<Void> logout(RefreshRequest refreshRequest){}
public ResponseEntity<UserDto> me(UserEntity userEntity){}

}
