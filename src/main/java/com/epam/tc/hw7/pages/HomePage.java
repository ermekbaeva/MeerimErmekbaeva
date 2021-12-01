package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    public static LoginForm loginForm;
    @UI("img#user-icon")
    public static Link userIcon;
    @UI("#user-name")
    public static Text userName;
    @UI("//a[contains(text(),'Metals & Colors')]")
    public static Button metalsAndColorsNavBar;
}
