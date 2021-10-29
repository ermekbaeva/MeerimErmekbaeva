package com.epam.tc.hw4.ex1.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw4.LoginPage;
import com.epam.tc.hw4.TestBase;
import com.epam.tc.hw4.ex1.pages.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        init();
        homePage = new HomePage();
        LoginPage loginPage;
    }

    @Feature(value = "Homework 4")
    @Story(value = "Exercise 1")
    @Test
    public void homePageTest() {
        checkBrowserTitle();
        userLogin();
        checkUserIsLogined();
        checkHomeButton();
        checkContactFormButton();
        checkServiceButton();
        checkMetalsColorsButton();
        checkImagesOnIndexPage();
        checkTextsOnIndexPage();
        checkFrameWithButton();
        switchToFrameWithButton();
        checkButtonInFrame();
        switchToOriginalWindow();
        checkHomeSideBarMenu();
        checkContactFormSideBarMenu();
        checkServiceSideBarMenu();
        checkMetalsColorsSideBarMenu();
        checkElementsSideBarMenu();
    }

    @Step("Assert Browser title")
    public void checkBrowserTitle() {
        assertEquals(prop.getProperty("title"), webDriver.getTitle());
    }

    @Step("Perform login")
    public void userLogin() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Step("Assert Username is loggined")
    public void checkUserIsLogined() {
        assertTrue(loginPage.isUserNameDisplayed());
        assertTrue(loginPage.getUserName().getText()
                .contains(prop.getProperty("fullusername")));
    }

    @Step("Assert that there is Home item on the header "
            + "section is displayed and it has proper text")
    public void checkHomeButton() {
        assertTrue(homePage.isHomeButtonDisplayed());
        assertTrue(homePage.homeButtonText().contains("HOME"));
    }

    @Step("Assert that there is Contact Form item on the header "
            + "section is displayed and it has proper text")
    public void checkContactFormButton() {
        assertTrue(homePage.isContactFormButtonDisplayed());
        assertTrue(homePage.contactFormButtonText().contains("CONTACT FORM"));
    }

    @Step("Assert that there is Service item on the header "
            + "section is displayed and it has proper text")
    public void checkServiceButton() {
        assertTrue(homePage.isServiceButtonDisplayed());
        assertTrue(homePage.serviceButtonText().contains("SERVICE"));
    }

    @Step("Assert that there is Metals&Colors item on the header "
            + "section is displayed and it has proper text")
    public void checkMetalsColorsButton() {
        assertTrue(homePage.isMetalsColorsButtonDisplayed());
        assertTrue(homePage.metalsColorsButtonText().contains("METALS & COLORS"));
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkImagesOnIndexPage() {
        assertTrue(homePage.isPractiseIconDisplayed());
        assertTrue(homePage.isCustomIconDisplayed());
        assertTrue(homePage.isMultiplatformIconDisplayed());
        assertTrue(homePage.isBaseIconDisplayed());
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkTextsOnIndexPage() {
        assertTrue(homePage.isPractiseTextDisplayed());
        assertTrue(homePage.isCustomTextDisplayed());
        assertTrue(homePage.isMultiplatformTextDisplayed());
        assertTrue(homePage.isBaseTextDisplayed());
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void checkFrameWithButton() {
        assertTrue(homePage.isFrameWithButtonDisplayed());
    }

    @Step("Switch to the iframe")
    public void switchToFrameWithButton() {
        webDriver.switchTo().frame(homePage.getFrameWithButton());
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void checkButtonInFrame() {
        assertTrue(homePage.isButtonFrameDisplayed());
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindow() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Assert that there is Home in the Left Section is displayed and it has proper text")
    public void checkHomeSideBarMenu() {
        assertTrue(homePage.isHomeSidebarMenuDisplayed());
        assertTrue(homePage.homeSidebarMenuText().contains("Home"));
    }

    @Step("Assert that there is ContactForm in the Left Section is displayed and it has proper text")
    public void checkContactFormSideBarMenu() {
        assertTrue(homePage.isContactFormSidebarMenuDisplayed());
        assertTrue(homePage.contactFormSidebarMenuText().contains("Contact form"));
    }

    @Step("Assert that there is Service in the Left Section is displayed and it has proper text")
    public void checkServiceSideBarMenu() {
        assertTrue(homePage.isServiceSidebarMenuDisplayed());
        assertTrue(homePage.serviceSidebarMenuText().contains("Service"));
    }

    @Step("Assert that there is MetalsColors in the Left Section is displayed and it has proper text")
    public void checkMetalsColorsSideBarMenu() {
        assertTrue(homePage.isMetalsColorsSidebarDisplayed());
        assertTrue(homePage.metalsColorsSidebarMenuText().contains("Metals & Colors"));
    }

    @Step("Assert that there is Elements in the Left Section is displayed and it has proper text")
    public void checkElementsSideBarMenu() {
        assertTrue(homePage.isElementsSidebarMenuDisplayed());
        assertTrue(homePage.elementsSidebarMenuText().contains("Elements packs"));
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
