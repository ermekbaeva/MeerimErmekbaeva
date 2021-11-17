package com.epam.tc.hw7.steps;

import static com.epam.tc.hw7.pages.JdiSite.metalsAndColorsNavBar;
import static com.epam.tc.hw7.pages.JdiSite.metalsAndColorsPage;

import com.epam.tc.hw7.TestInit;
import io.qameta.allure.Step;


public class MetalsAndColorsSteps implements TestInit {

    @Step
    public static void openMetalsColorsPage() {
        metalsAndColorsNavBar.click();
        metalsAndColorsPage.checkOpened();
    }
}
