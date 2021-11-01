package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends BasePage {
    @FindBy(id = "frame")
    private WebElement frameWithButton;
    @FindBy(id = "frame-button")
    private WebElement buttonFrame;
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    private List<WebElement> navigationNavBarElements;
    @FindBy(css = ".benefit-icon")
    private List<WebElement> imagesOnIndexPage;
    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsOnIndexPage;
    @FindBy(css = ".sidebar-menu.left")
    private List<WebElement> itemsOnSideBar;
    private String navigationElementsTextExpected = "HOME CONTACT FORM SERVICE METALS & COLORS";
    private List<String> textOnIndexPageExpected = Arrays
            .asList("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    private String itemsTextOnSideBarExpected = "Home Contact form Service Metals & Colors Elements packs";

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getFrameWithButton() {
        return frameWithButton;
    }

    public boolean isNavigationBarElementsDisplayed() {
        Boolean isElementsDisplayed = false;
        for (WebElement element : navigationNavBarElements
        ) {
            isElementsDisplayed = element.isDisplayed();
        }
        return isElementsDisplayed;
    }

    public boolean isImagesOnIndexPageDisplayed() {
        Boolean isElementsDisplayed = false;
        for (WebElement element : textsOnIndexPage
        ) {
            isElementsDisplayed = element.isDisplayed();
        }
        return isElementsDisplayed;
    }

    public boolean isTextsOnIndexPageDisplayed() {
        Boolean isElementsDisplayed = false;
        for (WebElement element : imagesOnIndexPage
        ) {
            isElementsDisplayed = element.isDisplayed();
        }
        return isElementsDisplayed;
    }

    public boolean isItemsOnSideBarDisplayed() {
        Boolean isElementsDisplayed = false;
        for (WebElement element : itemsOnSideBar
        ) {
            isElementsDisplayed = element.isDisplayed();
        }
        return isElementsDisplayed;
    }

    public boolean isFrameWithButtonDisplayed() {
        return frameWithButton.isDisplayed();
    }

    public boolean isButtonFrameDisplayed() {
        return buttonFrame.isDisplayed();
    }

    public boolean navBarHaveProperText() {
        String navigationElementsTextActual = navigationNavBarElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).toString()
                .replaceAll("[^a-zA-Z&]", " ").trim();

        return navigationElementsTextActual.equals(navigationElementsTextExpected);
    }

    public boolean textOnIndexHaveProperText() {
        List<String> textOnIndexPageActual = textsOnIndexPage.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        return textOnIndexPageExpected.containsAll(textOnIndexPageActual);
    }

    public boolean sideBarHaveProperText() {
        String itemsTextOnSideBarActual = itemsOnSideBar.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .toString().replaceAll("[^a-zA-Z&]", " ").trim();

        return itemsTextOnSideBarExpected.equals(itemsTextOnSideBarActual);
    }
}
