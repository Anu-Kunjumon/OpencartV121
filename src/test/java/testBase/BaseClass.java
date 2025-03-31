package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.net.URL;

import utilities.ConfigReader;

public class BaseClass
{
	
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException
	{
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(ConfigReader.getPropertyValue("execution_env").equalsIgnoreCase("remote"))
		{
			System.out.println(ConfigReader.getPropertyValue("execution_env"));
			System.out.println("Browser:"+browser+ ","+"OS:"+os);
			//OS
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN10);
				
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching OS");
			}
			System.out.println("Platform:"+cap.getPlatformName());
			//BROWSER
			switch(browser.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome");break;
			case "firefox": cap.setBrowserName("firefox");break;
			case "edge": cap.setBrowserName("edge");break;
			case "internet explorer": cap.setBrowserName("internet explorer");break;
			default: System.out.println("No matching browser");
			}
			
			//DRIVER CREATION USING REMOTEWEBDRIVER
			@SuppressWarnings("deprecation")
			URL gridURL=new URL(ConfigReader.getPropertyValue("gridURL"));
			System.out.println("Grid URL:"+gridURL);
			driver=new RemoteWebDriver(gridURL,cap);
				
		}
			
		
		if(ConfigReader.getPropertyValue("execution_env").equalsIgnoreCase("local"))	
		{	
			System.out.println(ConfigReader.getPropertyValue("execution_env"));
			System.out.println("Browser:"+browser+ ","+"OS:"+os);	
			switch(browser.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default : System.out.println("Invalid browsername");return;
			}
		}
			try
			{
			
			
			//driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String url=ConfigReader.getPropertyValue("appURL");
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Browser launched successfully and navigated to: " + url);
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());
			}
		}
	
	
	@AfterClass
	public void teardown()
	{
		try
		{
			if(driver!=null)
			{
				driver.quit();	
				System.out.println("Driver closed successfully");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			driver=null;
			System.out.println("Driver instance set to null");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber()
	{
		@SuppressWarnings("deprecation")
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumericString()
	{
		@SuppressWarnings("deprecation")
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return (generatedString+"@"+generatedNumber);
	}

}
