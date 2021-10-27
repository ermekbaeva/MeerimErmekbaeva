package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SumCalculatorTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "sumDataProvider")
    public void sumTest(int a, int b, int expected) {
        System.out.printf("Sum %d + %d test%n", a, b);
        int actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
