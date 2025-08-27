package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Legal_cost {
    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Legal_cost(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }

    //details


    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11051_Input']")
    private WebElement legalCostSumInsured_DD ;


    //details

    public void clickLegalSumDropDown(){
        if (verifyElement.verifyBrowserElementValue(legalCostSumInsured_DD, "Sum Insured") == 0){
            verifyElement.clickElement(legalCostSumInsured_DD,"Sum Insured");
        }
    }
}
