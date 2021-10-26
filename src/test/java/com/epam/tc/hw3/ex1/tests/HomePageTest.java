package com.epam.tc.hw3.ex1.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw3.TestBase;
import com.epam.tc.hw3.ex1.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        init();
        homePage = new HomePage();
    }

    @Test
    public void homePageTest() {
        //2. Assert Browser title
        assertEquals(prop.getProperty("title"), webDriver.getTitle());

        //3. Perform login
        homePage.clickOnUserIcon();
        homePage.login(prop.getProperty("username"), prop.getProperty("password"));

        //4. Assert Username is loggined
        assertTrue(homePage.isUserNameDisplayed());
        assertTrue(homePage.getUserName().getText()
                .contains(prop.getProperty("fullusername")));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(homePage.isHomeButtonDisplayed());
        assertTrue(homePage.homeButtonText().contains("HOME"));

        assertTrue(homePage.isContactFormButtonDisplayed());
        assertTrue(homePage.contactFormButtonText().contains("CONTACT FORM"));

        assertTrue(homePage.isServiceButtonDisplayed());
        assertTrue(homePage.serviceButtonText().contains("SERVICE"));

        assertTrue(homePage.isMetalsColorsButtonDisplayed());
        assertTrue(homePage.metalsColorsButtonText().contains("METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(homePage.isPractiseIconDisplayed());
        assertTrue(homePage.isCustomIconDisplayed());
        assertTrue(homePage.isMultiplatformIconDisplayed());
        assertTrue(homePage.isBaseIconDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTrue(homePage.isPractiseTextDisplayed());
        assertTrue(homePage.isCustomTextDisplayed());
        assertTrue(homePage.isMultiplatformTextDisplayed());
        assertTrue(homePage.isBaseTextDisplayed());

        //8. Assert that there is the iframe with “Frame Button” exist
        assertTrue(homePage.isFrameWithButtonDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getFrameWithButton());
        assertTrue(homePage.isButtonFrameDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertTrue(homePage.isHomeSidebarMenuDisplayed());
        assertTrue(homePage.homeSidebarMenuText().contains("Home"));

        assertTrue(homePage.isContactFormSidebarMenuDisplayed());
        assertTrue(homePage.contactFormSidebarMenuText().contains("Contact form"));

        assertTrue(homePage.isServiceSidebarMenuDisplayed());
        assertTrue(homePage.serviceSidebarMenuText().contains("Service"));

        assertTrue(homePage.isMetalsColorsSidebarDisplayed());
        assertTrue(homePage.metalsColorsSidebarMenuText().contains("Metals & Colors"));

        assertTrue(homePage.isElementsSidebarMenuDisplayed());
        assertTrue(homePage.elementsSidebarMenuText().contains("Elements packs"));
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
