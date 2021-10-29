package com.epam.tc.hw3.ex2.pages;

import com.epam.tc.hw3.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ServicePage extends TestBase {
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
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;
    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadiobox;
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement colorsDropDownMenu;

    public ServicePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnUserIcon() {
        userIcon.click();
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

    public void clickOnServiceButton() {
        serviceButton.click();
    }

    public void clickOnDifferentElementsButton() {
        differentElementsButton.click();
    }

    public void clickOnWaterCheckboxButton() {
        waterCheckbox.click();
    }

    public void clickOnWindCheckboxButton() {
        windCheckbox.click();
    }

    public void clickOnSelenRadioboxButton() {
        selenRadiobox.click();
    }

    public void login(String username, String password) {
        setUserName(username);
        setUserPassword(password);
        clickOnLoginButton();
    }

    public WebElement getUserName() {
        return userName;
    }

    public boolean isUserNameDisplayed() {
        return userName.isDisplayed();
    }

    public boolean isWaterCheckboxSelected() {
        return waterCheckbox.isSelected();
    }

    public boolean isWindCheckboxSelected() {
        return windCheckbox.isSelected();
    }

    public boolean isSelenRadioboxSelected() {
        return selenRadiobox.isSelected();
    }

    public void selectColorsDropDownMenuOption(String text) {
        Select colorSelect = new Select(colorsDropDownMenu);
        colorSelect.selectByVisibleText(text);
    }

    public String colorsDropDownMenuSelectedOption() {
        Select colorSelect = new Select(colorsDropDownMenu);
        return colorSelect.getFirstSelectedOption().getText();
    }

}
