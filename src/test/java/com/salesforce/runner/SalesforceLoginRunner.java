package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/SalesforceLoginFeature.feature"},
glue= {"com.salesforcesteps.com"}
)
//,plugin= {"pretty","html:target/cucumber-reports"}, monochrome = true

public class SalesforceLoginRunner extends AbstractTestNGCucumberTests{

}
