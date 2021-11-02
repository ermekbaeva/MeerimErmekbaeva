package com.epam.tc.hw5.page.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractComponent {
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement userPasswordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public void clickToUserIconButton() {
        wait.until(elementToBeClickable(userIcon)).click();
    }

    public void sendKeysToLoginInputField(String username, String password) {
        wait.until(visibilityOf(userNameInput)).sendKeys(username);
        wait.until(visibilityOf(userPasswordInput)).sendKeys(password);
    }

    public void clickToLoginButton() {
        wait.until(elementToBeClickable(loginButton)).click();
    }
}
