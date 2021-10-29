package com.epam.tc.hw3.ex2.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw3.LoginPage;
import com.epam.tc.hw3.TestBase;
import com.epam.tc.hw3.ex2.pages.ServicePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ServicePageTest extends TestBase {
    ServicePage servicePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        init();
        servicePage = new ServicePage();
        loginPage = new LoginPage();
    }

    @Test
    public void servicePageTest() {
        //2. Assert Browser title
        assertEquals(prop.getProperty("title"), webDriver.getTitle());

        //3. Perform login
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        //4. Assert Username is loggined
        assertTrue(loginPage.isUserNameDisplayed());
        assertTrue(loginPage.getUserName().getText()
                .contains(prop.getProperty("fullusername")));

        //5. Open through the header menu Service -> Different Elements Page
        servicePage.clickOnServiceButton();
        servicePage.clickOnDifferentElementsButton();

        //6. Select checkboxes
        servicePage.clickOnWaterCheckboxButton();
        servicePage.clickOnWindCheckboxButton();

        //7. Select radio
        servicePage.clickOnSelenRadioboxButton();

        //8. Select in dropdown
        servicePage.selectColorsDropDownMenuOption("Yellow");

        //9. Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertTrue(servicePage.isWaterCheckboxSelected());
        assertTrue(servicePage.isWindCheckboxSelected());

        //    • for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(servicePage.isSelenRadioboxSelected());

        //    • for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals("Yellow", servicePage.colorsDropDownMenuSelectedOption());
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
