package com.epam.tc.hw3.ex1.pages;

import com.epam.tc.hw3.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {
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
    @FindBy(xpath = "//a[text() = 'Home']")
    private WebElement homeButton;
    @FindBy(xpath = "//a[text() = 'Contact form']")
    private WebElement contactFormButton;
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[text() = 'Metals & Colors']")
    private WebElement metalsColorsButton;
    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement practiseIcon;
    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement customIcon;
    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement multiplatformIcon;
    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement baseIcon;
    @FindBy(xpath = "//span[text() = 'To include good practices']")
    private WebElement practiseText;
    @FindBy(xpath = "//span[text() = 'To be flexible and']")
    private WebElement customText;
    @FindBy(xpath = "//span[text() = 'To be multiplatform ']")
    private WebElement multiplatformText;
    @FindBy(xpath = "//span[text() = 'Already have good base']")
    private WebElement baseText;
    @FindBy(id = "frame")
    private WebElement frameWithButton;
    @FindBy(id = "frame-button")
    private WebElement buttonFrame;
    @FindBy(xpath = "//span[text() = 'Home']")
    private WebElement homeSidebarMenu;
    @FindBy(xpath = "//span[text() = 'Contact form']")
    private WebElement contactFormSidebarMenu;
    @FindBy(xpath = "//span[text() = 'Service']")
    private WebElement serviceSidebarMenu;
    @FindBy(xpath = "//span[text() = 'Metals & Colors']")
    private WebElement metalsColorsSidebarMenu;
    @FindBy(xpath = "//span[text() = 'Elements packs']")
    private WebElement elementsSidebarMenu;

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getFrameWithButton() {
        return frameWithButton;
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

    public void clickOnUserIcon() {
        userIcon.click();
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

    public boolean isHomeButtonDisplayed() {
        return homeButton.isDisplayed();
    }

    public boolean isContactFormButtonDisplayed() {
        return contactFormButton.isDisplayed();
    }

    public boolean isServiceButtonDisplayed() {
        return serviceButton.isDisplayed();
    }

    public boolean isMetalsColorsButtonDisplayed() {
        return metalsColorsButton.isDisplayed();
    }

    public boolean isPractiseIconDisplayed() {
        return practiseIcon.isDisplayed();
    }

    public boolean isCustomIconDisplayed() {
        return customIcon.isDisplayed();
    }

    public boolean isMultiplatformIconDisplayed() {
        return multiplatformIcon.isDisplayed();
    }

    public boolean isBaseIconDisplayed() {
        return baseIcon.isDisplayed();
    }

    public boolean isPractiseTextDisplayed() {
        return practiseText.isDisplayed();
    }

    public boolean isCustomTextDisplayed() {
        return customText.isDisplayed();
    }

    public boolean isMultiplatformTextDisplayed() {
        return multiplatformText.isDisplayed();
    }

    public boolean isBaseTextDisplayed() {
        return baseText.isDisplayed();
    }

    public boolean isFrameWithButtonDisplayed() {
        return frameWithButton.isDisplayed();
    }

    public boolean isButtonFrameDisplayed() {
        return buttonFrame.isDisplayed();
    }

    public boolean isHomeSidebarMenuDisplayed() {
        return homeSidebarMenu.isDisplayed();
    }

    public boolean isContactFormSidebarMenuDisplayed() {
        return contactFormSidebarMenu.isDisplayed();
    }

    public boolean isServiceSidebarMenuDisplayed() {
        return serviceSidebarMenu.isDisplayed();
    }

    public boolean isMetalsColorsSidebarDisplayed() {
        return metalsColorsSidebarMenu.isDisplayed();
    }

    public boolean isElementsSidebarMenuDisplayed() {
        return elementsSidebarMenu.isDisplayed();
    }

    public String homeButtonText() {
        return homeButton.getText();
    }

    public String contactFormButtonText() {
        return contactFormButton.getText();
    }

    public String serviceButtonText() {
        return serviceButton.getText();
    }

    public String metalsColorsButtonText() {
        return metalsColorsButton.getText();
    }

    public String homeSidebarMenuText() {
        return homeSidebarMenu.getText();
    }

    public String contactFormSidebarMenuText() {
        return contactFormSidebarMenu.getText();
    }

    public String serviceSidebarMenuText() {
        return serviceSidebarMenu.getText();
    }

    public String metalsColorsSidebarMenuText() {
        return metalsColorsSidebarMenu.getText();
    }

    public String elementsSidebarMenuText() {
        return elementsSidebarMenu.getText();
    }

}
