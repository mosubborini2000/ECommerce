package com.example.ECommerce.mapper.user;

import com.example.ECommerce.dto.auth.AuthRequest;
import com.example.ECommerce.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    UserEntity userRequestToUserEntity(AuthRequest userRequest);

}
