package com.project.BankingApp.basictests.ApiTests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BankAccountDataDrivenTests {

    @DataProvider(name = "TransactionData")
    public Object[][] getTestTransactionDataProvider(){
        return new Object[][]{
                {100, 200, 1100.0},
                {500, 500, 1000.0}
        };
    }

    @Test(testName = "TC_01_TransactionWithMultipleDepositWithdraws", dataProvider = "TransactionData")
    public void testTransactionWithMultipleDepositWithdraws(double val1, double val2, double finalBalance){
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(val1);
        account.deposit(val2);

        Assert.assertEquals(account.getBalance(), finalBalance, "Balance Should be "+finalBalance);
    }


}
