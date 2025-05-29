package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NIMBIS_Cyber_Insurance {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Cyber_Insurance(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    //COVER DETAILS

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11050']")
    private WebElement cyberinsurancecoveroption_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11050_DropDown']//li")
    public List<WebElement> allCyberinsuranceCoverOptions;

    @FindBy(xpath = "//button[@id='ContentPlaceHolder1_DynamicQuestions1_content_NonStandard_11048']")
    private WebElement coverforpartner_toggle ;

    @FindBy(xpath = "//button[@id='ContentPlaceHolder1_DynamicQuestions1_content_NonStandard_11049']")
    private WebElement coverforchildren_toggle ;

    //COVER DETAILS METHODS

    public void clickCyberInsuranceCoverDropDown(){
        if (verifyElement.verifyBrowserElementValue(cyberinsurancecoveroption_DD, "Cyber Insurance Cover Option") == 0){
            verifyElement.clickElement(cyberinsurancecoveroption_DD,"Cyber Insurance Cover Option");
        }
    }

    public List<WebElement> getAllCyberinsuranceCoverOptions() {
        return allCyberinsuranceCoverOptions;
    }

    public void clickCoverForPartnerToggleButton(){
        if (verifyElement.verifyBrowserElementValue(coverforpartner_toggle, "Cover For Partner") == 0){
            verifyElement.clickElement(coverforpartner_toggle,"Cover For Partner");
        }
    }

    public void clickCoverForChilderToggleButton(){
        if (verifyElement.verifyBrowserElementValue(coverforchildren_toggle, "Cover For Children") == 0){
            verifyElement.clickElement(coverforchildren_toggle,"Cover For Children");
        }
    }

}
