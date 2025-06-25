package com.sts.testautomation.steps;

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
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
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

                            WebDriverManager.edgedriver().setup();
                            testB = new EdgeDriver();
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
            Thread.sleep(6000);

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

            // Verify WebDriver is still available
            if (testB == null) {
                throw new IllegalStateException("WebDriver not available");
            }

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
            common = new common_functions1(testB, Device);

            System.out.println("All objects initialized successfully");

            // Search client and open quote
            common.searchClientandopenQuote();
            System.out.println("Client search and quote opening completed");

            // Process test cases
            int totalRows = EH.numRows;
            System.out.println("Processing " + (totalRows - 1) + " test cases...");

            for (int i = 1; i <= totalRows; i++) {
                try {
                    System.out.println("Processing test case " + i + "...");

                    // Navigate to Non-Road Vehicle cover
                    nimbisUserNavigation.clickCoverBtn();
                    Thread.sleep(2000);
                    nimbisUserNavigation.clickNonRoadVehicleCover();
                    Thread.sleep(2000);
                    nimbisUserNavigation.clickAddNewItemBtn();
                    Thread.sleep(6000);
                    nimbisUserNavigation.changeFocus2();

                    // Fill form with data from Excel
                    fillNonRoadVehicleForm(i);

                    // Calculate premium
                    common.calculatePremium();
                    Thread.sleep(3000);

                    // Log success
                    String path5 = captureScreenshotToFile(testB, "TestCase_" + i + ".png");
                    ExtentTestManager.getTest().addScreenCaptureFromPath(path5);
                   // ExtentTestManager.getTest().pass("TEST CASE " + i + " Passed");
                    System.out.println("TEST CASE " + i + " Passed");

                } catch (Exception e) {
                    System.err.println("Error in Test Case " + i + ": " + e.getMessage());
                    e.printStackTrace();

                    try {
                        common.closepopup();
                    } catch (Exception popupException) {
                        System.err.println("Failed to close popup: " + popupException.getMessage());
                    }

                    ExtentTestManager.getTest().fail("TEST CASE " + i + " Failed: " + e.getMessage());
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
            String path = captureScreenshotToFile(testB, "sumInsured.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
            // Vehicle Type dropdown
            nimbisNonRoadVehicle.clickVehicleTypeDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(rowIndex, "Vehicle Type"));
            String path3 = captureScreenshotToFile(testB, "vehcileType.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path3);
            // Vehicle details
            nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(rowIndex, "Make"));
            nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(rowIndex, "Model"));
            nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(rowIndex, "Year"));
            nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(rowIndex, "Registered Owner"));
            String path1 = captureScreenshotToFile(testB, "Vehicle.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path1);
            // Financing (if applicable)
            handleFinancing(rowIndex);

            // Basis of Settlement
            nimbisNonRoadVehicle.clickBasisOfSettlementDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(rowIndex, "Basis of settlement"));
            String path2 = captureScreenshotToFile(testB, "BaseOfSettlement.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path2);
            // Claims history
            fillClaimsHistory(rowIndex);

        } catch (Exception e) {
            String path = captureScreenshotToFile(testB, "Failed.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
            System.err.println("Error filling form for row " + rowIndex + ": " + e.getMessage());
            throw e;
        }
    }

    /**
     * Handle financing section
     */
    private void handleFinancing(int rowIndex) throws Exception {
        try {
            String financed = EH.getCellValueSpecific(rowIndex, "Financed");
            if (financed != null && financed.equalsIgnoreCase("Yes")) {
                String path = captureScreenshotToFile(testB, "Fiance.png");
                ExtentTestManager.getTest().addScreenCaptureFromPath(path);
                // nimbisNonRoadVehicle.clickFinanced();
                // String financialInstitution = EH.getCellValueSpecific(rowIndex, "Financial Institution");
                // nimbisNonRoadVehicle.enternonroadFinacialHouse(financialInstitution);
            }
        } catch (Exception e) {
            String path = captureScreenshotToFile(testB, "finance.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
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
            String path = captureScreenshotToFile(testB, "claimed.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            String path = captureScreenshotToFile(testB, "failedclaimed.png");
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
            System.err.println("Error filling claims history: " + e.getMessage());
            throw e;
        }
    }

    public static String captureScreenshotToFile(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/ExtentReports/screenshots/" + fileName;
        try {
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}