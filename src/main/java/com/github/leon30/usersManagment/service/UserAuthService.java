package com.github.leon30.usersManagment.service;

import com.github.leon30.usersManagment.models.UserAuth;
import com.github.leon30.usersManagment.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserAuthRepository userRepository;

    public List<UserAuth> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserAuth> getUser(String username){
        List<UserAuth> users = userRepository.findByUsername(username);
        if(users.size() > 0) {
            return Optional.of(userRepository.findByUsername(username).get(0));
        }else{
            return Optional.empty();
        }
    }

    public UserAuth save(UserAuth user){
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAuth> userDBop = getUser(username);
        if(userDBop.isPresent()){
            UserAuth userDB =userDBop.get();
            User user = new User(userDB.getUsername(),userDB.getHash(),new ArrayList<>());
            return user;
        }
        throw new UsernameNotFoundException(username);
    }
}
