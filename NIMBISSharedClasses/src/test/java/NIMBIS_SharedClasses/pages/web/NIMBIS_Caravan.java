package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Caravan {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Caravan(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
       // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }

//Details
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_CaravanValue']")
    private WebElement caravanValue_Txt ;

    //Insured Values

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_CaravanSumInsured']")
    private WebElement caravanSumInsured_Txt ;

    //Vehicle

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Make']")
    private WebElement caravanMake_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Model']")
    private WebElement caravanModel_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Year']")
    private WebElement caravanYear_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_RegistrationNumber']")
    private WebElement caravanRegisterNumber_Txt ;

    //claims
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11067']")
    private WebElement caravanClaim012_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11068']")
    private WebElement caravanClaim1324_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11069']")
    private WebElement caravanClaim2536_Txt ;

    //Extensions
    @FindBy(xpath = "//button[@id='chkExtension3209']")
    private WebElement extension_Btn ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3209']")
    private WebElement extensionSum_Txt ;

    //Details
    public void enterCaravanValue(String amount){
        if (verifyElement.verifyBrowserElementValue(caravanValue_Txt, "Caravan Value") == 0){
            verifyElement.sendKeys(caravanValue_Txt,"Caravan Value",amount);
        }
    }

    //Insured Values
    public void enterCaravanSumInsured(){
        if (verifyElement.verifyBrowserElementValue(caravanSumInsured_Txt, "Caravan Sum Insured") == 0){
            verifyElement.clickElement(caravanSumInsured_Txt,"Caravan Sum Insured");
        }
    }
    //Vehicle

    public void enterCaravanMake(String make){
        if (verifyElement.verifyBrowserElementValue(caravanMake_Txt, "Caravan Make") == 0){
            verifyElement.sendKeys(caravanMake_Txt,"Caravan Make",make);
        }
    }

    public void enterCaravanModel(String model){
        if (verifyElement.verifyBrowserElementValue(caravanModel_Txt, "Caravan Model") == 0){
            verifyElement.sendKeys(caravanModel_Txt,"Caravan Model",model);
        }
    }

    public void enterCaravanYear(String year){
        if (verifyElement.verifyBrowserElementValue(caravanYear_Txt, "Caravan Year") == 0){
            verifyElement.sendKeys(caravanYear_Txt,"Caravan Year",year);
        }
    }

    public void enterRegisterNumber(String number){
        if (verifyElement.verifyBrowserElementValue(caravanRegisterNumber_Txt, "Caravan Register Number") == 0){
            verifyElement.sendKeys(caravanRegisterNumber_Txt,"Caravan Register Number",number);
        }
    }

    //claims

    public void enterCaravanClaim012Months(String number){
        if (verifyElement.verifyBrowserElementValue(caravanClaim012_Txt, "Caravan Claim 0-12") == 0){
            verifyElement.sendKeys(caravanClaim012_Txt,"Caravan Claim 0-12",number);
        }
    }

    public void enterCaravanClaim1324Months(String number){
        if (verifyElement.verifyBrowserElementValue(caravanClaim1324_Txt, "Caravan Claim 13-24") == 0){
            verifyElement.sendKeys(caravanClaim1324_Txt,"Caravan Claim 13-24",number);
        }
    }

    public void enterCaravanClaim2536Months(String Number){
        if (verifyElement.verifyBrowserElementValue(caravanClaim2536_Txt, "Caravan Claim 25-36") == 0){
            verifyElement.sendKeys(caravanClaim2536_Txt,"Caravan Claim 25-36",Number);
        }
    }

    //Extensions

    public void clickExtension(){
        if (verifyElement.verifyBrowserElementValue(extension_Btn, "Extension for Contents") == 0){
            verifyElement.clickElement(extension_Btn,"Extension for Contents");
        }
    }

    public void enterExtensionSum(String amount){
        if (verifyElement.verifyBrowserElementValue(extensionSum_Txt, "Extension for sum") == 0){
            verifyElement.sendKeys(extensionSum_Txt,"Extension for sum",amount);
        }
    }

}
