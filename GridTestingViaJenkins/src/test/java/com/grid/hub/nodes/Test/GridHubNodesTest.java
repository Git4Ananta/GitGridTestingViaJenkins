package com.grid.hub.nodes.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.net.NetworkUtils;

import configuration.settings;



public class GridHubNodesTest {
	
	public RemoteWebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//System.out.println(settings.NODE2URL);
		//capabilities.setPlatform(Platform.VISTA);
		//capabilities.setBrowserName("firefox");
		//capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
		//capabilities.setCapability("deviceName","Sri-PC");
		//driver = new RemoteWebDriver(new URL("http://192.168.1.35:4444/wd/hub"), capabilities);
		driver = new RemoteWebDriver(new URL(settings.NODE2URL), capabilities);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitle() {
		System.out.println("*** Navigating to Application ***");
		driver.navigate().to(settings.BASEURL);
		String stringPageTitle = driver.getTitle();
		System.out.println("*** Verifying Title ***");
		Assert.assertTrue(stringPageTitle.equalsIgnoreCase("Google"), "Page title does't match");
	}
	
	/*@AfterClass
	
	public void closeBrowser(){
		if (driver!= null){
			driver.quit();
		}
	}*/
	
}