package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyCalculatorTest {
    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] multiplyDataProvider() {
        return new Object[][]{
                {3, 2, 6},
                {11, 10, 110},
                {7, 9, 63},
                {55, 8, 440}
        };
    }

    @Test(dataProvider = "multiplyDataProvider")
    public void multiplyTest(int a, int b, int expected) {
        System.out.printf("Multiply %d * %d test%n", a, b);
        int actual = calculator.multiply(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
