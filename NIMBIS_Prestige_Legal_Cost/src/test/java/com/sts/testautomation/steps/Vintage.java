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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

import java.util.concurrent.TimeUnit;

public class Vintage extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private ExcelHandler EH;
    private String Sheet;
    private common_functions1 commonFunctions;
    private NIMBIS_Vintage nimbisVintage;


    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet;

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
                            System.out.println("Tial Test started on " + currentNode.getKey());


                            System.setProperty("webdriver.edge.driver",
                                    "C:\\Users\\SandhiyaM\\Documents\\edgedriver_win64\\msedgedriver.exe");
                            System.out.println("Creation of driver");
                        //    WebDriverManager.edgedriver().setup();
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
    @Test(priority = 1, description = "Add Vintage Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;

        EH = new ExcelHandler(Sheet, "Vintage Test Cases", 0, 0);

        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisVintage = new NIMBIS_Vintage(testB, Device);
        commonFunctions = new common_functions1(testB, Device, Sheet);

        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        commonFunctions.contentsection();

        for (int i = 1; i <= 48; i++) {

            nimbisUserNavigation.clickCoverBtn();
            Thread.sleep(2000);
            nimbisUserNavigation.clickVintageCover();
            Thread.sleep(4000);
            nimbisUserNavigation.clickAddNewItemBtn();

            Thread.sleep(6000);
            nimbisUserNavigation.changeFocus2();
            try {
                //details
                if (EH.getCellValueSpecific(i, "Regular driver/rider driving convictions in the last 5 years").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickDrivingConvictions();
                }
                //insured value
                nimbisVintage.entervintageSumInsured(EH.getCellValueSpecific(i, "Sum insured"));
                //vehicle
                if (EH.getCellValueSpecific(i, "Performance enhancing modifications").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickPerformanceModification();
                }
                nimbisVintage.enterModel(EH.getCellValueSpecific(i, "Model"));
                nimbisVintage.entervin(EH.getCellValueSpecific(i, "Vin"));
                nimbisVintage.enterRegisterationNum(EH.getCellValueSpecific(i, "Registration Number"));
                nimbisVintage.enterMake(EH.getCellValueSpecific(i, "Make"));
                nimbisVintage.enterYear(EH.getCellValueSpecific(i, "Year"));
                nimbisVintage.enterengineNum(EH.getCellValueSpecific(i, "Engine Number"));
                nimbisVintage.clickVehicle_Code_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Code"));
//claims
                nimbisVintage.enterClaims12(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 12 months, excluding glass damage"));
                nimbisVintage.enterClaims13_24(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));
                nimbisVintage.enterClaims25_36(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));
                //driver
                nimbisVintage.clickAllowed_driver_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Allowed Drivers"));
//situation
                nimbisVintage.clickParking_Overnight_DD();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Parking Overnight"));
//cover options
                nimbisVintage.clickClass_Of_uset_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Class of Use"));


                if (EH.getCellValueSpecific(i, "Supported business").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickSupportedBusiness();
                }

                nimbisVintage.clickCoverType_DD();
                Thread.sleep(3000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Cover Type"));

                nimbisVintage.clickRestricted_Driver_DD();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Restricted Driver"));

                commonFunctions.calculatePremium();
                Thread.sleep(3000);
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                //   ExtentTestManager.getTest().get( "TEST CASE " + i + "Passed");
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
                // ExtentTestManager.getTest().fail( "TEST CASE " + i + "Failed");
                System.err.println("TEST CASE " + i + " Failed");
            }
        }

    }
}


















