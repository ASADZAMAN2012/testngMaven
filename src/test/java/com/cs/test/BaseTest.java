package com.cs.test;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	protected WebDriver webDriver;
	 
    @BeforeMethod
    public void setUp() throws MalformedURLException 
    {
 
        /*threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities();
        FirefoxProfile fp = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));*/
    	
    	FirefoxBinary binary = new FirefoxBinary();  
    	 File firefoxProfileFolder = new 
    	 File("/Users/asadzaman/Documents/workspace/CrowdSurgeUITest/src/test/resources/ffp");
    	 FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
    	 profile.setAcceptUntrustedCertificates(true);
    	 webDriver = new FirefoxDriver(binary, profile);
    }
 
    
    @AfterMethod
    public void closeBrowser() 
    {
    	webDriver.quit();
 
    }

}
