package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.sections.LoginForm;
import com.epam.tc.hw7.sections.MetalsAndColorsForm;
import org.openqa.selenium.WebElement;

public class JdiSite {
    public static HomePage homePage;
    public static LoginForm loginForm;
    public static MetalsAndColorsPage metalsAndColorsPage;
    public static MetalsAndColorsForm metalsAndColorsForm;
    @UI("#submit-button") public static Button submitButton;
    @UI("img#user-icon") public static Link userIcon;
    @UI("#user-name") public static Text userName;
    @UI(".fa-sign-out") public static Button logout;
    @UI("//a[contains(text(),'Metals & Colors')]") public static Button metalsAndColorsNavBar;
    @Css(".summ-res")
    public static WebElement summaryResult;
    @Css(".col-res")
    public static WebElement colorResult;
    @Css(".met-res")
    public static WebElement metalsResult;
    @Css(".elem-res")
    public static WebElement elementsResult;
    @Css(".sal-res")
    public static WebElement vegetablesResult;
}
