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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Assets_Specified_FieldValidation extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private common_functions1 commonFunctions;
    private NIMBIS_Prestige_AssetsSpecified nimbisPrestigeAssetsSpecified;
    private ExcelHandler EH;
    private String Sheet;
    public WebDriver testB;

    String projectPath = System.getProperty("user.dir");
    File currentDir = new File(projectPath);
    File parentDir = currentDir.getParentFile();
    String basePath = parentDir.getAbsolutePath();
    String excelPath = basePath + File.separator + "src" + File.separator + "NIMBIS.xlsx";

    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device) {
        try {
            HashSetup.SetUpBrowser();
            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = excelPath;

            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {
                    //Android
                    if (currentNode.getValue() instanceof AndroidNode) {
                        try {
                            //Focus here
                        } catch (Exception e) {
                            Assert.fail();
                            e.printStackTrace();

                        }
                    }
                    //iOS
                    else if (currentNode.getValue() instanceof IOSNode) {
                        try {

                        }    //Here

                        catch (Exception e) {
                            e.printStackTrace();
                            Assert.fail();
                        }
                    }

                    //Browsers
                    else if (currentNode.getValue() instanceof BrowserNode) {
                        try {
                            BrowserNode bNode = ((BrowserNode) currentNode.getValue());
                            System.out.println("NIMBIS Test started on " + currentNode.getKey());
                            String projectPath = System.getProperty("user.dir");
                            File currentDir = new File(projectPath);
                            File parentDir = currentDir.getParentFile();
                            String basePath = parentDir.getAbsolutePath();
                            System.out.println("Base path: " + basePath);
                            String relativePath = "Browser" + File.separator + "edgedriver_win64" + File.separator + "msedgedriver.exe";
                            String driverPath = basePath + File.separator + relativePath;

                            System.setProperty("webdriver.edge.driver", driverPath);
                          //  WebDriverManager.edgedriver().setup();
                            testB = new EdgeDriver();
                            testB.get(URL);
                            testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                            testB.manage().window().maximize();
                        } catch (Exception e) {
                            Assert.fail();
                            e.printStackTrace();

                        }
                    }
                }
            }
        } catch (Exception e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Parameters({"URL"})
    @Test(priority = 0, description = "Logging in to NIMBIS")
    public void Login(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        EH = new ExcelHandler(Sheet, "LoginDetails", 0, 0);
        nimbisLogin.enterUsername(EH.getCellValueSpecific(1, "Username"));
        nimbisLogin.clickContinueBtn();
        nimbisLogin.enterPassword(EH.getCellValueSpecific(1, "Password"));
        nimbisLogin.clickSignInBtn();
        Thread.sleep(6000);
    }

    @Parameters({"URL"})
    @Test(priority = 1, description = "Add Assest Specified Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        EH = new ExcelHandler(Sheet, "Assest Specified Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        commonFunctions = new common_functions1(testB, Device,Sheet);
        nimbisPrestigeAssetsSpecified = new NIMBIS_Prestige_AssetsSpecified(testB, Device);


        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();
        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickPopUpOkBtn();
        JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        commonFunctions.contentsection();
        for (int i = 1; i <= EH.numRows; i++) {
            try {
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAssetsSpecifiedCover();
                Thread.sleep(4000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(3000);
                nimbisUserNavigation.changeFocus2();
                Thread.sleep(900);

                nimbisPrestigeAssetsSpecified.enterSumInsured(EH.getCellValueSpecific(i, "Sum Insured"));
                nimbisPrestigeAssetsSpecified.clickAssetsSpecifiedCategory();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Assets Specified category"));
                elementFunctionality.captureScreenshotOnDevice("Assets specified category");
                nimbisPrestigeAssetsSpecified.enterAssetsSpecifiedDescription(EH.getCellValueSpecific(i, "Assets specified description"));
                //risk details
                nimbisPrestigeAssetsSpecified.entermanufacturer(EH.getCellValueSpecific(i, "Manufacturer"));
                nimbisPrestigeAssetsSpecified.enterserialnum(EH.getCellValueSpecific(i, "Serial Number"));
                nimbisPrestigeAssetsSpecified.clickAssetsSpecifiedBasicExcess();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basic excess - Assets specified"));
                elementFunctionality.captureScreenshotOnDevice("Assets specified BasisExcess");
                Thread.sleep(500);
                commonFunctions.calculatePremium();
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
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
                System.err.println("TEST CASE " + i + " Failed");
            }


        }
    }
}

