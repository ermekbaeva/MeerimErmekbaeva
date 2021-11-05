package com.epam.tc.hw5.cucumber.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


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
    @FindBy(xpath = "//li[text()[contains(.,'Selen')]]")
    private WebElement selenLogRowPanel;
    @FindBy(xpath = "//li[text()[contains(.,'Wind')]]")
    private WebElement windLogRowPanel;
    @FindBy(xpath = "//li[text()[contains(.,'Water')]]")
    private WebElement waterLogRowPanel;
    @FindBy(xpath = "//li[text()[contains(.,'Yellow')]]")
    private WebElement yellowLogRowPanel;

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
        wait.until(elementToBeClickable(colorsDropDownMenu));
        Select colorSelect = new Select(colorsDropDownMenu);
        colorSelect.selectByVisibleText("Yellow");
    }

    public boolean isWaterCheckboxSelected() {
        return waterCheckbox.isSelected();
    }

    public boolean isWindCheckboxSelected() {
        return windCheckbox.isSelected();
    }

    public boolean isSelenRadiobuttonSelected() {
        return selenRadiobutton.isSelected();
    }

    public String isColorsDropDownMenuSelected() {
        Select colorSelect = new Select(colorsDropDownMenu);
        return colorSelect.getFirstSelectedOption().getText();
    }

    public boolean isWaterDisplayedOnLogRow() {
        return waterLogRowPanel.isDisplayed();
    }

    public boolean isWindDisplayedOnLogRow() {
        return windLogRowPanel.isDisplayed();
    }

    public boolean isSelenDisplayedOnLogRow() {
        return selenLogRowPanel.isDisplayed();
    }

    public boolean isYellowDisplayedOnLogRow() {
        return yellowLogRowPanel.isDisplayed();
    }
}
