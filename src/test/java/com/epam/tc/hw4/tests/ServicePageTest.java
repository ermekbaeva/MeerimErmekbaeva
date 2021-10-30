package com.epam.tc.hw4.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw4.pages.BasePage;
import com.epam.tc.hw4.pages.LoginPage;
import com.epam.tc.hw4.pages.ServicePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ServicePageTest extends BasePage {
    ServicePage servicePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        init();
        servicePage = new ServicePage();
        loginPage = new LoginPage();
    }

    @Feature(value = "Homework 4")
    @Story(value = "Exercise 2 service page test")
    @Test
    public void servicePageTest() {
        checkBrowserTitle();
        userLogin();
        checkUserIsLogined();
        openElementsPage();
        selectCheckboxes();
        selectRadiobox();
        selectDropDownMenuOption();
        checkCheckbocksIsSelected();
        checkRadioIsSelected();
        checkSelectedOption();
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

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openElementsPage() {
        servicePage.clickOnServiceButton();
        servicePage.clickOnDifferentElementsButton();
    }

    @Step("Select checkboxes Water and Wind")
    public void selectCheckboxes() {
        servicePage.clickOnWaterCheckboxButton();
        servicePage.clickOnWindCheckboxButton();
    }

    @Step("Select radio Selen")
    public void selectRadiobox() {
        servicePage.clickOnSelenRadioboxButton();
    }

    @Step("Select in dropdown")
    public void selectDropDownMenuOption() {
        servicePage.selectColorsDropDownMenuOption("Yellow");
    }

    @Step("Assert that for each checkbox there is an individual log row"
            + "and value is corresponded to the status of checkbox")
    public void checkCheckbocksIsSelected() {
        assertTrue(servicePage.isWaterCheckboxSelected());
        assertTrue(servicePage.isWindCheckboxSelected());
    }

    @Step("for radio button there is a log row and value is corresponded "
            + "to the status of radio button")
    public void checkRadioIsSelected() {
        assertTrue(servicePage.isSelenRadioboxSelected());
    }

    @Step("for dropdown there is a log row and value is corresponded to the selected value")
    public void checkSelectedOption() {
        assertEquals("Yellow", servicePage.colorsDropDownMenuSelectedOption());
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
