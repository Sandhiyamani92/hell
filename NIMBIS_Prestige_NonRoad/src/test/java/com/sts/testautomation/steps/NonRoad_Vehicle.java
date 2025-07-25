package com.sts.testautomation.steps;

import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.nimbisutilities.common_functions1;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NonRoad_Vehicle extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private NIMBIS_NonRoad_Vehicle nimbisNonRoadVehicle;
    private ExcelHandler EH;
    private String Sheet;
    private common_functions1 common;

    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            HashSetup.SetUpBrowser();
            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet;

            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {
                    if (currentNode.getValue() instanceof AndroidNode) {
                        try {
                            // Android implementation if needed
                        } catch (Exception e) {
                            Assert.fail("Android setup failed: " + e.getMessage());
                            e.printStackTrace();
                        }
                    } else if (currentNode.getValue() instanceof IOSNode) {
                        try {
                            // iOS implementation if needed
                        } catch (Exception e) {
                            e.printStackTrace();
                            Assert.fail("iOS setup failed: " + e.getMessage());
                        }
                    } else if (currentNode.getValue() instanceof BrowserNode) {
                        try {
                            BrowserNode bNode = ((BrowserNode) currentNode.getValue());
                            System.out.println("NIMBIS Test started on " + currentNode.getKey());

                            WebDriverManager.chromedriver().setup();
                            testB = new ChromeDriver();
                            testB.get(URL);
                            testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                            testB.manage().window().maximize();

                            System.out.println("Browser setup completed successfully");

                        } catch (Exception e) {
                            Assert.fail("Browser setup failed: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            Assert.fail("Setup failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Parameters({"URL"})
    @Test(priority = 0, description = "Logging in to NIMBIS")
    public void Login(String URL) throws Exception {
        try {
            System.out.println("Starting login process...");

            // Verify WebDriver is initialized
            if (testB == null) {
                throw new IllegalStateException("WebDriver not initialized");
            }

            nimbisLogin = new NIMBIS_Login(testB, Device);
            EH = new ExcelHandler(Sheet, "LoginDetails", 0, 0);

            nimbisLogin.enterUsername(EH.getCellValueSpecific(1, "Username"));
            nimbisLogin.clickContinueBtn();
            nimbisLogin.enterPassword(EH.getCellValueSpecific(1, "Password"));
            nimbisLogin.clickSignInBtn();
            Thread.sleep(4000);

            System.out.println("Login completed successfully");

        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Parameters({"URL"})
    @Test(priority = 1, description = "Search Client and Process Non-Road Vehicle")
    public void CreateClient(String URL) throws Exception {
        try {
            url = URL;

            System.out.println("Initializing objects...");

            // Initialize Excel Handler first
            EH = new ExcelHandler(Sheet, "NonRoad Test Cases", 0, 0);
            System.out.println("Excel handler initialized");

            // Initialize all page objects and utilities
            nimbisLogin = new NIMBIS_Login(testB, Device);
            nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
            nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
            elementFunctionality = new ElementFunctionality(testB, Device);
            nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
            nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
            nimbisNonRoadVehicle = new NIMBIS_NonRoad_Vehicle(testB, Device);
            common = new common_functions1(testB, Device,Sheet);

            System.out.println("All objects initialized successfully");

            // Search client and open quote
            common.searchClientandopenQuote();
            System.out.println("Client search and quote opening completed");

            // Process test cases
            int totalRows = EH.numRows;
            System.out.println("Processing " + (totalRows - 1) + " test cases...");

            for (int i = 1; i <= 1; i++) {
                try {
                    System.out.println("Processing test case " + i + "...");

                    // Navigate to Non-Road Vehicle cover
                    nimbisUserNavigation.clickCoverBtn();
                    Thread.sleep(2000);
                    nimbisUserNavigation.clickNonRoadVehicleCover();
                    Thread.sleep(10000);
                    System.out.println("add");
                    nimbisUserNavigation.clickAddNewItemBtn();
                    Thread.sleep(3000);
                    nimbisUserNavigation.changeFocus2();

                    // Fill form with data from Excel
                    nimbisNonRoadVehicle.enternonroadValue(EH.getCellValueSpecific(i,"Sum Insured"));
                    nimbisNonRoadVehicle.clickVehicleTypeDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Type"));
                    nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(i, "Make"));
                    nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(i, "Model"));
                    nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(i, "Year"));
                    nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(i, "Registered Owner"));
                    elementFunctionality.captureScreenshotOnDevice("Vehicle details");
                    nimbisNonRoadVehicle.enternonroadClaims012(EH.getCellValueSpecific(i, "Number of Non-road Vehicles claims in the last 12 months"));
                    nimbisNonRoadVehicle.enternonroadClaims324(EH.getCellValueSpecific(i, "Number of Contents claims in the last 13 to 24 months"));
                    nimbisNonRoadVehicle.enternonroadClaims2536( EH.getCellValueSpecific(i, "Number of Contents claims in the last 25 to 36 months"));
                    elementFunctionality.captureScreenshotOnDevice("Claim history");
                    // Calculate premium
                    nimbisUserNavigation.clickSaveBtn();
                    Thread.sleep(50000);
                    // Try JavaScript click on any element containing "Calculate"

                  nimbisUserNavigation.clickCalculatePremiumBtn();
                    Thread.sleep(500);
                    elementFunctionality.captureScreenshotOnDevice("calculated Premium");
                    nimbisUserNavigation.clickPopUpOkRateBtn();
                    Thread.sleep(1000);
                    nimbisUserNavigation.clickSaveBtn();
                    nimbisUserNavigation.changeFocusToBrowser();
                    Thread.sleep(2000);

                    // Log success

                    ExtentTestManager.getTest().log(LogStatus.PASS,"TEST CASE " + i + "Passed");
                    System.out.println("TEST CASE " + i + " Passed");

                } catch (Exception e) {
                    System.err.println("Error in Test Case " + i + ": " + e.getMessage());
                    e.printStackTrace();

                    try {
                        common.closepopup();
                    } catch (Exception popupException) {
                        System.err.println("Failed to close popup: " + popupException.getMessage());
                    }

                    ExtentTestManager.getTest().log(LogStatus.FAIL,"TEST CASE " + i + "Failed");
                    System.err.println("TEST CASE " + i + " Failed");

                    // Continue with next test case
                    continue;
                }
            }

            System.out.println("All test cases completed");

        } catch (Exception e) {
            System.err.println("CreateClient method failed: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Helper method to fill Non-Road Vehicle form
     */
    private void fillNonRoadVehicleForm(int rowIndex) throws Exception {
        try {
            // Sum Insured
            String sumInsured = EH.getCellValueSpecific(rowIndex, "Sum Insured");
            nimbisNonRoadVehicle.enternonroadValue(sumInsured);
            elementFunctionality.captureScreenshotOnDevice("Sum insured");
            // Vehicle Type dropdown
            nimbisNonRoadVehicle.clickVehicleTypeDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(rowIndex, "Vehicle Type"));
            elementFunctionality.captureScreenshotOnDevice("Vehicle type");
            // Vehicle details
            nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(rowIndex, "Make"));
            nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(rowIndex, "Model"));
            nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(rowIndex, "Year"));
            nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(rowIndex, "Registered Owner"));
            elementFunctionality.captureScreenshotOnDevice("Vehicle details");
            // Financing (if applicable)
          //  handleFinancing(rowIndex);

            // Basis of Settlement
            nimbisNonRoadVehicle.clickBasisOfSettlementDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(rowIndex, "Basis of settlement"));
            elementFunctionality.captureScreenshotOnDevice("Basis of settlement");
            // Claims history
            fillClaimsHistory(rowIndex);

        } catch (Exception e) {
            elementFunctionality.captureScreenshotOnDevice("Error in fillNonRoadVehicleForm");
            System.err.println("Error filling form for row " + rowIndex + ": " + e.getMessage());
            throw e;
        }
    }

    /**
     * Handle financing section
     */
    private void handleFinancing(int rowIndex) throws Exception {
        try {

                 nimbisNonRoadVehicle.clickFinanced();
                 String financialInstitution = EH.getCellValueSpecific(rowIndex, "Financial Institution");
                 nimbisNonRoadVehicle.enternonroadFinacialHouse(financialInstitution);

        } catch (Exception e) {
            elementFunctionality.captureScreenshotOnDevice(" Error in finance");
            System.err.println("Error handling financing: " + e.getMessage());
            // Don't throw, just log - this might be optional
        }
    }

    /**
     * Fill claims history section
     */
    private void fillClaimsHistory(int rowIndex) throws Exception {
        try {
            String claims12 = EH.getCellValueSpecific(rowIndex, "Number of Non-road Vehicles claims in the last 12 months");
            String claims24 = EH.getCellValueSpecific(rowIndex, "Number of Contents claims in the last 13 to 24 months");
            String claims36 = EH.getCellValueSpecific(rowIndex, "Number of Contents claims in the last 25 to 36 months");

            nimbisNonRoadVehicle.enternonroadClaims012(claims12);
            nimbisNonRoadVehicle.enternonroadClaims324(claims24);
            nimbisNonRoadVehicle.enternonroadClaims2536(claims36);
            elementFunctionality.captureScreenshotOnDevice("Claim history");
        } catch (Exception e) {
            elementFunctionality.captureScreenshotOnDevice("Error in Claim history");
            System.err.println("Error filling claims history: " + e.getMessage());
            throw e;
        }
    }


}