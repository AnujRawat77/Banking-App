package com.project.BankingApp.tests.annotations;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AnnotationListener implements ITestListener {

    // Executed when test starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED : " + result.getName());
    }

    // Executed when test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED : " + result.getName());
    }

    // Executed when test fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED : " + result.getName());
        System.out.println("Reason : " + result.getThrowable());
    }

    // Executed when test skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED : " + result.getName());
    }

    // Executed when suite starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("SUITE STARTED : " + context.getName());
    }

    // Executed when suite finishes
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("SUITE FINISHED : " + context.getName());

        System.out.println("PASSED TESTS: " + context.getPassedTests().size());
    }
}