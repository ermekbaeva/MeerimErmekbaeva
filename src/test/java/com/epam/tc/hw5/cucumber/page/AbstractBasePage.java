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
    public static Properties prop;

    public AbstractBasePage() {
        wait = new WebDriverWait(CucumberHooks.driver, 10L);
        PageFactory.initElements(CucumberHooks.driver, this);

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
                    + "/src/test/resources/com.epam.tc.hw5/test.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
