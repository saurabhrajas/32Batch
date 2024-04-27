package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipTxtBox;
    @FindBy(xpath ="//input[@id='continue']") private WebElement continueBtn;
    //constructor
    public CheckOutPage1()
    {
    	PageFactory.initElements(driver,this);
    	
    }
    public String inputInfo()
    {
    	firstNameTxtBox.sendKeys("Harry");
    	lastNameTxtBox.sendKeys("Potter");
    	zipTxtBox.sendKeys("411014");
    	continueBtn.click();
    	return driver.getCurrentUrl();
    }
}
