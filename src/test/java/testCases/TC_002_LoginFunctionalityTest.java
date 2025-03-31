package testCases;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ConfigReader;

public class TC_002_LoginFunctionalityTest extends BaseClass {
	
	
	
	@Test
	public void verifyLoginFunctionalityTest()
	{
		try
		{
		logger.info("*****TESTCASE STARTED - TC_002_LoginFunctionality*****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*****Clicked My Account link*****");
		hp.clickLogin();
		logger.info("*****Clicked Login link*****");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(ConfigReader.getPropertyValue("email"));
		logger.info("*****Email id enterd*****");
		lp.setPassword(ConfigReader.getPropertyValue("password"));
		logger.info("*****Password entered*****");
		
		lp.clickLoginButton();
		logger.info("*****Clicked Login Button*****");
		
		MyAccountPage ma=new MyAccountPage(driver);
		boolean headingMyacc=ma.getMyAccountHeading();
		Assert.assertTrue(headingMyacc);
		logger.info("*****My Account heading displayed*****");
		
		ma.clickLogout();
		boolean headingMyacclogout=hp.getheadingAccountLogout();
		Assert.assertTrue(headingMyacclogout);
		logger.info("*****Account Logout heading displayed*****");
		
		logger.info("*****TESTCASE FINISHED  - TC_002_LoginFunctionality*****");
		}
		catch(Exception e)
		{
			logger.info("*****TESTCASE FAILED - TC_002_LoginFunctionality*****");
			Assert.fail();
			
		}
		
		
		
		
	}
}
