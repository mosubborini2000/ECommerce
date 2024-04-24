package com.example.ECommerce.controller;

import com.example.ECommerce.common.ApiResponse;
import com.example.ECommerce.dto.auth.AuthRequest;
import com.example.ECommerce.dto.auth.AuthResponse;
import com.example.ECommerce.dto.auth.RegisterRequest;
import com.example.ECommerce.service.auth.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v2/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest registerRequest
            ){
//        authService.register(registerRequest);
        return  ResponseEntity.ok( authService.register(registerRequest));


    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest authRequest
            ){
        authService.authenticate(authRequest);
        return  ResponseEntity.ok( authService.authenticate(authRequest));



    }

}
