package com.sgtesting.actitime.testsuite;
import com.cucumber.listener.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sgtesting.actitime.utility.ApplicationIndependent;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/FeatureFiles",
		glue={"com.sgtesting.actitime.stepdefinitions"},
		/*plugin={ "html:Reports/cucumber-html-report",
		        "json:Reports/cucumber.json", "pretty:Reports/cucumber-pretty.txt",
		        "usage:Reports/cucumber-usage.json", "junit:Reports/cucumber-results.xml" },*/
	
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/cucumber-extent-reports/ActTimeResultReport.html"},
		
		tags ={"@Execute"}
		)
public class DriverScript {
	
	TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void writeExtentReport() 
    {
    	Reporter.loadXMLConfig(ApplicationIndependent.getReportConfigPath());
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

}
