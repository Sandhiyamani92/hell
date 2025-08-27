package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Prestige_Personal_liability {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Personal_liability(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }

    //risk details

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_SumInsured']")
    private WebElement personalsumInsured_Txt ;

    //extensions
    @FindBy(xpath = "//button[@id='chkExtension6098']")
    private WebElement extension_Btn ;

    //methods

    public void enterpersonalSumInsured(String amount){
        if (verifyElement.verifyBrowserElementValue(personalsumInsured_Txt, "personal sum insured") == 0){
            verifyElement.sendKeys(personalsumInsured_Txt,"personal sum insured",amount);
        }
    }

    public void clickExtension(){
        if (verifyElement.verifyBrowserElementValue(extension_Btn, "Extension for Personal liability") == 0){
            verifyElement.clickElement(extension_Btn,"Extension for liability");
        }
    }
}
