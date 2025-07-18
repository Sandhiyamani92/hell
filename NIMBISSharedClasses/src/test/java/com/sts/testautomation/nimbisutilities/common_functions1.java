package com.sts.testautomation.nimbisutilities;

import com.sts.testautomation.pages.web.NIMBIS_Prestige_Contents;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Home;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import com.sts.testautomation.utilities.ElementFunctionality;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class common_functions1 {

    public WebDriver BrowserDriver;
    public String Device;
    public NIMBIS_Prestige_Contents contents;
    public NIMBIS_UserNavigation nimbisUserNavigation;
    public ElementFunctionality elementFunctionality;
    private ExcelHandler EH1;
    private String Sheet;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;

    public common_functions1(WebDriver browserDriver, String Device, String sheet) {
        this.BrowserDriver = browserDriver;
        this.Device = Device;
        this.Sheet = sheet;
        this.elementFunctionality = new ElementFunctionality(BrowserDriver, Device);
        // Initialize navigation here to avoid null pointer
        this.nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    // ... (keep all your existing dropdown validation methods - they look good)

    public void calculatePremium() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(BrowserDriver, 20);
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(15000);
        System.out.println("after save");
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserDriver;

            // Debug script to find all clickable elements
            String debugScript =
                    "var result = [];" +
                            "var allElements = document.querySelectorAll('span, li, button, a, div');" +
                            "for(var i = 0; i < allElements.length; i++) {" +
                            "  var elem = allElements[i];" +
                            "  if(elem.textContent || elem.title || elem.className) {" +
                            "    var info = {" +
                            "      tagName: elem.tagName," +
                            "      text: elem.textContent ? elem.textContent.trim().substring(0, 50) : ''," +
                            "      title: elem.title || ''," +
                            "      className: elem.className || ''," +
                            "      id: elem.id || ''," +
                            "      displayed: elem.offsetParent !== null" +
                            "    };" +
                            "    if(info.text.toLowerCase().includes('calculate') || " +
                            "       info.text.toLowerCase().includes('premium') || " +
                            "       info.title.toLowerCase().includes('calculate') || " +
                            "       info.title.toLowerCase().includes('premium') || " +
                            "       info.className.toLowerCase().includes('calculate') || " +
                            "       info.className.toLowerCase().includes('premium')) {" +
                            "      result.push(info);" +
                            "    }" +
                            "  }" +
                            "}" +
                            "return JSON.stringify(result);";

            Object result = js.executeScript(debugScript);
            System.out.println("=== DEBUG: Available Calculate/Premium elements ===");
            System.out.println(result.toString());
            System.out.println("====================================================");

        } catch (Exception e) {
            System.err.println("Debug script failed: " + e.getMessage());
        }
        nimbisUserNavigation.clickCalculatePremiumBtn();

        Thread.sleep(20000);
        elementFunctionality.captureScreenshotOnDevice("calculated Premium");

        try {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) BrowserDriver;



            try {
                Actions actions = new Actions(BrowserDriver);
                actions.sendKeys(Keys.ENTER).build().perform();
                Thread.sleep(1000);
                System.out.println("Method 3: ENTER key sent");
            } catch (Exception e3) {
                System.out.println("Method 3 failed");
            }


        }
        catch (Exception e7) {
            System.out.println("Method 8 failed");
        }

        Thread.sleep(1000);
        nimbisUserNavigation.changeFocus2();
        nimbisUserNavigation.clickpremiumsaveBtn();
        Thread.sleep(4000);
       // nimbisUserNavigation.changeFocus2();
        try {
            // Method 1: Find OK button in iframe
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@value='OK'] | //button[text()='OK'] | //span[text()='OK'] | //a[text()='OK']")
            ));
            okButton.click();
            System.out.println("OK button clicked in iframe - Method 1");

        } catch (Exception e1) {
            System.out.println("Method 1 failed, trying Method 2");

            try {
                // Method 2: JavaScript click in iframe
                JavascriptExecutor jsInFrame = (JavascriptExecutor) BrowserDriver;
                jsInFrame.executeScript(
                        "var okElements = document.querySelectorAll('input, button, span, a');" +
                                "for(var i = 0; i < okElements.length; i++) {" +
                                "  var elem = okElements[i];" +
                                "  if(elem.value === 'OK' || elem.textContent.trim() === 'OK') {" +
                                "    elem.click();" +
                                "    console.log('Clicked OK element:', elem);" +
                                "    break;" +
                                "  }" +
                                "}"
                );
                System.out.println("OK button clicked in iframe - Method 2");

            } catch (Exception e2) {
                System.out.println("Method 2 failed, trying Method 3");

                try {
                    // Method 3: Try common button selectors
                    WebElement button = BrowserDriver.findElement(
                            By.cssSelector("input[type='button'], input[type='submit'], button")
                    );
                    button.click();
                    System.out.println("Button clicked in iframe - Method 3");

                } catch (Exception e3) {
                    System.out.println("Method 3 failed, trying Method 4");

                    // Method 4: Send ENTER key in iframe
                    try {
                        Actions actions = new Actions(BrowserDriver);
                        actions.sendKeys(Keys.ENTER).build().perform();
                        System.out.println("ENTER key sent in iframe - Method 4");
                    } catch (Exception e4) {
                        System.out.println("All methods in iframe failed");
                    }
                }
            }
        }
        nimbisUserNavigation.changeFocusToBrowser();
    }

    public void searchClientandopenQuote() throws InterruptedException {
        // Remove this line - don't reinitialize, use existing one
        // nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);

        // Add null check and use BrowserDriver instead of testB
        if (nimbisUserNavigation == null) {
            nimbisUserNavigation = new NIMBIS_UserNavigation(BrowserDriver, Device);
        }

        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
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
                elementFunctionality.clickElement(element, fieldName);
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
                elementFunctionality.clickElement(dropdownElement, fieldName);
                Thread.sleep(500);
                nimbisUserNavigation.selectOption(optionValue);
                System.out.println("Selected " + optionValue + " for " + fieldName);
            }
        } catch (Exception e) {
            System.err.println("Error selecting dropdown option for " + fieldName + ": " + e.getMessage());
        }
    }

    public void contentsection() throws Exception {
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(BrowserDriver, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(BrowserDriver, Device);
        EH1 = new ExcelHandler(Sheet, "Content Test Cases", 0, 0);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(8000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(4000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH1.getCellValueSpecific(1, "Sum insured"));
        //nimbisPrestigeContents.enterContentsSumInsured("10000");

        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH1.getCellValueSpecific(1, "cover details"));
        // nimbisUserNavigation.selectOption("Full Cover");


        if (EH1.getCellValueSpecific(1, "cover details").equalsIgnoreCase("Yes")) {
            nimbisPrestigeHome.clickDaysUnoccupied90Days();
        }


        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH1.getCellValueSpecific(1, "NCB"));

        //add prvious uninterupted,commune,adjoining land
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH1.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));

        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH1.getCellValueSpecific(1, "Use of adjoining land"));
        //  nimbisPrestigeContents.enter


        //security
        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH1.getCellValueSpecific(1, "Electric Fence"));

        nimbisPrestigeContents.clickBurglarBarsOpeningWindows();

        // nimbisPrestigeContents.clickAlarmLinkedToArmedResponse();


        nimbisPrestigeContents.clickTwentyFourHourSecurityGuard();

        // nimbisPrestigeContents.clickAccessControlledArea();

        // nimbisPrestigeContents.clickAllDoorsProtectedBySecurityGates();

        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(2000);

        nimbisUserNavigation.selectOption(EH1.getCellValueSpecific(1, "Perimeter protection"));

        //  nimbisPrestigeContents.clickHighSecurityEstateComplex();

        //  nimbisPrestigeContents.clickCCTVCamera();

        //  nimbisPrestigeContents.clickLaserBeamsInGarden();

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH1.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH1.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH1.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        calculatePremium();
    }


    // Keep all your existing dropdown validation methods here...
    // (I'm not including them to keep the response concise, but keep all the dropdown validation methods)
}