package com.epam.tc.hw7.steps;

import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.data.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.entity.MetalsAndColors;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static com.epam.tc.hw7.pages.JdiSite.*;

public class MetalsAndColorsSteps implements TestInit {

    @Step
    public static void openMetalsColorsPage() {
        metalsAndColorsNavBar.click();
        metalsAndColorsPage.checkOpened();
    }


}
