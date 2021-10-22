package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.PageBaseTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class HomePageUITest extends PageBaseTest {

    @Test
    public void homePageTest() {

        //1. Open test site by URL
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);

        //2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        WebElement userIcon = webDriver.findElement(By.id("user-icon"));
        userIcon.click();

        WebElement userNameInput = webDriver.findElement(By.id("name"));
        userNameInput.sendKeys("Roman");

        WebElement userPasswordInput = webDriver.findElement(By.id("password"));
        userPasswordInput.sendKeys("Jdi1234");

        WebElement enterButton = webDriver.findElement(By.id("login-button"));
        enterButton.click();

        //4. Assert Username is loggined
        WebElement userName = webDriver.findElement(By.id("user-name"));
        webDriverWait.until(ExpectedConditions.visibilityOf(userName));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertTrue(userName.getText().contains("ROMAN IOVLEV"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeButton = webDriver.findElement(By.xpath("//a[text() = 'Home']"));
        softAssert.assertTrue(homeButton.isDisplayed());
        softAssert.assertTrue(homeButton.getText().contains("HOME"));

        WebElement contactFormButton = webDriver.findElement(By.xpath("//a[text() = 'Contact form']"));
        softAssert.assertTrue(contactFormButton.isDisplayed());
        softAssert.assertTrue(contactFormButton.getText().contains("CONTACT FORM"));

        WebElement serviceButton = webDriver.findElement(By.xpath("//a[contains(text(),'Service')]"));
        softAssert.assertTrue(serviceButton.isDisplayed());
        softAssert.assertTrue(serviceButton.getText().contains("SERVICE"));

        WebElement metalsColorsButton = webDriver.findElement(By.xpath("//a[text() = 'Metals & Colors']"));
        softAssert.assertTrue(metalsColorsButton.isDisplayed());
        softAssert.assertTrue(metalsColorsButton.getText().contains("METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        WebElement practiseIcon = webDriver.findElement(By.cssSelector(".icons-benefit.icon-practise"));
        softAssert.assertTrue(practiseIcon.isDisplayed());

        WebElement customIcon = webDriver.findElement(By.cssSelector(".icons-benefit.icon-custom"));
        softAssert.assertTrue(customIcon.isDisplayed());

        WebElement multiplatformIcon = webDriver.findElement(By.cssSelector(".icons-benefit.icon-multi"));
        softAssert.assertTrue(multiplatformIcon.isDisplayed());

        WebElement baseIcon = webDriver.findElement(By.cssSelector(".icons-benefit.icon-base"));
        softAssert.assertTrue(baseIcon.isDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement practiseText = webDriver.findElement(By.xpath("//span[text() = 'To include good practices']"));
        softAssert.assertTrue(practiseText.isDisplayed());

        WebElement customText = webDriver.findElement(By.xpath("//span[text() = 'To be flexible and']"));
        softAssert.assertTrue(customText.isDisplayed());

        WebElement multiplatformText = webDriver.findElement(By.xpath("//span[text() = 'To be multiplatform ']"));
        softAssert.assertTrue(multiplatformText.isDisplayed());

        WebElement baseText = webDriver.findElement(By.xpath("//span[text() = 'Already have good base']"));
        softAssert.assertTrue(baseText.isDisplayed());

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
        WebElement homeSidebarMenu = webDriver.findElement(By.xpath("//span[text() = 'Home']"));
        softAssert.assertTrue(homeSidebarMenu.isDisplayed());
        softAssert.assertTrue(homeSidebarMenu.getText().contains("Home"));

        WebElement contactFormSidebarMenu = webDriver.findElement(By.xpath("//span[text() = 'Contact form']"));
        softAssert.assertTrue(contactFormSidebarMenu.isDisplayed());
        softAssert.assertTrue(contactFormSidebarMenu.getText().contains("Contact form"));

        WebElement serviceSidebarMenu = webDriver.findElement(By.xpath("//span[text() = 'Service']"));
        softAssert.assertTrue(serviceSidebarMenu.isDisplayed());
        softAssert.assertTrue(serviceSidebarMenu.getText().contains("Service"));

        WebElement metalsColorsSidebarMenu = webDriver.findElement(By.xpath("//span[text() = 'Metals & Colors']"));
        softAssert.assertTrue(metalsColorsSidebarMenu.isDisplayed());
        softAssert.assertTrue(metalsColorsSidebarMenu.getText().contains("Metals & Colors"));

        WebElement elementsSidebarMenu = webDriver.findElement(By.xpath("//span[text() = 'Elements packs']"));
        softAssert.assertTrue(elementsSidebarMenu.isDisplayed());
        softAssert.assertTrue(elementsSidebarMenu.getText().contains("Elements packs"));

        softAssert.assertAll();
    }

}
