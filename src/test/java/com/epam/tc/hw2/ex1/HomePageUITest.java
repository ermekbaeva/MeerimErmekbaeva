package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.PageBaseTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class HomePageUITest extends PageBaseTest {

    @Test
    public void homePageTest() {

        //2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //4. Assert Username is loggined
        WebElement userName = webDriver.findElement(By.id("user-name"));
        webDriverWait.until(ExpectedConditions.visibilityOf(userName));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertTrue(userName.getText().contains("ROMAN IOVLEV"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationNavBarElements = webDriver
                .findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8"));

        for (WebElement element : navigationNavBarElements
        ) {
            softAssert.assertTrue(element.isDisplayed());
        }

        String navigationElementsTextExpected = "HOME CONTACT FORM SERVICE METALS & COLORS";
        String navigationElementsTextActual = navigationNavBarElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).toString()
                .replaceAll("[^a-zA-Z&]", " ").trim();

        softAssert.assertTrue(navigationElementsTextActual.equals(navigationElementsTextExpected));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesOnIndexPage = webDriver
                .findElements(By.cssSelector(".benefit-icon"));

        for (WebElement element : imagesOnIndexPage
        ) {
            softAssert.assertTrue(element.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsOnIndexPage = webDriver
                .findElements(By.cssSelector(".benefit-txt"));

        for (WebElement element : textsOnIndexPage
        ) {
            softAssert.assertTrue(element.isDisplayed());
        }

        List<String> textOnIndexPageExpected = Arrays
                .asList("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        List<String> textOnIndexPageActual = textsOnIndexPage.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        softAssert.assertTrue(textOnIndexPageExpected.containsAll(textOnIndexPageActual));

        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(frameWithButton.isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frameWithButton);
        WebElement buttonFrame = webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(buttonFrame.isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> itemsOnSideBar = webDriver
                .findElements(By.cssSelector(".sidebar-menu.left"));
        String itemsTextOnSideBarExpected = "Home Contact form Service Metals & Colors Elements packs";
        for (WebElement element : itemsOnSideBar
        ) {
            softAssert.assertTrue(element.isDisplayed());
        }
        String itemsTextOnSideBarActual = itemsOnSideBar.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .toString().replaceAll("[^a-zA-Z&]", " ").trim();

        softAssert.assertTrue(itemsTextOnSideBarExpected.equals(itemsTextOnSideBarActual));

        softAssert.assertAll();
    }

}
