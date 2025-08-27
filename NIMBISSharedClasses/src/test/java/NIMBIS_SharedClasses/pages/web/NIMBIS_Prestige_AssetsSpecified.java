package NIMBIS_SharedClasses.pages.web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import NIMBIS_SharedClasses.utilities.ElementFunctionality;

import java.util.List;

public class NIMBIS_Prestige_AssetsSpecified {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_AssetsSpecified (WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    //ASSETS SPECIFIED PAGE OBJECTS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_AllRiskSumInsured']")
    private WebElement sumInsured_Txt ;

    //RISK DETAILS

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11084']")
    private WebElement assetsSpecifiedCategory_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11084_DropDown']//li")
    public List<WebElement> assestsSpecifiedCategoryOptions;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Description']")
    private WebElement assetsSpecifiedDescription_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Manufacturer']")
    private WebElement manufacturer_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_SerialNumber']")
    private WebElement serialNumber_Txt ;

    //Excess options

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10578_Input']")
    private WebElement assetsSpecifiedBasicExcess_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10578_DropDown']//li")
    public List<WebElement> assestsSpecifiedBasicExcessOptions;

    // ASSETS SPECIFIED METHODS

    public void enterSumInsured(String sumInsured) {

        if (verifyElement.verifyBrowserElementValue( sumInsured_Txt, "Sum Insured") == 0) {
            verifyElement.sendKeys( sumInsured_Txt, "Sum Insured", sumInsured);
        }
    }

    public void entermanufacturer(String manufacturer) {

        if (verifyElement.verifyBrowserElementValue( manufacturer_Txt, "manufacturer") == 0) {
            verifyElement.sendKeys( manufacturer_Txt, "manufacturer", manufacturer);
        }
    }

    public void enterserialnum(String serialnum) {

        if (verifyElement.verifyBrowserElementValue( serialNumber_Txt, "serialnum") == 0) {
            verifyElement.sendKeys( serialNumber_Txt, "serialnum", serialnum);
        }
    }

    public void clickAssetsSpecifiedCategory() {

        if (verifyElement.verifyBrowserElementValue(assetsSpecifiedCategory_DD, "Assets Specified Category") == 0) {
            verifyElement.clickElement(assetsSpecifiedCategory_DD,"Assets Specified Category");
        }
    }

    public List<WebElement> getAssestsSpecifiedCategoryOptions() {
        return assestsSpecifiedCategoryOptions;
    }

    public void enterAssetsSpecifiedDescription(String assetsDescription) {

        if (verifyElement.verifyBrowserElementValue( assetsSpecifiedDescription_Txt, "Assets Specified Description") == 0) {
            verifyElement.sendKeys( assetsSpecifiedDescription_Txt, "Assets Specified Description", assetsDescription);
        }
    }

    public void clickAssetsSpecifiedBasicExcess() {

        if (verifyElement.verifyBrowserElementValue(assetsSpecifiedBasicExcess_DD, "Assets Specified Basic Excess") == 0) {
            verifyElement.clickElement(assetsSpecifiedBasicExcess_DD,"Assets Specified Basic Excess");
        }
    }

    public List<WebElement> getAssestsSpecifiedBasicExcessOptions() {
        return assestsSpecifiedBasicExcessOptions;
    }


}
