package com.epam.tc.hw4.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw4.pages.BasePage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.LoginPage;
import com.epam.tc.hw4.util.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class HomePageFailedTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        init();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Feature(value = "Homework 4")
    @Story(value = "Exercise 1 Failed home page test")
    @Test
    public void homePageFailedTest() {
        checkBrowserTitle();
        userLogin();
        checkUserIsLogined();
        checkNavigationBar();
        checkImagesOnIndexPage();
        checkTextsOnIndexPage();
        checkFrameWithButton();
        switchToFrameWithButton();
        checkButtonInFrame();
        switchToOriginalWindow();
        checkItemsOnSideBarSideBarMenu();
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
                .contains(prop.getProperty("otherfullusername")));
    }

    @Step("Assert that there are 4 items on the header "
            + "section are displayed and they have proper texts")
    public void checkNavigationBar() {
        assertTrue(homePage.isNavigationBarElementsDisplayed());
        assertTrue(homePage.navBarHaveProperText());
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkImagesOnIndexPage() {
        assertTrue(homePage.isImagesOnIndexPageDisplayed());
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkTextsOnIndexPage() {
        assertTrue(homePage.isTextsOnIndexPageDisplayed());
        assertTrue(homePage.textOnIndexHaveProperText());
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

    @Step("Assert that there are 5 items in the "
            + "Left Section are displayed and they have proper text")
    public void checkItemsOnSideBarSideBarMenu() {
        assertTrue(homePage.isItemsOnSideBarDisplayed());
        assertTrue(homePage.sideBarHaveProperText());
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
