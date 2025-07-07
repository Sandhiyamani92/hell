package com.sts.testautomation.nimbisutilities;

import com.sts.testautomation.pages.web.NIMBIS_Prestige_Contents;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class common_functions1 {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;
    public NIMBIS_Prestige_Contents contents;
    public NIMBIS_UserNavigation nimbisUserNavigation;
    public ElementFunctionality elementFunctionality;

    public common_functions1(WebDriver browserDriver, String Device) {
        this.BrowserDriver = browserDriver;
        this.Device = Device;
        this.verifyElement = new ElementFunctionality(BrowserDriver, Device);
        // Initialize navigation here to avoid null pointer
        this.nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    // ... (keep all your existing dropdown validation methods - they look good)

    public void calculatePremium() throws InterruptedException {
        elementFunctionality = new ElementFunctionality(BrowserDriver, Device);
        if (nimbisUserNavigation == null) {
            nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        }

        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.clickCalculatePremiumBtn();
        Thread.sleep(500);
        elementFunctionality.captureScreenshotOnDevice("calculated Premium");
        nimbisUserNavigation.clickPopUpOkRateBtn();
        Thread.sleep(1000);
        nimbisUserNavigation.clickSaveBtn();
        nimbisUserNavigation.changeFocusToBrowser();
    }

    public void searchClientandopenQuote() throws InterruptedException {
        // Remove this line - don't reinitialize, use existing one
        // nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);

        // Add null check and use BrowserDriver instead of testB
        if (nimbisUserNavigation == null) {
            nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        }

        nimbisUserNavigation.enterSearchText("9609137884085 ");
        //  nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
    }

    public void closepopup() throws InterruptedException {
        if (nimbisUserNavigation == null) {
            nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        }

        nimbisUserNavigation.changeFocusToBrowser();
        Thread.sleep(1000);
        nimbisUserNavigation.clickCloseBtn();
        Thread.sleep(1000);
        nimbisUserNavigation.changeFocusToBrowser();
        Thread.sleep(3000);
    }

    // Additional utility methods for better reusability

    /**
     * Generic method to fill form fields based on Excel data
     */
    public void fillFormField(String fieldType, String value, int rowIndex) {
        try {
            switch (fieldType.toLowerCase()) {
                case "sum insured":
                case "value":
                    // Handle sum insured fields
                    break;
                case "vehicle type":
                    // Handle dropdown selections
                    break;
                // Add more cases as needed
            }
        } catch (Exception e) {
            System.err.println("Error filling field " + fieldType + ": " + e.getMessage());
        }
    }

    /**
     * Generic method to handle conditional checkbox/button clicks
     */
    public void handleConditionalClick(String excelValue, WebElement element, String fieldName) {
        try {
            if (excelValue != null && excelValue.equalsIgnoreCase("Yes")) {
                verifyElement.clickElement(element, fieldName);
                System.out.println("Clicked: " + fieldName);
            }
        } catch (Exception e) {
            System.err.println("Error handling conditional click for " + fieldName + ": " + e.getMessage());
        }
    }

    /**
     * Generic method to handle dropdown selections
     */
    public void selectDropdownOption(WebElement dropdownElement, String optionValue, String fieldName) {
        try {
            if (optionValue != null && !optionValue.trim().isEmpty()) {
                verifyElement.clickElement(dropdownElement, fieldName);
                Thread.sleep(500);
                nimbisUserNavigation.selectOption(optionValue);
                System.out.println("Selected " + optionValue + " for " + fieldName);
            }
        } catch (Exception e) {
            System.err.println("Error selecting dropdown option for " + fieldName + ": " + e.getMessage());
        }
    }

    // Keep all your existing dropdown validation methods here...
    // (I'm not including them to keep the response concise, but keep all the dropdown validation methods)
}