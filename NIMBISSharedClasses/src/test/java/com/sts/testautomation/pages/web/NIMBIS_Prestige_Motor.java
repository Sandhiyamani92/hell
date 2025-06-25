package com.sts.testautomation.pages.web;
import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sts.testautomation.utilities.ElementFunctionality;

public class NIMBIS_Prestige_Motor {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Motor(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    // RISK DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VehicleType_Input']")
    private WebElement vehicleType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Vin']")
    private WebElement vinNumber_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_EngineNumber']")
    private WebElement engineNumber_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_RegistrationNumber']")
    private WebElement registrationNumber_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_AfterMarketModifications']")
    private WebElement performanceEnhancingModifications ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7283_Input']")
    private WebElement vehicleColour_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10596_Input']")
    private WebElement vehicleCode_DD ;



    // SECURITY

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10585_Input']")
    private WebElement firstTrackingDeviceRequired_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10587_Input']")
    private WebElement firstTrackingDeviceType_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10586']")
    private WebElement secondTrackingDeviceRequired ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10588_Input']")
    private WebElement secondTrackingDeviceType_DD ;

    // OVERNIGHT PARKING

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11109_Input']")
    private WebElement overnightParking_DD ;

    // COVER DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_basisofsettlement_Input']")
    private WebElement basisOfSettlement_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_CoverType_Input']")
    private WebElement coverType_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11105']")
    private WebElement classOfUse_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_IsSupported']")
    private WebElement supportedBusiness ;


    // EXCESS OPTIONS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7272_Input']")
    private WebElement basicExcess_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VoluntaryExcess']")
    private WebElement additionalExcess ;


    // DISCLOSURES

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10594']")
    private WebElement   driverConvictionsInTheLast5Years ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10581']")
    private WebElement previousUninterruptedVehicleInsurance_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10595']")
    private WebElement regularDriverRetired ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10895']")
    private WebElement registeredOwner_Txt ;


    // DRIVER

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7275_Input']")
    private WebElement allowedDrivers_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7280']")
    private WebElement advancedDriver ;


    // CLAIMS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10589']")
    private WebElement numberOfClaimsLast12month_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10590']")
    private WebElement numberOfClaimsLast24month_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10591']")
    private WebElement numberOfClaimsLast36month_Txt ;

    //FINANCE

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_chkIsFinanced']")
    private WebElement isFinanced ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10589']")
    private WebElement financeHouse_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_lstFinanceHouse_Input']")
    private WebElement financeDate_Txt  ;


    // LICENSE INFORMATION

    @FindBy(xpath = "(//tr[@class='rgRow']//button)[3]")
    private WebElement editDriver_Btn ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_btnSave']")
    private WebElement driverSave_Btn ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbLicenseCode_Input']")
    private WebElement licenseCode_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_dtLicenseDate_dateInput']")
    private WebElement licenseDate ;


    // SPECIFIED ACCESSORIES

    @FindBy(xpath = "//tr[@class='rgCommandRow']//a")
    private WebElement addSpecifiedAccessories ;

    @FindBy(xpath = "(//tr[@class='rgEditRow']//td//div[@class='RadComboBox RadComboBox_Default']//input)[1]")
    private WebElement specifiedAccessoriesName ;

    @FindBy(xpath = "(//tr[@class='rgEditRow']//td//div[@class='RadInput RadInput_Default']//input)[1]")
    private WebElement specifiedAccessoriesValue ;

    @FindBy(xpath = "//tr[@class='rgEditRow']//input[@title='Insert']")
    private WebElement saveSpecifiedAccessories ;


    // EXTENSIONS

    @FindBy(xpath = "//button[@id='chkExtension3205']")
    private WebElement creditShortfallExtended ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3205']")
    private WebElement creditShortfallExtendedSumInsured ;

    @FindBy(xpath = "//button[@id='chkExtension3206']")
    private WebElement reductionInValue ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3206']")
    private WebElement reductionInValueSumInsured ;

    @FindBy(xpath = "//button[@id='chkExtension3207']")
    private WebElement offRoadDriving ;

    @FindBy(xpath = "//button[@id='chkExtension3211']")
    private WebElement tyreCover ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3211']")
    private WebElement tyreCoverSumInsured ;


    // CAR HIRE

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_AddOnControl838_chkSelectedNonStandard_7310']")
    private WebElement carHire ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_AddOnControl838_NonStandard_10583_Input']")
    private WebElement carHireOption_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_AddOnControl838_NonStandard_10584_Input']")
    private WebElement carHireDays_DD ;


    //NAVIGATION

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_btnMMCode']")
    private WebElement change_Btn ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucVehicleLookup_txtSearch']")
    private WebElement vehicleSearch_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VehicleSumInsured']")
    private WebElement vehicleValue_Txt ;

    @FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucVehicleLookup_btnSearch']")
    private WebElement searchBtn ;

    @FindBy(xpath = "//tr[@id='ctl00_ContentPlaceHolder1_ucVehicleLookup_grdSearchVehicle_ctl00__0']")
    private WebElement vehicleResult1 ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_ucVehicleLookup_lstYOM']")
    private WebElement carMenufactureYear ;

    @FindBy(xpath = "//li//span[text()='Select']")
    private WebElement selectBtn ;



    //  COVER DETAILS METHODS



    public void enterVINNumber(String number){
        if (verifyElement.verifyBrowserElementValue(vinNumber_Txt, "VIN Number") == 0){
            verifyElement.sendKeys(vinNumber_Txt,"VIN Number",number);
        }
    }
    public void clickVehicleTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleType_DD, "Vehicle Type") == 0){
            verifyElement.clickElement(vehicleType_DD,"Vehicle Type");
        }
    }
    public void enterRegistrationNumber(String number){
        if (verifyElement.verifyBrowserElementValue(registrationNumber_Txt, "Registration Number") == 0){
            verifyElement.sendKeys(registrationNumber_Txt,"Registration Number",number);
        }
    }
    public void enterEngineNumber(String number){
        if (verifyElement.verifyBrowserElementValue(engineNumber_Txt, "Engine Number") == 0){
            verifyElement.sendKeys(engineNumber_Txt,"Engine Number",number);
        }
    }
    public void clickPerformanceEnhancingModifications(){
        if (verifyElement.verifyBrowserElementValue(performanceEnhancingModifications, "Performance enhancing modifications") == 0){
            verifyElement.clickElement(performanceEnhancingModifications,"Performance enhancing modifications");
        }
    }
    public void clickVehicleColourDropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleColour_DD, "Vehicle Colour") == 0){
            verifyElement.clickElement(vehicleColour_DD,"Vehicle Colour");
        }
    }
    public void clickVehicleCodeDropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleCode_DD, "Vehicle Code") == 0){
            verifyElement.clickElement(vehicleCode_DD,"Vehicle Code");
        }
    }

    // SECURITY DETAILS METHODS

    public void clickFirstTrackingDeviceRequiredDDropDown(){
        if (verifyElement.verifyBrowserElementValue(firstTrackingDeviceRequired_DD, "First tracking device required") == 0){
            verifyElement.clickElement(firstTrackingDeviceRequired_DD,"First tracking device required");
        }
    }
    public void clickFirstTrackingDeviceTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(firstTrackingDeviceType_DD, "First tracking device type") == 0){
            verifyElement.clickElement(firstTrackingDeviceType_DD,"First tracking device type");
        }
    }
    public void clickSecondTrackingDeviceRequired(){
        if (verifyElement.verifyBrowserElementValue(secondTrackingDeviceRequired, "Second Tracking Device required") == 0){
            verifyElement.clickElement(secondTrackingDeviceRequired,"Second Tracking Device required");
        }
    }
    public void clickSecondTrackingDeviceTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(secondTrackingDeviceType_DD, "Second tracking device type") == 0){
            verifyElement.clickElement(secondTrackingDeviceType_DD,"Second tracking device type");
        }
    }

    // OVERNIGHT PARKING METHODS

    public void clickOvernightParkingDropDown(){
        if (verifyElement.verifyBrowserElementValue(overnightParking_DD, "Overnight Parking") == 0){
            verifyElement.clickElement(overnightParking_DD,"Overnight Parking");
        }
    }

    // COVER DETAILS METHODS

    public void clickBasisOfSettlementDropDown(){
        if (verifyElement.verifyBrowserElementValue(basisOfSettlement_DD, "Basis Of Settlement") == 0){
            verifyElement.clickElement(basisOfSettlement_DD,"Basis Of Settlement");
        }
    }
    public void clickCoverTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(coverType_DD, "Cover Type") == 0){
            verifyElement.clickElement(coverType_DD,"Cover Type");
        }
    }
    public void clickClassOfUseDropDown(){
        if (verifyElement.verifyBrowserElementValue(classOfUse_DD, "Class Of Use") == 0){
            verifyElement.clickElement(classOfUse_DD,"Class Of Use");
        }
    }
    public void clickSupportedBusiness(){
        if (verifyElement.verifyBrowserElementValue(supportedBusiness, "Supported Business") == 0){
            verifyElement.clickElement(supportedBusiness,"Supported Business");
        }
    }

    // EXCESS OPTIONS METHODS

    public void clickBasicExcessDropDown(){
        if (verifyElement.verifyBrowserElementValue(basicExcess_DD, "Basic Excess") == 0){
            verifyElement.clickElement(basicExcess_DD,"Basic Excess");
        }
    }
    public void enterAdditionalExcess(String number){
        if (verifyElement.verifyBrowserElementValue(additionalExcess, "Additional Excess") == 0){
            verifyElement.sendKeys(additionalExcess,"Additional Excess",number);
        }
    }

    // DISCLOSURES METHODS

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
    public void clickRegularDriverRetired(){
        if (verifyElement.verifyBrowserElementValue(regularDriverRetired, "Regular Driver Retired") == 0){
            verifyElement.clickElement(regularDriverRetired,"Regular Driver Retired");
        }
    }
    public void enterRegisteredOwner(String number){
        if (verifyElement.verifyBrowserElementValue(registeredOwner_Txt, "Registered Owner") == 0){
            verifyElement.sendKeys(registeredOwner_Txt,"Registered Owner",number);
        }
    }

    // DRIVER METHODS

    public void clickAllowedDriversDropDown(){
        if (verifyElement.verifyBrowserElementValue(allowedDrivers_DD, "Allowed Drivers") == 0){
            verifyElement.clickElement(allowedDrivers_DD,"Allowed Drivers");
        }
    }
    public void clickAdvancedDriver(){
        if (verifyElement.verifyBrowserElementValue(advancedDriver, "Advanced Driver") == 0){
            verifyElement.clickElement(advancedDriver,"Advanced Driver");
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

    //FINANCE METHODS

    public void clickIsFinanced(){
        if (verifyElement.verifyBrowserElementValue(isFinanced, "Is Financed") == 0){
            verifyElement.clickElement(isFinanced,"Is Financed");
        }
    }
    public void enterFinanceHouse(String number){
        if (verifyElement.verifyBrowserElementValue(financeHouse_Txt, "Finance House") == 0){
            verifyElement.sendKeys(financeHouse_Txt,"Finance House",number);
        }
    }
    public void enterFinanceDate(String number){
        if (verifyElement.verifyBrowserElementValue(financeDate_Txt, "Finance Date") == 0){
            verifyElement.sendKeys(financeDate_Txt,"Finance Date",number);
        }
    }

    // LICENSE INFORMATION METHODS

    public void clickLicenseCodeDropDown(){
        if (verifyElement.verifyBrowserElementValue(licenseCode_DD, "License Code") == 0){
            verifyElement.clickElement(licenseCode_DD,"License Code");
        }
    }
    public void enterLicenseDate(String number){
        if (verifyElement.verifyBrowserElementValue(licenseDate, "License Date") == 0){
            verifyElement.sendKeys(licenseDate,"License Date",number);
        }
    }
    public void clickEditDriver_Btn(){
        if (verifyElement.verifyBrowserElementValue(editDriver_Btn, "editDriver_Btn") == 0){
            verifyElement.clickElement(editDriver_Btn,"editDriver_Btn");
        }
    }
    public void clickDriverSave_Btn(){
        if (verifyElement.verifyBrowserElementValue(driverSave_Btn, "driverSave_Btn") == 0){
            verifyElement.clickElement(driverSave_Btn,"driverSave_Btn");
        }
    }

    //  SPECIFIED ACCESSORIES METHODS

    public void clickAddSpecifiedAccessories(){
        if (verifyElement.verifyBrowserElementValue(addSpecifiedAccessories, "addSpecifiedAccessories") == 0){
            verifyElement.clickElement(addSpecifiedAccessories,"addSpecifiedAccessories");
        }
    }
    public void clickSpecifiedAccessoriesName(){
        if (verifyElement.verifyBrowserElementValue(specifiedAccessoriesName, "Specified Accessories Name") == 0){
            verifyElement.clickElement(specifiedAccessoriesName,"Specified Accessories Name");
        }
    }
    public void enterSpecifiedAccessoriesValue(String number){
        if (verifyElement.verifyBrowserElementValue(specifiedAccessoriesValue, "Specified Accessories Value") == 0){
          //  verifyElement.sendKeysWithClear(specifiedAccessoriesValue,"Specified Accessories Value",number);
            verifyElement.sendKeys(specifiedAccessoriesValue,"Specified Accessories Value",number);
        }
    }
    public void clickSaveSpecifiedAccessories(){
        if (verifyElement.verifyBrowserElementValue(saveSpecifiedAccessories, "saveSpecifiedAccessories") == 0){
            verifyElement.clickElement(saveSpecifiedAccessories,"saveSpecifiedAccessories");
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
    public void clickReductionInValue(){
        if (verifyElement.verifyBrowserElementValue(reductionInValue, "Reduction In Value") == 0){
            verifyElement.clickElement(reductionInValue,"Reduction In Value");
        }
    }
    public void enterReductionInValueSumInsured(String number){
        if (verifyElement.verifyBrowserElementValue(reductionInValueSumInsured, "Reduction In Value Sum Insured") == 0){
            verifyElement.sendKeys(reductionInValueSumInsured,"Reduction In Value Sum Insured",number);
        }
    }
    public void clickOffRoadDriving(){
        if (verifyElement.verifyBrowserElementValue(offRoadDriving, "Off Road Driving") == 0){
            verifyElement.clickElement(offRoadDriving,"Off Road Driving");
        }
    }
    public void clickTyreCover(){
        if (verifyElement.verifyBrowserElementValue(tyreCover, "Tyre Cover") == 0){
            verifyElement.clickElement(tyreCover,"Tyre Cover");
        }
    }
    public void enterTyreCoverSumInsured(String number){
        if (verifyElement.verifyBrowserElementValue(tyreCoverSumInsured, "Tyre Cover Sum Insured") == 0){
            verifyElement.sendKeys(tyreCoverSumInsured,"Tyre Cover Sum Insured",number);
        }
    }

    // CAR HIRE METHODS

    public void clickCarHire(){
        if (verifyElement.verifyBrowserElementValue(carHire, "Car Hire") == 0){
            verifyElement.clickElement(carHire,"Car Hire");
        }
    }
    public void clickCarHireOptionDropDown(){
        if (verifyElement.verifyBrowserElementValue(carHireOption_DD, "Car Hire Option") == 0){
            verifyElement.clickElement(carHireOption_DD,"Car Hire Option");
        }
    }
    public void clickCarHireDaysDropDown(){
        if (verifyElement.verifyBrowserElementValue(carHireDays_DD, "Car Hire Days") == 0){
            verifyElement.clickElement(carHireDays_DD,"Car Hire Days");
        }
    }

    public void clickChangeBtn(){
        if (verifyElement.verifyBrowserElementValue(change_Btn, "Change Btn") == 0){
            verifyElement.clickElement(change_Btn,"Change Btn");
        }
    }
    public void enterVehicleSearch(String number){
        if (verifyElement.verifyBrowserElementValue(vehicleSearch_Txt, "Vehicle Search") == 0){
            verifyElement.sendKeys(vehicleSearch_Txt,"Vehicle Search",number);
        }
    }
    public void clickVehicleResult1(){
        if (verifyElement.verifyBrowserElementValue(vehicleResult1, "VehicleResult1") == 0){
            verifyElement.clickElement(vehicleResult1,"VehicleResult1");
        }
    }
    public void clickSearchBtn(){
        if (verifyElement.verifyBrowserElementValue(searchBtn, "Search Btn") == 0){
            verifyElement.clickElement(searchBtn,"Search Btn");
        }
    }
    public void enterVehicleValue(String number){
        if (verifyElement.verifyBrowserElementValue(vehicleValue_Txt, "vehicle Value") == 0){
            verifyElement.sendKeys(vehicleValue_Txt,"vehicle Value",number);
        }
    }
    public void clickCarMenufactureYear(){
        if (verifyElement.verifyBrowserElementValue(carMenufactureYear, "CarMenufactureYear") == 0){
            verifyElement.clickElement(carMenufactureYear,"CarMenufactureYear");
        }
    }
    public void clickSelectBtn(){
        if (verifyElement.verifyBrowserElementValue(selectBtn, "selectBtn") == 0){
            verifyElement.clickElement(selectBtn,"selectBtn");
        }
    }


}
