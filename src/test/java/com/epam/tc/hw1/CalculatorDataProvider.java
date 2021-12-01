package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public Object[][] divisionDataProvider() {
        return new Object[][]{
                {6, 2, 3},
                {110, 10, 11},
                {27, 9, 3},
                {81, 9, 9}
        };
    }

    @DataProvider
    public Object[][] multiplyDataProvider() {
        return new Object[][]{
                {3, 2, 6},
                {11, 10, 110},
                {7, 9, 63},
                {55, 8, 440}
        };
    }

    @DataProvider
    public Object[][] subtractDataProvider() {
        return new Object[][]{
                {5, 2, 3},
                {11, 10, 1},
                {27, 9, 18},
                {53, 15, 38}
        };
    }

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][]{
                {23, 2, 25},
                {89, 10, 99},
                {12, 90, 102},
                {12, 67, 79}
        };
    }
}
