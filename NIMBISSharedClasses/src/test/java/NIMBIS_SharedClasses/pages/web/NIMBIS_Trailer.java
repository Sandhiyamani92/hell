package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Trailer {
    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Trailer(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }
//details
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_FinanceDetails_dateInput']")
    private WebElement financeDate_Txt;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_chkIsFinanced']")
    private WebElement isFianced_Btn;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_lstFinanceHouse_Input']")
    private WebElement financeHouse_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_txtPeriodOfFinance']")
    private WebElement periodOfFiance_Txt;

    //claims

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11070']")
    private WebElement trailerClaim012_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11071']")
    private WebElement trailerlaim1324_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11072']")
    private WebElement trailerClaim2536_Txt ;

    //cover options

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7297")
    private WebElement  typeOfVehicleliability_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7298")
    private WebElement  typeOfCover_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7299")
    private WebElement  classOfUse_DD ;

    //extensions

    //Extensions
    @FindBy(xpath = "//button[@id='chkExtension3210']")
    private WebElement trailerextension_Btn ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3210']")
    private WebElement TrailerextensionSum_Txt ;

    //Insured Value

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_TrailerSumInsured']")
    private WebElement trailerSumInsured_Txt;

    //details

    public void enterFinanceHouse(String house){
        if (verifyElement.verifyBrowserElementValue(financeHouse_Txt, "Finance House") == 0){
            verifyElement.sendKeys(financeHouse_Txt,"Finance House",house);
        }
    }

    public void enterFinancePeriod(String period){
        if (verifyElement.verifyBrowserElementValue(periodOfFiance_Txt, "Finance Date") == 0){
            verifyElement.sendKeys(periodOfFiance_Txt,"Finance Date",period);
        }
    }

    public void enterFinanceDate(String date){
        if (verifyElement.verifyBrowserElementValue(periodOfFiance_Txt, "Finance Period") == 0){
            verifyElement.sendKeys(periodOfFiance_Txt,"Finance Period",date);
        }
    }

    public void clickFinaced(){
        if (verifyElement.verifyBrowserElementValue(isFianced_Btn, "Is Financed") == 0){
            verifyElement.clickElement(isFianced_Btn,"Is Financed");
        }
    }



//Insured Value

    public void enterTrailerSum(String amount){
        if (verifyElement.verifyBrowserElementValue(trailerSumInsured_Txt, "Trailer Sum") == 0){
            verifyElement.sendKeys(trailerSumInsured_Txt,"Trailer Sum",amount);
        }
    }


    //claims

    public void enterTrailerClaim012Months(String number){
        if (verifyElement.verifyBrowserElementValue(trailerClaim012_Txt, "Trailer Claim 0-12") == 0){
            verifyElement.sendKeys(trailerClaim012_Txt,"Trailer Claim 0-12",number);
        }
    }

    public void enterTrailerClaim1324Months(String number){
        if (verifyElement.verifyBrowserElementValue(trailerlaim1324_Txt, "Trailer Claim 13-24") == 0){
            verifyElement.sendKeys(trailerlaim1324_Txt,"Trailer Claim 13-24",number);
        }
    }

    public void enterTrailerClaim2536Months(String Number){
        if (verifyElement.verifyBrowserElementValue(trailerClaim2536_Txt, "Caravan Claim 25-36") == 0){
            verifyElement.sendKeys(trailerClaim2536_Txt,"Trailer Claim 25-36",Number);
        }
    }

    //Extensions

    public void clickTrailerExtension(){
        if (verifyElement.verifyBrowserElementValue(trailerextension_Btn, "Extension for Trailer") == 0){
            verifyElement.clickElement(trailerextension_Btn,"Extension for Trailer");
        }
    }

    public void enterTrailerExtensionSum(String amount){
        if (verifyElement.verifyBrowserElementValue(TrailerextensionSum_Txt, "Extension for sum") == 0){
            verifyElement.sendKeys(TrailerextensionSum_Txt,"Extension for sum",amount);
        }
    }

    //cover options

    public void clickVehicleLiabilityDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfVehicleliability_DD, "Vehicle Liability") == 0){
            verifyElement.clickElement(typeOfVehicleliability_DD,"Vehicle Liability");
        }
    }

    public void clickTypeOfCoverDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfCover_DD, "Type of cover option") == 0){
            verifyElement.clickElement(typeOfCover_DD,"Type of cover option");
        }
    }

    public void clickClassOfUseDropDown(){
        if (verifyElement.verifyBrowserElementValue(classOfUse_DD, "Type of class of use") == 0){
            verifyElement.clickElement(classOfUse_DD,"Type of class of use");
        }
    }
}
