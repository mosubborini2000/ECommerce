package com.example.ECommerce.mapper.user;

import com.example.ECommerce.dto.auth.AuthResponse;
import com.example.ECommerce.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    AuthResponse userEntityToUserResponse(UserEntity userEntity);

}
