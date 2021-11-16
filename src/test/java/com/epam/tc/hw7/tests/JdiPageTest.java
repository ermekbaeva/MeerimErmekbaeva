package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.data.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.steps.MetalsAndColorsSteps;
import com.epam.tc.hw7.steps.MetalsAndColorsSteps.*;
import com.epam.tc.hw7.entity.MetalsAndColors;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static com.epam.tc.hw7.pages.JdiSite.*;
import static com.epam.tc.hw7.steps.MetalsAndColorsSteps.openMetalsColorsPage;


public class JdiPageTest implements TestInit {

    @Test(dataProvider = "getDataFromJson", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void publisherOnboardingTest(MetalsAndColors data) throws FileNotFoundException {
        metalsAndColorsForm.submit(data);
        submitButton.click();
    }
}
