package com.qa.bdd;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.qa.bdd",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },
    monochrome = true
)
public class CucumberTestRunner
        extends AbstractTestNGCucumberTests {
}