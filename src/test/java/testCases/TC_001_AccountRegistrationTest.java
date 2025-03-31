package testCases;

import org.apache.commons.lang3.RandomStringUtils;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
		@Test
		public void verifyAccountRegistration()
		{
			try
			{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*****Clicked My Account Button*****");
			hp.clickRegister();
			logger.info("*****Clicked Register button*****");
			RegisterAccountPage register=new RegisterAccountPage(driver);
			
			logger.info("*****Passed inputs*****");
			register.setFirstName(randomString().toUpperCase());
			register.setlastName(randomString().toUpperCase());
			register.setEmail(randomString()+"@gmail.com");
			register.setTelephoneNumber(randomNumber());
			
			String pwd=randomAlphaNumericString();
			register.setPassword(pwd);
			register.setCnfPasswrod(pwd);
			
			register.clickPrivacyPolicy();
			logger.info("*****Clicked Privacy Policy*****");
			register.clickContinue();
			logger.info("*****Clicked Continue button*****");
			String cnfMsg=register.getConfirmationMsg();
			
			if(cnfMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("*****TEST FAILED*****");
				logger.debug("*****Debug Logs*****");
				Assert.assertTrue(false);
			}
			
			//Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
			logger.info("*****Verified Confirmation Msg*****");
			}
			catch(Exception e)
			{
				
				Assert.fail();
			}
			logger.info("*****SUCCESSFULLY FINISHED TESTCASE: TC_001_AccountRegistrationTest*****");
		}
}
