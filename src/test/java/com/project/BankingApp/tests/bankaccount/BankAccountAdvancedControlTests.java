package com.project.BankingApp.tests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountAdvancedControlTests {
    BankAccount account;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        account = new BankAccount(1000, "Alex");
    }

    @Test(testName = "TC_01_TransactionWithMultipleDeposits")
    public void testTransactionWithMultipleDeposits(){

        account.deposit(150);
        account.deposit(550);

        Assert.assertEquals(account.getBalance(), 1700.0, "Balance Should be 1700");
    }

    @Test(testName = "TC_02_TransactionWithMultipleWithdraws", dependsOnMethods = {"testTransactionWithMultipleDeposits"})
    public void testTransactionWithMultipleWithdraws(){

        account.withdraw(100);
        account.withdraw(200);

        Assert.assertEquals(account.getBalance(), 700.0, "Balance Should be 700");
    }

    @Test(testName = "TC_03_TestingRandom", enabled = false)
    public void testRandom(){
        Assert.assertTrue(true);
    }
}
