package com.epam.tc.hw6.service;

import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;


public class WebDriverProvider {
    private static WebDriver driver;

    private WebDriverProvider() {

    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            String browserName = System.getProperty("browser.name", "chrome");
            driver = WebDriverFactory.createWebDriver(
                    Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
