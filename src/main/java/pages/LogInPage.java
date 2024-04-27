package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LogInPage extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement userNameTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	public LogInPage()
	{
		PageFactory.initElements(driver,this);
	}//constructor
	public String LoginToApplication() throws IOException
	{
		logger=report.createTest("Login to sauce lab application");
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO,"User name is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login button is clicked");
		logger.log(Status.INFO,"Login is sucessful");
		return driver.getCurrentUrl();//https://www.saucedemo.com/inventory.html
		
	}
	public String LoginToApplicationWithMultiCreds(String un,String pas)
	{
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pas);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();	
	}
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
		
	}

}
