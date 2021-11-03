package com.epam.tc.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends AbstractBasePage {
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceMenuButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;
    @FindBy(xpath = "//a[contains(text(),'User Table')]")
    private WebElement userTableButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
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
