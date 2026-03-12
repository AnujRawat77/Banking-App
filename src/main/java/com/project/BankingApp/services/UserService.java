package com.project.BankingApp.services;

import com.project.BankingApp.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public User creatUser(String userName){
        User user = new User();

        user.setId( (int)(Math.random()*100) );
        user.setName(userName);
        user.setBalance(0.0);
        user.setTransactions(new ArrayList<>());

        return user;
    }

    public List<User> getAllUsers(){
        return null;
    }

}
