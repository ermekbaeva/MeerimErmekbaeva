package com.epam.tc.hw6.service;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public final class WebDriverFactory {
    private WebDriverFactory() {

    }

    public static WebDriver createWebDriver(final Browser browser) {
        WebDriver driver;
        driver = createRemoteWebDriver(browser);
        return driver;
    }

    private static WebDriver createRemoteWebDriver(final Browser browser) {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
        return driver;
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }
}
