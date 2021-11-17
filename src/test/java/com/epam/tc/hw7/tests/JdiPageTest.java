package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.pages.JdiSite.colorResult;
import static com.epam.tc.hw7.pages.JdiSite.elementsResult;
import static com.epam.tc.hw7.pages.JdiSite.metalsAndColorsForm;
import static com.epam.tc.hw7.pages.JdiSite.metalsResult;
import static com.epam.tc.hw7.pages.JdiSite.summaryResult;
import static com.epam.tc.hw7.pages.JdiSite.vegetablesResult;
import static com.epam.tc.hw7.steps.MetalsAndColorsSteps.openMetalsColorsPage;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.data.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.entity.MetalsAndColors;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;


public class JdiPageTest implements TestInit {

    @Test(dataProvider = "getDataFromJson", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void metalAndColorFormTest(MetalsAndColors data) throws FileNotFoundException {
        openMetalsColorsPage();
        metalsAndColorsForm.selectOddNumbers(String.valueOf(data.getSummary().get(0)));
        metalsAndColorsForm.selectEvenNumbers(String.valueOf(data.getSummary().get(1)));
        metalsAndColorsForm.clickCalculateButton();
        metalsAndColorsForm.selectElements(data.getElements());
        metalsAndColorsForm.selectColor(data.getColor());
        metalsAndColorsForm.selectMetal(data.getMetals());
        metalsAndColorsForm.unselectVegetables();
        metalsAndColorsForm.selectVegetables(data.getVegetables());
        metalsAndColorsForm.clickSubmitButton();

        assertThat(summaryResult.getText()).containsIgnoringCase(String.valueOf(data.getSum()));
        assertThat(colorResult.getText()).containsIgnoringCase(data.getColor());
        assertThat(metalsResult.getText()).containsIgnoringCase(data.getMetals());
        assertThat(elementsResult.getText()).contains(data.getElements());
        assertThat(vegetablesResult.getText()).contains(data.getVegetables());
    }
}
