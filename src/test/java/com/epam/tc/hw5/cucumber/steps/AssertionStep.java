package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;


public class AssertionStep extends AbstractBaseStep {

    @Then("Log rows are displayed")
    public void itemsAreDisplayed() {
        boolean waterCheckbox = differentElementsPage.isWaterCheckboxDisplayed();
        boolean windCheckbox = differentElementsPage.isWindCheckboxDisplayed();
        boolean selenRadiobutton = differentElementsPage.isSelenRadiobuttonDisplayed();
        boolean colorDropDownMenu = differentElementsPage.isColorsDropDownMenuDisplayed();

        assertThat(waterCheckbox)
                .as("Water checkbox was not found")
                .isTrue();
        assertThat(windCheckbox)
                .as("Wind checkbox was not found")
                .isTrue();
        assertThat(selenRadiobutton)
                .as("Selen radiobutton was not found")
                .isTrue();
        assertThat(colorDropDownMenu)
                .as("Yellow dropdown option was not found")
                .isTrue();
    }

    @Then("there is an individual log row and value is corresponded to the status of checkbox")
    public void checkboxesAreSelected() {
        boolean waterCheckbox = differentElementsPage.isWaterCheckboxSelected();
        boolean windCheckbox = differentElementsPage.isWindCheckboxSelected();
        boolean waterInLogRow = differentElementsPage.isWaterDisplayedOnLogRow();
        boolean windInLogRow = differentElementsPage.isWindDisplayedOnLogRow();
        assertThat(waterCheckbox)
                .as("Water checkbox is not selected")
                .isTrue();
        assertThat(windCheckbox)
                .as("Wind checkbox is not selected")
                .isTrue();
        assertThat(waterInLogRow)
                .as("Water checkbox is not displayed on log row")
                .isTrue();
        assertThat(windInLogRow)
                .as("Wind checkbox is not displayed on log row")
                .isTrue();
    }

    @Then("there is a log row and value is corresponded to the status of radio button")
    public void radiobuttonIsSelected() {
        boolean selenRadiobutton = differentElementsPage.isSelenRadiobuttonSelected();
        boolean selenInLogRow = differentElementsPage.isSelenDisplayedOnLogRow();
        assertThat(selenRadiobutton)
                .as("Selen radiobutton is not selected")
                .isTrue();
        assertThat(selenInLogRow)
                .as("Selen radiobutton is not displayed on log row")
                .isTrue();
    }

    @Then("there is a log row and value is corresponded to the selected value of dropdown")
    public void dropDownMenuIsSelected() {
        String colorDropDownMenu = differentElementsPage.isColorsDropDownMenuSelected();
        boolean yellowInLogRow = differentElementsPage.isYellowDisplayedOnLogRow();
        assertThat(colorDropDownMenu)
                .as("Yellow dropdown option is not selected")
                .isEqualTo("Yellow");
        assertThat(yellowInLogRow)
                .as("Yellow dropdown option is not displayed on log row")
                .isTrue();
    }

    @Then ("\"User Table\" page should be opened")
    public void userTablePageIsOpened() {
        String userTableTitle = userTablePage.userTableTitle();
        assertThat(userTableTitle)
                .as("Uer Table page is not opened")
                .isEqualTo("User Table");
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void logRowHasProperText() {
        boolean vipInLogRow = userTablePage.isVipDisplayedOnLogRow();
        assertThat(vipInLogRow)
                .as("'Vip: condition changed to true' is not displayed on log row")
                .isTrue();
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numbersIsDisplayedOnUserTable() {
        int numberOfDropDown = userTablePage.numberOfDisplayedDropDownOnUserTable();
        assertThat(numberOfDropDown)
                .as("6 dropdowns are not displayed on User Table Page")
                .isEqualTo(6);
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void usernamesIsDisplayedOnUserTable() {
        int numberOfUsername = userTablePage.numberOfDisplayedUsernamesUserTable();
        assertThat(numberOfUsername)
                .as("6 usernames are not displayed on User Table Page")
                .isEqualTo(6);
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionIsDisplayedOnUserTable() {
        int numberOfDescriptions = userTablePage.numberOfDisplayedDescriptionsUserTable();
        assertThat(numberOfDescriptions)
                .as("6 descriptions are not displayed on User Table Page")
                .isEqualTo(6);
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesIsDisplayedOnUserTable() {
        int numberOfCheckboxes = userTablePage.numberOfDisplayedCheckboxesUserTable();
        assertThat(numberOfCheckboxes)
                .as("6 checkboxes are not displayed on User Table Page")
                .isEqualTo(6);
    }

    @Then("^User table should contain following values: ([^\\\"]+)$")
    public void userTableContainValues() {

    }

    @Then("^droplist should contain values ([^\\\"]+) in column Type for user Roman$")
    public void droplistcontainValuesForRoman() {

    }
}
