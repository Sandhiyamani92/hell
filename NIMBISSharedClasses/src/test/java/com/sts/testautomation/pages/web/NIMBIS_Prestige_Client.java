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
    private WebElement email3Address_Txt;

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


    //CLIENT DETAILS METHODS

    public void clickClientType() {

        if (verifyElement.verifyBrowserElementValue(clientType_DD, "Client Type") == 0) {
            verifyElement.clickElement(clientType_DD,"Client Type");
        }
    }
    public void enterLastName(String lastName) {

        if (verifyElement.verifyBrowserElementValue( lastName_Txt, "Last Name") == 0) {
            verifyElement.sendKeys( lastName_Txt, "Last Name", lastName);
        }
    }

    public void enterFirstName(String firstName) {

        if (verifyElement.verifyBrowserElementValue(firstName_Txt, "First Name") == 0) {
            verifyElement.sendKeys(firstName_Txt, "First Name", firstName);
        }
    }

    public void clickIdentityType() {

        if (verifyElement.verifyBrowserElementValue(identityType_DD, "Identity Type") == 0) {
            verifyElement.clickElement(identityType_DD,"Identity Type");
        }
    }
    public void enterIdentificationNumber(String idNum) {

        if (verifyElement.verifyBrowserElementValue(identification_Txt, "Identification Number") == 0) {
            verifyElement.sendKeys(identification_Txt, "Identification Number", idNum);
        }
    }
    public void clickGender() {

        if (verifyElement.verifyBrowserElementValue(gender_DD, "Gender") == 0) {
            verifyElement.clickElement(gender_DD,"Gender");
        }
    }
    public void clickTitle() {

        if (verifyElement.verifyBrowserElementValue(title_DD, "Title") == 0) {
            verifyElement.clickElement(title_DD,"Title");
        }
    }
    public void clickMaritalStatus() {

        if (verifyElement.verifyBrowserElementValue(maritalStatus_DD, "Marital Status") == 0) {
            verifyElement.clickElement(maritalStatus_DD,"Marital Status");
        }
    }

    //CLIENT ADDRESS DETAILS METHODS

    public void enterPostalCode(String postalCode) {

        if (verifyElement.verifyBrowserElementValue(postalCode_Txt, "Postal Code") == 0) {
            verifyElement.sendKeys(postalCode_Txt, "Postal Code", postalCode);
        }
    }
    public void enterStreet(String idNum) {

        if (verifyElement.verifyBrowserElementValue(street_Txt, "Street") == 0) {
            verifyElement.sendKeys(street_Txt, "Street", idNum);
        }
    }
    public void enterBuilding(String building) {

        if (verifyElement.verifyBrowserElementValue(building_Txt, "Building") == 0) {
            verifyElement.sendKeys(building_Txt, "Building", building);
        }
    }
    public void enterTown(String town) {

        if (verifyElement.verifyBrowserElementValue(town_Txt, "Town") == 0) {
            verifyElement.sendKeys(town_Txt, "Town", town);
        }
    }
    public void enterComplex(String complex) {

        if (verifyElement.verifyBrowserElementValue(complex_Txt, "Complex") == 0) {
            verifyElement.sendKeys(complex_Txt, "Complex", complex);
        }
    }
    public void clickLoadMap_Btn() {

        if (verifyElement.verifyBrowserElementValue(loadMap_Btn, "Load Map") == 0) {
            verifyElement.clickElement(loadMap_Btn,"Load Map");
        }
    }




}
