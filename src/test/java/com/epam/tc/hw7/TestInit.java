package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.data.UserDataProvider.ROMAN;
import static com.epam.tc.hw7.steps.LoginSteps.login;
import static com.epam.tc.hw7.steps.LoginSteps.openSite;
import static com.epam.tc.hw7.steps.LoginSteps.shouldBeLoggedIn;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initElements(JdiSite.class);
        openSite();
        login(ROMAN);
        shouldBeLoggedIn(ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    static void tearDown() {
        killAllSeleniumDrivers();
    }
}
