/**
 * 
 */
package com.sts.testautomation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sts.testautomation.utilities.ElementFunctionality;

/**
 * @author sefakoramafikeng
 *
 */
public class TrailerCaravanRatingInfo_Prestige {
	

	public WebDriver BrowserDriver;
	public ElementFunctionality verifyElement; 	
	public String Device;
	
	public TrailerCaravanRatingInfo_Prestige(WebDriver browserDriver, String Device)
	{
		BrowserDriver = browserDriver;
		this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
		PageFactory.initElements(BrowserDriver, this);
	}
	

	
	@FindBy(xpath="//select[@id='txt13']")
	private WebElement dropdownStatus;
	
	@FindBy(xpath="//input[@id='txt15']")
	private WebElement txtEffectiveDate;	

	@FindBy(xpath="//input[@id='txt18']")
	private WebElement txtCancellationDate;	
	

	@FindBy(xpath="//select[@id='txt20']")
	private WebElement dropdownRating;
	

	@FindBy(xpath="//select[@id='txt24']")
	private WebElement dropdownSasriaCover;	
	

	@FindBy(xpath="//input[@id='txt25']")
	private WebElement txtSasriaSumInsured;
	

	@FindBy(xpath="//input[@id='txt29']")
	private WebElement txtDiscountLoading;
	

	@FindBy(xpath="//span[@id='valuationBtn26']")
	private WebElement IconSearchRiskAddress;
	
	//Methods
		public void selectStatusDropDown(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(dropdownStatus, "Status Dropdown") == 0)
			{
				verifyElement.selectorOptionPicker(dropdownStatus, "Status Dropdown", Value);
			}
			else 
			{
				System.err.println("Element Status Dropdown couldnt be found " );
			}
		}
		
		public void enterEffectiveDateTextbox(String value)
		{
			if(verifyElement.verifyBrowserElementValue(txtEffectiveDate, "Effective Date") == 0)
			{
				verifyElement.sendKeys(txtEffectiveDate, "Effective Date", value);
			}else
			{
				System.err.println("Effective Date could not be found");
			}
			
		}
		
		public void enterCancellationDateTextbox(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(txtCancellationDate, "Cancellation Date Textbox") == 0)
			{
				verifyElement.clickElement(txtCancellationDate, "Cancellation Date Textbox");
				verifyElement.sendKeys(txtCancellationDate, "Cancellation Date Textbox", Value);
			}
			else
			{
				System.err.println("Element Cancellation Date Textbox couldnt be found ");
			}
		}
		
		public void selectRatingMethodDropDown(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(dropdownRating, "Rating Method Dropdown") == 0)
			{
				verifyElement.selectorOptionPicker(dropdownRating, "Rating Method Dropdown", Value);
			}
			else 
			{
				System.err.println("Element Rating Method Dropdown couldnt be found " );
			}
		}
		
		public void selectSasriaCoverDropDown(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(dropdownSasriaCover, "Sasria Cover DropDown") == 0)
			{
				verifyElement.selectorOptionPicker(dropdownSasriaCover, "Sasria Cover DropDown", Value);
			}
			else 
			{
				System.err.println("Element Sasria Cover DropDown couldnt be found " );
			}
		}
		
		public void enterSasriaSumInsuredTextbox(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(txtSasriaSumInsured, "Sasria Sum Insured TextBox") == 0)
			{
				verifyElement.clickElement(txtSasriaSumInsured, "Sasria Sum Insured TextBox");
				verifyElement.sendKeys(txtSasriaSumInsured, "Sasria Sum Insured TextBox", Value);
			}
			else
			{
				System.err.println("Element Sasria Sum Insured TextBox couldnt be found ");
			}
		}
		
		public void enterDiscountLoadingTextbox(String Value)
		{
			if(verifyElement.verifyBrowserElementValue(txtDiscountLoading, "Discount/ Loading % Textbox") == 0)
			{
				verifyElement.clickElement(txtDiscountLoading, "Discount/ Loading % Textbox");
				verifyElement.sendKeys(txtDiscountLoading, "Discount/ Loading % Textbox", Value);
			}
			else
			{
				System.err.println("Element Discount/ Loading % Textbox couldnt be found ");
			}
		}
		
		public void clickSearchRiskAddressIcon()
		{
			if(verifyElement.verifyBrowserElementValue(IconSearchRiskAddress, "Search Risk Address Icon") == 0)
			{
				verifyElement.clickElement(IconSearchRiskAddress, "Search Risk Address Icon");
				//verifyElement.clickElement(IconSearchRiskAddress, "Search Risk Address Icon");
			}
			else
			{
				System.err.println("Element Search Risk Address Icon couldnt be found");
			}
		}

}
