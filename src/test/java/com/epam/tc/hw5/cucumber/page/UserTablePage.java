package com.epam.tc.hw5.cucumber.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UserTablePage extends AbstractBasePage {

    @FindBy(id = "ivan")
    private WebElement ivanVipCheckbox;
    @FindBy(xpath = "//li[text()[contains(.,'Vip: condition changed to true')]]")
    private WebElement vipInLogRowPanel;
    private List<WebElement> dropDownOnUserPage = CucumberHooks.driver
            .findElements(By.tagName("select"));
    private List<WebElement> usernamesOnUserPage = CucumberHooks.driver
            .findElements(By.xpath("//tr//a"));
    private List<WebElement> descriptionsOnUserPage = CucumberHooks.driver
            .findElements(By.xpath("//div[@class='user-descr']//span"));
    private List<WebElement> checkboxesOnUserPage = CucumberHooks.driver
            .findElements(By.xpath("//input[@type='checkbox']"));

    public String userTableTitle() {
        return CucumberHooks.driver.getTitle();
    }

    public void clickToIvanVipCheckbox() {
        wait.until(elementToBeClickable(ivanVipCheckbox)).click();
    }

    public boolean isVipDisplayedOnLogRow() {
        return vipInLogRowPanel.isDisplayed();
    }

    public int numberOfDisplayedDropDownOnUserTable() {
        return dropDownOnUserPage.size();
    }

    public int numberOfDisplayedUsernamesUserTable() {
        return usernamesOnUserPage.size();
    }

    public int numberOfDisplayedDescriptionsUserTable() {
        return descriptionsOnUserPage.size();
    }

    public int numberOfDisplayedCheckboxesUserTable() {
        return checkboxesOnUserPage.size();
    }
}
