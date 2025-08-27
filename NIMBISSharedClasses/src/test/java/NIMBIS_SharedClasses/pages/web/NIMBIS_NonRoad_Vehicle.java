package NIMBIS_SharedClasses.pages.web;

import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_NonRoad_Vehicle {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_NonRoad_Vehicle(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }

    //details

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_SumInsured']")
    private WebElement nonroadValue_Txt ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11091']")
    private WebElement vehicleType_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11093']")
    private WebElement classOfUse_DD ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11095']")
    private WebElement nonroadYear_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11092']")
    private WebElement nonroadMake_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11094']")
    private WebElement nonroadModel_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11096']")
    private WebElement nonroadRegisteredOwner_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11098]")
    private WebElement nonroadFinacialHouse_Txt ;

    @FindBy(xpath = "//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11097")
    private WebElement nonroadFinacialFianced_btn ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11099]")
    private WebElement nonroadBasisOfSettlement_DD ;

    @FindBy(xpath = "//div[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11098]")
    private WebElement nonroadCoinsured_DD ;

    //claims

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11100']")
    private WebElement nonroadclaims012_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11101']")
    private WebElement nonroadClaims324_Txt ;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_11102']")
    private WebElement nonroadClaims2536_Txt ;


    //details method

    public void enternonroadValue(String amount){
        if (verifyElement.verifyBrowserElementValue(nonroadValue_Txt, "Non road Sum Insured") == 0){
            verifyElement.sendKeys(nonroadValue_Txt,"Non road Insured",amount);
        }
    }

    public void enternonroadMake(String make){
        if (verifyElement.verifyBrowserElementValue(nonroadMake_Txt, "Non road Make") == 0){
            verifyElement.sendKeys(nonroadMake_Txt,"Non road Make",make);
        }
    }

    public void enternonroadYear(String year){
        if (verifyElement.verifyBrowserElementValue(nonroadYear_Txt, "Non road Year") == 0){
            verifyElement.sendKeys(nonroadYear_Txt,"Non road Year",year);
        }
    }

    public void enternonroadModel(String model){
        if (verifyElement.verifyBrowserElementValue(nonroadModel_Txt, "Non road Model") == 0){
            verifyElement.sendKeys(nonroadModel_Txt,"Non road Model",model);
        }
    }

    public void enternonroadRegisteredOwner(String owner){
        if (verifyElement.verifyBrowserElementValue(nonroadRegisteredOwner_Txt, "Non road Registered Owner") == 0){
            verifyElement.sendKeys(nonroadRegisteredOwner_Txt,"Non road Registered Owner",owner);
        }
    }

    public void enternonroadFinacialHouse(String house){
        if (verifyElement.verifyBrowserElementValue(nonroadFinacialHouse_Txt, "Non road financial House") == 0){
            verifyElement.sendKeys(nonroadFinacialHouse_Txt,"Non road financial House",house);
        }
    }

    public void clickVehicleTypeDropDown(){
        if (verifyElement.verifyBrowserElementValue(vehicleType_DD, "Vehicle Type") == 0){
            verifyElement.clickElement(vehicleType_DD,"Vehicle Type");
        }
    }

    public void clickClassOfUseDropDown(){
        if (verifyElement.verifyBrowserElementValue(classOfUse_DD, "Class of Use") == 0){
            verifyElement.clickElement(classOfUse_DD,"Class of Use");
        }
    }

    public void clickBasisOfSettlementDropDown(){
        if (verifyElement.verifyBrowserElementValue(nonroadBasisOfSettlement_DD, "Basis Of Settlement") == 0){
            verifyElement.clickElement(nonroadBasisOfSettlement_DD,"Basis of Settlement");
        }
    }

    public void clickCoinsuredDropDown(){
        if (verifyElement.verifyBrowserElementValue(nonroadCoinsured_DD, "Co insured") == 0){
            verifyElement.clickElement(nonroadCoinsured_DD,"Co insured");
        }
    }

    public void clickFinanced(){
        if (verifyElement.verifyBrowserElementValue(nonroadFinacialFianced_btn, "Is fianced") == 0){
            verifyElement.clickElement(nonroadFinacialFianced_btn,"Unoccupied for more than 90 days");
        }
    }

    //claims

    public void enternonroadClaims012(String claim){
        if (verifyElement.verifyBrowserElementValue(nonroadclaims012_Txt, "Non road Claims012") == 0){
            verifyElement.sendKeys(nonroadclaims012_Txt,"Non road Claims012",claim);
        }
    }

    public void enternonroadClaims324(String claim){
        if (verifyElement.verifyBrowserElementValue(nonroadClaims324_Txt, "Non road Claims324") == 0){
            verifyElement.sendKeys(nonroadClaims324_Txt,"Non road Claims324",claim);
        }
    }

    public void enternonroadClaims2536(String claim){
        if (verifyElement.verifyBrowserElementValue(nonroadClaims2536_Txt, "Non road Claims2536") == 0){
            verifyElement.sendKeys(nonroadClaims2536_Txt,"Non road Claims2536",claim);
        }
    }
}

