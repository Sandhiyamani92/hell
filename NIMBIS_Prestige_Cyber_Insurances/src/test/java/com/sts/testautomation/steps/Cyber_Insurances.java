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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.TimeUnit;

public class Cyber_Insurances extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Cyber_Insurance nimbisCyberInsurance;
    private common_functions1 commonFunctions;
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
                          System.out.println("NIMBI Test started on " + currentNode.getKey());

                           System.setProperty("webdriver.edge.driver",
                                   "C:\\Users\\SandhiyaM\\Documents\\edgedriver_win64\\msedgedriver.exe");
                         System.out.println("Creation of driver");
                         WebDriverManager.edgedriver().setup();
                           testB = new EdgeDriver();
                         testB.get(URL);
                           testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                         testB.manage().window().maximize();

                        //   WebDriverManager.edgedriver().setup();
                         //  Map<String, Object> edgeOptionsMap = new HashMap<>();
                          //   edgeOptionsMap.put("args", Arrays.asList("--headless", "--disable-gpu", "--window-size=1920,1080"));
                           //  EdgeOptions options = new EdgeOptions();options.setCapability("ms:edgeOptions", edgeOptionsMap);
                             //  testB = new EdgeDriver(options);
                             // testB.get(URL);


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
        Thread.sleep(3000);

    }

    @Parameters({"URL"})
    @Test(priority = 1, description = "Add Cyber Insurance Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;

        EH = new ExcelHandler(Sheet, "Cyber Insurance Test Cases", 0, 0);

        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisCyberInsurance = new NIMBIS_Cyber_Insurance(testB, Device);
        commonFunctions=new common_functions1(testB,Device,Sheet);

            nimbisUserNavigation.enterSearchText("Vukani Shembe ");
            nimbisUserNavigation.clickSearchBtn();

            Thread.sleep(3000);
            nimbisUserNavigation.clickClientResultName();
            Thread.sleep(3000);
            nimbisUserNavigation.clickAddNewQuote();
            nimbisUserNavigation.clickPrestigeV2_Chkbox();
            nimbisUserNavigation.clickNextBtn();
            nimbisUserNavigation.clickNextBtn();
            nimbisUserNavigation.clickPopUpOkBtn();
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            nimbisUserNavigation.clickNextBtn();
            nimbisUserNavigation.clickOpenQuote();
            Thread.sleep(1000);
            nimbisUserNavigation.clickCoverBtn();
            nimbisUserNavigation.clickCyberinsuranceCover();
            Thread.sleep(2000);
        for (int i = 1; i <=EH.numRows; i++) {
            nimbisUserNavigation.clickAddNewItemBtn();

            try{
            Thread.sleep(3000);
            nimbisUserNavigation.changeFocus2();
            nimbisCyberInsurance.clickCyberInsuranceCoverDropDown();
            Thread.sleep(500);


            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Cyber insurance cover option"));
                elementFunctionality.captureScreenshotOnDevice("cyber insurance cover option");

            if (EH.getCellValueSpecific(i, "Cover for partner").equalsIgnoreCase("Yes")) {
                nimbisCyberInsurance.clickCoverForPartnerToggleButton();
                elementFunctionality.captureScreenshotOnDevice("cyber insurance cover for partner");
            }
            if (EH.getCellValueSpecific(i, "Cover for children").equalsIgnoreCase("Yes")) {
                nimbisCyberInsurance.clickCoverForChilderToggleButton();
                elementFunctionality.captureScreenshotOnDevice("cyber insurance cover for Children");
            }

                commonFunctions.calculatePremium();
            Thread.sleep(3000);
                ExtentTestManager.getTest().log(LogStatus.PASS,"TEST CASE " + i + "Passed");
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
                ExtentTestManager.getTest().log(LogStatus.FAIL,"TEST CASE " + i + "Failed");
               // ExtentTestManager.getTest().fail( "TEST CASE " + i + "Failed");
            System.err.println("TEST CASE " + i + " Failed");
        }
    }



    }

    public void captureTestCaseScreenshot(int i, String value) {
        String[] RatingInfoFields = new String[]{"Security Items", "Endorsement ", "UW Questions ", "Geyser Type"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
                //  elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + value + " " + ", Selected option : " + EH1.getCellValue(Integer.toString(i), value));
                break;
            }
        }
    }
}

