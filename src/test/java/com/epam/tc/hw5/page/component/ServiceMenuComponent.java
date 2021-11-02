package com.epam.tc.hw5.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ServiceMenuComponent extends AbstractComponent {
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceMenuButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;
    @FindBy(xpath = "//a[contains(text(),'User Table')]")
    private WebElement userTableButton;

    protected ServiceMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void clickToServiceHeaderMenu() {
        wait.until(elementToBeClickable(serviceMenuButton)).click();
    }

    public void clickToDifferentElementsInServiceMenu() {
        wait.until(elementToBeClickable(differentElementsButton)).click();
    }

    public void clickToUserTableInServiceMenu() {
        wait.until(elementToBeClickable(differentElementsButton)).click();
    }
}
