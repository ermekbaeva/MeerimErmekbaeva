package com.epam.tc.hw4.util;

import com.epam.tc.hw4.pages.BasePage;
import io.qameta.allure.Attachment;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener extends BasePage implements ITestListener {
    String filePath = System.getProperty("user.dir")
            + "/src/test/resources/com.epam.tc.hw4/screenshots/";

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName().toString().trim();
        takeScreenShot(methodName, webDriver);
        attachScreenshot(webDriver);
    }

    public void takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
