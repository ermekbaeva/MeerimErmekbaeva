package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;


public class PageBaseTest {
    protected WebDriverWait webDriverWait;
    protected WebDriver webDriver;
    protected SoftAssert softAssert;
    protected static final String url = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);

        //3. Perform login
        WebElement userIcon = webDriver.findElement(By.id("user-icon"));
        userIcon.click();

        WebElement userNameInput = webDriver.findElement(By.id("name"));
        userNameInput.sendKeys("Roman");

        WebElement userPasswordInput = webDriver.findElement(By.id("password"));
        userPasswordInput.sendKeys("Jdi1234");

        WebElement enterButton = webDriver.findElement(By.id("login-button"));
        enterButton.click();
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
