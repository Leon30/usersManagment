package com.github.leon30.usersManagment.controller;

import com.github.leon30.usersManagment.dto.AuthenticationRequest;
import com.github.leon30.usersManagment.dto.AuthenticationResponse;
import com.github.leon30.usersManagment.models.UserAuth;
import com.github.leon30.usersManagment.security.Token;
import com.github.leon30.usersManagment.service.UserAuthService;
import com.github.leon30.usersManagment.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class userAuthController {

    @Autowired
    UserAuthService userAuthService;

    @GetMapping("/{name}")
    public ResponseEntity<UserAuth> getUser(@PathVariable("name") String username){
        return userAuthService.getUser(username)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAuthService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            Token jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt.getToken(),jwt.getExpires_in()), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
