package com.project.BankingApp.tests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankAccountTransactionTests {

    BankAccount account;

    @BeforeMethod
    public void setUp(){
        account = new BankAccount(0, "Rohan Gupta");
    }

    @Test(testName = "TC_01_TransactionWithMultipleDeposits")
    public void testTransactionWithMultipleDeposits(){
        BankAccount account = new BankAccount(0, "Rohan");

        account.deposit(150);
        account.deposit(550);

        Assert.assertEquals(account.getBalance(), 700.0, "Balance Should be 700");
    }

    @Test(testName = "TC_02_TransactionWithMultipleWithdraws")
    public void testTransactionWithMultipleWithdraws(){
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(100);
        account.withdraw(200);

        Assert.assertEquals(account.getBalance(), 700.0, "Balance Should be 700");
    }

    @Test(testName = "TC_03_TransactionWithMultipleDepositWithdraws")
    public void testTransactionWithMultipleDepositWithdraws(){
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(100);
        account.deposit(200);

        Assert.assertEquals(account.getBalance(), 1100.0, "Balance Should be 1100");
    }

    @Test(testName = "TC_04_TransactionWithNegativeDepositAmount")
    public void testTransactionWithNegativeDepositAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.deposit(-521.3)
        );
        Assert.assertEquals(exception.getMessage(), "Deposit amount must be positive");
    }

    @Test(testName = "TC_05_TransactionWithWithdrawOverBalance")
    public void testTransactionWithWithdrawOverBalance(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Insufficient balance");
    }

    @Test(testName = "TC_06_TransactionWithNegativeWithdrawAmount")
    public void testTransactionWithNegativeWithdrawAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(-3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Withdrawal amount must be positive");
    }
    @Test(testName = "TC_07_TransactionWithWithdrawAmountEqualToBalance")
    public void testTransactionWithWithdrawAmountEqualToBalance(){
        BankAccount account = new BankAccount(1000, "Rohan");
        account.withdraw(1000);
        Assert.assertEquals(account.getBalance(), 0.0);
    }

    @AfterMethod
    public void free(){
        account = null;
    }
}
