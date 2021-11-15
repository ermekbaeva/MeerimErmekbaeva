package com.epam.tc.hw7.tests;

import com.epam.tc.hw7.TestInit;
import com.epam.tc.hw7.data.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.entity.MetalsAndColors;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class JdiPageTest implements TestInit {

    @Test(dataProvider = "getDataFromJson", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void publisherOnboardingTest(MetalsAndColors data) throws FileNotFoundException {
        System.out.println("summary is: " + data.getSummary());
        System.out.println("elements is: " + data.getElements());
        System.out.println("color is: " + data.getColor());
        System.out.println("metals is: " + data.getMetals());
        System.out.println("vegetables is: " + data.getVegetables());

    }
}
