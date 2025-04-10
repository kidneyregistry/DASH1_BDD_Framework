package com.nkr.AppHooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.nkr.DriverFactory.DriverFactory;
import com.nkr.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class LoginHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	// Fetches the config.properties file's data into prop
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	// Initializes the browser driver depending upon the configuration
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser is " + browserName);

		// Creating ChromeOptions and adding the argument
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-running-insecure-content"); // Add this line

		// Initializes the browser driver with the options
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName); // No changes here, assuming init_driver handles options in DriverFactory
	}

	// Closes the browser at the end of execution
	@After(order = 0)
	public void quitBrowser() throws InterruptedException {
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.quit();
	}
	
	// Saves the screenshot for the failed scenario
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}

	/*
	 * //Saves the screenshot for the failed scenario
	 * 
	 * @After(order = 2) public void sendEmail() { SendEmail email = new
	 * SendEmail(); email.sendE();
	 * 
	 * }
	 */



