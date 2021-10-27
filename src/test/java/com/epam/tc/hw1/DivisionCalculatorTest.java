package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.testng.annotations.Test;

public class DivisionCalculatorTest extends CalculatorBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "divisionDataProvider")
    public void divisionTest(int a, int b, int expected) {
        System.out.printf("Division %d / %d test%n", a, b);
        int actual = calculator.division(a, b);
        assertThat(actual).isEqualTo(expected);
        assertThatThrownBy(() -> calculator.division(32, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
