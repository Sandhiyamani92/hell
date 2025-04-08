package com.sts.testautomation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sts.testautomation.utilities.ElementFunctionality;
public class NIMBIS_UserNavigation {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public  NIMBIS_UserNavigation(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }


    @FindBy(xpath = "//div[@id='ctl00_MainMenu']//ul//span[contains(text(),'Quotations')]")
    private WebElement Quotation_DD ;

    @FindBy(xpath = "//a[contains(text(),'Add a new Quote')]")
    private WebElement addNewQuote_DD ;

    @FindBy(xpath = "(//input[@class='rlbCheck'])[2]")
    private WebElement prestigeV2_Chkbox ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbPolicyFrequency_Input']")
    private WebElement policyFrequency_DD ;

    @FindBy(xpath = "//button[@class='rwzButton rwzNext']")
    private WebElement nextBtn ;

    @FindBy(xpath = "//button[@class='rwzButton rwzNext']")
    private WebElement openQuoteBtn ;



    //METHODS

    public void clickQuotation_DD() {

        if (verifyElement.verifyBrowserElementValue(Quotation_DD, "Quotation Drop Down") == 0) {
            verifyElement.clickElement(Quotation_DD,"Quotation Drop Down");
        }
    }
    public void clickAddNewQuote_DD() {

        if (verifyElement.verifyBrowserElementValue(addNewQuote_DD, "Add New Quote") == 0) {
            verifyElement.clickElement(addNewQuote_DD,"Add New Quote");
        }
    }
    public void clickPrestigeV2_Chkbox() {

        if (verifyElement.verifyBrowserElementValue(prestigeV2_Chkbox, "Prestige V2") == 0) {
            verifyElement.clickElement(prestigeV2_Chkbox,"Prestige V2");
        }
    }
    public void clickPolicyFrequency_DD() {

        if (verifyElement.verifyBrowserElementValue(policyFrequency_DD, "Policy Frequency") == 0) {
            verifyElement.clickElement(policyFrequency_DD,"Policy Frequency");
        }
    }
    public void clickNextBtn() {

        if (verifyElement.verifyBrowserElementValue(nextBtn, "Next") == 0) {
            verifyElement.clickElement(nextBtn,"Next");
        }
    }



}
