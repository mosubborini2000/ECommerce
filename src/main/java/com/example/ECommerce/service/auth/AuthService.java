package com.example.ECommerce.service.auth;

import com.example.ECommerce.config.JwtService;
import com.example.ECommerce.dto.auth.AuthRequest;
import com.example.ECommerce.dto.auth.AuthResponse;
import com.example.ECommerce.dto.auth.RegisterRequest;
import com.example.ECommerce.model.Role;
import com.example.ECommerce.model.UserEntity;
import com.example.ECommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        UserEntity userEntity=UserEntity.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
        userRepository.save(userEntity);
        var jwtToken=jwtService.generateToken(userEntity);
        return AuthResponse.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .token(jwtToken)
                .build();

    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword())
        );
                var user=userRepository.findByUsername(authRequest.getUsername()).orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();

    }

}
