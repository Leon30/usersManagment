package com.github.leon30.usersManagment.repository;

import com.github.leon30.usersManagment.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String>{
    List<User> findByDoc(Long doc);
    List<User> findAll();

    public long count();
}
