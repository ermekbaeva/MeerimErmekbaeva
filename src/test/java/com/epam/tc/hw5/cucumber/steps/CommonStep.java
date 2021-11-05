package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.cucumber.page.AbstractBasePage.prop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class CommonStep extends AbstractBaseStep {

    @Given("I open Jdi test site")
    public void openHomePage() {
        homePage.open();
    }

    @When("I login as user \"Roman Iovlev\"")
    public void loginInHomePage() {
        loginPage.clickToUserIconButton();
        loginPage.sendKeysToLoginInputField(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.clickToLoginButton();
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceInTheHeader() {
        homePage.clickToServiceHeaderMenu();
    }

    @When("I click on \"Different Elements Page\" button in Service dropdown")
    public void clickOnDifferentElementsInServiceMenu() {
        homePage.clickToDifferentElementsInServiceMenu();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickToUserTableInServiceMenu() {
        homePage.clickToUserTableInServiceMenu();
    }

    @When("I select \"water\" checkbox")
    public void clickOnWaterCheckbox() {
        differentElementsPage.clickWaterCheckbox();
    }

    @When("I select \"wind\" checkbox")
    public void clickOnWindCheckbox() {
        differentElementsPage.clickWindCheckbox();
    }

    @When("I select \"selen\" radiobutton")
    public void clickOnSelenRadiobutton() {
        differentElementsPage.clickSelenRadiobutton();
    }

    @When("I select \"yellow\" in color dropdown menu")
    public void clickOnYellowInDropdownMenu() {
        differentElementsPage.clickYellowInDropdownMenu();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void clickOnVipCheckboxforSergey() {
        userTablePage.clickToIvanVipCheckbox();
    }
}
