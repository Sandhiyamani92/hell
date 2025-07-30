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

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Model']")
    private WebElement model_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Model']")
    private WebElement registerationnum_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Year']")
    private WebElement year_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Make']")
    private WebElement make_Txt;

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

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_IsSupported']")
    private WebElement  supported_btn ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11121']")
    private WebElement  restrictedDriver_DD ;

    //add driver
    @FindBy(xpath = "//span[@title='Add Driver']")
    private WebElement  addDriver_btn ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_lastname']")
    private WebElement  policyholdername_txt ;

    //choose person

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbExistingClients']")
    private WebElement  chooseDriver_DD ;

    //policyholder respresentive
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_NonStandard_50']")
    private WebElement passportNum_Txt;

    //client details
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

    //license details

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbLicenseCode']")
    private WebElement driverLicenseCode_DD;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_dtLicenseDate_dateInput']")
    private WebElement driverLicenseDate_Txt;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_cmbRelationshipType']")
    private WebElement driverRelationship_DD;


    //methods

    //details

    public void clickDrivingConvictions(){
        if (verifyElement.verifyBrowserElementValue(regularDriverLast5Year, "Driving convictions in last 5 year") == 0){
            verifyElement.clickElement(regularDriverLast5Year,"Driving convictions in last 5 year");
        }
    }

    //insured value
    public void  entervintageSumInsured( String amount) {
        if (verifyElement.verifyBrowserElementValue(sumInsured_Txt, "vintage sum insured") == 0) {
            verifyElement.sendKeys(sumInsured_Txt,"vintage sum insured",amount);
        }
    }
    //vehicle
    public void clickPerformanceModification(){
        if (verifyElement.verifyBrowserElementValue(performanceEnhancingModification, "Performance enhancing modifications") == 0){
            verifyElement.clickElement(performanceEnhancingModification,"Performance enhancing modifications");
        }
    }

    public void  enterModel( String amount) {
        if (verifyElement.verifyBrowserElementValue(model_Txt, "Model") == 0) {
            verifyElement.sendKeys(model_Txt,"Model",amount);
        }
    }

    public void  entervin( String amount) {
        if (verifyElement.verifyBrowserElementValue(vin_Txt, "VIN") == 0) {
            verifyElement.sendKeys(vin_Txt,"VIN",amount);
        }
    }

    public void  enterRegisterationNum( String amount) {
        if (verifyElement.verifyBrowserElementValue(registerationnum_Txt, "registeration num") == 0) {
            verifyElement.sendKeys(registerationnum_Txt,"registeration num",amount);
        }
    }

    public void  enterMake( String amount) {
        if (verifyElement.verifyBrowserElementValue(make_Txt, "Make") == 0) {
            verifyElement.sendKeys(make_Txt,"Make",amount);
        }
    }

    public void  enterYear( String amount) {
        if (verifyElement.verifyBrowserElementValue(year_Txt, "Year") == 0) {
            verifyElement.sendKeys(year_Txt,"Year",amount);
        }
    }

    public void  enterengineNum( String amount) {
        if (verifyElement.verifyBrowserElementValue(engineNumber_Txt, "Engine num") == 0) {
            verifyElement.sendKeys(engineNumber_Txt,"Engine num",amount);
        }
    }

    public void clickVehicle_Code_DD(){
        if (verifyElement.verifyBrowserElementValue(vehicleCode_DD, "Vehicle code") == 0){
            verifyElement.clickElement(vehicleCode_DD,"Vehicle code");
        }
    }
    //claims

    public void  enterClaims12( String amount) {
        if (verifyElement.verifyBrowserElementValue(vintageClaim012_Txt, "Claims_12") == 0) {
            verifyElement.sendKeys(vintageClaim012_Txt,"Claims_12",amount);
        }
    }

    public void  enterClaims13_24( String amount) {
        if (verifyElement.verifyBrowserElementValue(vintageClaim012_24_Txt, "Claims13_24") == 0) {
            verifyElement.sendKeys(vintageClaim012_24_Txt,"Claims13_24",amount);
        }
    }

    public void  enterClaims25_36( String amount) {
        if (verifyElement.verifyBrowserElementValue(vintageClaim025_36_Txt, "Claims25_36") == 0) {
            verifyElement.sendKeys(vintageClaim025_36_Txt,"Claims25_36",amount);
        }
    }
    //driver
    public void  enterLicense_date( String amount) {
        if (verifyElement.verifyBrowserElementValue(licenceDate_Txt, "License date") == 0) {
            verifyElement.sendKeys(licenceDate_Txt,"License date",amount);
        }
    }

    public void clickAllowed_driver_DD(){
        if (verifyElement.verifyBrowserElementValue(allowedDriver_DD, "Allowed driver") == 0){
            verifyElement.clickElement(allowedDriver_DD,"Allowed driver");
        }
    }
    //situation
    public void clickParking_Overnight_DD(){
        if (verifyElement.verifyBrowserElementValue(parkingOvernight_DD, "Parking Overnight") == 0){
            verifyElement.clickElement(parkingOvernight_DD,"Parking Overnight");
        }
    }
    //cover options

    public void clickBasis_of_settlement_DD(){
        if (verifyElement.verifyBrowserElementValue(basisOfSettlement_DD, "Basis of settlement") == 0){
            verifyElement.clickElement(basisOfSettlement_DD,"Basis of settlement");
        }
    }

    public void clickClass_Of_uset_DD(){
        if (verifyElement.verifyBrowserElementValue(classOfUse_DD, "Class of use") == 0){
            verifyElement.clickElement(classOfUse_DD,"Class of use");
        }
    }

    public void clickVehicle_liability_DD(){
        if (verifyElement.verifyBrowserElementValue(vehicleliability_DD, "Vehicle liability") == 0){
            verifyElement.clickElement(vehicleliability_DD,"PVehicle liability");
        }
    }

    public void clickCoverType_DD(){
        if (verifyElement.verifyBrowserElementValue(coverType_DD, "Cover Type") == 0){
            verifyElement.clickElement(coverType_DD,"Cover Type");
        }
    }

    public void clickRestricted_Driver_DD(){
        if (verifyElement.verifyBrowserElementValue(restrictedDriver_DD, "Restricted Driver") == 0){
            verifyElement.clickElement(restrictedDriver_DD,"Restricted Drive");
        }
    }

    public void clickSupportedBusiness(){
        if (verifyElement.verifyBrowserElementValue(supported_btn, "Supported business") == 0){
            verifyElement.clickElement(supported_btn,"Supported business");
        }
    }

    //client name
    public void enterPolicyHolderName(String name){
        if (verifyElement.verifyBrowserElementValue(policyholdername_txt, "Policyholder name") == 0){
            verifyElement.sendKeys(policyholdername_txt,"Policyholder name",name);
        }
    }

//policyholder rep
    public void enterPolicyHolderPassportNum(String Num){
        if (verifyElement.verifyBrowserElementValue(passportNum_Txt, "Policyholder PassportNum") == 0){
            verifyElement.sendKeys(passportNum_Txt,"Policyholder PassportNum",Num);
        }
    }

    //client details
    public void clickTypeOfPolicyHolderTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverType_DD, "PolicyHolderType") == 0){
            verifyElement.clickElement(driverType_DD,"PolicyHolderType");
        }
    }

    public void clickPolicyholderRetired(){
        if (verifyElement.verifyBrowserElementValue(driverRetired_Btn, "Policy holder retired") == 0){
            verifyElement.clickElement(driverRetired_Btn,"Policy holder retired");
        }
    }

    public void enterPolicyHolderDateofbith(String DOB){
        if (verifyElement.verifyBrowserElementValue(driverDateofbirth_Txt, "Policyholder DOB") == 0){
            verifyElement.sendKeys(driverDateofbirth_Txt,"Policyholder DOB",DOB);
        }
    }

    public void enterPolicyHolderIdentification(String Identification){
        if (verifyElement.verifyBrowserElementValue(driverIdentification_Txt, "Policyholder identification") == 0){
            verifyElement.sendKeys(driverIdentification_Txt,"Policyholder identification",Identification);
        }
    }

    public void clickTypeOfPolicyHolderGenderDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverGender_DD, "PolicyHolderGender") == 0){
            verifyElement.clickElement(driverGender_DD,"PolicyHolderGender");
        }
    }

    public void clickMaritialstatusDropDown(){
        if (verifyElement.verifyBrowserElementValue(driverMaritalstatus_DD, "Maritial status") == 0){
            verifyElement.clickElement(driverMaritalstatus_DD,"Maritial status");
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


    //license info
    public void enterPolicyHolderLicenceDate(String Date){
        if (verifyElement.verifyBrowserElementValue(driverLicenseDate_Txt, "Policyholder LicenceDate") == 0){
            verifyElement.sendKeys(driverLicenseDate_Txt,"Policyholder LicenceDate",Date);
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




