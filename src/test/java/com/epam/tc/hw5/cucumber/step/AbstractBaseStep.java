package com.epam.tc.hw5.cucumber.step;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.cucumber.page.DifferentElementsPage;
import com.epam.tc.hw5.cucumber.page.HomePage;
import com.epam.tc.hw5.cucumber.page.UserTablePage;
import org.openqa.selenium.WebDriver;


public class AbstractBaseStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractBaseStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
