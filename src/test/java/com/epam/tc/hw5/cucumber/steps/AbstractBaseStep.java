package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.page.DifferentElementsPage;
import com.epam.tc.hw5.cucumber.page.HomePage;
import com.epam.tc.hw5.cucumber.page.LoginPage;
import com.epam.tc.hw5.cucumber.page.UserTablePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public abstract class AbstractBaseStep {
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;
    protected LoginPage loginPage;
    public static Properties prop;

    public AbstractBaseStep() {
        homePage = new HomePage();
        differentElementsPage = new DifferentElementsPage();
        userTablePage = new UserTablePage();
        loginPage = new LoginPage();

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
