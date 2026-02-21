package com.project.BankingApp.tests.bankaccount;

import com.project.BankingApp.entity.BankAccount;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BankAccountTestListener implements ITestListener {

    BankAccount account;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        System.out.println("Exception (Any): " + result.getThrowable() + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution Finished");
    }

}
