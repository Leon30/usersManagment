package com.github.leon30.usersManagment.repository;

import com.github.leon30.usersManagment.models.UserAuth;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserAuthRepository extends MongoRepository<UserAuth,String> {

    List<UserAuth> findByUsername(String username);

}
