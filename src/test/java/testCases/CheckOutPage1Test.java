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
import pages.CheckOutPage1;
import pages.Inventory_Page;
import pages.LogInPage;
import utility.Screenshot;

public class CheckOutPage1Test extends TestBase
{
	LogInPage login;
	Inventory_Page invent;
	CartPage cart;
	CheckOutPage1 check1;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		intialization();
		login=new LogInPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1=new CheckOutPage1();
		login.LoginToApplication();
		invent.add6Products();
		invent.ClickOncartIcon();
		cart.clickOncheckOutBtn();
	}
	@Test(enabled = true,groups = {"Sanity","Retesting"})
	public void inputInfoTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("checkout page 2 URL = "+actURL);
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
