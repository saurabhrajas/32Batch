package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReportManager extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName=new SimpleDateFormat("dd-MM-YYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter("C:\\Users\\HP\\eclipse-workspace\\32Batch_selenium_project\\Extent Report"+reportName+".html");
			report=new ExtentReports();
			report.attachReporter(htmlreporter);
			report.setSystemInfo("OS","Windows");
			report.setSystemInfo("Environment","SIT");
			report.setSystemInfo("Build Number","102.02.02123");
			report.setSystemInfo("Browser","Chrome");
			htmlreporter.config().setDocumentTitle("UI Testing Documents");
			htmlreporter.config().setReportName("UI Test Report");
		}	
		return report;
	}

}
