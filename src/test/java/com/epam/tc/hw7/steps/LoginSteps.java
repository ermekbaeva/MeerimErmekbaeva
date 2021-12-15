package com.epam.tc.hw7.steps;

import static com.epam.tc.hw7.JdiSite.homePage;
import static com.epam.tc.hw7.pages.HomePage.loginForm;
import static com.epam.tc.hw7.pages.HomePage.userIcon;
import static com.epam.tc.hw7.pages.HomePage.userName;

import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.entity.User;
import io.qameta.allure.Step;


public class LoginSteps implements TestInit {
    @Step
    public static void openSite() {
        homePage.open();
    }

    @Step
    public static void shouldBeLoggedIn(User name) {
        if (!userName.isDisplayed()) {
            login(name);
        }
    }

    @Step
    public static void login(User name) {
        userIcon.click();
        loginForm.loginAs(name);
    }
}
