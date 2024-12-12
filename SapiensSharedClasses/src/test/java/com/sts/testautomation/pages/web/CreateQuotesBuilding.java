package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateQuotesBuilding {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public CreateQuotesBuilding(WebDriver browserDriver, String Device) {
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
    
    @FindBy(xpath = "//*[@id=\"alert1723530969057_content\"]/div/div[2]/a")
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
        verifyElement.sendKeys(Language,  "Select language drop down", language); 
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_maritalstatus_Input\"]")
    				
    WebElement MaritalStatus; 

    public void enterMaritalStatus(String maritalStatus) {
        verifyElement.selectorOptionPicker(MaritalStatus,  "Select marital status drop down", maritalStatus);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucDynamicQuestionsPerson_maritalstatus_Input\"]")
	
    WebElement updateMaritalStatus; 

    public void enterMaritalStatusUpdate(String maritalStatus) {
        verifyElement.sendKeys(updateMaritalStatus,  "Select marital status drop down", maritalStatus);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_occupation_Input\"]")
    WebElement Occupation; 

    public void enterOccupation(String occupation) {
        verifyElement.sendKeysSapiens(Occupation,  "Select occupation drop down", occupation);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucDynamicQuestionsPerson_employmentstatus_Input\"]")
    WebElement OccupationUpdate; 

    public void enterOccupationUpdate(String occupation) {
        verifyElement.sendKeys(OccupationUpdate,  "Select occupation drop down", occupation);    
        		
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
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_QuoteTabStrip\"]/div/ul/li[5]/span")
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
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement saveClientDetails; 

    public void clickSaveClientDetails() {
        verifyElement.clickElement(saveClientDetails,  "Click saveClientDetailsy");    
        		
    }  
    
   
    
    @FindBy(xpath = "//iframe[@name='GenericPopup']")
    WebElement collectionWindow2; 

    public void changeFocus2() {
        
    	verifyElement.switchToBrowserFrame(collectionWindow2,  "Switch focus to pop up frame");    
        		
    } 
    
   
    
    
    @FindBy(xpath = "//iframe[@name='SelectPerson']")
    WebElement driverWindow; 

    public void changeToDriverWindow() {
        
    	verifyElement.switchToBrowserFrame(driverWindow,  "Switch focus to pop up frame");    
        		
    } 
    
    @FindBy(xpath = "//iframe[@name='SelectVehicle']")
    WebElement carSelectionWindow; 

    public void changeFocusToCarSelectection() {
        
    	verifyElement.switchToBrowserFrame(carSelectionWindow,  "Switch focus to pop up frame");    
        		
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
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_cmbExistingClients_Input\"]")
    WebElement chooseDriver; 

    public void enterDriver(String motorDriver) {
        verifyElement.sendKeysSapiens(chooseDriver,  "select  motorDriver ", motorDriver);    
        		
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
        verifyElement.sendKeysBrowserElementJavascript(typeOfHome,  "TypeOfHome", TypeOfHome);    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8935_Input\"]")
    WebElement locality; 

    public void enterLocality(String Locality) {
        verifyElement.sendKeysSapiens(locality,  "locality", Locality);    
        		
    }  
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input\"]")
    WebElement roofType; 

    public void enterTypeOfRoof(String RoofType) {
        verifyElement.sendKeysBrowserElementJavascript(roofType,  "RoofType", RoofType);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8975_Input\"]")
    WebElement coverTypeContent; 

    public void enterCoverTypeContent(String CoverTypeContent) {
        verifyElement.sendKeysBrowserElementJavascript(coverTypeContent,  "CoverTypeContent", CoverTypeContent);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_Input\"]")
    WebElement roofTypeContentDropDown; 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_RoofType_DropDown\"]/div/ul/li[10]")
    WebElement roofTypeContentDropDownSelection; 

    public void enterTypeOfRoofContents(String RoofType) {
        verifyElement.clickElement(roofTypeContentDropDown, "Roof type");
        
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_WallType_Input\"]")
    WebElement wallType; 

    public void enterTypeOfWall(String WallType) {
        verifyElement.sendKeysBrowserElementJavascript(wallType,  "typeOfWall", WallType);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8933_Input\"]")
    WebElement basicExcess; 

    public void enterBasicExcess(String BasicExcess) {
        verifyElement.sendKeysBrowserElementJavascript(basicExcess,  "basicExcess", BasicExcess);    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9026_Input\"]")
    WebElement basicExcessMotor; 

    public void enterBasicExcessMotor(String BasicExcess) {
        verifyElement.sendKeysWithClear(basicExcessMotor,  "basicExcessMotor", BasicExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8974_Input\"]")
    WebElement basicExcessContents; 

    public void enterBasicExcessContents(String BasicExcess) {
        verifyElement.sendKeysBrowserElementJavascript(basicExcessContents,  "basicExcess", BasicExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9024_Input\"]")
    WebElement voluntaryExcessMotor; 

    public void enterVoluntaryExcessMotor(String VoluntaryExcess) {
        verifyElement.sendKeysWithClear(voluntaryExcessMotor,  "voluntaryExcess", VoluntaryExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8934_Input\"]")
    WebElement voluntaryExcess; 

    public void enterVoluntaryExcess(String VoluntaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(voluntaryExcess,  "voluntaryExcess", VoluntaryExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8973_Input\"]")
    WebElement voluntaryExcessContents; 

    public void enterVoluntaryExcessContents(String VoluntaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(voluntaryExcessContents,  "voluntaryExcess", VoluntaryExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8940\"]")
    WebElement compulsaryExcess; 

    public void enterCompulsaryExcess(String CompulsaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(compulsaryExcess,  "compulsaryExcess", CompulsaryExcess);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8956\"]")
    WebElement compulsaryExcessContents; 

    public void enterCompulsaryExcessContents(String CompulsaryExcess) {
        verifyElement.sendKeysBrowserElementJavascript(compulsaryExcessContents,  "compulsaryExcess", CompulsaryExcess);    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8921_Input\"]")
    WebElement zeroToTwelveMonthsClaims; 

    public void enterZeroToTwelveMonthsClaims(String ZeroToTwelveMonthsClaims) {
        verifyElement.sendKeysBrowserElementJavascript(zeroToTwelveMonthsClaims,  "zeroToTwelveMonthsClaims", ZeroToTwelveMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8957_Input\"]")
    WebElement zeroToTwelveMonthsClaimsContents; 

    public void enterZeroToTwelveMonthsClaimsContents(String ZeroToTwelveMonthsClaims) {
        verifyElement.sendKeysBrowserElementJavascript(zeroToTwelveMonthsClaimsContents,  "zeroToTwelveMonthsClaims", ZeroToTwelveMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8922_Input\"]")
    WebElement thirteenToTwentyFourMonthsClaims; 

    public void enterThirteenToTwentyFourMonthsClaims(String ThirteenToTwentyFourMonthsClaims) {
        verifyElement.sendKeysBrowserElementJavascript(thirteenToTwentyFourMonthsClaims,  "ThirteenToTwentyFourMonthsClaims", ThirteenToTwentyFourMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8958_Input\"]")
    WebElement thirteenToTwentyFourMonthsClaimsContents; 

    public void enterThirteenToTwentyFourMonthsClaimsContents(String ThirteenToTwentyFourMonthsClaims) {
        verifyElement.sendKeysSapiens(thirteenToTwentyFourMonthsClaimsContents,  "ThirteenToTwentyFourMonthsClaims", ThirteenToTwentyFourMonthsClaims);    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8923_Input\"]")
    WebElement twentyFiveToThirtySixMonthsClaims; 

    public void enterTwentyFiveToThirtySixMonthsClaims(String TwentyFiveToThirtySixMonthsClaims) {
        verifyElement.sendKeysBrowserElementJavascript(twentyFiveToThirtySixMonthsClaims,  "twentyFiveToThirtySixMonthsClaims", TwentyFiveToThirtySixMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8959_Input\"]")
    WebElement twentyFiveToThirtySixMonthsClaimsContents; 

    public void enterTwentyFiveToThirtySixMonthsClaimsContents(String TwentyFiveToThirtySixMonthsClaims) {
        verifyElement.sendKeysBrowserElementJavascript(twentyFiveToThirtySixMonthsClaimsContents,  "twentyFiveToThirtySixMonthsClaims", TwentyFiveToThirtySixMonthsClaims);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8948_Input\"]")
    WebElement financialInstitution; 

    public void enterFinancialInstitution(String FinancialInstitution) {
        verifyElement.sendKeysSapiens(financialInstitution,  "financialInstitution", FinancialInstitution);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8952\"]")
    WebElement registeredOwner; 

    public void enterRegisteredOwner(String RegisteredOwner) {
    	verifyElement.scrollToElementBrowser(registeredOwner);	
    	verifyElement.sendKeysBrowserElementJavascript(registeredOwner,  "registeredOwner", RegisteredOwner);    
        
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3455\"]/span")
    WebElement accidentalBuildingsDamageCover; 

    public void clickAccidentalBuildingsCover() {
        verifyElement.clickElement(accidentalBuildingsDamageCover,  "accidentalBuildingsDamageCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3463\"]/span")
    WebElement accidentalDamageCoverContents; 

    public void clickAccidentalCoverContents() {
       verifyElement.scrollToElementBrowser(accidentalDamageCoverContents);
    	verifyElement.clickElement(accidentalDamageCoverContents,  "accidentalBuildingsDamageCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"3463lstExtensionSumInsured3463_Input\"]")
    WebElement accidentalCoverContentsSumInsured; 

    public void enterAccidentalCoverContentsSumInsured(String ACCDAM_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(accidentalCoverContentsSumInsured,  "accidentalBuildingsCoverSumInsured", ACCDAM_sumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"3455lstExtensionSumInsured3455_Input\"]")
    WebElement accidentalBuildingsCoverSumInsured; 

    public void enterAccidentalBuildingsCoverSumInsured(String ACCDAM_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(accidentalBuildingsCoverSumInsured,  "accidentalBuildingsCoverSumInsured", ACCDAM_sumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"txtExtensionSumInsured3465\"]")
    WebElement bedAndBreakfastSumInsured; 

    public void enterBedAndBreakfastSumInsured(String ACCDAM_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(bedAndBreakfastSumInsured,  "bedAndBreakfastSumInsured", ACCDAM_sumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"3468lstExtensionSumInsured3468_Input\"]")
    WebElement powerSurgeContentsSumInsured; 

    public void enterPowerSurgeContentsSumInsured(String ACCDAM_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(powerSurgeContentsSumInsured,  "powerSurgeContentsSumInsured", ACCDAM_sumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension3468\"]/span")
    WebElement powerSurgeContents; 

    public void clickPowerSurgeContents() {
        verifyElement.scrollToElementBrowser(powerSurgeContents);
    	verifyElement.clickElement(powerSurgeContents,  "powerSurgeContents");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3469\"]/span")
    WebElement subsidenceContents; 

    public void clickSubsidenceContents() {
        verifyElement.clickElement(subsidenceContents,  "subsidenceContents");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3456\"]/span")
    WebElement accidentalDamageFixedCover; 

    public void clickAccidentalFixedCover() {
        verifyElement.clickElement(accidentalDamageFixedCover,  "accidentalDamageFixedCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3464\"]/span")
    WebElement accidentalDamageInsideCover; 

    public void clickAccidentalInsideCover() {
        verifyElement.clickElement(accidentalDamageInsideCover,  "accidentalDamageInsideCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3465\"]/span")
    WebElement bedAndBreakfast; 

    public void clickBedAndBreakfast() {
        verifyElement.clickElement(bedAndBreakfast,  "bedAndBreakfast");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3466\"]/span")
    WebElement homeBasedBusinessStock; 

    public void clickHomeBasedBusinessStock() {
        verifyElement.clickElement(homeBasedBusinessStock,  "homeBasedBusinessStock");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3467\"]/span")
    WebElement keysContents; 

    public void clickKeysContents() {
        verifyElement.clickElement(keysContents,  "homeBasedBusinessStock");    
        		
    } 

    
    
    
    @FindBy(xpath = "//*[@id=\"chkExtension3457\"]/span")
    WebElement geyserCover; 

    public void clickGeyserCover() {
        verifyElement.clickElement(geyserCover,  "geyserCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3458\"]/span")
    WebElement Keys; 

    public void clickKeysCover() {
        verifyElement.clickElement(Keys,  "Keys");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3459\"]/span")
    WebElement powerSurge; 

    public void clickPowerSurgeCover() {
        verifyElement.clickElement(powerSurge,  "powerSurge");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8961\"]/span")
    WebElement burglarBars; 

    public void clickBurglarBars() {
        verifyElement.clickElement(burglarBars,  "burglarBars");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8962\"]/span")
    WebElement securityGates; 

    public void clickSecurityGates() {
        verifyElement.clickElement(securityGates,  "securityGates");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_HasElectricFence\"]/span")
    WebElement electricFence; 

    public void clickElectricFence() {
        verifyElement.clickElement(electricFence,  "electricFence");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8963\"]/span")
    WebElement highSecurityComplex; 

    public void clickHighSecurityComplex() {
        verifyElement.clickElement(highSecurityComplex,  "highSecurityComplex");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8964\"]/span")
    WebElement alarmLinked; 

    public void clickAlarmLinked() {
        verifyElement.clickElement(alarmLinked,  "alarmLinked");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"3459lstExtensionSumInsured3459_Input\"]")
    WebElement powerSurgeSumInsured; 

    public void enterPowerSurgeSumInsured(String PSURGE_sumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(powerSurgeSumInsured,  "powerSurgeSumInsured", PSURGE_sumInsured);    
        		
    }

    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_SectionToolbar\"]/ul/li[1]/span")
    WebElement saveBuilding; 

    public void clickSaveBuilding() {
        verifyElement.clickElement(saveBuilding,  "Click save risk");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[3]/span")
    WebElement saveExtensions; 

    public void clickSaveExtensionsAllRisk() {
        verifyElement.clickElement(saveExtensions,  "Click save extension");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li[2]/span")
    WebElement calculatePremium; 

    public void clickCalculatePremiums() {
        verifyElement.clickElement(calculatePremium,  "calculatePremium");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_RiskGrid.ascx_userControl_lstItemsOnQuote_ctl00_ctl04_btnEdit\"]")
    WebElement editItemDetails; 

    public void clickEditItem() {
        verifyElement.clickElement(editItemDetails,  "editItemDetails");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement savePremium; 

    public void clickSavePremium() {
        verifyElement.clickElement(savePremium,  "savePremium");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"RadWindowWrapper_ctl00_GenericPopup\"]/div[1]/div/ul/li[2]/span")
    WebElement closeRatingPop; 

    public void clickCloseRating() {
        verifyElement.clickElement(closeRatingPop,  "closeWarning");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__0\"]/td[7]")
    WebElement finalPremium; 

    public String finalPremium() {
        String premium = finalPremium.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"alert1731398125289_message\"]/ul/li")
    WebElement bbWarningText; 

    public String bbWarning() {
        String premium = bbWarningText.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__0\"]/td[5]")
    WebElement basePremiumPC; 

    public String basePremiumPC() {
        String premium = basePremiumPC.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__0\"]/td[7]")
    WebElement finalPremiumPC; 

    public String finalPremiumPC() {
        String premium = finalPremiumPC.getText()  ;  
        	return premium;	
    } 
    

    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__1\"]/td[7]]")
    WebElement finalPremiumCyber; 

    public String finalPremiumCyber() {
        String premium = finalPremiumCyber.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__1\"]/td[7]")
    WebElement finalPremium2; 

    public String finalPremium2() {
        String premium = finalPremium2.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__0\"]/td[5]")
    WebElement basePremium; 

    public String basePremium() {
        String premium = basePremium.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__2\"]/td[7]")
    WebElement finalPremium3; 

    public String finalPremium3() {
        String premium = finalPremium3.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucDetails_detailsPanelBar\"]/ul/li[1]/div/div/div[1]/div/div[1]/div/strong")
    WebElement quoteNumber; 

    public String quoteNumber() {
        String quote = quoteNumber.getText()  ;  
        	return quote;	
    } 
    
    
    
    //Content elements
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[3]/span")
    WebElement clickContent; 

    public void clickContents() {
        verifyElement.clickElement(clickContent,  "Click contents");    
        		
    } 
    
    
    //Motor elements
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[10]/span")
    WebElement motorBtn;
    public void clickMotor() {
        verifyElement.clickElement(motorBtn,  "Click motorBtn");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucVehicleLookup_VehicleLookupTabPage\"]/div/ul/li[1]/span")
    WebElement vehicleTab;
    public void clickVehicleTab() {
        verifyElement.clickElement(vehicleTab,  "Click vehicleTab");    
        		
    } 
    
    
    				
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ItemToolBar\"]/ul/li/span")
    WebElement selectVehicle;
    public void clickSelectVehicle() {
     
    	verifyElement.hoverBrowserElement(selectVehicle, "Hover over element");
        		
    }
    
    public void hoverSelectVehicle() {
        
    	verifyElement.clickBrowserElementJavascript(vehicleTab,  "Click selectVehicle");    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_btnMMCode\"]")
    WebElement change;
    public void clickChange() {
        verifyElement.clickElement(change,  "Click change");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlCondition_1\"]")
    WebElement conditionVeryGood;
    public void conditionVeryGood() {
        verifyElement.clickBrowserElementJavascript(conditionVeryGood,  "Click conditionVeryGood");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlCondition_0\"]")
    WebElement conditionExcellent;
    public void conditionExcellent() {
        verifyElement.clickBrowserElementJavascript(change,  "Click conditionExcellent");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlCondition_2\"]")
    WebElement conditionGood;
    public void conditionGood() {
        verifyElement.clickBrowserElementJavascript(conditionGood,  "Click conditionGood");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlCondition_3\"]")
    WebElement conditionPoor;
    public void conditionPoor() {
        verifyElement.clickBrowserElementJavascript(change,  "Click conditionPoor");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlCondition_4\"]")
    WebElement conditionVeryPoor;
    public void conditionVeryPoor() {
        verifyElement.clickBrowserElementJavascript(change,  "Click conditionExcellent");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlMileage_1\"]")
    WebElement mileageLow;
    public void mileageLow() {
        verifyElement.clickBrowserElementJavascript(mileageLow,  "Click mileageLow");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlMileage_2\"]")
    WebElement mileageAverage;
    public void mileageAverage() {
        verifyElement.clickBrowserElementJavascript(mileageAverage,  "Click mileageAverage");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlMileage_3\"]")
    WebElement mileageHigh;
    public void mileageHigh() {
        verifyElement.clickBrowserElementJavascript(mileageHigh,  "Click mileageHigh");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlMileage_0\"]")
    WebElement mileageVeryLow;
    public void mileageVeryLow() {
        verifyElement.clickBrowserElementJavascript(mileageVeryLow,  "Click mileageVeryLow");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_ucVehicleLookup_rlMileage_4\"]")
    WebElement mileageVeryHigh;
    public void mileageVeryHigh() {
        verifyElement.clickBrowserElementJavascript(mileageVeryHigh,  "Click mileageVeryHigh");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]")
    WebElement saveDriver;
    public void clickSaveDriver() {
        verifyElement.clickElement(saveDriver,  "Click change");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_QuoteTabStrip\"]/div/ul/li[2]/span")
    WebElement policyHolderTab;
    public void clickPolicyHolderTab() {
        verifyElement.clickElement(policyHolderTab,  "Click policyHolderTab");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucPolicyHolders_PersonList_ctl00_ctl04_btnEdit\"]")
    WebElement editPolicyHolder;
    public void clickEditPolicyHolder() {
        verifyElement.clickElement(editPolicyHolder,  "Click editPolicyHolder");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9500\"]/span")
    WebElement secondTrackingDevice;
    public void clickSecondTrackingDevice() {
        verifyElement.clickBrowserElementJavascript(secondTrackingDevice,  "Click secondTrackingDevice");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9489_Input\"]")
    WebElement secondTrackingDeviceType; 

    public void enterSecondTrackingDevice(String SecondTrackingDeviceType) {
        verifyElement.sendKeys(secondTrackingDeviceType,  "Enter 2ND tracking", SecondTrackingDeviceType);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9006_Input\"]")
    WebElement uninterruptedCover; 

    public void enterUninterruptedCover(String UninterruptedCover) {
        verifyElement.sendKeys(uninterruptedCover,  "Enter uninterruptedCover", UninterruptedCover);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8999_Input\"]")
    WebElement motorColour; 

    public void enterColour(String colour) {
        verifyElement.sendKeys(motorColour,  "Enter motor colour", colour);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_firstname\"]")
    WebElement driverFirstName; 

    public void enterDriverFirstName(String driverName) {
        verifyElement.sendKeysSapiens(driverFirstName,  "Enter driverName", driverName);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_firstname\"]")
    WebElement driverLastName; 

    public void enterDriverLastName(String driverName) {
        verifyElement.sendKeysSapiens(driverLastName,  "Enter driverLastName", driverName);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestionsPerson_identification\"]")
    WebElement driverIdentification; 

    public void enterDriverIdentification(String DriverIdentification) {
        verifyElement.sendKeysSapiens(driverIdentification,  "Enter DriverIdentification", DriverIdentification);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_cmbLicenseCode_Input\"]")
    WebElement driverLicenseCode; 

    public void enterDriverLicenseCode(String DriverLicenseCode) {
        verifyElement.sendKeysSapiens(driverLicenseCode,  "Enter driverLicenseCode", DriverLicenseCode);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_dtLicenseDate_dateInput\"]")
    WebElement driverLicenseDate; 

    public void enterDriverLicenseDate(String DriverLicenseDate) {
        verifyElement.sendKeysSapiens(driverLicenseDate,  "Enter DriverLicenseDate", DriverLicenseDate);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_cmbRelationshipType_Input\"]")
    WebElement driverRelationship; 

    public void enterDriverRelationship(String DriverRelationship) {
        verifyElement.sendKeysSapiens(driverRelationship,  "Enter driverRelationship", DriverRelationship);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucVehicleLookup_txtVehicleCode\"]")
    WebElement mmCode; 

    public void enterCarSearch(String MmCode) {
        verifyElement.sendKeysBrowserElementJavascript(mmCode,  "Enter motor mmCode", MmCode);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8996_Input\"]")
    WebElement carBody; 

    public void enterCarBodyType(String CarBody) {
        verifyElement.sendKeys(carBody,  "Enter carBody type", CarBody);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_basisofsettlement_Input\"]")
    WebElement basisOfSettlement; 

    public void enterBasisOfSettlement(String BasisOfSettlement) {
        verifyElement.sendKeysWithClear(basisOfSettlement,  "Enter basis of settlement", BasisOfSettlement);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Use_Input\"]")
    WebElement carUse; 

    public void enterCarUse(String CarUse) {
        verifyElement.sendKeys(carUse,  "Enter car use", CarUse);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_OvernightParking_Input\"]")
    WebElement overnightParking; 

    public void enterOvernightPark(String OvernightParking) {
        verifyElement.sendKeys(overnightParking,  "Enter OvernightParking", OvernightParking);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9007_Input\"]")
    WebElement zeroToTwelveMonthsClaimsMotor; 

    public void enterZeroToTwelveMonthsClaimsMotor(String ZeroToTwelveMonthsClaimsMotor) {
        verifyElement.sendKeys(zeroToTwelveMonthsClaimsMotor,  "Enter zeroToTwelveMonthsClaimsMotor", ZeroToTwelveMonthsClaimsMotor);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9008_Input\"]")
    WebElement thirteenToTwentyFourMonthsClaimsMotor; 

    public void enterThirteenToTwentyFourMonthsClaimsMotor(String ThirteenToTwentyFourMonthsClaimsMotor) {
        verifyElement.sendKeys(thirteenToTwentyFourMonthsClaimsMotor,  "Enter thirteenToTwentyFourMonthsClaimsMotor", ThirteenToTwentyFourMonthsClaimsMotor);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9009_Input\"]")
    WebElement twentyFiveToThirtySixMonthsClaimsMotor; 

    public void enterTwentyFiveToThirtySixMonthsClaimsMotor(String TwentyFiveToThirtySixMonthsClaimsMotor) {
        verifyElement.sendKeys(twentyFiveToThirtySixMonthsClaimsMotor,  "Enter TwentyFiveToThirtySixMonthsClaimsMotor", TwentyFiveToThirtySixMonthsClaimsMotor);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9010\"]")
    WebElement registeredOwnerMotor; 

    public void enterRegisteredOwnerMotor(String RegisteredOwner) {
        verifyElement.sendKeysBrowserElementJavascript(registeredOwnerMotor,  "Enter registeredOwnerMotor", RegisteredOwner);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9011\"]")
    WebElement registeredOwnerId; 

    public void enterRegisteredOwnerId(String RegisteredOwner) {
        verifyElement.sendKeysSapiens(registeredOwnerId,  "Enter registeredOwnerMotor", RegisteredOwner);    
        		
    }
    
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9014_Input\"]")
    WebElement firstTrackingDevice; 

    public void enterFirstTrackingDevice(String FirstTrackingDevice) {
       verifyElement.scrollToElementBrowser(firstTrackingDevice);
    	verifyElement.sendKeys(firstTrackingDevice,  "Enter firstTrackingDevice", FirstTrackingDevice);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_9488_Input\"]")
    WebElement firstTrackingDeviceType; 

    public void enterFirstTrackingDeviceType(String FirstTrackingDeviceType) {
      
    	verifyElement.sendKeys(firstTrackingDeviceType,  "Enter FirstTrackingDeviceType", FirstTrackingDeviceType);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_CoverType_Input\"]")
    WebElement coverTypeMotor; 

    public void enterCoverTypeMotor(String CoverType) {
        verifyElement.sendKeys(coverTypeMotor,  "Enter cover type", CoverType);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_OdometerReading\"]")
    WebElement odometerReading; 

    public void enterOdometerReading(String OdometerReading) {
        verifyElement.sendKeysBrowserElementJavascript(odometerReading,  "Enter odometerReading", OdometerReading);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucVehicleLookup_txtEnteredPrice\"]")
    WebElement motorValue; 

    public void enterMotorValue(String MotorValue) {
        verifyElement.sendKeysWithClear(motorValue,  "Enter motorValue", MotorValue);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"chkExtension3484\"]/span")
    WebElement extensionOfLiability; 

    public void clickExtensionOfLiability() {
        verifyElement.clickElement(extensionOfLiability,  "Click extensionOfLiability");    
        		
    } 
    
    
    @FindBy(xpath = "//*[@id=\"chkExtension3485\"]/span")
    WebElement keysMotor; 

    public void clickKeysMotor() {
        verifyElement.clickElement(keysMotor,  "Click keysMotor");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3486\"]/span")
    WebElement fourByFourCover; 

    public void clickFourByFour() {
        verifyElement.clickElement(fourByFourCover,  "Click fourByFourCover");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3487\"]/span")
    WebElement thirdPartyLiability; 

    public void clickThirdPartyLiability() {
        
    	verifyElement.scrollToElementBrowser(thirdPartyLiability);
    	verifyElement.clickBrowserElementJavascript(thirdPartyLiability,  "Click thirdPartyLiability");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"chkExtension3488\"]/span")
    WebElement tyreCover; 

    public void clickTyreCover() {
        verifyElement.clickElement(tyreCover,  "Click tyreCover");    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_AddOnControl804_chkSelectedNonStandard_9097\"]/span")
    WebElement carHire; 

    public void clickCarHire() {
       
    	verifyElement.clickBrowserElementJavascript(carHire,  "Click carHire");    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_AddOnControl805_chkSelectedNonStandard_9100\"]/span")
    WebElement payingOffVehicle; 

    public void clickPayingOfYourVehicle() {
        verifyElement.clickElement(payingOffVehicle,  "Click payingOffVehicle");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_AddOnControl805_NonStandard_9101_Input\"]")
    WebElement payingOffVehicleOptions; 

    public void enterPayingOffVehicleOptions(String PayingOffVehicleOptions) {
        verifyElement.sendKeysBrowserElementJavascript(payingOffVehicleOptions,  "Enter payingOffVehicleOptions", PayingOffVehicleOptions);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_AddOnControl804_NonStandard_9098_Input\"]")
    WebElement carHireOptions; 

    public void enterCarHireOptions(String CarHireOptions) {
        verifyElement.sendKeys(carHireOptions,  "Enter carHireOptions", CarHireOptions);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"3485lstExtensionSumInsured3485_Input\"]")
    WebElement keysSumInsured; 

    public void enterKeysSumInsured(String KeysSumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(keysSumInsured,  "Enter carHireOptions", KeysSumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"3487lstExtensionSumInsured3487_Input\"]")
    WebElement thirdPartySumInsured; 

    public void enterThirdPartySumInsured(String ThirdPartySumInsured) {
        verifyElement.sendKeys(thirdPartySumInsured,  "Enter thirdPartySumInsured", ThirdPartySumInsured);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_AddOnControl804_NonStandard_9099_Input\"]")
    WebElement carHireDays; 

    public void enterCarHireDays(String CarHireDays) {
        verifyElement.sendKeys(carHireDays,  "Click carHireDays", CarHireDays);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[3]/span")
    WebElement accidentTow; 

    public void clickAccidentTow() {
        verifyElement.clickElement(accidentTow,  "Click contents");    
        		
    } 
    
    

    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_SectionToolbar\"]/ul/li[3]/span")
    WebElement addDriver; 

    public void clickAddDriver() {
        verifyElement.clickElement(addDriver,  "Click addDriver");    
        		
    } 
    
    //Cyber elements
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[7]/span")
    WebElement cyber; 

    public void clickCyber() {
        verifyElement.clickElement(cyber,  "Click cyber");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8985\"]/span")
    WebElement includeSpouse; 

    public void clickIncludeSpouse() {
        verifyElement.clickElement(includeSpouse,  "Click includeSpouse");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8986\"]/span")
    WebElement includeChildren; 

    public void clickIncludeChildren() {
        verifyElement.clickElement(includeChildren,  "Click includeChildren");    
        		
    } 
    
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8984\"]/span")
    WebElement cyberPackage; 

    public void enterCyberPackage(String CyberPackage) {
        verifyElement.sendKeysWithClear(cyberPackage,  "Enter cyberPackage", CyberPackage);    
        		
    }
    
    
    //Personal Computer
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[5]/span")
    WebElement personalComputer; 

    public void clickPersonalComputer() {
        verifyElement.clickElement(personalComputer,  "Click personalComputer");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8979\"]")
    WebElement personalComputerSumInsured; 

    public void enterPersonalComputerSumInsured(String PersonalComputerSumInsured) {
        verifyElement.sendKeysSapiens(personalComputerSumInsured,  "enter personalComputerSumInsured", PersonalComputerSumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_AllRiskType_Input\"]")
    WebElement allRisksCategory; 

    public void enterAllRiskCategory(String AllRisksCategory) {
        verifyElement.sendKeysSapiens(allRisksCategory,  "enter allRiskCategory", AllRisksCategory);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Description\"]")
    WebElement makeDescription; 

    public void enterMakeDescription(String MakeDescription) {
        verifyElement.sendKeysBrowserElementJavascript(makeDescription,  "enter makeDescription", MakeDescription);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Manufacturer\"]")
    WebElement manufacturer; 

    public void enterManufacturer(String Manufacturer) {
        verifyElement.sendKeysBrowserElementJavascript(manufacturer,  "enter manufacturer", Manufacturer);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_SerialNumber\"]")
    WebElement serialNumber; 

    public void enterSerialNumber(String SerialNumber) {
        verifyElement.sendKeysBrowserElementJavascript(serialNumber,  "enter serialNumber", SerialNumber);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension3476\"]/span")
    WebElement electronicBreakdown; 

    public void clickElectricBreakdown() {
        verifyElement.clickElement(electronicBreakdown,  "Click electronicBreakdown");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"txtExtensionSumInsured3476\"]")
    WebElement electronicBreakdownSumInsured; 

    public void enterElectronicBreakdownSumInsured(String ElectronicBreakdownSumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(electronicBreakdownSumInsured,  "enter electronicBreakdownSumInsured", ElectronicBreakdownSumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension3477\"]/span")
    WebElement reinstatementOfData; 

    public void clickReinstatementOfData() {
        verifyElement.clickElement(reinstatementOfData,  "Click reinstatementOfData");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"txtExtensionSumInsured3477\"]")
    WebElement reinstatementOfDataSumInsured; 

    public void enterReinstatementOfDataSumInsured(String ReinstatementOfDataSumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(reinstatementOfDataSumInsured,  "enter reinstatementOfDataSumInsured", ReinstatementOfDataSumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension3478\"]/span")
    WebElement ensureCompatibility; 

    public void clickEnsureCompatibility() {
        verifyElement.clickElement(ensureCompatibility,  "Click ensureCompatibility");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"txtExtensionSumInsured3478\"]")
    WebElement ensureCompatibilitySuminsured; 

    public void enterEnsureCompatibilitySuminsured(String EnsureCompatibilitySuminsured) {
        verifyElement.sendKeysBrowserElementJavascript(ensureCompatibilitySuminsured,  "enter ensureCompatibilitySuminsured", EnsureCompatibilitySuminsured);    
        		
    }
    
    
    
    
    //All Risk
    

    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[4]/span")
    WebElement allRisk; 

    public void clickAllRisk() {
        verifyElement.clickElement(allRisk,  "Click allRisk");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"chkExtension3472\"]/span")
    WebElement remoteBlocker; 

    public void clickRemoteBlocker() {
        verifyElement.clickElement(remoteBlocker,  "Click remoteBlocker");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_AllRiskSumInsured\"]")
    WebElement allRiskSumInsured; 

    public void enterAllRiskSumInsured(String AllRiskSumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(allRiskSumInsured,  "enter allRiskSumInsured", AllRiskSumInsured);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_AllRiskType_Input\"]")
    WebElement allRiskCategoryAR; 
    public void enterAllRiskCategoryAR(String AllRiskCategoryAR) {
        verifyElement.sendKeysBrowserElementJavascript(allRiskCategoryAR,  "enter AllRiskCategoryAR", AllRiskCategoryAR);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Description\"]")
    WebElement makeDescriptionAR; 
    
    public void enterMakeDescriptionAR(String MakeDescriptionAR) {
        verifyElement.sendKeysBrowserElementJavascript(makeDescriptionAR,  "enter serialNumber", MakeDescriptionAR);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_Manufacturer\"]")
    WebElement manufacturerAR; 
    
    public void enterManufacturerAR(String ManufacturerAR) {
        verifyElement.sendKeysBrowserElementJavascript(manufacturerAR,  "enter ManufacturerAR", ManufacturerAR);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_SerialNumber\"]")
    WebElement serialNumberAR; 
    
    public void enterSerialNumberAR(String SerialNumberAR) {
        verifyElement.sendKeysBrowserElementJavascript(serialNumberAR,  "enter SerialNumberAR", SerialNumberAR);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__2\"]/td[5]")
    WebElement basePremiumAR; 

    public String basePremiumAR() {
        String premium = basePremiumAR.getText()  ;  
        	return premium;	
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_RateResultsGrid_ctl00__2\"]/td[7]")
    WebElement finalPremiumAR; 

    public String finalPremiumAR() {
        String premium = finalPremiumAR.getText()  ;  
        	return premium;	
    } 
    
    
    //personal liabilit7
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_ucCover_TabSections\"]/div/ul/li[6]/span")
    WebElement personalLiaibility; 

    public void clickPersonalLiability() {
        verifyElement.clickElement(personalLiaibility,  "Click personalLiaibility");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_DynamicQuestions1_itempanel_SumInsured\"]")
    WebElement personalLiaibilityClick; 

    public void clickPersonalLiabilityClick() {
        verifyElement.clickElement(personalLiaibility,  "Click personalLiaibilityClick");    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8980_Input\"]")
    WebElement personalLiabilitySumInsured; 
    
    public void enterPersonalLiabilitySumInsured(String PersonalLiabilitySumInsured) {
        verifyElement.sendKeysBrowserElementJavascript(personalLiabilitySumInsured,  "enter personalLiabilitySumInsured", PersonalLiabilitySumInsured);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8981_Input\"]")
    WebElement personalLiabilityBusinessLiability; 
    
    public void enterPersonalLiabilityBusinessLiability(String PersonalLiabilityBusinessLiability) {
        verifyElement.sendKeysBrowserElementJavascript(personalLiabilityBusinessLiability,  "enter personalLiabilityBusinessLiability", PersonalLiabilityBusinessLiability);    
        		
    }
    
    
    //Personal accident

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_DynamicQuestions1_itempanel_SumInsured\"]")
    WebElement personalAccidentClick; 

    public void clickPersonalAccident() {
        verifyElement.clickElement(personalAccidentClick,  "Click personalAccidentClick");    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_PersonInsured_Input\"]")
    WebElement personInsured; 
    
    public void enterPersonInsured(String PersonInsured) {
        verifyElement.sendKeysBrowserElementJavascript(personInsured,  "enter PersonInsured", PersonInsured);    
        		
    }
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8993\"]")
    WebElement death; 
    
    public void enterDeath(String Death) {
        verifyElement.sendKeysBrowserElementJavascript(death,  "enter death", Death);    
        		
    }
    
    
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8994\"]")
    WebElement disability; 
    
    public void enterDisability(String Disability) {
        verifyElement.sendKeysBrowserElementJavascript(disability,  "enter disability", Disability);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_8995_Input\"]")
    WebElement medicalBenefit; 
    
    public void enterMedicalBenefit(String MedicalBenefit) {
        verifyElement.sendKeysBrowserElementJavascript(medicalBenefit,  "enter medicalBenefit", MedicalBenefit);    
        		
    }
    
    @FindBy(xpath = "//*[@id=\"ctl00_txtSearch\"]")
    WebElement mainSearchTextBox; 

    public void enterTextToSearch(String MainSearchTextBox) {
        verifyElement.sendKeysBrowserElementJavascript(mainSearchTextBox,  "enter test to search", MainSearchTextBox);    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"btnSearch\"]")
    WebElement mainSearchButton; 

    public void clickMainSearchButton() {
        verifyElement.clickElement(mainSearchButton,  "Click search button");    
        		
    } 
    
    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstResults_ctl00_ctl04_hpHeader\"]")
    WebElement clickQuote; 

    public void clickQuote() {
        verifyElement.clickElement(clickQuote,  "Click clickQuote button");    
        		
    } 
    
    
}
    
    
    
    
    
    
    
   