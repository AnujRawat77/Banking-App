package com.project.BankingApp.tests.annotations;

import org.testng.annotations.Factory;

public class LoginFactory {

    @Factory
    public Object[] createLoginUser(){
        return new Object[]{
                new LoginTest("ADMIN"),
                new LoginTest("USER"),
                new LoginTest("GUEST"),
        };
    }

}
