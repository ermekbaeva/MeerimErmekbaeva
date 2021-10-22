package com.epam.tc.hw2.ex2;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tc.hw2.PageBaseTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class ServicePageUITest extends PageBaseTest {

    @Test
    public void servicePageTest() {

        //1. Open test site by URL
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);

        //2. Assert Browser title
        assertEquals("Home Page", webDriver.getTitle());

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
        assertTrue(userName.isDisplayed());
        assertTrue(userName.getText().contains("ROMAN IOVLEV"));

        //5. Open through the header menu Service -> Different Elements Page
        WebElement serviceButton = webDriver.findElement(By.xpath("//a[contains(text(),'Service')]"));
        serviceButton.click();
        WebElement differentElementsButton = webDriver
                .findElement(By.xpath("//a[contains(text(),'Different elements')]"));
        differentElementsButton.click();

        //6. Select checkboxes
        WebElement waterCheckbox = webDriver.findElement(By.xpath("//label[@class='label-checkbox'][1]/input"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(waterCheckbox));
        waterCheckbox.click();

        WebElement windCheckbox = webDriver.findElement(By.xpath("//label[@class='label-checkbox'][3]/input"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(windCheckbox));
        windCheckbox.click();

        //7. Select radio
        WebElement selenRadiobox = webDriver.findElement(By.xpath("//label[@class='label-radio'][4]/input"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selenRadiobox));
        selenRadiobox.click();

        //8. Select in dropdown
        WebElement colorsDropDownMenu = webDriver.findElement(By.xpath("//select[@class='uui-form-element']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(colorsDropDownMenu));
        Select colorSelect = new Select(colorsDropDownMenu);
        colorSelect.selectByVisibleText("Yellow");

        //9. Assert that
        //    • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        assertTrue(waterCheckbox.isSelected());
        assertTrue(windCheckbox.isSelected());

        //    • for radio button there is a log row and value is corresponded to the status of radio button
        assertTrue(selenRadiobox.isSelected());

        //    • for dropdown there is a log row and value is corresponded to the selected value. 
        assertEquals("Yellow", colorSelect.getFirstSelectedOption().getText());
    }
}
