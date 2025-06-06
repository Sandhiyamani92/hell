package com.sts.testautomation.pages.web;

import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NIMBIS_Trailer {
    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public NIMBIS_Trailer(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // this.caravanSumInsured_Txt = caravanSumInsuredTxt;
        PageFactory.initElements(BrowserDriver, this);
    }
//details
    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_FinanceDetails_dateInput']")
    private WebElement financeDate_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_chkIsFinanced_ClientState']")
    private WebElement isFianced_Btn;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_lstFinanceHouse_Input']")
    private WebElement financeHouse_Txt;

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_QuoteRiskItemFinanceControl1_txtPeriodOfFinance']")
    private WebElement periodOfFiance_Txt;

    //Insured Value

    @FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_TrailerSumInsured']")
    private WebElement trailerSumInsured_Txt;

    //details

    public void enterFinanceHouse(String house){
        if (verifyElement.verifyBrowserElementValue(financeHouse_Txt, "Finance House") == 0){
            verifyElement.sendKeys(financeHouse_Txt,"Finance House",house);
        }
    }

    public void enterFinancePeriod(String period){
        if (verifyElement.verifyBrowserElementValue(periodOfFiance_Txt, "Finance Date") == 0){
            verifyElement.sendKeys(periodOfFiance_Txt,"Finance Date",period);
        }
    }

    public void enterFinanceDate(String date){
        if (verifyElement.verifyBrowserElementValue(periodOfFiance_Txt, "Finance Period") == 0){
            verifyElement.sendKeys(periodOfFiance_Txt,"Finance Period",date);
        }
    }

    public void clickFinaced(){
        if (verifyElement.verifyBrowserElementValue(isFianced_Btn, "Is Financed") == 0){
            verifyElement.clickElement(isFianced_Btn,"Is Financed");
        }
    }

//Insured Value

    public void enterTrailerSum(String amount){
        if (verifyElement.verifyBrowserElementValue(trailerSumInsured_Txt, "Trailer Sum") == 0){
            verifyElement.sendKeys(trailerSumInsured_Txt,"Trailer Sum",amount);
        }
    }

}
