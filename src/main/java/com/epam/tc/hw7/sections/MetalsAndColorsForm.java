package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entity.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {
    @UI("#metals")
    Dropdown metals;
    @UI("#colors")
    Dropdown colors;
    @UI("#salad-dropdown")
    Dropdown vegetables;
    @UI("#calculate-button") Button calculateButton;
    @UI("#submit-button") Button submitButton;
    @UI("#g1") Checkbox water;
    @UI("#g2") Checkbox earth;
    @UI("#g3") Checkbox wind;
    @UI("#g4") Checkbox fire;
    @UI("#odds-selector") RadioButtons oddNumbers;
    @UI("#even-selector") RadioButtons evenNumbers;
}
