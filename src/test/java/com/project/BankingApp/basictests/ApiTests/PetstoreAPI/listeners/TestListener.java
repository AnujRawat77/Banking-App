package com.project.BankingApp.basictests.ApiTests.PetstoreAPI.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.BankingApp.basictests.ApiTests.PetstoreAPI.reports.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener {

    // ✅ ExtentReports instance — shared across all tests
    private ExtentReports extentReports;

    // ✅ ThreadLocal ensures each test thread has its own ExtentTest node
    // This is important for parallel test execution
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // ✅ Triggered once before the entire test suite starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("====== TEST SUITE STARTED: " + context.getName() + " ======");
        extentReports = ExtentReportManager.getInstance();
    }

    // ✅ Triggered before each individual test method starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---> Test Started: " + result.getMethod().getMethodName());

        // Create a new test node in the Extent Report
        ExtentTest test = extentReports.createTest(
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).testName(),
                result.getMethod().getDescription()          // Test description (optional)
        );

        // Add category/tag based on test class name
        test.assignCategory(result.getTestClass().getName());

        // Store in ThreadLocal for use in pass/fail/skip methods
        extentTest.set(test);
    }

    // ✅ Triggered when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.PASS, "Test Passed ✅");
    }

    // ✅ Triggered when a test FAILS
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " + result.getMethod().getMethodName());

        // Log the failure reason and stack trace to the report
        extentTest.get().log(Status.FAIL, "Test Failed ❌");
        extentTest.get().log(Status.FAIL, "Failure Reason: " + result.getThrowable().getMessage());
        extentTest.get().fail(result.getThrowable());   // Full stack trace in report
    }

    // ✅ Triggered when a test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ SKIPPED: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.SKIP, "Test Skipped ⚠️");
        extentTest.get().skip(result.getThrowable());
    }

    // ✅ Triggered once after the entire test suite finishes
    // CRITICAL: flush() writes all data to the HTML file — without this, report won't generate
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("====== TEST SUITE FINISHED: " + context.getName() + " ======");
        if (extentReports != null) {
            extentReports.flush();
            System.out.println("✅ Extent Report generated at: reports/ExtentReport.html");
        }
    }
}