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

    @FindBy(xpath = "//li[@id='ctl00_ContentPlaceHolder1_BrokerProductList_i1']//input")
    private WebElement prestigeV2_Chkbox ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_cmbPolicyFrequency_Input']")
    private WebElement policyFrequency_DD ;

    @FindBy(xpath = "//button[@class='rwzButton rwzNext']")
    private WebElement nextBtn ;

    @FindBy(xpath = "//span[contains(text(),'Open Quote')]")
    private WebElement openQuoteBtn ;

    @FindBy(xpath = "//li//span[text()='Cover']")
    private WebElement coverBtn ;

    @FindBy(xpath = "//li//span[contains(text(),'Add New Item')]")
    private WebElement addNewItemBtn ;

    @FindBy(xpath = "//input[@id='ctl00_txtSearch']")
    private WebElement search_Txt ;

    @FindBy(xpath = "//input[@id='btnSearch']")
    private WebElement searchBtn ;

    @FindBy(xpath = "//a[text()='Vukani Shembe (9609137884085)']")
    private WebElement clientResultName ;

    @FindBy(xpath = "(//span[@class='rtbButton'])[2]")
    private WebElement newQuoteBtn ;

    @FindBy(xpath = "//a[@class='rwPopupButton']")
    private WebElement popUpOkBtn ;

    @FindBy(xpath = "//span[text()='OK']")
    private WebElement popUpOkRateBtn ;




    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement collectionWindow2;

    @FindBy(xpath = "//iframe[@name='alert1748804661282']")
    WebElement warningFrame;

    @FindBy(xpath = "//div[@id='alert1748804661282_message']")
    WebElement warningmsg;

    @FindBy(xpath = "/html/body/form/div[6]/div[3]/div[2]/div/div[4]/div[2]/div/ul/li[2]/span")
    WebElement calculatePremiumBtn;

    @FindBy(xpath = "(//*[@id='ctl00_ContentPlaceHolder1_SectionToolbar']//span[@title='Add item to quote'])[1]")
    WebElement saveBtn;



    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement mainWindow;

    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_btnSave']")
    public WebElement premiumsaveBtn;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_btnOK']")
    public WebElement premiumokBtn;

    @FindBy(xpath = "//*[@id='RadWindowWrapper_ctl00_GenericPopup']//span[@title='Close']")
    WebElement closebtn;


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

    @FindBy(xpath = "//li//span[contains(text(),'Cyber Insurance')]")
    private WebElement cyberinsuranceCover ;

    @FindBy(xpath = "//li//span[contains(text(),'Trailer')]")
    private WebElement trailerCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Caravan')]")
    private WebElement caravanCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Vintage')]")
    private WebElement vintageCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Non-road vehicle')]")
    private WebElement nonRoadVehicleCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Legal Cost')]")
    private WebElement legalCostCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Personal Liability')]")
    private WebElement PersonalLiabilityCover ;

    @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Personal Accident')]")
    private WebElement PersonalAccidentCover ;

   // @FindBy(xpath = "//span[@class='rtsTxt' and contains(text(), 'Non-road vehicle')]")
    //  private WebElement nonRoadVehicleCover ;





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

    public void clickCloseBtn(){
        if (verifyElement.verifyBrowserElementValue(closebtn, "Close button") == 0) {
            verifyElement.clickElement(closebtn,"Close button");
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

    public void clickpremiumsaveBtn(){
        if (verifyElement.verifyBrowserElementValue(premiumsaveBtn, "Save") == 0) {
            verifyElement.clickElement(premiumsaveBtn, "Save");
        }
    }

    public void clickpremiumsokBtn(){
        if (verifyElement.verifyBrowserElementValue(premiumokBtn, "ok") == 0) {
            verifyElement.clickElement(premiumokBtn, "ok");
        }
    }

    public void clickOpenQuote() {

        if (verifyElement.verifyBrowserElementValue(openQuoteBtn, "Open Quote") == 0) {
            verifyElement.clickElement(openQuoteBtn, "Open Quote");
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

    public void clickNonRoadVehicleCover() {

        if (verifyElement.verifyBrowserElementValue(nonRoadVehicleCover, "Non Road Vehicle Cover") == 0) {
            verifyElement.clickElement(nonRoadVehicleCover,"Non Road Vehicle Cover");
        }
    }

    public void clickCyberinsuranceCover() {

        if (verifyElement.verifyBrowserElementValue(cyberinsuranceCover, "Cyber Insurance Cover") == 0) {
            verifyElement.clickElement(cyberinsuranceCover,"Cyber Insurance Cover");
        }
    }

    public Object clickCaravanCover() {

        if (verifyElement.verifyBrowserElementValue(caravanCover, "Caravan Cover") == 0) {
            verifyElement.clickElement(caravanCover,"Caravan Cover");
        }
        return null;
    }

    public void clickTrailerCover() {

        if (verifyElement.verifyBrowserElementValue(trailerCover, "Trailer Cover") == 0) {
            verifyElement.clickElement(trailerCover,"Trailer Cover");
        }
    }

    public void clickVintageCover() {

        if (verifyElement.verifyBrowserElementValue(vintageCover, "Vintage Cover") == 0) {
            verifyElement.clickElement(vintageCover,"Vintage Cover");
        }
    }

    public void clickPersonalLiabilityCover() {

        if (verifyElement.verifyBrowserElementValue(PersonalLiabilityCover, "Personal liability Cover") == 0) {
            verifyElement.clickElement(PersonalLiabilityCover,"Personal liability Cover");
        }
    }

    public void clickPersonalAccidentCover() {

        if (verifyElement.verifyBrowserElementValue(PersonalAccidentCover, "Personal Accident Cover") == 0) {
            verifyElement.clickElement(PersonalAccidentCover,"Personal Accident Cover");
        }
    }

    public void clickLegalCostCover() {

        if (verifyElement.verifyBrowserElementValue(legalCostCover, "Legal Cost Cover") == 0) {
            verifyElement.clickElement(legalCostCover,"Legal Cost Cover");
        }
    }

    public void selectOption(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//li[@class='rcbItem' and contains(normalize-space(.),'" + option +"')]"));;
      //  WebElement item = BrowserDriver.findElement(By.xpath("//li[contains(normalize-space(text()), '" + option +"')]"));;
   //     WebDriverWait wait = new WebDriverWait(BrowserDriver, 200);
     //   wait.until(ExpectedConditions.elementToBeClickable(item));
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {

            verifyElement.clickElement(item, option);
        }
        else
        {
            System.err.println("Element"+ option+"couldnt be found " );
        }
    }

    public void selectOptionradiobox(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//label[contains(text(),'" + option +"')]"));;
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {

            verifyElement.clickElement(item, option);
        }
        else
        {
            System.err.println("Element"+ option+"couldnt be found " );
        }
    }
    public void selectOptionExcess(String option){
        WebElement item = BrowserDriver.findElement(By.xpath("//div[@class='rcbScroll rcbWidth']//ul[@class='rcbList']//li[contains(text(),'"+option+"')]"));;
        if(verifyElement.verifyBrowserElementValue(item, option) == 0)
        {

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

    public void changeWarningFrame() {

        verifyElement.switchToBrowserFrame(warningFrame,  "Switch focus to pop up frame");

    }


    public void premiumsaveBtn() {
    }
}
