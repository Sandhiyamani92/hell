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

    @FindBy(xpath = "//span[@title='Add Driver']")
    private WebElement  addDriver_btn ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_lastname']")
    private WebElement  policyholdername_txt ;

    //client details

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbExistingClients']")
    private WebElement  chooseDriver_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_NonStandard_50']")
    private WebElement passportNum_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_identification']")
    private WebElement driverIdentification_Txt;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_NonStandard_42']")
    private WebElement driverType_DD;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_gender']")
    private WebElement driverGender_DD;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_maritalstatus']")
    private WebElement driverMaritalstatus_DD;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_dateofbirth_dateInput']")
    private WebElement driverDateofbirth_Txt;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_NonStandard_34']")
    private WebElement driverRetired_Btn;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbLicenseCode']")
    private WebElement driverLicenseCode_DD;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_dtLicenseDate_dateInput']")
    private WebElement driverLicenseDate_Txt;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbRelationshipType']")
    private WebElement driverRelationship_DD;


    //methods

    public void enterPolicyHolderName(String name){
        if (verifyElement.verifyBrowserElementValue(policyholdername_txt, "Policyholder name") == 0){
            verifyElement.sendKeys(policyholdername_txt,"Policyholder name",name);
        }
    }

    public void enterPolicyHolderIdentification(String Identification){
        if (verifyElement.verifyBrowserElementValue(driverIdentification_Txt, "Policyholder identification") == 0){
            verifyElement.sendKeys(driverIdentification_Txt,"Policyholder identification",Identification);
        }
    }

    public void enterPolicyHolderDateofbith(String DOB){
        if (verifyElement.verifyBrowserElementValue(driverDateofbirth_Txt, "Policyholder DOB") == 0){
            verifyElement.sendKeys(driverDateofbirth_Txt,"Policyholder DOB",DOB);
        }
    }

    public void enterPolicyHolderPassportNum(String Num){
        if (verifyElement.verifyBrowserElementValue(passportNum_Txt, "Policyholder PassportNum") == 0){
            verifyElement.sendKeys(passportNum_Txt,"Policyholder PassportNum",Num);
        }
    }

    public void enterPolicyHolderLicenceDate(String Date){
        if (verifyElement.verifyBrowserElementValue(driverLicenseDate_Txt, "Policyholder LicenceDate") == 0){
            verifyElement.sendKeys(driverLicenseDate_Txt,"Policyholder LicenceDate",Date);
        }
    }

    public void clickTypeOfPolicyHolderTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverType_DD, "PolicyHolderType") == 0){
            verifyElement.clickElement(driverType_DD,"PolicyHolderType");
        }
    }

    public void clickTypeOfPolicyHolderchooseDriverTDropDown(){
        if (verifyElement.verifyBrowserElementValue(chooseDriver_DD, "PolicyHolderType") == 0){
            verifyElement.clickElement(chooseDriver_DD,"PolicyHolderType");
        }
    }

    public void clickTypeOfPolicyHolderPersonDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverType_DD, "PolicyHolderPerson") == 0){
            verifyElement.clickElement(driverType_DD,"PolicyHolderPerson");
        }
    }

    public void clickTypeOfPolicyHolderGenderDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverGender_DD, "PolicyHolderGender") == 0){
            verifyElement.clickElement(driverGender_DD,"PolicyHolderGender");
        }
    }

    public void clickTypeOfPolicyHolderLicenceCodeDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverLicenseCode_DD, "PolicyHolderLicenceCode") == 0){
            verifyElement.clickElement(driverLicenseCode_DD,"PolicyHolderLicenceCode");
        }
    }

    public void clickTypeOfPolicyHolderRelationshipDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverRelationship_DD, "PolicyHolderRelationship") == 0){
            verifyElement.clickElement(driverRelationship_DD,"PolicyHolderRelationship");
        }
    }










}




