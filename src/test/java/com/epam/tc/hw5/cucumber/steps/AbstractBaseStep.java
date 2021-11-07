package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.page.DifferentElementsPage;
import com.epam.tc.hw5.cucumber.page.HomePage;
import com.epam.tc.hw5.cucumber.page.LoginPage;
import com.epam.tc.hw5.cucumber.page.UserTablePage;


public abstract class AbstractBaseStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected LoginPage loginPage;

    public AbstractBaseStep() {
        homePage = new HomePage();
        differentElementsPage = new DifferentElementsPage();
        userTablePage = new UserTablePage();
        loginPage = new LoginPage();
    }
}
