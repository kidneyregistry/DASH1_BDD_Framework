package com.nkr.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 *This will initialize the browser and set intial URL
	 * @param browser and URL
	 * @return this will return tldriver.
	 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);
		//System.out.println("URL value is: " + url);
		
		if (browser.equals("chrome")) {	
			
			
			ChromeOptions options = new ChromeOptions();
		   	// options.addArguments("-incognito");
		   	 options.addArguments("--disable-popup-blocking");
		   	 options.addArguments("--disable-notification");
		   	 options.addArguments("--disable-extensions");
		   	 options.setExperimentalOption("useAutomationExtension", false);
		   	 options.addArguments("test-type");
		   	    options.addArguments("no-sandbox");
		   	    //Fix for cannot get automation extension
		   	    options.addArguments("disable-extensions");
		   	    options.addArguments("start-maximized");
		   	    options.addArguments("--js-flags=--expose-gc");         
		   	    options.addArguments("disable-plugins");
		   	    options.addArguments("--enable-precise-memory-info"); 
		   	    options.addArguments("--disable-popup-blocking");
		   	    options.addArguments("--disable-default-apps");
		   	    options.addArguments("test-type=browser");
		   	    options.addArguments("disable-infobars");
		   	    options.addArguments("--ignore-ssl-errors=yes");
		   	    options.addArguments("--ignore-certificate-errors");
		   	    
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(options));						
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		
		//getDriver().get(url);
		return getDriver();

	}
	
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
