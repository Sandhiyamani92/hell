package com.sts.testautomation.pages.web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sts.testautomation.utilities.ElementFunctionality;

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

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_AllRiskType_Input']")
    private WebElement assetsSpecifiedCategory_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_Description']")
    private WebElement assetsSpecifiedDescription_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_10578_Input']")
    private WebElement assetsSpecifiedBasicExcess_DD ;

    // ASSETS SPECIFIED METHODS

    public void enterSumInsured(String sumInsured) {

        if (verifyElement.verifyBrowserElementValue( sumInsured_Txt, "Sum Insured") == 0) {
            verifyElement.sendKeys( sumInsured_Txt, "Sum Insured", sumInsured);
        }
    }

    public void clickAssetsSpecifiedCategory() {

        if (verifyElement.verifyBrowserElementValue(assetsSpecifiedCategory_DD, "Assets Specified Category") == 0) {
            verifyElement.clickElement(assetsSpecifiedCategory_DD,"Assets Specified Category");
        }
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


}
