package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Personal_Accident {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Personal_Accident(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }

    //details

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10600_dateInput']")
    private WebElement coverdetail_Txt ;

    //detailsMethod

    public void enterCoverDate(String date){
        if (verifyElement.verifyBrowserElementValue(coverdetail_Txt, "Cover detail") == 0){
            verifyElement.sendKeys(coverdetail_Txt,"Cover detail",date);
        }
    }
}
