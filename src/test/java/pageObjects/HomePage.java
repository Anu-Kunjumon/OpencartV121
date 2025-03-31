package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	private WebDriverWait wait;
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver); // calls BasePage constructor driver and pass the HomePage driver
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	//locators
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement headingAccountLogout;
	
	public void clickMyAccount()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccount));
			lnkMyAccount.click();
			System.out.println("Successfully Clicked lnkMyAccount button");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
		
	}
	public void clickRegister()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(lnkRegister));
			lnkRegister.click();
			System.out.println("Successfully Clicked lnkRegister button");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	public void clickLogin()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(lnkLogin));
			lnkLogin.click();
			System.out.println("Successfully Clicked lnkLogin button");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	public boolean getheadingAccountLogout()
	{
		try
		{
			return headingAccountLogout.isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			return false;
		}
	}
}
