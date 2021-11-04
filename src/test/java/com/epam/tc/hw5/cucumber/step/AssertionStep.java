package com.epam.tc.hw5.cucumber.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


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

    @Then("checkbox name and its status are corresponding to selected")
    public void checkboxesAreSelected() {
        boolean waterCheckbox = differentElementsPage.isWaterCheckboxSelected();
        boolean windCheckbox = differentElementsPage.isWindCheckboxSelected();

        assertThat(waterCheckbox)
                .as("Water checkbox is not selected")
                .isTrue();
        assertThat(windCheckbox)
                .as("Wind checkbox is not selected")
                .isTrue();
    }

    @Then("radio button name and it status is corresponding to selected")
    public void radiobuttonIsSelected() {
        boolean selenRadiobutton = differentElementsPage.isSelenRadiobuttonSelected();

        assertThat(selenRadiobutton)
                .as("Selen radiobutton is not selected")
                .isTrue();
    }

    @Then("dropdown name and selected value is corresponding to selected")
    public void dropDownMenuIsSelected() {
        String colorDropDownMenu = differentElementsPage.isColorsDropDownMenuSelected();
        assertThat(colorDropDownMenu)
                .as("Yellow dropdown option is not selected")
                .isEqualTo("Yellow");
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

    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numbersIsDisplayedOnUserTable() {

    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void usernamesIsDisplayedOnUserTable() {

    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionIsDisplayedOnUserTable() {

    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesIsDisplayedOnUserTable() {

    }

    @Then("User table should contain following values:")
    public void userTableContainValues() {

    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistcontainValuesForRoman() {

    }
}
