package com.project.BankingApp.basictests.ApiTests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankAccountParameterizedTests {

    @Parameters({"Value1", "Value2", "FinalBalance"})
    @Test(testName = "TC_01_TransactionWithMultipleDepositWithdraws")
    public void testTransactionWithMultipleDepositWithdraws(
            @Optional("200") double val1,
            @Optional("300") double val2,
            @Optional("1100") double finalBalance) {
        BankAccount account = new BankAccount(1000, "Rohan");

        account.withdraw(val1);
        account.deposit(val2);

        Assert.assertEquals(account.getBalance(), finalBalance, "Balance Should be "+finalBalance);
    }
}
