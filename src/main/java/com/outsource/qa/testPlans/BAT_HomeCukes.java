package com.outsource.qa.testPlans;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        ,glue={"com.outsource.qa.stepDefinitions"}
        ,monochrome = true
        ,tags = {}
        ,format = {"pretty","html:target/html","json:target/cucumber.json"}
)
//"src/main/resources/features"
public class BAT_HomeCukes {
}
