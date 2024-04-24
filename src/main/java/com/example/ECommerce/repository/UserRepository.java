package com.example.ECommerce.repository;

import com.example.ECommerce.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //step 2 cretae repo and method for unique filed
    //the username is unique
    //step 3 :create
    //jwt auth filter
    Optional<UserEntity> findByUsername(String username);

}
