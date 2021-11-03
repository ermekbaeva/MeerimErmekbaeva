package com.epam.tc.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DifferentElementsPage extends AbstractBasePage {
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;
    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/input")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[text()[contains(.,'Selen')]]/input")
    private WebElement selenRadiobutton;
    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement colorsDropDownMenu;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWaterCheckboxDisplayed() {
        return waterCheckbox.isDisplayed();
    }

    public boolean isWindCheckboxDisplayed() {
        return windCheckbox.isDisplayed();
    }

    public boolean isSelenRadiobuttonDisplayed() {
        return selenRadiobutton.isDisplayed();
    }

    public boolean isColorsDropDownMenuDisplayed() {
        return colorsDropDownMenu.isDisplayed();
    }

    public void clickWaterCheckbox() {
        wait.until(elementToBeClickable(waterCheckbox)).click();
    }

    public void clickWindCheckbox() {
        wait.until(elementToBeClickable(windCheckbox)).click();
    }

    public void clickSelenRadiobutton() {
        wait.until(elementToBeClickable(selenRadiobutton)).click();
    }

    public void clickYellowInDropdownMenu() {
        wait.until(elementToBeClickable(colorsDropDownMenu)).click();
    }
}
