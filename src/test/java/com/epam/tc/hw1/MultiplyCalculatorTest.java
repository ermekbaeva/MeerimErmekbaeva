package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class MultiplyCalculatorTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "multiplyDataProvider")
    public void multiplyTest(int a, int b, int expected) {
        System.out.printf("Multiply %d * %d test%n", a, b);
        int actual = calculator.multiply(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
