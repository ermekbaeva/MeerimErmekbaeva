package com.epam.tc.hw3.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw3.pages.BasePage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        init();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void homePageTest() {
        //2. Assert Browser title
        assertEquals(prop.getProperty("title"), webDriver.getTitle());

        //3. Perform login
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        //4. Assert Username is loggined
        assertTrue(loginPage.isUserNameDisplayed());
        assertTrue(loginPage.getUserName().getText()
                .contains(prop.getProperty("fullusername")));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(homePage.isNavigationBarElementsDisplayed());
        assertTrue(homePage.navBarHaveProperText());

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(homePage.isImagesOnIndexPageDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertTrue(homePage.isTextsOnIndexPageDisplayed());
        assertTrue(homePage.textOnIndexHaveProperText());

        //8. Assert that there is the iframe with “Frame Button” exist
        assertTrue(homePage.isFrameWithButtonDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getFrameWithButton());
        assertTrue(homePage.isButtonFrameDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertTrue(homePage.isItemsOnSideBarDisplayed());
        assertTrue(homePage.sideBarHaveProperText());
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.close();
    }
}
