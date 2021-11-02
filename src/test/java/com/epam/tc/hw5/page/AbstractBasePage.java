package com.epam.tc.hw5.page;

import com.epam.tc.hw5.page.component.AbstractComponent;
import com.epam.tc.hw5.page.component.LoginComponent;
import org.openqa.selenium.WebDriver;

public class AbstractBasePage extends AbstractComponent {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected LoginComponent loginComponent;

    protected AbstractBasePage(WebDriver driver) {
        super(driver);
        loginComponent = new LoginComponent(driver);
    }

    public void sendKeysToLoginInputField(String username, String password) {
        loginComponent.sendKeysToLoginInputField(username, password);
    }

    public void clickToLoginButton() {
        header.clickToLoginButton();
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
