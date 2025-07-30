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
    private common_functions1 commonFunctions;

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
                            System.setProperty("webdriver.edge.driver",
                                    "C:\\Users\\SandhiyaM\\Documents\\edgedriver_win64\\msedgedriver.exe");
                            System.out.println("Creation of driver");
                            // WebDriverManager.chromedriver().setup();
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
            commonFunctions = new common_functions1(testB, Device, Sheet);

            System.out.println("All objects initialized successfully");

            // Search client and open quote
            commonFunctions.searchClientandopenQuote();
            System.out.println("Client search and quote opening completed");

            // Process test cases
            int totalRows = EH.numRows;
            System.out.println("Processing " + (totalRows - 1) + " test cases...");

            for (int i = 1; i <= EH.numRows; i++) {
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
                    nimbisNonRoadVehicle.enternonroadValue(EH.getCellValueSpecific(i, "Sum Insured"));
                    nimbisNonRoadVehicle.clickVehicleTypeDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Type"));
                    nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(i, "Make"));
                    nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(i, "Model"));
                    nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(i, "Year"));
                    nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(i, "Registered Owner"));
                    elementFunctionality.captureScreenshotOnDevice("Vehicle details");
                    nimbisNonRoadVehicle.enternonroadClaims012(EH.getCellValueSpecific(i, "Number of Non-road Vehicles claims in the last 12 months"));
                    nimbisNonRoadVehicle.enternonroadClaims324(EH.getCellValueSpecific(i, "Number of Contents claims in the last 13 to 24 months"));
                    nimbisNonRoadVehicle.enternonroadClaims2536(EH.getCellValueSpecific(i, "Number of Contents claims in the last 25 to 36 months"));
                    elementFunctionality.captureScreenshotOnDevice("Claim history");
                    // Calculate premium
                    commonFunctions.calculatePremium();
                    Thread.sleep(3000);
                    // Log success

                    ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                    System.out.println("TEST CASE " + i + " Passed");

                } catch (Exception e) {
                    nimbisUserNavigation.changeFocusToBrowser();
                    System.out.println(e.toString());
                    Thread.sleep(1000);
                    nimbisUserNavigation.clickCloseBtn();
                    Thread.sleep(1000);
                    nimbisUserNavigation.changeFocusToBrowser();
                    Thread.sleep(3000);
                    System.out.println("Test Case  : " + i);
                    ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE " + i + "Failed");
                    // ExtentTestManager.getTest().fail( "TEST CASE " + i + "Failed");
                    System.err.println("TEST CASE " + i + " Failed");
                }
            }


        }


    }