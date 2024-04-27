package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LogInPage;
import utility.ReadData;
import utility.Screenshot;

public class VerifyMultipleCredentialsTest extends TestBase
{
	LogInPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		intialization();
		login=new LogInPage(); 
	}
	@Test(enabled = true,groups = {"Sanity","Retesting"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);//"Swag Labs";
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
	
	}
	@Test(enabled = true,groups = "Regreesion")
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL="https://www.saucedemo.com/";//ReadData.readExcel(1,0);//(1,0)
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(expURL,actURL);
	}
	@Test(enabled = true,groups = {"Regreesion","Retesting"}/*,dependsOnMethods = "verifyURLofApplicationTest"*/)
	public void LoginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(2, 0);//"https://www.saucedemo.com/inventory.html";(2,0)
		String actURL=login.LoginToApplication();
	    Assert.assertEquals(expURL,actURL);
	}
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			
				};
		
	}
	@Test(dataProvider = "credentials")
	public void LoginToApplicationWithMultiCredsTest(String un,String pas)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.LoginToApplicationWithMultiCreds(un, pas);
		s.assertEquals(expURL, actURL);
		s.assertAll();
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
