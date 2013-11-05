package com.cs.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	protected WebDriver driver;
	 
    @BeforeMethod
    public void setUp() throws MalformedURLException 
    {
 
        /*threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities();
        FirefoxProfile fp = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));*/
    	
	     /*FirefoxBinary binary = new FirefoxBinary();  
		 File firefoxProfileFolder = new 
		 File("/Users/asadzaman/Documents/workspace/CrowdSurgeUITest/src/test/resources/ffp");
		 FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
		 profile.setAcceptUntrustedCertificates(true);
		 webDriver = new FirefoxDriver(binary, profile);*/
    	
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
        desiredCapabilities.setVersion(System.getenv("SELENIUM_VERSION"));
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        driver = new RemoteWebDriver(
                    new URL("http://daemonp:2d3e8899-7ee6-4f82-a2a4-363b42a1caae@ondemand.saucelabs.com:80/wd/hub"),
                    desiredCapabilities);
    }
 
    
    @AfterMethod
    public void closeBrowser() 
    {
    	driver.quit();
 
    }

}
