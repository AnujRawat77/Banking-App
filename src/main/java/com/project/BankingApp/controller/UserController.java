package com.project.BankingApp.controller;

import com.project.BankingApp.entity.User;
import com.project.BankingApp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody String userName){
        try{
            User user = userService.creatUser(userName);
            return ResponseEntity.status(201).body(user);

        }catch (Exception e){
            log.error("Error creating user: {}", e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

}
