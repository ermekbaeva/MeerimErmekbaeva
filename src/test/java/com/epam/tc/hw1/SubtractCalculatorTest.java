package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class SubtractCalculatorTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "subtractDataProvider")
    public void subtractTest(int a, int b, int expected) {
        System.out.printf("Subtract %d - %d test%n", a, b);
        int actual = calculator.subtract(a, b);
        assertThat(actual)
                .as("Failed on subtract %d and %d", a, b)
                .isEqualTo(expected);
    }
}
