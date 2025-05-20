package com.sts.testautomation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//li[@id='ctl00_ContentPlaceHolder1_BrokerProductList_i1']//input")
    private WebElement prestigeV2_Chkbox ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbPolicyFrequency_Input']")
    private WebElement policyFrequency_DD ;

    @FindBy(xpath = "//button[@class='rwzButton rwzNext']")
    private WebElement nextBtn ;

    @FindBy(xpath = "//span[contains(text(),'Open Quote')]")
    private WebElement openQuoteBtn ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_ucCover_RiskGrid.ascx_userControl_lstItemsOnQuote_ctl00_ctl04_btnEdit']")
    private WebElement editQuoteIcon ;


    @FindBy(xpath = "//li//span[contains(text(),'Cover')]")
    private WebElement coverBtn ;

    @FindBy(xpath = "//li//span[contains(text(),'Add New Item')]")
    private WebElement addNewItemBtn ;

    @FindBy(xpath = "//input[@id='ctl00_txtSearch']")
    private WebElement search_Txt ;

    @FindBy(xpath = "//input[@id='btnSearch']")
    private WebElement searchBtn ;

    @FindBy(xpath = "//a[@id='ctl00_ContentPlaceHolder1_lstResults_ctl00_ctl04_hpHeader']")
    private WebElement clientResultName ;

    @FindBy(xpath = "(//span[@class='rtbButton'])[2]")
    private WebElement newQuoteBtn ;

    @FindBy(xpath = "//a[@class='rwPopupButton']")
    private WebElement popUpOkBtn ;

    @FindBy(xpath = "//td//a[@class='rwPopupButton']")
    private WebElement OkBtn ;

    @FindBy(xpath = "//td[@class='rwWindowContent']//a//span[contains(text(),'OK')]")
    private WebElement popUpOkRateBtn ;




    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement collectionWindow2;


    @FindBy(xpath = "//form[@id='formPopup']//iframe[@name='GenericPopup']")
    WebElement collectionWindow3;

    @FindBy(xpath = "//li//span[contains(text(),'Calculate Coverage Premium')]")
    WebElement calculatePremiumBtn;

    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_SectionToolbar']/ul/li[1]")
    WebElement saveBtn;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_btnSave']")
    WebElement saveBtn2;

    @FindBy(xpath = "//li//span[text()='Blackbox Log']")
    WebElement blackBoxLogBtn;

    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_BlackBoxInput']//li//span[text()='Raw View']")
    WebElement blackBoxRawViewIn;


    @FindBy(xpath = "//div[@id='ContentPlaceHolder1_BlackBoxOutput']//li//span[text()='Raw View']")
    WebElement blackBoxRawViewOut;


    @FindBy(xpath = "//li//span[text()='BlackBox Input']")
    WebElement blackBoxInput;


    @FindBy(xpath = "//li//span[text()='BlackBox Output']")
    WebElement blackBoxOutput;

    public  void clickBlackBoxOutput(){
        verifyElement.clickElement(blackBoxOutput,"blackBoxOutput");
    }
    public  void clickBlackBoxRawViewOut(){
        verifyElement.clickElement(blackBoxRawViewOut,"blackBoxRawViewOut");
    }
    public  void clickBlackBoxInput(){
        verifyElement.clickElement(blackBoxInput,"blackBoxRawViewOut");
    }
    public  void clickBlackBoxRawViewIn(){
        verifyElement.clickElement(blackBoxRawViewIn,"blackBoxRawViewIn");
    }





    @FindBy(xpath = "//span[@class='rwCommandButton rwCloseButton']")
    WebElement closeBtn;

    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement mainWindow;

    public  void clickCloseBtn(){
        verifyElement.clickElement(closeBtn,"Close Button");
    }

    public void changeFocusToBrowser() {

        verifyElement.switchOutOfBrowserFrame();

    }
    @FindBy(xpath = "//*[@class='RadWindow RadWindow_Default rwNormalWindow rwTransparentWindow']/table/tbody/tr[2]/td[2]")
    WebElement alertWindow;

    public void changeFocusToAlert() {

        verifyElement.switchToBrowserFrame(alertWindow,  "Switch focus to pop up frame");

    }



    // RISK COVERS
    @FindBy(xpath = "//li//span[contains(text(),'Assets Specified')]")
    private WebElement assetsSpecifiedCover ;

    @FindBy(xpath = "//li//span[contains(text(),'Home')]")
    private WebElement homeCover ;

    @FindBy(xpath = "//li//span[contains(text(),'Contents')]")
    private WebElement contentsCover ;





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
    public void clickEditQuoteIcon() {

        if (verifyElement.verifyBrowserElementValue(editQuoteIcon, "Edit Quote Icon") == 0) {
            verifyElement.clickElement(editQuoteIcon,"Edit Quote Icon");
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
    public void clickOkBtn() {

        if (verifyElement.verifyBrowserElementValue(OkBtn, "Ok") == 0) {
            verifyElement.clickElement(OkBtn,"Ok");
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

    public void enterSearchText(String name) {

        if (verifyElement.verifyBrowserElementValue(search_Txt, "Search") == 0) {
            verifyElement.sendKeys(search_Txt,"Search",name);
        }
    }
    public void clickSearchBtn() {

        if (verifyElement.verifyBrowserElementValue(searchBtn, "Search") == 0) {
            verifyElement.clickElement(searchBtn, "Search");
        }
    }

    public void clickClientResultName() {

        if (verifyElement.verifyBrowserElementValue(clientResultName, "Client Result Name") == 0) {
            verifyElement.clickElement(clientResultName, "Client Result Name");
        }
    }

    public void clickAddNewQuote() {

        if (verifyElement.verifyBrowserElementValue(newQuoteBtn, "New Quote") == 0) {
            verifyElement.clickElement(newQuoteBtn, "New Quote");
        }
    }

    public void clickPopUpOkRateBtn() {

        if (verifyElement.verifyBrowserElementValue(popUpOkRateBtn, "popUpOkRateBtn") == 0) {
            verifyElement.clickElement(popUpOkRateBtn, "popUpOkRateBtn");
        }
    }

    public void clickPopUpOkBtn() {

        if (verifyElement.verifyBrowserElementValue(popUpOkBtn, "Pop Up Ok Btn") == 0) {
            verifyElement.clickElement(popUpOkBtn, "Pop Up Ok Btn");
        }
    }

    public void clickCalculatePremiumBtn() {

        if (verifyElement.verifyBrowserElementValue(calculatePremiumBtn, "Calculate Premium") == 0) {
            verifyElement.clickElement(calculatePremiumBtn, "Calculate Premium");
        }
    }

    public void clickSaveBtn() {

        if (verifyElement.verifyBrowserElementValue(saveBtn, "Save") == 0) {
            verifyElement.clickElement(saveBtn, "Save");
        }
    }

    public void clickSaveBtn2() {

        if (verifyElement.verifyBrowserElementValue(saveBtn2, "Save") == 0) {
            verifyElement.clickElement(saveBtn2, "Save");
        }
    }

    public void clickOpenQuote() {

        if (verifyElement.verifyBrowserElementValue(openQuoteBtn, "Open Quote") == 0) {
            verifyElement.clickElement(openQuoteBtn, "Open Quote");
        }
    }

    public void clickBlackBoxLogBtn() {

        if (verifyElement.verifyBrowserElementValue(blackBoxLogBtn, "blackBoxLogBtn") == 0) {
            verifyElement.clickElement(blackBoxLogBtn, "blackBoxLogBtn");
        }
    }




    //RISK COVERS METHODS

    public void clickAssetsSpecifiedCover() {

        if (verifyElement.verifyBrowserElementValue(assetsSpecifiedCover, "Assets Specified Cover") == 0) {
            verifyElement.clickElement(assetsSpecifiedCover,"Assets Specified Cover");
        }
    }

    public void clickHomeCover() {

        if (verifyElement.verifyBrowserElementValue(homeCover, "Home Cover") == 0) {
            verifyElement.clickElement(homeCover,"Home Cover");
        }
    }

    public void clickContentsCover() {

        if (verifyElement.verifyBrowserElementValue(contentsCover, "Content Cover") == 0) {
            verifyElement.clickElement(contentsCover,"Content Cover");
        }
    }


    public void selectOption(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//li[text()= '" + option +"']"));;
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {
           // ((JavascriptExecutor) BrowserDriver).executeScript("arguments[0].click();", item);

            verifyElement.clickElement(item, option);
        }
        else
        {
            System.err.println("Element"+ option+"couldnt be found " );
        }
    }
    public void selectOptionExcess(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7215_DropDown']//ul//li[text()= '"+option+"']"));;
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {
           // ((JavascriptExecutor) BrowserDriver).executeScript("arguments[0].click();", item);

           verifyElement.clickElement(item, option);

        }
        else
        {
            System.err.println("Element"+ option+"couldnt be found " );
        }
    }

    public void changeFocus2() {

        verifyElement.switchToBrowserFrame(collectionWindow2,  "Switch focus to pop up frame");

    }
    public void changeFocus3() {

        verifyElement.switchToBrowserFrame(collectionWindow3,  "Switch focus to pop up frame");

    }



}
