package com.github.leon30.usersManagment.repository;

import com.github.leon30.usersManagment.models.UserImp;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserImp,String>{
    List<UserImp> findByDoc(Long doc);
    List<UserImp> findAll();

    public long count();
}
