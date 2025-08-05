package com.sts.testautomation.nimbisutilities;

import com.sts.testautomation.pages.web.NIMBIS_Prestige_Contents;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Home;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import com.sts.testautomation.utilities.ElementFunctionality;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.KeepAliveOutputStream;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    private ExcelHandler EH;
    private static final String EXCEL_FILE_PATH_front = "C:\\Users\\SandhiyaM\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS.xlsx";
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
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


public void UW_calculatePremium(String SheetName, int rowNum) throws Exception {
    nimbisUserNavigation.clickSaveBtn();
    Thread.sleep(7000);
    elementFunctionality.switchOutOfBrowserFrame();
    Thread.sleep(3000);
    nimbisUserNavigation.clickCalculatePremiumBtn();
    Thread.sleep(6000);
    nimbisUserNavigation.changeFocus2();
    elementFunctionality.captureScreenshotOnDevice("Msg");
    List<WebElement> textAreas = BrowserDriver.findElements(By.xpath("//td//div[@class='rwDialogText']"));
    String messageToWrite = "No Message is Displayed"; // default

    if (!textAreas.isEmpty()) {
        WebElement textArea = textAreas.get(0);

        if (textArea.isDisplayed()) {
            List<WebElement> listItems = textArea.findElements(By.tagName("li"));
            StringBuilder combinedText = new StringBuilder();

            for (WebElement item : listItems) {
                System.out.println(item.getText());
                combinedText.append(item.getText()).append(", ");
            }

            if (combinedText.length() > 0) {
                combinedText.setLength(combinedText.length() - 2); // remove last comma
                messageToWrite = combinedText.toString();
            }
            nimbisUserNavigation.clickOkBtn();
        }
    }

    write_Extracted_rule_to_Sheet(
            "C:\\Users\\SandhiyaM\\Documents\\GitHub\\qa-automation-nimbus\\src\\UW.xlsx",SheetName,rowNum , 4, messageToWrite
    );

    nimbisUserNavigation.clickpremiumsaveBtn();

    //
    Thread.sleep(3000);

    nimbisUserNavigation.changeFocusToBrowser();

    nimbisUserNavigation.clickCloseBtn();


    Thread.sleep(1000);
    nimbisUserNavigation.changeFocusToBrowser();
    Thread.sleep(1000);
    nimbisUserNavigation.clickLogsTabBtn();
    Thread.sleep(1000);
    nimbisUserNavigation.clickPremiumBlackBoxTabBtn();
    Thread.sleep(1000);
    nimbisUserNavigation.clickLogsViewFirstDetails();


    Thread.sleep(1000);

    nimbisUserNavigation.changeFocus2();
    Thread.sleep(1000);
    nimbisUserNavigation.clickBlackBoxInput();
    Thread.sleep(1000);
    String textIn =  BrowserDriver.findElement(By.id("ContentPlaceHolder1_txtBBXMLInput")).getAttribute("value");
    System.out.println(textIn);
    write_Extracted_rule_to_Sheet("C:\\Users\\SandhiyaM\\Documents\\GitHub\\qa-automation-nimbus\\src\\UW.xlsx",SheetName,rowNum ,5,textIn);


    nimbisUserNavigation.clickBlackBoxRawViewIn();
    Thread.sleep(1000);
    nimbisUserNavigation.clickBlackBoxOutput();
    Thread.sleep(1000);
    nimbisUserNavigation.clickBlackBoxRawViewOut();
    Thread.sleep(1000);

    String textOut =  BrowserDriver.findElement(By.id("ContentPlaceHolder1_txtBBXMLOutput")).getAttribute("value");
    System.out.println(textOut);
    write_Extracted_rule_to_Sheet("C:\\Users\\SandhiyaM\\Documents\\GitHub\\qa-automation-nimbus\\src\\UW.xlsx",SheetName,rowNum ,6,textOut);

}
    public void calculatePremium() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(BrowserDriver, 20);
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(10000);
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

        Thread.sleep(3000);
        nimbisUserNavigation.changeFocus2();
        nimbisUserNavigation.clickpremiumsaveBtn();
        Thread.sleep(4000);
       // nimbisUserNavigation.changeFocus2();
        Thread.sleep(2000);
        nimbisUserNavigation.changeFocusToBrowser();

        nimbisUserNavigation.clickCloseBtn();

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
       // nimbisUserNavigation.clickPopUpOkBtn();
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
     * Generic method to handle conditional checkbox/button clicks
     */


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
        EH1 = new ExcelHandler(EXCEL_FILE_PATH_front, "Content Test Cases", 0, 0);
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
        Thread.sleep(4000);
     System.out.println("ncb");
        //add prvious uninterupted,commune,adjoining land
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH1.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));

        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        Thread.sleep(1000);
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

        nimbisPrestigeContents.enterNumberOfClaimsLast12month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast24month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast36month("0");
        calculatePremium();
    }

    public void write_Extracted_rule_to_Sheet(String FilePath, String SheetName, int rowNum, int colNum, String element) throws Exception {

        try {


            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int numRows = ExcelWSheet.getLastRowNum() + 1;

            ExcelWSheet.getRow(rowNum).createCell(colNum).setCellValue(element);

            ExcelWBook.write(new FileOutputStream(FilePath));

            FileOutputStream fileOut = new FileOutputStream(FilePath);
            ExcelWBook.write(fileOut);
            fileOut.close();
            ExcelWBook.close();
            System.out.println("Completed writing extracted rule");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }


    }

    // Keep all your existing dropdown validation methods here...
    // (I'm not including them to keep the response concise, but keep all the dropdown validation methods)
}