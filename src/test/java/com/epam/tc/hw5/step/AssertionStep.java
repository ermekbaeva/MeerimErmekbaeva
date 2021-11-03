package com.epam.tc.hw5.step;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.page.DifferentElementsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;


public class AssertionStep extends AbstractBaseStep {

    @Then("Log rows are displayed")
    public void itemsAreDisplayed(String searchText) {
        boolean waterCheckbox = differentElementsPage.isWaterCheckboxDisplayed();
        boolean windCheckbox = differentElementsPage.isWindCheckboxDisplayed();
        boolean selenRadiobutton = differentElementsPage.isSelenRadiobuttonDisplayed();
        boolean colorDropDownMenu = differentElementsPage.isColorsDropDownMenuDisplayed();

        assertThat(waterCheckbox)
                .as("Water checkbox was not found")
                .isTrue();
        assertThat(windCheckbox)
                .as("Water checkbox was not found")
                .isTrue();
        assertThat(selenRadiobutton)
                .as("Water checkbox was not found")
                .isTrue();
        assertThat(colorDropDownMenu)
                .as("Water checkbox was not found")
                .isTrue();
    }
}
