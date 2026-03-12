package com.project.BankingApp.tests.annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

// Depends , Priority, Factory

public class LoginTest {
    private final String userType;

    public LoginTest(String userType){
        this.userType = userType;
    }

    @Test(testName = "TC_User_01")
    public void testUser(){
        System.out.println("Login User Type: "+userType);
    }

    @Test(dependsOnMethods = {"testUser"})
    public void testAddition(){
        Assert.assertEquals(2+5, 7);
    }
}
