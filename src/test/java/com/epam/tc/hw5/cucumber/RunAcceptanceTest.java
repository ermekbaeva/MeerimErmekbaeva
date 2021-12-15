package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:com.epam.tc.hw5/cucumber/"},
        glue = {"com.epam.tc.hw5.cucumber.steps",
                "com.epam.tc.hw5.cucumber.hooks"},
        plugin = {"pretty"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
