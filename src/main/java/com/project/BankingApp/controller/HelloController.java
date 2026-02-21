package com.project.BankingApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloMessage(){
        return "Hi! How are you.";
    }
}
