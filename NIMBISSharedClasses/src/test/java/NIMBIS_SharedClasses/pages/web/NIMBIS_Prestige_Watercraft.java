package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import NIMBIS_SharedClasses.utilities.ElementFunctionality;

public class NIMBIS_Prestige_Watercraft {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Watercraft(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    // CRAFT MOTOR DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11064']")
    private WebElement numberOfMotor_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11065_Input']")
    private WebElement motorMake_DD ;

    // FINANCE

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7268']")
    private WebElement creditShortfall_Txt ;

    // VESSEL

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Model']")
    private WebElement craftMakeAndModel_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_CraftName']")
    private WebElement craftName_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7267']")
    private WebElement glitterFinish ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Year']")
    private WebElement yearOfManufacture_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_BodyType_Input']")
    private WebElement craftType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_HullMaterial_Input']")
    private WebElement hullConstruction_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_ValueHull']")
    private WebElement sumInsured_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10603']")
    private WebElement lengthOfVessel_Txt ;

    // DISCLOSURES

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10606']")
    private WebElement Modifications ;

    // SITUATION

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7270_Input']")
    private WebElement useOfCraft_DD ;

    // COVER OPTIONS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7269_Input']")
    private WebElement typeOfCover_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7271_Input']")
    private WebElement waterCraftLiability_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11114_Input']")
    private WebElement areaOfUse_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10604_Input']")
    private WebElement storageMethod_DD ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10605']")
    private WebElement craftSurfLaunched ;

    // ENGINE DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtYearOfManufacture']")
    private WebElement engineYearOfManufacture_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtHorsePower']")
    private WebElement engineHorsePower_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtManufacturer']")
    private WebElement engineManufacturer_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtSerialNumber']")
    private WebElement engineSerialNumber_Txt ;


    // ===== CRAFT MOTOR DETAILS =====

    public void enterNumberOfMotor(String value) {
        if (verifyElement.verifyBrowserElementValue(numberOfMotor_Txt, "Number Of Motor") == 0) {
            verifyElement.sendKeys(numberOfMotor_Txt, "Number Of Motor", value);
        }
    }

    public void clickMotorMake() {
        if (verifyElement.verifyBrowserElementValue(motorMake_DD, "Motor Make") == 0) {
            verifyElement.clickElement(motorMake_DD, "Motor Make");
        }
    }
    // ENGINE DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbEngineType_Input']")
    private WebElement engineType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_txtSumInsured']")
    private WebElement engineSumInsured_Txt ;

    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_SectionToolbar']/ul/li[4]")
    WebElement addEngineBtn ;


// ===== FINANCE =====

    public void enterCreditShortfall(String value) {
        if (verifyElement.verifyBrowserElementValue(creditShortfall_Txt, "Credit Shortfall") == 0) {
            verifyElement.sendKeys(creditShortfall_Txt, "Credit Shortfall", value);
        }
    }

// ===== VESSEL =====

    public void enterCraftMakeAndModel(String value) {
        if (verifyElement.verifyBrowserElementValue(craftMakeAndModel_Txt, "Craft Make And Model") == 0) {
            verifyElement.sendKeys(craftMakeAndModel_Txt, "Craft Make And Model", value);
        }
    }

    public void enterCraftName(String value) {
        if (verifyElement.verifyBrowserElementValue(craftName_Txt, "Craft Name") == 0) {
            verifyElement.sendKeys(craftName_Txt, "Craft Name", value);
        }
    }

    public void clickGlitterFinish() {
        if (verifyElement.verifyBrowserElementValue(glitterFinish, "Glitter Finish") == 0) {
            verifyElement.clickElement(glitterFinish, "Glitter Finish");
        }
    }

    public void enterYearOfManufacture(String value) {
        if (verifyElement.verifyBrowserElementValue(yearOfManufacture_Txt, "Year Of Manufacture") == 0) {
            verifyElement.sendKeys(yearOfManufacture_Txt, "Year Of Manufacture", value);
        }
    }

    public void clickCraftType() {
        if (verifyElement.verifyBrowserElementValue(craftType_DD, "Craft Type") == 0) {
            verifyElement.clickElement(craftType_DD, "Craft Type");
        }
    }

    public void clickHullConstruction() {
        if (verifyElement.verifyBrowserElementValue(hullConstruction_DD, "Hull Construction") == 0) {
            verifyElement.clickElement(hullConstruction_DD, "Hull Construction");
        }
    }

    public void enterSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(sumInsured_Txt, "Sum Insured") == 0) {
            verifyElement.sendKeys(sumInsured_Txt, "Sum Insured", value);
        }
    }

    public void enterLengthOfVessel(String value) {
        if (verifyElement.verifyBrowserElementValue(lengthOfVessel_Txt, "Length Of Vessel") == 0) {
            verifyElement.sendKeys(lengthOfVessel_Txt, "Length Of Vessel", value);
        }
    }

// ===== DISCLOSURES =====

    public void clickModifications() {
        if (verifyElement.verifyBrowserElementValue(Modifications, "Modifications") == 0) {
            verifyElement.clickElement(Modifications, "Modifications");
        }
    }

// ===== SITUATION =====

    public void clickUseOfCraft() {
        if (verifyElement.verifyBrowserElementValue(useOfCraft_DD, "Use Of Craft") == 0) {
            verifyElement.clickElement(useOfCraft_DD, "Use Of Craft");
        }
    }

// ===== COVER OPTIONS =====

    public void clickTypeOfCover() {
        if (verifyElement.verifyBrowserElementValue(typeOfCover_DD, "Type Of Cover") == 0) {
            verifyElement.clickElement(typeOfCover_DD, "Type Of Cover");
        }
    }

    public void clickWaterCraftLiability() {
        if (verifyElement.verifyBrowserElementValue(waterCraftLiability_DD, "Water Craft Liability") == 0) {
            verifyElement.clickElement(waterCraftLiability_DD, "Water Craft Liability");
        }
    }

    public void clickAreaOfUse() {
        if (verifyElement.verifyBrowserElementValue(areaOfUse_DD, "Area Of Use") == 0) {
            verifyElement.clickElement(areaOfUse_DD, "Area Of Use");
        }
    }

// Note: The following WebElement is repeated for two fields — areaOfUse_DD and storageMethod_DD.
// To avoid confusion or duplication in real scenarios, double-check and assign separate locators if needed.

    public void clickStorageMethod() {
        if (verifyElement.verifyBrowserElementValue(storageMethod_DD, "Storage Method") == 0) {
            verifyElement.clickElement(storageMethod_DD, "Storage Method");
        }
    }

    public void clickCraftSurfLaunched() {
        if (verifyElement.verifyBrowserElementValue(craftSurfLaunched, "Craft Surf Launched") == 0) {
            verifyElement.clickElement(craftSurfLaunched, "Craft Surf Launched");
        }
    }

// ===== ENGINE DETAILS =====

    public void clickEngineType() {
        if (verifyElement.verifyBrowserElementValue(engineType_DD, "Engine Type") == 0) {
            verifyElement.clickElement(engineType_DD, "Engine Type");
        }
    }

    public void enterEngineSumInsured(String value) {
        if (verifyElement.verifyBrowserElementValue(engineSumInsured_Txt, "Engine Sum Insured") == 0) {
            verifyElement.sendKeys(engineSumInsured_Txt, "Engine Sum Insured", value);
        }
    }

    public void clickAddEngineBtn() {
        if (verifyElement.verifyBrowserElementValue(addEngineBtn, "Add Engine Button") == 0) {
            verifyElement.clickElement(addEngineBtn, "Add Engine Button");
        }
    }

    public void enterEngineYearOfManufacture(String value) {
        if (verifyElement.verifyBrowserElementValue(engineYearOfManufacture_Txt, "Engine Year Of Manufacture") == 0) {
            verifyElement.sendKeys(engineYearOfManufacture_Txt, "Engine Year Of Manufacture", value);
        }
    }

    public void enterEngineHorsePower(String value) {
        if (verifyElement.verifyBrowserElementValue(engineHorsePower_Txt, "Engine Horse Power") == 0) {
            verifyElement.sendKeys(engineHorsePower_Txt, "Engine Horse Power", value);
        }
    }

    public void enterEngineManufacturer(String value) {
        if (verifyElement.verifyBrowserElementValue(engineManufacturer_Txt, "Engine Manufacturer") == 0) {
            verifyElement.sendKeys(engineManufacturer_Txt, "Engine Manufacturer", value);
        }
    }

    public void enterEngineSerialNumber(String value) {
        if (verifyElement.verifyBrowserElementValue(engineSerialNumber_Txt, "Engine Serial Number") == 0) {
            verifyElement.sendKeys(engineSerialNumber_Txt, "Engine Serial Number", value);
        }
    }







}
