package com.sts.testautomation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sts.testautomation.utilities.ElementFunctionality;

public class NIMBIS_Prestige_Client {
    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Prestige_Client(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }


    // CLIENT DETAILS

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbClientType_Input']")
    private WebElement clientType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_firstname']")
    private WebElement firstName_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_lastname']")
    private WebElement lastName_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_idtype_Input']")
    private WebElement identityType_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_identification']")
    private WebElement identification_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_gender_Input']")
    private WebElement gender_DD;

    @FindBy(xpath = "ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_title_Input")
    private WebElement title_DD;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_maritalstatus_ClientState']")
    private WebElement maritalStatus_DD;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_email']")
    private WebElement emailAddress_Txt;

    //ADDRESS DETAILS

    @FindBy(xpath = "ctl00_ContentPlaceHolder1_ucAddress_txtLine1")
    private WebElement postalCode_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucAddress_txtStreet']")
    private WebElement street_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucAddress_txtLine2']")
    private WebElement building_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucAddress_txtTownCity']")
    private WebElement town_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_ucAddress_txtLine1']")
    private WebElement complex_Txt;

    @FindBy(xpath = "//button[@name='ctl00$ContentPlaceHolder1$ucAddress$btnRefreshMap']")
    private WebElement loadMap_Btn;

}
