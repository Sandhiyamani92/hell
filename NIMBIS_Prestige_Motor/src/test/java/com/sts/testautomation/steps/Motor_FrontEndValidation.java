package com.sts.testautomation.steps;

import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.NIMBIS_Login;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Client;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Motor;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
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

public class Motor_FrontEndValidation extends  BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private ExcelHandler EH;
    private String Sheet;

    @Parameters({"URL", "Device","NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet ;

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




                            WebDriverManager.edgedriver().setup();
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

        nimbisLogin = new NIMBIS_Login(testB,Device);

        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        EH = new ExcelHandler(Sheet, "LoginDetails", 0, 0);

        nimbisLogin.enterUsername(EH.getCellValueSpecific(1,"Username"));
        nimbisLogin.clickContinueBtn();
        nimbisLogin.enterPassword(EH.getCellValueSpecific(1,"Password"));
        nimbisLogin.clickSignInBtn();
        Thread.sleep(6000);

    }

    @Parameters({"URL"})
    @Test(priority = 1, description = "Add Home Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB,Device);

        EH = new ExcelHandler(Sheet, "Motor Test Cases", 0, 0);


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
        nimbisUserNavigation.clickCoverBtn();
        nimbisUserNavigation.clickMotorCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();

        // RISK DETAILS

        nimbisUserNavigation.selectOption("Golf Cart");

        nimbisPrestigeMotor.enterVINNumber("1234567890");

        nimbisPrestigeMotor.enterEngineNumber("123456789");

        nimbisPrestigeMotor.enterRegistrationNumber("AQW123GP");

        nimbisPrestigeMotor.clickPerformanceEnhancingModifications();

        nimbisPrestigeMotor.clickVehicleColourDropDown();
        nimbisUserNavigation.selectOption("Black");

        nimbisPrestigeMotor.clickVehicleCodeDropDown();
        nimbisUserNavigation.selectOption("New or previously owned (Code 1 or 2)");

        //SECURITY

        nimbisPrestigeMotor.clickFirstTrackingDeviceRequiredDDropDown();
        nimbisUserNavigation.selectOption("None");

        nimbisPrestigeMotor.clickSecondTrackingDeviceRequired();

        nimbisPrestigeMotor.clickFirstTrackingDeviceTypeDropDown();
        nimbisUserNavigation.selectOption("None");

        nimbisPrestigeMotor.clickSecondTrackingDeviceTypeDropDown();
        nimbisUserNavigation.selectOption("None");

        // SITUATION

        nimbisPrestigeMotor.clickOvernightParkingDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("Behind Locked Gates");

        // COVER DETAILS

        nimbisPrestigeMotor.clickBasisOfSettlementDropDown();
        nimbisUserNavigation.selectOption("Retail");

        nimbisPrestigeMotor.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption("Comprehensive");

        nimbisPrestigeMotor.clickClassOfUseDropDown();
        nimbisUserNavigation.selectOption("Domestic Use");

        nimbisPrestigeMotor.clickSupportedBusiness();

        //EXCESS

        nimbisPrestigeMotor.clickBasicExcessDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("5 000");

        nimbisPrestigeMotor.enterAdditionalExcess("1000");

        //CLAIMS

        nimbisPrestigeMotor.enterNumberOfClaimsLast12month("0");

        nimbisPrestigeMotor.enterNumberOfClaimsLast24month("0");

        nimbisPrestigeMotor.enterNumberOfClaimsLast36month("0");

        //FIANANCE

        nimbisPrestigeMotor.clickIsFinanced();

        nimbisPrestigeMotor.enterFinanceHouse("FNB");

        //SPECIFIED ACCESSORIES

        //nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
        //nimbisUserNavigation.selectOption("");

        //nimbisPrestigeMotor.enterSpecifiedAccessoriesValue("");

        // EXTENSIONS

        nimbisPrestigeMotor.clickCreditShortfallExtended();
        nimbisPrestigeMotor.enterCreditShortfallExtendedSumInsured("2000");

        nimbisPrestigeMotor.clickReductionInValue();
        nimbisPrestigeMotor.enterReductionInValueSumInsured("10000");

        nimbisPrestigeMotor.clickOffRoadDriving();

        nimbisPrestigeMotor.clickTyreCover();
        nimbisPrestigeMotor.enterTyreCoverSumInsured("10000");


        //CAR HIRE

        nimbisPrestigeMotor.clickCarHire();

        nimbisPrestigeMotor.clickCarHireOptionDropDown();
        nimbisUserNavigation.selectOption("Compact vehicle with AC (Manual)");

        nimbisPrestigeMotor.clickCarHireDaysDropDown();
        nimbisUserNavigation.selectOption("30 Days");




    }

    public void captureTestCaseScreenshot(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Garden and landscaping - extended cover"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + " - " + cover + " " + ", Selected option : " + EH.getCellValueSpecific(i,sumInsured));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotPe(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Power surge"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + " - " + cover + " " + ", Selected option : " + EH.getCellValueSpecific(i,sumInsured));
                break;
            }
        }
    }


}
