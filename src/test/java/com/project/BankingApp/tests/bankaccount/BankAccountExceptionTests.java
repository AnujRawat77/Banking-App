package com.project.BankingApp.tests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankAccountExceptionTests {

    @Test(testName = "TC_01_InitializeWithNegativeBalance", priority = 5)
    public void testInitializationWithNegativeBalance(){
        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class, () -> new BankAccount(-40.7, "Lakshay Pahuja"));
        Assert.assertEquals(exception.getMessage(), "Initial balance cannot be negative");
    }

    @Test(testName = "TC_02_TransactionWithNegativeDepositAmount", priority = 5)
    public void testTransactionWithNegativeDepositAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.deposit(-521.3)
        );
        Assert.assertEquals(exception.getMessage(), "Deposit amount must be positive");
    }

    @Test(testName = "TC_03_TransactionWithWithdrawOverBalance", priority = 5)
    public void testTransactionWithWithdrawOverBalance(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Insufficient balance");
    }

    @Test(testName = "TC_04_TransactionWithNegativeWithdrawAmount", priority = 5)
    public void testTransactionWithNegativeWithdrawAmount(){
        BankAccount account = new BankAccount(1000, "Rohan");

        IllegalArgumentException exception = Assert.expectThrows(IllegalArgumentException.class,
                () -> account.withdraw(-3000.3)
        );
        Assert.assertEquals(exception.getMessage(), "Withdrawal amount must be positive");
    }

}
