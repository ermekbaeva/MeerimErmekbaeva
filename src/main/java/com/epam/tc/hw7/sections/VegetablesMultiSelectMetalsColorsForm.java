package com.epam.tc.hw7.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VegetablesMultiSelectMetalsColorsForm {

    @FindBy(css = "#vegetables .caret")
    WebElement vegetablesExpand;
    @FindBy(css = "#vegetables label")
    List<WebElement> vegetablesList;
    @FindBy(css = "#vegetables button")
    WebElement vegetablesValue;
    @FindBy(css = "#vegetables ul")
    WebElement vegetablesIsExpanded;

    private boolean vegetablesIsExpanded() {
        return vegetablesIsExpanded.getAttribute("style").equals("display: block;");
    }

    public void selectOptions(List<String> value) {
        for (String val : value) {
            if (!vegetablesIsExpanded())
                vegetablesExpand.click();
            for (WebElement listOption : vegetablesList) {
                if (listOption.getText().trim().equals(val))
                    listOption.click();
            }
        }
    }

    public void unselectOptionVegetables() {
        if (!vegetablesIsExpanded())
            vegetablesExpand.click();
        for (WebElement listOption : vegetablesList) {
            if (listOption.getText().trim().equals("Vegetables"))
                listOption.click();
        }
    }

    public String getValue() {
        return vegetablesValue.getText();
    }
}
