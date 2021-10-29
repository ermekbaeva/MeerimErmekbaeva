package com.epam.tc.hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {
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

    public LoginPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void setUserName(String username) {
        userNameInput.sendKeys(username);
    }

    public void setUserPassword(String password) {
        userPasswordInput.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickOnUserIcon() {
        userIcon.click();
    }
    public WebElement getUserName() {
        return userName;
    }

    public boolean isUserNameDisplayed() {
        return userName.isDisplayed();
    }

    public void login(String username, String password) {
        clickOnUserIcon();
        setUserName(username);
        setUserPassword(password);
        clickOnLoginButton();
    }
}
