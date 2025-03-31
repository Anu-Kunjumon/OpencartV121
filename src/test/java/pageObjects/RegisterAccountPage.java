package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends BasePage {
	
	public RegisterAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelePhone;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtCnfPassword;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement chkbxPrivacyPolicy;
	
	@FindBy(xpath="//input[@type='submit' and @value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		try
		{
			if(txtFirstName.isDisplayed())
			{
			txtFirstName.clear();
			txtFirstName.sendKeys(fname);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
		
	}
	public void setlastName(String lname)
	{
		try
		{
			if(txtLastName.isDisplayed())
			{
				txtLastName.clear();
				txtLastName.sendKeys(lname);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
		
	}
	
	public void setTelephoneNumber(String telephone)
	{
		try
		{
			if(txtTelePhone.isDisplayed())
			{
				txtTelePhone.clear();
				txtTelePhone.sendKeys(telephone);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	
	public void setEmail(String email)
	{
		try
		{
			if(txtEmail.isDisplayed())
			{
				txtEmail.clear();
				txtEmail.sendKeys(email);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
		
	}
	public void setPassword(String pwd)
	{
		try
		{
			if(txtPassword.isDisplayed())
			{
				txtPassword.clear();
				txtPassword.sendKeys(pwd);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	
	public void setCnfPasswrod(String cnfpwd)
	{
		try
		{
			if(txtCnfPassword.isDisplayed())
			{
				txtCnfPassword.clear();
				txtCnfPassword.sendKeys(cnfpwd);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	
	public void clickPrivacyPolicy()
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(chkbxPrivacyPolicy));
			chkbxPrivacyPolicy.click();
			System.out.println("Successfully Clicked chkbxPrivacyPolicy Chechkbox");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
		
		
	}
	public void clickContinue()
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(btnContinue));
			btnContinue.click();
			System.out.println("Successfully Clicked txtContinue button");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
		}
	}
	public String getConfirmationMsg()
	{
		try
		{
			String msg = msgConfirmation.getText();
			return msg;
		}
		catch(Exception e)
		{
			 return e.getMessage();
		}
		
	}
}
