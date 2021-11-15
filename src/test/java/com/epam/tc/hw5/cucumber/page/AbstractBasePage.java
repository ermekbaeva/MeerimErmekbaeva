package com.epam.tc.hw5.cucumber.page;

import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractBasePage {
    public WebDriverWait wait;

    public AbstractBasePage() {
        wait = new WebDriverWait(CucumberHooks.driver, 10L);
        PageFactory.initElements(CucumberHooks.driver, this);
    }
}
