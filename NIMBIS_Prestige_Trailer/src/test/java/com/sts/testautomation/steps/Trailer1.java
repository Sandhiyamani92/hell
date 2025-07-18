package com.sts.testautomation.steps;

import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import com.sts.testautomation.extentReports.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Trailer1 extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Caravan nimbisCaravn;
    private NIMBIS_Trailer nimbisTrailer;
    private ExcelHandler excelHandler;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Initialize Test Environment")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            // Initialize HashSetup only once
            if (HashSetup == null) {
                HashSetup.SetUpBrowser();
            }

            System.out.println("Instantiating Nodes for device: " + device);
            url = URL;
            Device = device;
            Sheet = datasheet;

            // Initialize browser based on device type
            initializeBrowser(URL, device);

            // Initialize page objects and utilities once
            initializePageObjects();

            // Initialize Excel handler once
            excelHandler = new ExcelHandler(Sheet, "Trailer Test Cases", 0, 0);

            System.out.println("Setup completed successfully for device: " + device);

        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
            Assert.fail("Test setup failed: " + e.getMessage());
        }
    }

    private void initializeBrowser(String URL, String device) {
        for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
            if (currentNode.getKey().equals(Device)) {
                if (currentNode.getValue() instanceof BrowserNode) {
                    try {
                        System.out.println("Starting browser test on " + currentNode.getKey());

                        // Use WebDriverManager for better driver management
                        WebDriverManager.edgedriver().setup();
                        testB = new EdgeDriver();

                        // Optimize timeouts
                        testB.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        testB.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                        testB.manage().window().maximize();

                        // Navigate to URL
                        testB.get(URL);

                        // Initialize WebDriverWait and JavascriptExecutor (compatible with older Selenium versions)
                        wait = new WebDriverWait(testB, 20);
                        js = (JavascriptExecutor) testB;

                        System.out.println("Browser initialized successfully");

                    } catch (Exception e) {
                        System.err.println("Browser initialization failed: " + e.getMessage());
                        throw new RuntimeException("Failed to initialize browser", e);
                    }
                }
                // Add Android and iOS handling if needed
                else if (currentNode.getValue() instanceof AndroidNode) {
                    System.out.println("Android device setup - implement as needed");
                }
                else if (currentNode.getValue() instanceof IOSNode) {
                    System.out.println("iOS device setup - implement as needed");
                }
                break;
            }
        }
    }

    private void initializePageObjects() {
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);
        nimbisTrailer = new NIMBIS_Trailer(testB, Device);
    }

    @Test(priority = 0, description = "Complete Trailer Quote Process")
    public void completeTrailerQuoteProcess() throws Exception {
        // Start a single test in Extent Reports
        ExtentTestManager.startTest("Create Trailer Quote Process", "Complete end-to-end trailer quote creation with multiple test cases");

        try {
            // Step 1: Login
            logStep("Starting login process");
            loginToNimbis();

            // Step 2: Search and select client
            logStep("Searching for client");
            searchAndSelectClient();

            // Step 3: Create new quote
            logStep("Creating new quote");
            createNewQuote();

            // Step 4: Process trailer test cases
            logStep("Processing trailer test cases");
            processTrailerTestCases();

            ExtentTestManager.getTest().log( LogStatus.PASS, "Passed");

        } catch (Exception e) {
            elementFunctionality.captureScreenshotOnDevice("failure");
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed");
            throw e;
        }
    }

    private void loginToNimbis() throws Exception {
        try {
            logStep("Loading login page and entering credentials");

            ExcelHandler loginHandler = new ExcelHandler(Sheet, "LoginDetails", 0, 0);

            nimbisLogin.enterUsername(loginHandler.getCellValueSpecific(1, "Username"));
            elementFunctionality.captureScreenshotOnDevice("Username");

            nimbisLogin.clickContinueBtn();


            nimbisLogin.enterPassword(loginHandler.getCellValueSpecific(1, "Password"));
            elementFunctionality.captureScreenshotOnDevice("password");

            nimbisLogin.clickSignInBtn();
            waitForPageLoad();

            elementFunctionality.captureScreenshotOnDevice("Username");
            logStep("Login completed successfully");

        } catch (Exception e) {
            elementFunctionality.captureScreenshotOnDevice("Username");
            logStep("Login failed: " + e.getMessage());
            throw e;
        }
    }

    private void searchAndSelectClient() throws InterruptedException {
        logStep("Searching for client: Automation Automation");

        nimbisUserNavigation.enterSearchText("Vukani Shembe");
        elementFunctionality.captureScreenshotOnDevice("Username");

        nimbisUserNavigation.clickSearchBtn();
        waitForElement(5);


        nimbisUserNavigation.clickClientResultName();
        waitForElement(3);


        logStep("Client search and selection completed");
    }

    private void createNewQuote() throws InterruptedException {
        logStep("Creating new quote");

        nimbisUserNavigation.clickAddNewQuote();


        nimbisUserNavigation.clickPrestigeV2_Chkbox();


        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();


        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        waitForElement(2);


        logStep("New quote created successfully");
    }

    private void processTrailerTestCases() throws Exception {
        int totalRows = excelHandler.NumberRows();
        logStep("Starting to process " + (totalRows - 1) + " trailer test cases");

        for (int i = 1; i <= totalRows; i++) {
            try {
                logStep("Starting test case " + i + " of " + (totalRows - 1));
                processIndividualTrailerCase(i);

                logStep("Test case " + i + " completed successfully");
                elementFunctionality.captureScreenshotOnDevice("Username");

            } catch (Exception e) {
                handleTestCaseFailure(i, e);
            }
        }

        logStep("All trailer test cases processing completed");
    }

    private void processIndividualTrailerCase(int testCaseNumber) throws Exception {
        logStep("Processing trailer case #" + testCaseNumber);

        // Open trailer cover
        nimbisUserNavigation.clickCoverBtn();
        nimbisUserNavigation.clickTrailerCover();
        waitForElement(2);
        nimbisUserNavigation.clickAddNewItemBtn();

        waitForElement(3);
        nimbisUserNavigation.changeFocus2();
        elementFunctionality.captureScreenshotOnDevice("Username");

        // Fill trailer details
        fillTrailerDetails(testCaseNumber);

        // Fill vehicle information
        fillVehicleInformation(testCaseNumber);

        // Fill claims history
        fillClaimsHistory(testCaseNumber);

        // Fill cover options
        fillCoverOptions(testCaseNumber);

        // Add extensions
        addExtensions(testCaseNumber);

        // Calculate premium and save
        calculatePremiumAndSave(testCaseNumber);

        logStep("Trailer case #" + testCaseNumber + " processing completed");
    }

    private void fillTrailerDetails(int testCaseNumber) {
        logStep("Filling trailer details for case " + testCaseNumber);

        nimbisTrailer.clickFinaced();
        nimbisTrailer.enterFinanceHouse(excelHandler.getCellValueSpecific(testCaseNumber, "Finance House"));
        nimbisTrailer.enterFinancePeriod(excelHandler.getCellValueSpecific(testCaseNumber, "Period finance"));
        nimbisTrailer.enterTrailerSum(excelHandler.getCellValueSpecific(testCaseNumber, "Trailer Sum Insured"));

        elementFunctionality.captureScreenshotOnDevice("Username");
        logStep("Trailer details completed for case " + testCaseNumber);
    }

    private void fillVehicleInformation(int testCaseNumber) {
        logStep("Filling vehicle information for case " + testCaseNumber);

        nimbisCaravn.enterCaravanMake(excelHandler.getCellValueSpecific(testCaseNumber, "Make"));
        nimbisCaravn.enterCaravanModel(excelHandler.getCellValueSpecific(testCaseNumber, "Model"));
        nimbisCaravn.enterCaravanYear(excelHandler.getCellValueSpecific(testCaseNumber, "Year"));
        nimbisCaravn.enterRegisterNumber(excelHandler.getCellValueSpecific(testCaseNumber, "Registration Number"));

        elementFunctionality.captureScreenshotOnDevice("Username");
        logStep("Vehicle information completed for case " + testCaseNumber);
    }

    private void fillClaimsHistory(int testCaseNumber) {
        logStep("Filling claims history for case " + testCaseNumber);

        nimbisTrailer.enterTrailerClaim012Months(
                excelHandler.getCellValueSpecific(testCaseNumber, "Number of Trailer claims in the last 12 months, excluding glass damage"));
        nimbisTrailer.enterTrailerClaim1324Months(
                excelHandler.getCellValueSpecific(testCaseNumber, "Number of Trailer claims in the last 13 - 24 months, excluding glass damage"));
        nimbisTrailer.enterTrailerClaim2536Months(
                excelHandler.getCellValueSpecific(testCaseNumber, "Number of Trailer claims in the last 25 - 36 months, excluding glass damage"));

        elementFunctionality.captureScreenshotOnDevice("Username");
        logStep("Claims history completed for case " + testCaseNumber);
    }

    private void fillCoverOptions(int testCaseNumber) {
        logStep("Filling cover options for case " + testCaseNumber);

        nimbisTrailer.clickVehicleLiabilityDropDown();
        nimbisUserNavigation.selectOption(excelHandler.getCellValueSpecific(testCaseNumber, "Vehicle Liability"));

        nimbisTrailer.clickTypeOfCoverDropDown();
        nimbisUserNavigation.selectOption(excelHandler.getCellValueSpecific(testCaseNumber, "Class of Use"));

        nimbisTrailer.clickClassOfUseDropDown();
        nimbisUserNavigation.selectOption(excelHandler.getCellValueSpecific(testCaseNumber, "Type of cover"));

        elementFunctionality.captureScreenshotOnDevice("Username");
        logStep("Cover options completed for case " + testCaseNumber);
    }

    private void addExtensions(int testCaseNumber) {
        logStep("Adding extensions for case " + testCaseNumber);

        nimbisTrailer.clickTrailerExtension();
        nimbisTrailer.enterTrailerExtensionSum(excelHandler.getCellValueSpecific(testCaseNumber, "sum insured"));

        elementFunctionality.captureScreenshotOnDevice("Username");
        logStep("Extensions completed for case " + testCaseNumber);
    }

    private void calculatePremiumAndSave(int testCaseNumber) throws InterruptedException {
        logStep("Calculating premium and saving for case " + testCaseNumber);

        nimbisUserNavigation.clickSaveBtn();
        waitForElement(1);


        nimbisUserNavigation.clickCalculatePremiumBtn();
        waitForElement(3);


        nimbisUserNavigation.clickPopUpOkRateBtn();
        waitForElement(1);


        nimbisUserNavigation.clickSaveBtn();
        nimbisUserNavigation.changeFocusToBrowser();
        waitForElement(1);


        logStep("Premium calculation and save completed for case " + testCaseNumber);
    }

    private void handleTestCaseFailure(int testCaseNumber, Exception e) {
        try {
            nimbisUserNavigation.changeFocusToBrowser();
            logStep("Test case " + testCaseNumber + " failed: " + e.getMessage());

            // Try to close any open dialogs
            nimbisUserNavigation.clickCloseBtn();
            waitForElement(1);
            nimbisUserNavigation.changeFocusToBrowser();


            logStep("Cleanup completed for failed test case " + testCaseNumber);

        } catch (Exception cleanupException) {
            logStep("Cleanup failed for test case " + testCaseNumber + ": " + cleanupException.getMessage());
        }
    }

    // Utility methods
    private void logStep(String stepDescription) {

        System.out.println(stepDescription);
    }

    private void waitForElement(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    private void waitForPageLoad() {
        try {
            wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            System.out.println("Page load wait timed out, continuing...");
        }
    }


    @AfterClass
    public void tearDown() {
        try {
            if (testB != null) {
                testB.quit();
                System.out.println("Browser closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }
}