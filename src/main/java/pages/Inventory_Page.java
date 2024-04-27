package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;

public class Inventory_Page extends TestBase
{
	//object Repository
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
	//Adding products
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productBoltTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productRedTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement productOneSize;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebooklogo;
	//Removing products
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeProd_jacket;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removeProd_backpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeProd_bolttshirt;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeProd_redtshirt;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeProd_bikelight;
	//constructor
	public Inventory_Page()
	{
		PageFactory.initElements(driver,this);
	}
	//methods
	public String verifyPageTitle()
	{
		return pageTitle.getText();	
	}
	public boolean verifyTwitterLogo()
	{
		return TwitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return facebooklogo.isDisplayed();
	}
	public String add6Products()
	{
		HandleDropDown.handleSelect(dropDown, "Price (low to high)");
		productJacket.click();
		productBackpack.click();
		productBikeLight.click();
		productBoltTshirt.click();
		productRedTshirt.click();
		productOneSize.click();
		return cartCount.getText();
		
	}
	public String remove5Products()
	{
		add6Products();
		removeProd_backpack.click();
		removeProd_jacket.click();
		removeProd_bolttshirt.click();
		removeProd_redtshirt.click();
		removeProd_bikelight.click();
		return cartCount.getText();
	}
	public void ClickOncartIcon()
	{
		cartIcon.click();
	}

}
