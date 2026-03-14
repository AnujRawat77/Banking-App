package com.project.BankingApp.basictests.UiTests.notion;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class NotionLoginTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    Dotenv dotenv = Dotenv.load();
    private final String username = dotenv.get("NOTION_USERNAME");
    private final String password = dotenv.get("NOTION_PASSWORD");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "NotionLoginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"rawatanuj324@gmail.com", "WrongPassword", false},
                {username, password, true}
        };
    }

    public void scrollAndClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Step 1: Wait for element to be PRESENT in DOM first
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        // Step 2: Scroll to it
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", element);

        // Step 3: Re-fetch fresh reference AFTER scroll (avoids StaleElementException)
        element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        // Step 4: Click
        try {
            element.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", element);
        }
    }

    // Define locators as constants at the top of the class
    private static final By CONTINUE_BTN = By.xpath("//div[@role='button' and contains(.,'Continue')]");
    private static final By CONTINUE_WITH_PASSWORD_BTN = By.xpath("//div[@role='button' and contains(.,'Continue with password')]");
    private static final By EMAIL_INPUT = By.id("notion-email-input-1");
    private static final By PASSWORD_INPUT = By.id("notion-password-input-3");

    @Test(testName = "TC_01_LoginNotion", dataProvider = "NotionLoginData")
    public void testNotionLogin(String username, String password, boolean expectedResult) {

        driver.get("https://www.notion.so/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT)).sendKeys(username);

        scrollAndClick(CONTINUE_BTN);  // Pass locator, not element

        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT)).sendKeys(password);

        scrollAndClick(CONTINUE_WITH_PASSWORD_BTN);  // Pass locator, not element

        if (expectedResult) {
            WebElement dashboard = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("#notion-app > div > div > div:nth-child(1) > div > nav")
                    )
            );
            Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible");
        } else {
            WebElement errorMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".notion-login [role='alert']")
                    )
            );
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be visible");
        }
    }


    @Test(testName = "TC_02_LoginNotion")
    public void testNotionLoginValid() throws InterruptedException {
        driver.get("https://www.notion.so/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT)).sendKeys(username);

        scrollAndClick(CONTINUE_BTN);  // Pass locator, not element

        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT)).sendKeys(password);

        scrollAndClick(CONTINUE_WITH_PASSWORD_BTN);

        WebElement dashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#notion-app > div > div > div:nth-child(1) > div > nav")
                )
        );
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible");


        Thread.sleep(5000);
    }
}
