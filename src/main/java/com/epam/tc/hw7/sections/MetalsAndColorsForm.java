package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entity.MetalsAndColors;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;


public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @UI("#calculate-button")
    public static Button calculateButton;
    @UI("[name=custom_radio_odd]")
    public static RadioButtons oddNumbers;
    @UI("[name=custom_radio_even]")
    public static RadioButtons evenNumbers;
    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;
    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;
    @UI("input[type=checkbox]")
    public static Checklist elements;
    @JDropdown(root = "#vegetables",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;
    @UI("#submit-button")
    public static Button submitButton;
    @UI("[class='panel-body-list results'] li")
    public static List<WebElement> results;

    public void selectVegetables(String... value) {
        vegetables.select(value);
    }

    public void selectElements(String... value) {
        elements.select(value);
    }

    public void selectOddNumbers(String value) {
        oddNumbers.select(value);
    }

    public void selectEvenNumbers(String value) {
        evenNumbers.select(value);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public void selectColor(String value) {
        colors.expand();
        colors.select(value);
    }

    public void selectMetal(String value) {
        metals.expand();
        metals.select(value);
    }

    public void unselectVegetables() {
        vegetables.select("Vegetables");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<String> getResult() {
        return results.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
