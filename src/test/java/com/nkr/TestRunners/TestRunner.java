 package com.nkr.TestRunners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.HTMLReporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
				features = {"src/test/resources/Features"},
		glue = {"com.nkr.Step_Definition", "com.nkr.AppHooks", "com.nkr.TestRunners"},
				
				plugin={"de.monochromata.cucumber.report.PrettyReports:Report/cucumber"},
				//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
				//plugin = {"json:target/cucumber.json"} //By mohammed
				
		monochrome=true,
		tags = "not @Skip"

		
		)

public class TestRunner {
	
	@AfterMethod
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("extent-config.xml"));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
	
		
	}


//how to fix 500 error in testNG Cucumber - https://www.youtube.com/watch?v=KSSas70525g
