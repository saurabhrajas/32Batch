package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page;
import pages.LogInPage;
import utility.Screenshot;

public class CartPageTest extends TestBase
{
	LogInPage login;
	Inventory_Page invent;
	CartPage cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		intialization();
		login=new LogInPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		login.LoginToApplication();
		invent.add6Products();
		invent.ClickOncartIcon();
	}
	@Test(enabled = true,groups = {"Sanity","Retesting"})
	public void verifyCartPageURLTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=cart.verifyCartPageUrl();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("the title of cart page is equal = "+actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.sc(it.getName());
		}	
		driver.close();
	}
	
	


}
