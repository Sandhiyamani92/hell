package com.sts.testautomation.pages.web;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[contains(text(),'Open Quote')]")
    private WebElement openQuoteBtn ;

    @FindBy(xpath = "//li//span[contains(text(),'Cover')]")
    private WebElement coverBtn ;

    @FindBy(xpath = "//li//span[contains(text(),'Add New Item')]")
    private WebElement addNewItemBtn ;

    // RISK COVERS
    @FindBy(xpath = "//li//span[contains(text(),'Assets Specified')]")
    private WebElement assetsSpecifiedCover ;





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
    public void clickCoverBtn() {

        if (verifyElement.verifyBrowserElementValue(coverBtn, "Cover") == 0) {
            verifyElement.clickElement(coverBtn,"Cover");
        }
    }
    public void clickAddNewItemBtn() {

        if (verifyElement.verifyBrowserElementValue(addNewItemBtn, "Add New Item") == 0) {
            verifyElement.clickElement(addNewItemBtn,"Add New Item");
        }
    }

    //RISK COVERS METHODS

    public void clickAssetsSpecifiedCover() {

        if (verifyElement.verifyBrowserElementValue(assetsSpecifiedCover, "Assets Specified Cover") == 0) {
            verifyElement.clickElement(assetsSpecifiedCover,"Assets Specified Cover");
        }
    }


    public void selectOption(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//li[contains(text(),'" + option +"')]"));;
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {

            verifyElement.clickElement(item, option);
        }
        else
        {
            System.err.println("Element"+ option+"couldnt be found " );
        }
    }



}
