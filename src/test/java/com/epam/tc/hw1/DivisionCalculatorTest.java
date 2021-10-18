package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivisionCalculatorTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] divisionDataProvider() {
        return new Object[][]{
                {6, 2, 3},
                {110, 10, 11},
                {27, 9, 3},
                {81, 9, 9}
        };
    }

    @Test(dataProvider = "divisionDataProvider")
    public void divisionTest(int a, int b, int expected) {
        System.out.printf("Division %d / %d test%n", a, b);
        int actual = calculator.division(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
