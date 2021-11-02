package com.epam.tc.hw5.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsComponent extends AbstractComponent {
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

    public DifferentElementsComponent(WebDriver driver) {
        super(driver);
    }
}
