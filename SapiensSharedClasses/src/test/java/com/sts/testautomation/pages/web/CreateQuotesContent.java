package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateQuotesContent {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public CreateQuotesContent(WebDriver browserDriver, String Device) {
        BrowserDriver = browserDriver;
        this.Device = Device;
        verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    //Reusable List Elements

    @FindBy(xpath = "//body")
    WebElement clickOnSpaceElement;

    public void clickOnSpace() {
        verifyElement.clickElement(clickOnSpaceElement, "Click on space");
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_MainMenu\"]/ul/li[3]/span")
    WebElement quotationElement;

    public void hoverOverQuotationElement() {
        verifyElement.hoverBrowserElement(quotationElement, "Hover over quotation element"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_MainMenu\"]/ul/li[3]/div/ul/li[1]/a")
    WebElement addNewQuoteBtn;

    public void clickAddNewQuote() {
        verifyElement.clickElement(addNewQuoteBtn, "Click add new quote button"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstBroker_ctl00__1\"]/td[2]")
    WebElement concourseItBroker;

    public void clickBroker() {
        verifyElement.clickElement(concourseItBroker, "Click Concourse IT button"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_WizCreateQuote\"]/div[2]/ul/li[3]/button")
    WebElement nextBtn; 

    public void clickOnNextBtn() {
        verifyElement.clickElement(nextBtn, "Click Next button"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_BrokerProductList_i6\"]/label/input")
    WebElement privatePortfolioCheckbx;

    public void clickOnPrivatePortfolioCheckbx() {
        verifyElement.clickElement(privatePortfolioCheckbx, "Click private portfolio check box"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSearch\"]")
    WebElement clickSearchBtn;

    public void clickOnSearchBtn() {
        verifyElement.clickElement(clickSearchBtn, "Click clickSearchBtn"); 
    }
    
    @FindBy(xpath = "//*[@id=\"RadWindowWrapper_alert1720164918467\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li/a")
    WebElement clickCloseAlert;

    public void clickCloseAlertBtn() {
        verifyElement.clickElement(clickCloseAlert, "Click clickCloseAlert"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_QuoteList_ctl00_ctl04_LoadQuoteImage\"]")
    WebElement clickEditQuote;

    public void clickEditQuote() {
        verifyElement.clickElement(clickEditQuote, "Click clickEditQuote"); 
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstClientResults_ctl00_ctl04_btnClient\"]")
    WebElement clickOnClient;

    public void clickOnClientBtn() {
        verifyElement.clickElement(clickOnClient, "Click clickOnClient"); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_txtSearchTerm\"]")
    WebElement clientSearch; 

    public void enterClientSearch(String ClientSearch) {
        verifyElement.sendKeysSapiens(clientSearch, "Enter clientSearch text box", ClientSearch); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_firstname\"]")
    WebElement clientFirstName; 

    public void enterClientFirstNameTxtBx(String firstName) {
        verifyElement.sendKeysSapiens(clientFirstName, "Enter first name text box", firstName); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_lastname\"]")
    WebElement clientLastName; 

    public void enterClientLastNameTxtBx(String lastName) {
        verifyElement.sendKeysSapiens(clientLastName, "Enter last name text box", lastName); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_identification\"]")
    WebElement clientIdentification; 

    public void enterClientIdentification(String identification) {
        verifyElement.sendKeysSapiens(clientIdentification, "Enter identification box", identification); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_employmentstatus_Input\"]")
    WebElement EmploymentStatus; 

    public void enterEmploymentStatus(String employmentStatus) {
        verifyElement.sendKeysSapiens(EmploymentStatus,  "Select employment drop down", employmentStatus); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_language_Input\"]")
    WebElement Language; 

    public void enterLanguage(String language) {
        verifyElement.sendKeysSapiens(Language,  "Select language drop down", language); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_maritalstatus_Input\"]")
    WebElement MaritalStatus; 

    public void enterMaritalStatus(String maritalStatus) {
        verifyElement.sendKeysSapiens(MaritalStatus,  "Select marital status drop down", maritalStatus);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_occupation_Input\"]")
    WebElement Occupation; 

    public void enterOccupation(String occupation) {
        verifyElement.sendKeysSapiens(Occupation,  "Select occupation drop down", occupation);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_txtLine1\"]")
    				
    WebElement complexAddress; 

    public void enterComplex(String complex) {
        verifyElement.sendKeysSapiens(complexAddress,  "Enter complex", complex);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_txtLine2\"]")
    WebElement buildingAddress; 

    public void enterBuilding(String building) {
        verifyElement.sendKeysSapiens(buildingAddress,  "Enter building", building);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_txtStreet\"]")
    WebElement street; 

    public void enterStreet(String Street) {
        verifyElement.sendKeysSapiens(street,  "Enter street ", Street);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_txtTownCity\"]")
    WebElement City; 

    public void enterCity(String city) {
        verifyElement.sendKeysSapiens(City,  "Enter city", city);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_lstSuburb_Input\"]")
    WebElement PostalCode; 

    public void enterPostalCode(String postalCode) {
        verifyElement.sendKeysSapiens(PostalCode,  "Enter postal Code", postalCode);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_lstSuburb_ClientState\"]")
    WebElement postalCodeClick; 

    public void clickPostalCode() {
        verifyElement.clickElement(postalCodeClick,  "Click postal Code");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddress_lstProvince_Input\"]")
    WebElement Province; 

    public void enterProvince(String province) {
        verifyElement.sendKeysSapiens(Province,  "Enter postal Code", province);    
        		
    }
    
    //ADDRESS FOR BUILDING TWO
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddressControl_txtLine1\"]")
	
    WebElement complexAddress2; 

    public void enterComplex2(String complex) {
        verifyElement.sendKeysSapiens(complexAddress2,  "Enter complex2", complex);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddressControl_txtLine2\"]")
    WebElement buildingAddress2; 

    public void enterBuilding2(String building) {
        verifyElement.sendKeysSapiens(buildingAddress2,  "Enter building2", building);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddressControl_txtStreet\"]")
    WebElement street2; //*[@id="ctl00_ContentPlaceHolder1_ucAddressControl_txtStreet"]

    public void enterStreet2(String Street) {
        verifyElement.sendKeysSapiens(street2,  "Enter street2 ", Street);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddressControl_txtTownCity\"]")
    WebElement City2; 

    public void enterCity2(String city) {
        verifyElement.sendKeysSapiens(City2,  "Enter city2", city);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucAddressControl_lstSuburb_Input\"]")
    WebElement PostalCode2; 

    public void enterPostalCode2(String postalCode) {
        verifyElement.sendKeysSapiens(PostalCode2,  "Enter postal Code2", postalCode);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Address_Input\"]")
    WebElement selectAddress; 

    public void enterNewAddress(String SelectAddress) {
        verifyElement.sendKeysSapiens(selectAddress,  "selectAddress", SelectAddress);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement addNewAddress; 

    public void clickAddNewAddress() {
        verifyElement.clickElement(addNewAddress,  "clickAddNewAddress");    
        		
    }
    
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[3]/span")
    WebElement openQuote; 

    public void clickOpenQuote() {
        verifyElement.clickElement(openQuote,  "Click Open quote");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_QuoteTabStrip\"]/div/ul/li[6]/span")
    WebElement cover; 

    public void clickCover() {
        verifyElement.clickElement(cover,  "Click cover ");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[2]/span")
    
    WebElement building; 

    public void clickBuilding() {
        verifyElement.clickElement(building,  "Click building");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[4]/span")
    WebElement addNewItem; 

    public void clickAddNewItem() {
        verifyElement.clickElement(addNewItem,  "Click add new item ");    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[6]/span")
    WebElement changeCollectionFrequency; 

    public void clickChangeCollectionFrequency() {
        verifyElement.clickElement(changeCollectionFrequency,  "Click change collection frequency");    
        		
    }  
    
   
    
    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement collectionWindow2; 

    public void changeFocus2() {
        
    	verifyElement.switchToBrowserFrame(collectionWindow2,  "Switch focus to pop up frame");    
        		
    } 
    
    @FindBy(xpath = "//iframe[@name='SelectAddress']")
    WebElement addressWindow; 

    public void changeFocusAddressWindow() {
        
    	verifyElement.switchToBrowserFrame(addressWindow,  "Switch focus to pop up frame");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"RadWindowWrapper_alert1720166351268\"]/table/tbody/tr[2]/td[2]")
    WebElement alertWindow; 

    public void changeFocusToAlert() {
        
    	verifyElement.switchToBrowserFrame(alertWindow,  "Switch focus to pop up frame");    
        		
    } 
    
    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement mainWindow; 

    public void changeFocusToBrowser() {
        
    	verifyElement.switchOutOfBrowserFrame();
        		
    } 
    
  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_cmbPolicyFrequency_Input\"]")
    WebElement collectionFrequency; 

    public void enterCollectionFrequency(String CollectionFrequency) {
        verifyElement.sendKeysSapiens(collectionFrequency,  "select  collection frequency", CollectionFrequency);    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_cmbPolicyFrequency_DropDown\"]/div/ul/li[3]")
    WebElement SelectMonthlyCollectionFrequency; 

    public void selectMonthlyCollectionFrequency() {
        verifyElement.clickElement(SelectMonthlyCollectionFrequency,  "select monthly collection frequency");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_btnAddress\"]")
    WebElement newAddress; 

    public void clickOnNewAddress() {
        verifyElement.clickElement(newAddress,  "Click on newAddress");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement collectionFrequencySave; 

    public void clickSaveCollectionFrequency() {
        verifyElement.clickElement(collectionFrequencySave,  "Click save collection frequency");    
        		
    }  
    
    
    //Building info
    
    @FindBy(xpath = "//*[@id=\"ctl00_GenericPopup_C\"]")
    WebElement buildingsWindow; 

    public void focusBuildingWindow() {
        verifyElement.switchToBrowserFrame(buildingsWindow, "Focus on buildings window");
        
    }  
    
    @FindBy(xpath = "//*[@id=\"RadWindowWrapper_ctl00_GenericPopup\"]/div[1]/div/ul/li[1]/span")
    WebElement itemDetails; 

    public void focusBuildingWindow2() {
        verifyElement.clickElement(buildingsWindow, "Focus on buildings window");
        
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_PropertySumInsured\"]")
    WebElement propertySumInsured; 

    public void enterPropertySumInsured(String PropertySumInsured) {
        verifyElement.sendKeysSapiens(propertySumInsured,  "Enter property sum insured", PropertySumInsured);    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_PropertyType_Input\"]")
    WebElement typeOfHome; 

    public void enterTypeOfHome(String TypeOfHome) {
        verifyElement.sendKeysSapiens(typeOfHome,  "TypeOfHome", TypeOfHome);    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input\"]")
    WebElement roofType; 

    public void enterTypeOfRoof(String RoofType) {
        verifyElement.sendKeysBrowserElementJavascript(roofType,  "RoofType", RoofType);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_WallType_Input\"]")
    WebElement wallType; 

    public void enterTypeOfWall(String WallType) {
        verifyElement.sendKeysBrowserElementJavascript(wallType,  "typeOfWall", WallType);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2661_Input\"]")
    WebElement basicExcess; 

    public void enterBasicExcess(String BasicExcess) {
        verifyElement.sendKeysBrowserElementJavascript(basicExcess,  "basicExcess", BasicExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2662_Input\"]")
    WebElement voluntaryExcess; 

    public void enterVoluntaryExcess(String VoluntaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(voluntaryExcess,  "voluntaryExcess", VoluntaryExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2684\"]")
    WebElement compulsaryExcess; 

    public void enterCompulsaryExcess(String CompulsaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(compulsaryExcess,  "compulsaryExcess", CompulsaryExcess);    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2613_Input\"]")
    WebElement zeroToTwelveMonthsClaims; 

    public void enterZeroToTwelveMonthsClaims(String ZeroToTwelveMonthsClaims) {
        verifyElement.sendKeysSapiens(zeroToTwelveMonthsClaims,  "zeroToTwelveMonthsClaims", ZeroToTwelveMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2614_Input\"]")
    WebElement thirteenToTwentyFourMonthsClaims; 

    public void enterThirteenToTwentyFourMonthsClaims(String ThirteenToTwentyFourMonthsClaims) {
        verifyElement.sendKeysSapiens(thirteenToTwentyFourMonthsClaims,  "ThirteenToTwentyFourMonthsClaims", ThirteenToTwentyFourMonthsClaims);    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2615_Input\"]")
    WebElement twentyFiveToThirtySixMonthsClaims; 

    public void enterTwentyFiveToThirtySixMonthsClaims(String TwentyFiveToThirtySixMonthsClaims) {
        verifyElement.sendKeysSapiens(twentyFiveToThirtySixMonthsClaims,  "twentyFiveToThirtySixMonthsClaims", TwentyFiveToThirtySixMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_2692_Input\"]")
    WebElement financialInstitution; 

    public void enterFinancialInstitution(String FinancialInstitution) {
        verifyElement.sendKeysSapiens(financialInstitution,  "financialInstitution", FinancialInstitution);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_5353\"]")
    WebElement registeredOwner; 

    public void enterRegisteredOwner(String RegisteredOwner) {
    	verifyElement.scrollToElementBrowser(registeredOwner);	
    	verifyElement.sendKeysBrowserElementJavascript(registeredOwner,  "registeredOwner", RegisteredOwner);    
        
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension92\"]/span")
    WebElement accidentalBuildingsDamageCover; 

    public void clickAccidentalBuildingsCover() {
        verifyElement.clickElement(accidentalBuildingsDamageCover,  "accidentalBuildingsDamageCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"92lstExtensionSumInsured92_Input\"]")
    WebElement accidentalBuildingsCoverSumInsured; 

    public void enterAccidentalBuildingsCoverSumInsured(String ACCDAM_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(accidentalBuildingsCoverSumInsured,  "accidentalBuildingsCoverSumInsured", ACCDAM_sumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension93\"]/span")
    WebElement accidentalDamageFixedCover; 

    public void clickAccidentalFixedCover() {
        verifyElement.clickElement(accidentalDamageFixedCover,  "accidentalDamageFixedCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension94\"]/span")
    WebElement geyserCover; 

    public void clickGeyserCover() {
        verifyElement.clickElement(geyserCover,  "geyserCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension95\"]/span")
    WebElement Keys; 

    public void clickKeysCover() {
        verifyElement.clickElement(Keys,  "Keys");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension91\"]/span")
    WebElement powerSurge; 

    public void clickPowerSurgeCover() {
        verifyElement.clickElement(powerSurge,  "Keys");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"91lstExtensionSumInsured91_Input\"]")
    WebElement powerSurgeSumInsured; 

    public void enterPowerSurgeSumInsured(String PSURGE_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(powerSurgeSumInsured,  "powerSurgeSumInsured", PSURGE_sumInsured);    
        		
    }

    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_SectionToolbar\"]/ul/li[1]/span")
    WebElement saveBuilding; 

    public void clickSaveBuilding() {
        verifyElement.clickElement(saveBuilding,  "ThirteenToTwentyFourMonthsClaims");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[2]/span")
    WebElement calculatePremium; 

    public void clickCalculatePremiums() {
        verifyElement.clickElement(calculatePremium,  "calculatePremium");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement savePremium; 

    public void clickSavePremium() {
        verifyElement.clickElement(savePremium,  "savePremium");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__0\"]/td[7]")
    WebElement finalPremium; 

    public String finalPremium() {
        String premium = finalPremium.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucDetails_detailsPanelBar\"]/ul/li[1]/div/div/div[1]/div/div[1]/div/strong")
    WebElement quoteNumber; 

    public String quoteNumber() {
        String quote = quoteNumber.getText()  ;  
        	return quote;	
    } 
    
}
    
    
    
    
    
    
    
   