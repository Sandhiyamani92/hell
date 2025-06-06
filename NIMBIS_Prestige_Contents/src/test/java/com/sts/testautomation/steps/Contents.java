package com.sts.testautomation.steps;


import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.TimeUnit;

public class Contents extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private ExcelHandler EH;
    private String Sheet;


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


                         //   WebDriverManager.edgedriver().setup();
                          //  testB = new EdgeDriver();
                          //  testB.get(URL);
                          //  testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                         //   testB.manage().window().maximize();

                            WebDriverManager.edgedriver().setup();
                            Map<String, Object> edgeOptionsMap = new HashMap<>();
                          //  edgeOptionsMap.put("args", Arrays.asList("--headless", "--disable-gpu", "--window-size=1920,1080"));
                            EdgeOptions options = new EdgeOptions();options.setCapability("ms:edgeOptions", edgeOptionsMap);
                            testB = new EdgeDriver(options);
                            testB.get(URL);


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
        // url = URL;

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
    @Test(priority = 1, description = "Search Client")
    public void CreateClient(String URL) throws Exception {
        EH = new ExcelHandler(Sheet, "Content Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);


        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        url = URL;


        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        // JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        for (int i = 1; i < EH.numRows; i++) {
            try {
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickContentsCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();
                nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(i, "Sum insured"));
                //nimbisPrestigeContents.enterContentsSumInsured("10000");

                nimbisPrestigeContents.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "cover details"));
                // nimbisUserNavigation.selectOption("Full Cover");

                nimbisPrestigeContents.clickTypeOfHomeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of home"));

                if (EH.getCellValueSpecific(i, "cover details").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeHome.clickDaysUnoccupied90Days();
                }

                nimbisPrestigeContents.clickTypeOfRoofConstructionDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Roof type"));
                //   JavascriptExecutor js = (JavascriptExecutor) testB;
                //  js.executeScript("window.scrollTo(0,nimbisPrestigeContents.clickResidenceTypeDropDown();");
                nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();

                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Wall type"));

                nimbisPrestigeContents.clickLightningConductorSABS();

                nimbisPrestigeContents.clickFireRetardantSABS();

                nimbisPrestigeContents.clickSurgeProtectionSANS();

                nimbisPrestigeContents.clickResidenceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Residence type"));

                nimbisPrestigeContents.clickUseOfPremisesDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Use of premises"));


                nimbisPrestigeContents.clickNCB_DropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "NCB"));

                nimbisPrestigeContents.clickIncreasedRiskBusinessType();

                nimbisPrestigeContents.clickThatch15OfMainBuilding();

                nimbisPrestigeContents.clickRenewableEnergyEquipment();

                //add prvious uninterupted,commune,adjoining land
                nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(i, "Years of previous uninterrupted contents insurance cover"));

                nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
                nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(i, "Use of adjoining land"));
                //  nimbisPrestigeContents.enter

                nimbisPrestigeContents.clickPlotSmallHoldingOrFarm();




                //security
                nimbisPrestigeContents.clickElectricFence_DropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Electric Fence"));

                nimbisPrestigeContents.clickBurglarBarsOpeningWindows();

                nimbisPrestigeContents.clickAlarmLinkedToArmedResponse();


                nimbisPrestigeContents.clickTwentyFourHourSecurityGuard();

                nimbisPrestigeContents.clickAccessControlledArea();

                nimbisPrestigeContents.clickAllDoorsProtectedBySecurityGates();

                nimbisPrestigeContents.clickpermiterProtection_DD();
                Thread.sleep(3000);

                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Perimeter protection"));

                nimbisPrestigeContents.clickHighSecurityEstateComplex();

                nimbisPrestigeContents.clickCCTVCamera();

                nimbisPrestigeContents.clickLaserBeamsInGarden();

                //claims

                nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 12 months"));

                nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 13 to 24 months"));

                nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 25 to 36 months"));

                //excess options

                //  nimbisPrestigeContents.clickBasicExcessDropDown();
                //nimbisUserNavigation.selectOption("1 000");

                nimbisPrestigeContents.clickBedAndBreakfast();
                nimbisPrestigeContents.clickItemsOutAndAbout();
                nimbisPrestigeContents.clickBusinessContentsExtendedCover();
                nimbisPrestigeContents.clickMarqueeHire();
                nimbisPrestigeContents.clickGardenAndOutdoorItemsExtendedCover();
                nimbisUserNavigation.clickSaveBtn();
                Thread.sleep(500);
                nimbisUserNavigation.clickCalculatePremiumBtn();
                Thread.sleep(500);
                // nimbisUserNavigation.changeFocusToAlert();
                nimbisUserNavigation.clickPopUpOkRateBtn();
                Thread.sleep(1000);
                // nimbisUserNavigation.changeFocus2();
                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();

                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(3000);
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



