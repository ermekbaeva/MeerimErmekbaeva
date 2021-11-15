package com.epam.tc.hw5.cucumber.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractBasePage {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceMenuButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;
    @FindBy(xpath = "//a[contains(text(),'User Table')]")
    private WebElement userTableButton;


    public void open() {
        CucumberHooks.driver.get(BASE_URL);
    }

    public void clickToServiceHeaderMenu() {
        wait.until(elementToBeClickable(serviceMenuButton)).click();
    }

    public void clickToDifferentElementsInServiceMenu() {
        wait.until(elementToBeClickable(differentElementsButton)).click();
    }

    public void clickToUserTableInServiceMenu() {
        wait.until(elementToBeClickable(userTableButton)).click();
    }
}
