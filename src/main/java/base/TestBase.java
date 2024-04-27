package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;



public class TestBase 
{
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static WebDriver driver;
	public void intialization() throws InterruptedException, IOException
	{        
		     String browser=ReadData.readPropertyFile("Browser");
		     if(browser.equals("chrome"))
		     {
		    	 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(); 
		     }
		     else if(browser.equals("edge"))
		     {
		    	 WebDriverManager.edgedriver().setup();
		    	 driver=new EdgeDriver();
		     }
		     else if(browser.equals("firefox"))
		     {
		    	WebDriverManager.firefoxdriver().setup();
		    	driver=new FirefoxDriver();
		     }
			
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.get(ReadData.readPropertyFile("URL"));
	}

}
