package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:com.epam.tc.hw5/cucumber/"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
