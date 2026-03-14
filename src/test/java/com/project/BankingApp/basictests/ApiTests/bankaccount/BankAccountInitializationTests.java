package com.project.BankingApp.basictests.ApiTests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankAccountInitializationTests {

    @Test(testName = "TC_01_InitializeWithZeroBalance")
    public void testInitializationWithZeroBalance() {
        BankAccount account = new BankAccount(0, "Amit Datta");
        Assert.assertEquals(account.getBalance(), 0.0, "Balance should be zero.");
    }

    @Test(testName = "TC_02_InitializeWithPositiveBalance")
    public void testInitializationWithPositiveBalance(){
        BankAccount account1 = new BankAccount(100, "Lakshay Pahuja");
        Assert.assertEquals(account1.getBalance(), 100.0, "Balance should be 100.");

        BankAccount account2 = new BankAccount(562.36, "Rohit Sharma");
        Assert.assertEquals(account2.getBalance(), 562.36, "Balance should be 562.36.");

        BankAccount account3 = new BankAccount(10000.3, "Virat Kohli");
        Assert.assertEquals(account3.getBalance(), 10000.3, "Balance should be 10000.3.");
    }

    @Test(testName = "TC_03_InitializeWithNegativeBalance")
    public void testInitializationWithNegativeBalance(){
        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class, () -> new BankAccount(-40.7, "Lakshay Pahuja"));
        Assert.assertEquals(exception.getMessage(), "Initial balance cannot be negative");
    }

    @Test(testName = "TC_04_TransactionWithMultipleDeposits")
    public void testTransactionWithMultipleDeposits(){
        BankAccount account = new BankAccount(0, "Rohan");

        account.deposit(150);
        account.deposit(550);

        Assert.assertEquals(account.getBalance(), 700.0, "Balance Should be 700");
    }

    @Test(testName = "TC_05_TransactionWithMultipleWithdraws")
    public void testTransactionWithMultipleWithdraws(){
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(100);
        account.withdraw(200);

        Assert.assertEquals(account.getBalance(), 700.0, "Balance Should be 700");
    }

    @Test(testName = "TC_06_TransactionWithMultipleDepositWithdraws")
    public void testTransactionWithMultipleDepositWithdraws(){
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(100);
        account.deposit(200);

        Assert.assertEquals(account.getBalance(), 1100.0, "Balance Should be 1100");
    }

    @Test(testName = "TC_07_TransactionWithNegativeDepositAmount")
    public void testTransactionWithNegativeDepositAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.deposit(-521.3)
        );
        Assert.assertEquals(exception.getMessage(), "Deposit amount must be positive");
    }

    @Test(testName = "TC_08_TransactionWithWithdrawOverBalance")
    public void testTransactionWithWithdrawOverBalance(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Insufficient balance");
    }

    @Test(testName = "TC_09_TransactionWithNegativeWithdrawAmount")
    public void testTransactionWithNegativeWithdrawAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(-3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Withdrawal amount must be positive");
    }
    @Test(testName = "TC_10_TransactionWithWithdrawAmountEqualToBalance")
    public void testTransactionWithWithdrawAmountEqualToBalance(){
        BankAccount account = new BankAccount(1000, "Rohan");
        account.withdraw(1000);
        Assert.assertEquals(account.getBalance(), 0.0);
    }

}
