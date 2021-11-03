package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ServicePage extends BasePage {
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
