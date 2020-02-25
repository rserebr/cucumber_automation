package com.cucumber.testautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "com.cucumber.testautomation",
        tags = "@web",
        plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber.json" }
)
public class RunCucumberTest  {}
