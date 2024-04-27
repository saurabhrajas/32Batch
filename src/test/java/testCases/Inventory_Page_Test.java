package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LogInPage;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LogInPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		intialization();
		login=new LogInPage();
		invent=new Inventory_Page();
		login.LoginToApplication();
	}
	@Test(enabled = true,priority = 1,groups = {"Sanity","Retesting"}) 
	public void verifyPageTitleTest()
	{
		String expTitle="Products";
		String actTitle=invent.verifyPageTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("the title of inventory page is equal = "+actTitle);
	}
	@Test(enabled = true,priority = 2,groups = "Regreesion")
	public void verifyTwitterLogo()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Twitter Logo is Present = "+result);
				
	}
	@Test(enabled = true,priority =4, groups = {"Retesting","Regreesion"})
	public void add6Products()
	{
		String expCount="6";
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total product added to the cart = " + actCount);
	}
	@Test(enabled = true,priority = 3,groups = {"Regreesion","Retesting"})
	public void remove6Products()
	{
		String expcount="1";
		String actcount=invent.remove5Products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Total product removed to the cart ="+actcount);
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
