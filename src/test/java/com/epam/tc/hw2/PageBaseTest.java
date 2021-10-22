package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class PageBaseTest {
    protected WebDriverWait webDriverWait;
    protected WebDriver webDriver;
    protected SoftAssert softAssert;
    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
