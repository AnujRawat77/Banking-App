package com.project.BankingApp.tests.annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {

    // ---------- ADDITION TESTS ----------
    @Test(groups = {"Add"}, retryAnalyzer = AnnotationRetryAnalyzer.class)
    public void testAddition() {
        Assert.assertEquals(2 + 5, 7);
    }

    @Test(groups = {"Add"})
    public void testAdditionWithNegative() {
        Assert.assertEquals(-2 + 3, 1);
    }

    // ---------- SUBTRACTION TESTS ----------
    @Test(groups = {"Subtract"})
    public void testSubtraction() {
        Assert.assertEquals(10 - 4, 6);
    }

    @Test(groups = {"Subtract"})
    public void testSubtractionNegativeResult() {
        Assert.assertEquals(5 - 10, -5);
    }

    // ---------- MULTIPLICATION TESTS ----------
    @Test(groups = {"Multiply"})
    public void testMultiplication() {
        Assert.assertEquals(3 * 4, 12);
    }

    @Test(groups = {"Multiply"})
    public void testMultiplicationWithZero() {
        Assert.assertEquals(10 * 0, 0);
    }

    // ---------- DIVISION TESTS ----------
    @Test(groups = {"Divide"})
    public void testDivision() {
        Assert.assertEquals(20 / 5, 4);
    }

    @Test(groups = {"Divide"})
    public void testDivisionDouble() {
        Assert.assertEquals(9.0 / 3.0, 3.0);
    }

    // ---------- SMOKE GROUP ----------
    @Test(groups = {"Smoke", "Add"})
    public void smokeTestAddition() {
        Assert.assertEquals(1 + 1, 2);
    }

    // ---------- REGRESSION GROUP ----------
    @Test(groups = {"Regression", "Subtract", "Multiply"})
    public void regressionMathTest() {
        Assert.assertTrue((6 - 2) == 4 && (2 * 3) == 6);
    }
}