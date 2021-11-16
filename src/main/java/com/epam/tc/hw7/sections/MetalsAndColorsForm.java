package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entity.MetalsAndColors;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @UI("#calculate-button")
    Button calculateButton;
    @UI("[name=custom_radio_odd]")
    RadioButtons oddNumbers;
    @UI("[name=custom_radio_even]")
    RadioButtons evenNumbers;
    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;
    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;
    @UI("[id=elements-checklist]")
    private Checklist elements;

    public void selectOddNumbers(List<Integer> value) {
        for (Integer val : value) {
            oddNumbers.select(val);
        }

    }

    public void selectEvenNumbers(String value) {
        evenNumbers.select(value);
    }

    public void submit(MetalsAndColors data) {
        //oddNumbers.select(data.getSummary().get(0));
        //evenNumbers.select(data.getSummary().get(1));
        //calculateButton.click();
        selectOddNumbers(data.getSummary());
        calculateButton.click();
        //elements.select(data.getElements().get(0));
        colors.expand();
        colors.select(data.getColor());
        metals.expand();
        metals.select(data.getMetals());
    }
}
