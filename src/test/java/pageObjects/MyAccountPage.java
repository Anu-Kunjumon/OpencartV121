package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAccountPage extends BasePage{
	
	private WebDriverWait wait;
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1] | //h2[text()='My Account']")
	WebElement headingMyAccount;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnkLogout;
	
	public boolean getMyAccountHeading()
	{
		try
		{
			return (headingMyAccount.isDisplayed());
			//Assert.assertEquals(heading, "My Account");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	public void clickLogout()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(lnkLogout));
			lnkLogout.click();
			System.out.println("Logout button clicked");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
