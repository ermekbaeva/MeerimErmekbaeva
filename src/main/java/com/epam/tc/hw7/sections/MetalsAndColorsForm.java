package com.epam.tc.hw7.sections;

import static com.epam.tc.hw7.pages.JdiSite.submitButton;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entity.MetalsAndColors;
import java.util.List;


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

    public void selectVegetables(List<String> value) {
        for (String val : value) {
            vegetables.select(val);
        }
    }

    public void selectElements(List<String> value) {
        for (String val : value) {
            elements.select(val);
        }
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
}
