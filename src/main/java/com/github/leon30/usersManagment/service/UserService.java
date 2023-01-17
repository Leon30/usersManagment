package com.github.leon30.usersManagment.service;

import com.github.leon30.usersManagment.models.User;
import com.github.leon30.usersManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        List<User> users = userRepository.findByDoc(id);
        if(users.size() > 0) {
            return Optional.of(userRepository.findByDoc(id).get(0));
        }else{
            return Optional.empty();
        }
    }

    public Optional<User> modifyUser(Long id, User newUser){
        Optional<User> op = getUser(id);
        if(op.isPresent()){
            newUser.setId(op.get().getId());
            return Optional.of(save(newUser));
        }else{
            return Optional.empty();
        }
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean delete(Long id){
        return getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
