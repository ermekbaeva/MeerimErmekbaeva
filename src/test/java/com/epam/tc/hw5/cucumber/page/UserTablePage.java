package com.epam.tc.hw5.cucumber.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserTablePage extends AbstractBasePage {

    @FindBy(id = "ivan")
    private WebElement ivanVipCheckbox;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String userTableTitle() {
        return driver.getTitle();
    }

    public void clickToIvanVipCheckbox() {
        wait.until(elementToBeClickable(ivanVipCheckbox)).click();
    }
}
