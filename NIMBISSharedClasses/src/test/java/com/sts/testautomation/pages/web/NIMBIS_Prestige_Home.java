package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sts.testautomation.utilities.ElementFunctionality;

public class NIMBIS_Prestige_Home {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Home(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }


    //COVER DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_PropertySumInsured']")
    private WebElement homeSumInsured_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7230_Input']")
    private WebElement  coverType_DD ;

    //RISK DETAILS
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_PropertyType_Input']")
    private WebElement  typeOfHome_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7228']")
    private WebElement daysUnoccupied90Days ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_WallType']")
    private WebElement  typeOfWallConstruction_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input']")
    private WebElement  typeOfRoofConstruction_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_HasLightningRod']")
    private WebElement lightningConductorSABS ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7231']")
    private WebElement fireRetardantSABS ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7237']")
    private WebElement surgeProtectionSANS ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10527_Input']")
    private WebElement residenceType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10551_Input']")
    private WebElement useOfPremises_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Description']")
    private WebElement description;


    //GEYSER DETAILS
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7221']")
    private WebElement noOfElectricGeyser_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10547']")
    private WebElement noOfGasGeysers_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10548']")
    private WebElement noOfHeatPumpGeysers_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10549']")
    private WebElement noOfSolarGeysers_Txt ;

    // DISCLOOSURES

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_chkIsFinanced']")
    private WebElement isFinanced ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7224']")
    private WebElement thatch15OfMainBuilding ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NCB_Input']")
    private WebElement ncb_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_DateofPurchase_dateInput']")
    private WebElement dateOfPurchase_Txt;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10528']")
    private WebElement renewableEnergyEquipment ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10530']")
    private WebElement previousUninterruptedBuildingsInsurance_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10550']")
    private WebElement plotSmallHoldingOrFarm ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10552_Input']")
    private WebElement increasedRiskBusinessType ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10553']")
    private WebElement commune ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10576']")
    private WebElement within100mOfaWaterBody ;

    //SECURITY

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7232']")
    private WebElement burglarBarsOpeningWindows ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7233']")
    private WebElement alarmLinkedToArmedResponse ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7238_Input']")
    private WebElement electricFence_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10540']")
    private WebElement twentyFourHourSecurityGuard ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10541']")
    private WebElement accessControlledArea ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10542']")
    private WebElement allDoorsProtectedBySecurityGates  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10543_Input']")
    private WebElement perimeterProtection_DD  ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10544']")
    private WebElement highSecurityEstateComplex ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10545']")
    private WebElement cctvCamera ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10546']")
    private WebElement laserBeamsInGarden ;

    //CLAIMS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10531']")
    private WebElement numberOfClaimsLast12month_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10534']")
    private WebElement numberOfClaimsLast24month_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10535']")
    private WebElement numberOfClaimsLast36month_Txt ;

    //EXCESS OPTIONS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_VoluntaryExcess']")
    private WebElement additionalExcess_Txt  ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7215_Input']")
    private WebElement basicExcess_DD ;

    //EXTENSIONS

    @FindBy(xpath = "//button[@id='chkExtension5661']")
    private WebElement powerSurge;

    @FindBy(xpath = "//button[@id='chkExtension5662']")
    private WebElement powerSurgeMainCoverSumInsured ;

    @FindBy(xpath = "//button[@id='chkExtension5663']")
    private WebElement gardenAndLandscapingExtendedCover ;

    @FindBy(xpath = "//button[@id='chkExtension5664']")
    private WebElement subsidenceLandslipOrGroundHeaveExtendedCover ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucSectionExtensions_rptExtensionGroup_ctl00_rptExtensionDetail_ctl00_ucDynamicQuestions_NonStandard_11046_Input']")
    private WebElement powerSurgeSumInsured_DD;

    @FindBy(xpath = "//input[@id='5663lstExtensionSumInsured5663_Input']")
    private WebElement gardenAndLandscapingSumInsured_DD;

    //COVER DETAILS METHODS

    public void  enterHomeSumInsured( String amount) {
        if (verifyElement.verifyBrowserElementValue(homeSumInsured_Txt, "Home Sum Insured") == 0) {
            verifyElement.sendKeys(homeSumInsured_Txt,"Home Sum Insured",amount);
        }
    }

    public void clickCoverTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(coverType_DD, "Cover Type") == 0){
            verifyElement.clickElement(coverType_DD,"Cover Type");
        }
    }

    //RISK DETAILS METHODS

    public void clickTypeOfHomeDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfHome_DD, "Type Of Home") == 0){
            verifyElement.clickElement(typeOfHome_DD,"Type Of Home");
        }
    }

    public void clickDaysUnoccupied90Days(){
        if (verifyElement.verifyBrowserElementValue(daysUnoccupied90Days, "Unoccupied for more than 90 days") == 0){
            verifyElement.clickElement(daysUnoccupied90Days,"Unoccupied for more than 90 days");
        }
    }

    public void clickTypeOfRoofConstructionDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfRoofConstruction_DD, "Type of roof construction") == 0){
            verifyElement.clickElement(typeOfRoofConstruction_DD,"Type of roof construction");
        }
    }

    public void clickTypeOfWallConstructionDropDown(){
        if (verifyElement.verifyBrowserElementValue(typeOfWallConstruction_DD, "Type of wall construction") == 0){
            verifyElement.clickElement(typeOfWallConstruction_DD,"Type of wall construction");
        }
    }

    public void clickLightningConductorSABS(){
        if (verifyElement.verifyBrowserElementValue(lightningConductorSABS, "Lightning Conductor SABS") == 0){
            verifyElement.clickElement(lightningConductorSABS,"Lightning Conductor SABS");
        }
    }

    public void clickFireRetardantSABS(){
        if (verifyElement.verifyBrowserElementValue(fireRetardantSABS, "Fire Retardant SABS") == 0){
            verifyElement.clickElement(fireRetardantSABS,"Fire Retardant SABS");
        }
    }

    public void clickSurgeProtectionSANS(){
        if (verifyElement.verifyBrowserElementValue(surgeProtectionSANS, "Surge Protection SANS") == 0){
            verifyElement.clickElement(surgeProtectionSANS,"Surge Protection SANS");
        }
    }

    public void clickResidenceTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(residenceType_DD, "Residence Type") == 0){
            verifyElement.clickElement(residenceType_DD,"Residence Type");
        }
    }

    public void clickUseOfPremisesDropDown(){
        if (verifyElement.verifyBrowserElementValue(useOfPremises_DD, "Use Of Premises") == 0){
            verifyElement.clickElement(useOfPremises_DD,"Use Of Premises");
        }
    }

    public void  enterDescription( String descrip) {
        if (verifyElement.verifyBrowserElementValue(description, "Description") == 0) {
            verifyElement.sendKeys(description,"Description",descrip);
        }
    }

    //GEYSER DETAILS METHODS

    public void  enterNoOfElectricGeyser( String amount) {
        if (verifyElement.verifyBrowserElementValue(noOfElectricGeyser_Txt, "No Of Electric Geysers") == 0) {
            verifyElement.sendKeys(noOfElectricGeyser_Txt,"No Of Electric Geysers",amount);
        }
    }

    public void  enterNoOfGasGeysers( String amount) {
        if (verifyElement.verifyBrowserElementValue(noOfGasGeysers_Txt, "No Of Gas Geysers") == 0) {
            verifyElement.sendKeys(noOfGasGeysers_Txt,"No Of Gas Geysers",amount);
        }
    }

    public void  enterNoOfHeatPumpGeysers( String amount) {
        if (verifyElement.verifyBrowserElementValue(noOfHeatPumpGeysers_Txt, "No Of Heat Pump Geysers") == 0) {
            verifyElement.sendKeys(noOfHeatPumpGeysers_Txt,"No Of Heat Pump Geysers",amount);
        }
    }

    public void  enterNoOfSolarGeysers( String amount) {
        if (verifyElement.verifyBrowserElementValue(noOfSolarGeysers_Txt, "No Of Solar Geysers") == 0) {
            verifyElement.sendKeys(noOfSolarGeysers_Txt,"No Of Solar Geysers",amount);
        }
    }

    //DISCLOOSURES METHODS

    public void clickIsFinanced(){
        if (verifyElement.verifyBrowserElementValue(isFinanced, "Is Financed") == 0){
            verifyElement.clickElement(isFinanced,"Is Financed");
        }
    }

    public void clickThatch15OfMainBuilding(){
        if (verifyElement.verifyBrowserElementValue(thatch15OfMainBuilding, "thatch15OfMainBuilding") == 0){
            verifyElement.clickElement(thatch15OfMainBuilding,"thatch15OfMainBuilding");
        }
    }

    public void clickNCB_DropDown(){
        if (verifyElement.verifyBrowserElementValue(ncb_DD, "NCB") == 0){
            verifyElement.clickElement(ncb_DD,"NCB");
        }
    }

    public void clickDateOfPurchase(String date){
        if (verifyElement.verifyBrowserElementValue(dateOfPurchase_Txt, "Date Of Purchase") == 0){
            verifyElement.sendKeys(dateOfPurchase_Txt,"Date Of Purchase",date);
        }
    }

    public void clickRenewableEnergyEquipment(){
        if (verifyElement.verifyBrowserElementValue(renewableEnergyEquipment, "Renewable Energy Equipment") == 0){
            verifyElement.clickElement(renewableEnergyEquipment,"Renewable Energy Equipment");
        }
    }

    public void clickPreviousUninterruptedBuildingsInsurance(String years){
        if (verifyElement.verifyBrowserElementValue(previousUninterruptedBuildingsInsurance_Txt, "Years of previous uninterrupted buildings insurance cover") == 0){
            verifyElement.sendKeys(previousUninterruptedBuildingsInsurance_Txt,"Years of previous uninterrupted buildings insurance cover",years);
        }
    }

    public void clickPlotSmallHoldingOrFarm(){
        if (verifyElement.verifyBrowserElementValue(plotSmallHoldingOrFarm, "Plot Small Holding Or Farm") == 0){
            verifyElement.clickElement(plotSmallHoldingOrFarm,"Plot Small Holding Or Farm");
        }
    }

    public void clickIncreasedRiskBusinessType(){
        if (verifyElement.verifyBrowserElementValue(increasedRiskBusinessType, "Increased Risk Business Type") == 0){
            verifyElement.clickElement(increasedRiskBusinessType,"Increased Risk Business Type");
        }
    }

    public void clickCommune(){
        if (verifyElement.verifyBrowserElementValue(commune, "Increased Risk Business Type") == 0){
            verifyElement.clickElement(commune,"Increased Risk Business Type");
        }
    }

    public void clickWithin100mOfaWaterBody(){
        if (verifyElement.verifyBrowserElementValue(within100mOfaWaterBody, "Within 100m Of a Water Body") == 0){
            verifyElement.clickElement(within100mOfaWaterBody,"Within 100m Of a Water Body");
        }
    }

    //SECURITY METHODS

    public void clickBurglarBarsOpeningWindows(){
        if (verifyElement.verifyBrowserElementValue(burglarBarsOpeningWindows, "Burglar Bars Opening Windows") == 0){
            verifyElement.clickElement(burglarBarsOpeningWindows,"Burglar Bars Opening Windows");
        }
    }

    public void clickAlarmLinkedToArmedResponse(){
        if (verifyElement.verifyBrowserElementValue(alarmLinkedToArmedResponse, "Alarm Linked To Armed Response") == 0){
            verifyElement.clickElement(alarmLinkedToArmedResponse,"Alarm Linked To Armed Response");
        }
    }

    public void clickElectricFence_DropDown(){
        if (verifyElement.verifyBrowserElementValue(electricFence_DD, "Alarm Linked To Armed Response") == 0){
            verifyElement.clickElement(electricFence_DD,"Alarm Linked To Armed Response");
        }
    }

    public void clickTwentyFourHourSecurityGuard(){
        if (verifyElement.verifyBrowserElementValue(twentyFourHourSecurityGuard, "24 hour security guard") == 0){
            verifyElement.clickElement(twentyFourHourSecurityGuard,"24 hour security guard");
        }
    }

    public void clickAccessControlledArea(){
        if (verifyElement.verifyBrowserElementValue(accessControlledArea, "Access Controlled Area") == 0){
            verifyElement.clickElement(accessControlledArea,"Access Controlled Area");
        }
    }

    public void clickAllDoorsProtectedBySecurityGates(){
        if (verifyElement.verifyBrowserElementValue(allDoorsProtectedBySecurityGates, "All Doors Protected By Security Gates") == 0){
            verifyElement.clickElement(allDoorsProtectedBySecurityGates,"All Doors Protected By Security Gates");
        }
    }

    public void clickPerimeterProtection_DropDown(){
        if (verifyElement.verifyBrowserElementValue(perimeterProtection_DD, "Perimeter Protection") == 0){
            verifyElement.clickElement(perimeterProtection_DD,"Perimeter Protection");
        }
    }

    public void clickHighSecurityEstateComplex(){
        if (verifyElement.verifyBrowserElementValue(highSecurityEstateComplex, "High Security Estate Complex") == 0){
            verifyElement.clickElement(highSecurityEstateComplex,"High Security Estate Complex");
        }
    }

    public void clickCCTVCamera(){
        if (verifyElement.verifyBrowserElementValue(cctvCamera, "CCTV Camera") == 0){
            verifyElement.clickElement(cctvCamera,"CCTV Camera");
        }
    }

    public void clickLaserBeamsInGarden(){
        if (verifyElement.verifyBrowserElementValue(laserBeamsInGarden, "Laser Beams In Garden") == 0){
            verifyElement.clickElement(laserBeamsInGarden,"Laser Beams In Garden");
        }
    }

    //CLAIMS METHODS

    public void enterNumberOfClaimsLast12month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast12month_Txt, "Number of Building claims in the last 12 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast12month_Txt,"Number of Building claims in the last 12 months, excluding geyser damage",claims);
        }
    }

    public void enterNumberOfClaimsLast24month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast24month_Txt, "Number of Building claims in the last 13 to 24 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast24month_Txt,"Number of Building claims in the last 13 to 24 months, excluding geyser damage",claims);
        }
    }

    public void enterNumberOfClaimsLast36month(String claims){
        if (verifyElement.verifyBrowserElementValue(numberOfClaimsLast36month_Txt, "Number of Buildings claims in the last 25 to 36 months, excluding geyser damage") == 0){
            verifyElement.sendKeys(numberOfClaimsLast36month_Txt,"Number of Buildings claims in the last 25 to 36 months, excluding geyser damage",claims);
        }
    }

    //EXCESS METHODS

    public void enterAdditionalExcess_Txt(String amount){
        if (verifyElement.verifyBrowserElementValue(additionalExcess_Txt , "Additional Excess") == 0){
            verifyElement.sendKeys(additionalExcess_Txt ,"Additional Excess",amount);
        }
    }

    public void clickBasicExcessDropDown(){
        if (verifyElement.verifyBrowserElementValue(basicExcess_DD, "Basic Excess") == 0){
            verifyElement.clickElement(basicExcess_DD,"Basic Excess");
        }
    }
    public void clickBasicExcessDropDown2(String input){
        if (verifyElement.verifyBrowserElementValue(basicExcess_DD, "Basic Excess") == 0){
            // verifyElement.clickElement(basicExcess_DD,"Basic Excess");
            verifyElement.sendKeys(basicExcess_DD,"", input);
        }
    }

    //EXTENSIONS METHODS

    public void clickPowerSurge(){
        if (verifyElement.verifyBrowserElementValue(powerSurge, "Power Surge") == 0){
            verifyElement.clickElement(powerSurge,"Power Surge");
        }
    }

    public void clickPowerSurgeMainCoverSumInsured(){
        if (verifyElement.verifyBrowserElementValue(powerSurgeMainCoverSumInsured, "Power Surge Main Cover Sum Insured") == 0){
            verifyElement.clickElement(powerSurgeMainCoverSumInsured,"Power Surge Main Cover Sum Insured");
        }
    }

    public void clickGardenAndLandscapingExtendedCover(){
        if (verifyElement.verifyBrowserElementValue(gardenAndLandscapingExtendedCover, "Garden And Landscaping Extended Cover") == 0){
            verifyElement.clickElement(gardenAndLandscapingExtendedCover,"Garden And Landscaping Extended Cover");
        }
    }

    public void clickSubsidenceLandslipOrGroundHeaveExtendedCove(){
        if (verifyElement.verifyBrowserElementValue(subsidenceLandslipOrGroundHeaveExtendedCover, "Subsidence, landslip or ground heave - extended cover") == 0){
            verifyElement.clickElement(subsidenceLandslipOrGroundHeaveExtendedCover,"Subsidence, landslip or ground heave - extended cover");
        }
    }
    public void clickPowerSurgeSumInsuredDropDown() {

        if (verifyElement.verifyBrowserElementValue(powerSurgeSumInsured_DD, "Power Surge Sum Insured") == 0) {
            verifyElement.clickElement(powerSurgeSumInsured_DD,"Power Surge Sum Insured");
        }
    }

    public void clickGardenAndLandscapingSumInsuredDropDown() {

        if (verifyElement.verifyBrowserElementValue(gardenAndLandscapingSumInsured_DD, "Garden and landscaping - extended cover Sum Insured") == 0) {
            verifyElement.clickElement(gardenAndLandscapingSumInsured_DD,"Garden and landscaping - extended cover Sum Insured");
        }
    }



}
