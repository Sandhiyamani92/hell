package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Vintage {
    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Vintage(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);

        PageFactory.initElements(BrowserDriver, this);
    }

    //Details
    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11112']")
    private WebElement regularDriverLast5Year ;

    //Insured value
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VehicleSumInsured']")
    private WebElement sumInsured_Txt;

    //Vehicle
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Vin']")
    private WebElement vin_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_EngineNumber']")
    private WebElement engineNumber_Txt;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_AfterMarketModifications']")
    private WebElement performanceEnhancingModification ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11111']")
    private WebElement  vehicleCode_DD ;

//claims
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11073']")
    private WebElement vintageClaim012_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11074']")
    private WebElement vintageClaim012_24_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11075']")
    private WebElement vintageClaim025_36_Txt;

    //Driver
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_LicenseDate']")
    private WebElement licenceDate_Txt;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7300']")
    private WebElement  allowedDriver_DD ;

    //situation
    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11110']")
    private WebElement  parkingOvernight_DD ;

    //cover options

    @FindBy(xpath = "//div[@id='cctl00_ContentPlaceHolder1_DynamicQuestions1_basisofsettlement']")
    private WebElement  basisOfSettlement_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7301']")
    private WebElement  vehicleliability_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11107']")
    private WebElement  classOfUse_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_CoverType']")
    private WebElement  coverType_DD ;


    //@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11073']")
   // private WebElement vintageClaim012_Txt;
}
