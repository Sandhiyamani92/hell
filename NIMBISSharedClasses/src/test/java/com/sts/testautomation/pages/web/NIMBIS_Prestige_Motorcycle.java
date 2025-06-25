package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Prestige_Motorcycle {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Motorcycle(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11056_Input']")
    private WebElement vehicleCode_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VIN']")
    private WebElement vinNumber_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11058']")
    private WebElement previousUninterruptedVehicleInsurance_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11061']")
    private WebElement   driverConvictionsInTheLast5Years ;

    // CLAIMS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11053']")
    private WebElement numberOfClaimsLast12month_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11054']")
    private WebElement numberOfClaimsLast24month_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11055']")
    private WebElement numberOfClaimsLast36month_Txt ;

    // COVER DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7293_Input']")
    private WebElement basisOfSettlement_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11106_Input']")
    private WebElement classOfUse_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11052_Input']")
    private WebElement basicExcess_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7290_Input']")
    private WebElement ncb_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NCB_Input']")
    private WebElement claimFreeGroup_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7289_Input']")
    private WebElement vehicleLiability_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11085']")
    private WebElement retailValuePercentage_Txt ;

    ////
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7288_Input']")
    private WebElement allowedRiders_DD ;

    // EXTENSIONS

    @FindBy(xpath = "//button[@id='chkExtension3213']")
    private WebElement creditShortfallExtended ;
    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3213']")
    private WebElement creditShortfallExtendedSumInsured ;



    public void enterVINNumber(String number){
        if (verifyElement.verifyBrowserElementValue(vinNumber_Txt, "VIN Number") == 0){
            verifyElement.sendKeys(vinNumber_Txt,"VIN Number",number);
        }
    }
    public void clickVehicleCodeDropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleCode_DD, "Vehicle Code") == 0){
            verifyElement.clickElement(vehicleCode_DD,"Vehicle Code");
        }
    }

    public void clickDriverConvictionsInTheLast5Years(){
        if (verifyElement.verifyBrowserElementValue(driverConvictionsInTheLast5Years, "TDriver Convictions In The Last 5 Years") == 0){
            verifyElement.clickElement(driverConvictionsInTheLast5Years,"Driver Convictions In The Last 5 Years");
        }
    }
    public void enterPreviousUninterruptedVehicleInsurance(String number){
        if (verifyElement.verifyBrowserElementValue(previousUninterruptedVehicleInsurance_Txt, "Previous Uninterrupted Vehicle Insurance") == 0){
            verifyElement.sendKeys(previousUninterruptedVehicleInsurance_Txt,"Previous Uninterrupted Vehicle Insurance",number);
        }
    }

    // CLAIMS METHODS

    public void enterNumberOfClaimsLast12month(String number){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast12month_Txt, "Number Of Claims Last 12 Month") == 0){
            verifyElement.sendKeys(numberOfClaimsLast12month_Txt,"Number Of Claims Last 12 Month",number);
        }
    }
    public void enterNumberOfClaimsLast24month(String number){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast24month_Txt, "Number Of Claims Last 24 Month") == 0){
            verifyElement.sendKeys(numberOfClaimsLast24month_Txt,"Number Of Claims Last 24 Month",number);
        }
    }
    public void enterNumberOfClaimsLast36month(String number){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast36month_Txt, "Number Of Claims Last 12 Month") == 0){
            verifyElement.sendKeys(numberOfClaimsLast36month_Txt,"Number Of Claims Last 12 Month",number);
        }
    }

    // COVER DETAILS METHODS

    public void clickBasisOfSettlementDropDown(){
        if (verifyElement.verifyBrowserElementValue(basisOfSettlement_DD, "Basis Of Settlement") == 0){
            verifyElement.clickElement(basisOfSettlement_DD,"Basis Of Settlement");
        }
    }

    public void clickClassOfUseDropDown(){
        if (verifyElement.verifyBrowserElementValue(classOfUse_DD, "Class Of Use") == 0){
            verifyElement.clickElement(classOfUse_DD,"Class Of Use");
        }
    }

    public void clickBasicExcessDropDown(){
        if (verifyElement.verifyBrowserElementValue(basicExcess_DD, "Basic Excess") == 0){
            verifyElement.clickElement(basicExcess_DD,"Basic Excess");
        }
    }
    public void clickNCB_DropDown(){
        if (verifyElement.verifyBrowserElementValue(ncb_DD, "NCB") == 0){
            verifyElement.clickElement(ncb_DD,"NCB");
        }
    }

    public void clickClaimFreeGroup_DropDown(){
        if (verifyElement.verifyBrowserElementValue(claimFreeGroup_DD, "Claim Free Group") == 0){
            verifyElement.clickElement(claimFreeGroup_DD,"Claim Free Group");
        }
    }

    public void clickVehicleLiability_DropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleLiability_DD, "Vehicle Liability") == 0){
            verifyElement.clickElement(vehicleLiability_DD,"Vehicle Liability");
        }
    }

    public void clickAllowedRiders_DropDown(){
        if (verifyElement.verifyBrowserElementValue(allowedRiders_DD, "Allowed Riders") == 0){
            verifyElement.clickElement(allowedRiders_DD,"Allowed Riders");
        }
    }

    public void enterRetailValuePercentage(String number){
        if (verifyElement.verifyBrowserElementValue(retailValuePercentage_Txt, "Retail Value Percentage") == 0){
            verifyElement.sendKeys(retailValuePercentage_Txt,"Retail Value Percentage",number);
        }
    }

    // EXTENSIONS METHODS

    public void clickCreditShortfallExtended(){
        if (verifyElement.verifyBrowserElementValue(creditShortfallExtended, "Credit Shortfall Extended") == 0){
            verifyElement.clickElement(creditShortfallExtended,"Credit Shortfall Extended");
        }
    }
    public void enterCreditShortfallExtendedSumInsured(String number){
        if (verifyElement.verifyBrowserElementValue(creditShortfallExtendedSumInsured, "Credit Shortfall Extended Sum Insured") == 0){
            verifyElement.sendKeys(creditShortfallExtendedSumInsured,"Credit Shortfall Extended Sum Insured",number);
        }
    }
}
