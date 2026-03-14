package com.project.BankingApp.basictests.ApiTests.PetstoreAPI.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    // ✅ Singleton Pattern — Only one instance of ExtentReports throughout the run
    public static ExtentReports getInstance() {

        if (extentReports == null) {

            // ✅ SparkReporter defines where and how the HTML report looks
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");

            // ✅ Report Configurations
            sparkReporter.config().setReportName("Petstore API Test Report");
            sparkReporter.config().setDocumentTitle("API Automation Results");
            sparkReporter.config().setTheme(Theme.DARK);              // DARK or STANDARD
            sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
            sparkReporter.config().setEncoding("UTF-8");

            // ✅ Attach SparkReporter to ExtentReports
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            // ✅ Add System/Environment Info to Report
            extentReports.setSystemInfo("Application", "Petstore API");
            extentReports.setSystemInfo("Base URL", "https://petstore.swagger.io/v2/");
            extentReports.setSystemInfo("Tester", "Anuj Rawat");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Framework", "Rest Assured + TestNG");
        }

        return extentReports;
    }
}