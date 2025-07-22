package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Prestige_FineArts {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_FineArts(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }


    // RISK DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10518_Input']")
    private WebElement residenceType_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_IsOccupiedduringtheday']")
    private WebElement daysUnoccupied90Days ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_WallType']")
    private WebElement  typeOfWallConstruction_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input']")
    private WebElement  typeOfRoofConstruction_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10599_Input']")
    private WebElement  fineArtCategory_DD ;

    // COVER DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7255_Input']")
    private WebElement  typeOfCover_DD ;

    // SECURITY DETAILS

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7259']")
    private WebElement burglarBarsOpeningWindows ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10520']")
    private WebElement allDoorsProtectedBySecurityGates  ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7260']")
    private WebElement alarmLinkedToArmedResponse ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10521']")
    private WebElement highSecurityEstateComplex ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7253_Input']")
    private WebElement electricFence_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7254']")
    private WebElement accessControlledArea ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10523']")
    private WebElement twentyFourHourSecurityGuard ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10524']")
    private WebElement cctvCamera ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10525']")
    private WebElement laserBeamsInGarden ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10526_Input']")
    private WebElement perimeterProtection_DD  ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_AlarmType']")
    private WebElement alarmType_DD  ;

    // EXTENSIONS

    @FindBy(xpath = "//button[@id='chkExtension3203']")
    private WebElement exhibition ;

    @FindBy(xpath = "//button[@id='chkExtension5658']")
    private WebElement artAtTemporaryLocation ;

    @FindBy(xpath = "//button[@id='chkExtension5659']")
    private WebElement artInTransitInSouthAfrica ;

    @FindBy(xpath = "//button[@id='chkExtension5660']]")
    private WebElement defectiveTitle;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured3203']")
    private WebElement exhibitionSumInsured_Txt ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured5658']")
    private WebElement artAtTemporaryLocationSumInsured_Txt ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured5659']")
    private WebElement artInTransitInSouthAfricaSumInsured_Txt ;

    @FindBy(xpath = "//input[@id='txtExtensionSumInsured5660']")
    private WebElement defectiveTitleSumInsured_Txt;


    // RISK DETAILS
    public void clickResidenceType() {
        if (verifyElement.verifyBrowserElementValue(residenceType_DD, "Residence Type") == 0) {
            verifyElement.clickElement(residenceType_DD, "Residence Type");
        }
    }

    public void clickDaysUnoccupied90Days() {
        if (verifyElement.verifyBrowserElementValue(daysUnoccupied90Days, "Unoccupied for 90 Days") == 0) {
            verifyElement.clickElement(daysUnoccupied90Days, "Unoccupied for 90 Days");
        }
    }

    public void clickTypeOfWallConstruction() {
        if (verifyElement.verifyBrowserElementValue(typeOfWallConstruction_DD, "Type of Wall Construction") == 0) {
            verifyElement.clickElement(typeOfWallConstruction_DD, "Type of Wall Construction");
        }
    }

    public void clickTypeOfRoofConstruction() {
        if (verifyElement.verifyBrowserElementValue(typeOfRoofConstruction_DD, "Type of Roof Construction") == 0) {
            verifyElement.clickElement(typeOfRoofConstruction_DD, "Type of Roof Construction");
        }
    }

    public void clickFineArtCategory() {
        if (verifyElement.verifyBrowserElementValue(fineArtCategory_DD, "Fine Art Category") == 0) {
            verifyElement.clickElement(fineArtCategory_DD, "Fine Art Category");
        }
    }
    // COVER DETAILS

    public void clickTypeOfCover() {
        if (verifyElement.verifyBrowserElementValue(typeOfCover_DD, "Type Of Cove") == 0) {
            verifyElement.clickElement(typeOfCover_DD, "Type Of Cove");
        }
    }

    // SECURITY DETAILS

    public void clickBurglarBarsOpeningWindows() {
        if (verifyElement.verifyBrowserElementValue(burglarBarsOpeningWindows, "Burglar Bars on Opening Windows") == 0) {
            verifyElement.clickElement(burglarBarsOpeningWindows, "Burglar Bars on Opening Windows");
        }
    }

    public void clickAllDoorsProtectedBySecurityGates() {
        if (verifyElement.verifyBrowserElementValue(allDoorsProtectedBySecurityGates, "All Doors Protected by Security Gates") == 0) {
            verifyElement.clickElement(allDoorsProtectedBySecurityGates, "All Doors Protected by Security Gates");
        }
    }

    public void clickAlarmLinkedToArmedResponse() {
        if (verifyElement.verifyBrowserElementValue(alarmLinkedToArmedResponse, "Alarm Linked to Armed Response") == 0) {
            verifyElement.clickElement(alarmLinkedToArmedResponse, "Alarm Linked to Armed Response");
        }
    }

    public void clickHighSecurityEstateComplex() {
        if (verifyElement.verifyBrowserElementValue(highSecurityEstateComplex, "High Security Estate/Complex") == 0) {
            verifyElement.clickElement(highSecurityEstateComplex, "High Security Estate/Complex");
        }
    }

    public void clickElectricFence() {
        if (verifyElement.verifyBrowserElementValue(electricFence_DD, "Electric Fence") == 0) {
            verifyElement.clickElement(electricFence_DD, "Electric Fence");
        }
    }

    public void clickAccessControlledArea() {
        if (verifyElement.verifyBrowserElementValue(accessControlledArea, "Access Controlled Area") == 0) {
            verifyElement.clickElement(accessControlledArea, "Access Controlled Area");
        }
    }

    public void clickTwentyFourHourSecurityGuard() {
        if (verifyElement.verifyBrowserElementValue(twentyFourHourSecurityGuard, "24-Hour Security Guard") == 0) {
            verifyElement.clickElement(twentyFourHourSecurityGuard, "24-Hour Security Guard");
        }
    }

    public void clickCctvCamera() {
        if (verifyElement.verifyBrowserElementValue(cctvCamera, "CCTV Camera") == 0) {
            verifyElement.clickElement(cctvCamera, "CCTV Camera");
        }
    }

    public void clickLaserBeamsInGarden() {
        if (verifyElement.verifyBrowserElementValue(laserBeamsInGarden, "Laser Beams in Garden") == 0) {
            verifyElement.clickElement(laserBeamsInGarden, "Laser Beams in Garden");
        }
    }

    public void clickPerimeterProtection() {
        if (verifyElement.verifyBrowserElementValue(perimeterProtection_DD, "Perimeter Protection") == 0) {
            verifyElement.clickElement(perimeterProtection_DD, "Perimeter Protection");
        }
    }

    public void clickAlarmType() {
        if (verifyElement.verifyBrowserElementValue(alarmType_DD, "Alarm Type") == 0) {
            verifyElement.clickElement(alarmType_DD, "Alarm Type");
        }
    }

    // EXTENSIONS

    public void clickExhibition() {
        if (verifyElement.verifyBrowserElementValue(exhibition, "Exhibition") == 0) {
            verifyElement.clickElement(exhibition, "Exhibition");
        }
    }

    public void clickArtAtTemporaryLocation() {
        if (verifyElement.verifyBrowserElementValue(artAtTemporaryLocation, "Art at Temporary Location") == 0) {
            verifyElement.clickElement(artAtTemporaryLocation, "Art at Temporary Location");
        }
    }

    public void clickArtInTransitInSouthAfrica() {
        if (verifyElement.verifyBrowserElementValue(artInTransitInSouthAfrica, "Art in Transit in South Africa") == 0) {
            verifyElement.clickElement(artInTransitInSouthAfrica, "Art in Transit in South Africa");
        }
    }

    public void clickDefectiveTitle() {
        if (verifyElement.verifyBrowserElementValue(defectiveTitle, "Defective Title") == 0) {
            verifyElement.clickElement(defectiveTitle, "Defective Title");
        }
    }

    public void enterExhibitionSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(exhibitionSumInsured_Txt, "Exhibition Sum Insured") == 0) {
            verifyElement.sendKeys(exhibitionSumInsured_Txt, "Exhibition Sum Insured", value);
        }
    }

    public void enterArtAtTemporaryLocationSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(artAtTemporaryLocationSumInsured_Txt, "Art at Temporary Location Sum Insured") == 0) {
            verifyElement.sendKeys(artAtTemporaryLocationSumInsured_Txt, "Art at Temporary Location Sum Insured", value);
        }
    }

    public void enterArtInTransitInSouthAfricaSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(artInTransitInSouthAfricaSumInsured_Txt, "Art in Transit in South Africa Sum Insured") == 0) {
            verifyElement.sendKeys(artInTransitInSouthAfricaSumInsured_Txt, "Art in Transit in South Africa Sum Insured", value);
        }
    }

    public void enterDefectiveTitleSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(defectiveTitleSumInsured_Txt, "Defective Title Sum Insured") == 0) {
            verifyElement.sendKeys(defectiveTitleSumInsured_Txt, "Defective Title Sum Insured", value);
        }
    }

}
