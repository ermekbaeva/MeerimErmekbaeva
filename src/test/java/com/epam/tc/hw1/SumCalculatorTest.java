package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalculatorTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][]{
                {23, 2, 25},
                {89, 10, 99},
                {12, 90, 102},
                {12, 67, 79}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sumTest(int a, int b, int expected) {
        System.out.printf("Sum %d + %d test%n", a, b);
        int actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
