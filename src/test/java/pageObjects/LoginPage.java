package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {
	
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement btnLogin;
	
		public void setEmailAddress(String emailaddress)
	{
		try
		{
			if(txtEmailAddress.isDisplayed())
			{
			txtEmailAddress.isDisplayed();
			txtEmailAddress.clear();
			txtEmailAddress.sendKeys(emailaddress);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void setPassword(String password)
	{
		try
		{
			if(txtPassword.isDisplayed())
			{
			txtPassword.isDisplayed();
			txtPassword.clear();
			txtPassword.sendKeys(password);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void clickLoginButton()
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			btnLogin.click();
			System.out.println("Clicked Login button");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
