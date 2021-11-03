package com.epam.tc.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class AbstractBasePage {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    public static Properties prop;
    protected LoginPage loginPage;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5L);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        loginPage = new LoginPage(driver);
    }

    protected AbstractBasePage() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/com.epam.tc.hw3/test.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickToUserIconButton() {
        loginPage.clickToUserIconButton();
    }

    public void sendKeysToLoginInputField(String username, String password) {
        loginPage.sendKeysToLoginInputField(username, password);
    }

    public void clickToLoginButton() {
        loginPage.clickToLoginButton();
    }

    public void loginUser() {

    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }

}
