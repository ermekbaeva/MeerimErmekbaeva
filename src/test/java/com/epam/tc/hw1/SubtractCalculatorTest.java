package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractCalculatorTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] subtractDataProvider() {
        return new Object[][]{
                {5, 2, 3},
                {11, 10, 1},
                {27, 9, 18},
                {53, 15, 38}
        };
    }

    @Test(dataProvider = "subtractDataProvider")
    public void subtractTest(int a, int b, int expected) {
        int actual = calculator.subtract(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
