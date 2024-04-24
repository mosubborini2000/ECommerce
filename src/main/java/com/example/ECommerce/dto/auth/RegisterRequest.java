package com.example.ECommerce.dto.auth;

import com.example.ECommerce.model.Role;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;

    private String password;
    private Role role;




}
