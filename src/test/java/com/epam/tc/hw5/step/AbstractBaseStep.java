package com.epam.tc.hw5.step;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.page.HomePage;
import org.openqa.selenium.WebDriver;


public class AbstractBaseStep {
    protected HomePage homePage;
    public AbstractBaseStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        homePage = new HomePage(driver);
    }
}
