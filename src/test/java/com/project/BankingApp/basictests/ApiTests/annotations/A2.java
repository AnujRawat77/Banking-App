package com.project.BankingApp.basictests.ApiTests.annotations;

import org.testng.Assert;
import org.testng.annotations.*;

public class A2 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @DataProvider(name = "AdditionData")
    public Object[][] additionData(){
        return new Object[][]{
                {2, 2, 4},
                {5, 2, 7}
        };
    }

    @Test(dataProvider = "AdditionData")
    public void testAddition(int a, int b, int result){
        Assert.assertEquals(a+b, result);
    }


    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterSuite
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

}
