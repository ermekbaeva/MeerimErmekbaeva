package com.epam.tc.hw7.steps;

import static com.epam.tc.hw7.data.UserDataProvider.ROMAN;
import static com.epam.tc.hw7.pages.JdiSite.homePage;
import static com.epam.tc.hw7.pages.JdiSite.loginForm;
import static com.epam.tc.hw7.pages.JdiSite.userIcon;
import static com.epam.tc.hw7.pages.JdiSite.userName;

import com.epam.tc.hw7.TestInit;
import io.qameta.allure.Step;


public class LoginSteps implements TestInit {
    @Step
    public static void openSite() {
        homePage.open();
    }

    @Step
    public static void shouldBeLoggedIn() {
        if (!userName.isDisplayed()) {
            login();
        }
    }

    @Step
    public static void login() {
        userIcon.click();
        loginForm.loginAs(ROMAN);
    }
}
