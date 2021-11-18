package com.sgtesting.actitime.testsuite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "FeatureFiles/",
		glue = {"com.sgtesting.actitime.stepdefinitions"}	
		)

public class TestSuite {

}
