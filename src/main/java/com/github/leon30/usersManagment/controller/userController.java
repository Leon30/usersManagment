package com.github.leon30.usersManagment.controller;

import com.github.leon30.usersManagment.models.UserImp;
import com.github.leon30.usersManagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<UserImp>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{doc}")
    public ResponseEntity<UserImp> getUser(@PathVariable("doc") Long doc){
        return userService.getUser(doc)
                .map(user -> new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{doc}")
    public ResponseEntity<UserImp> modifyUser(@PathVariable("doc") Long doc, @RequestBody UserImp user){
        return userService.modifyUser(doc,user)
                .map(u -> new ResponseEntity<>(u,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("save")
    public ResponseEntity<UserImp> save(@RequestBody UserImp user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        if(userService.delete(Long.parseLong(id))){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
