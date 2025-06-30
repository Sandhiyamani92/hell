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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Motorcycle_FrontEndValidation extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private NIMBIS_Prestige_Motorcycle nimbisPrestigeMotorcycle;
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
        nimbisPrestigeMotorcycle = new NIMBIS_Prestige_Motorcycle(testB,Device);

        EH = new ExcelHandler(Sheet, "Motorcycle Test Cases", 0, 0);


        for(int i = 32 ; i <= EH.numRows;i++){
            try{
                nimbisUserNavigation.enterSearchText("9609137884085 ");
                nimbisUserNavigation.clickSearchBtn();
                ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case Objective " +EH.getCellValue(Integer.toString(i), "Test objective"));

                Thread.sleep(5000);
                nimbisUserNavigation.clickClientResultName();
                Thread.sleep(5000);
                nimbisUserNavigation.clickAddNewQuote();
                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickPopUpOkBtn();
                JavascriptExecutor js = (JavascriptExecutor) testB;
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickOpenQuote();
                Thread.sleep(2000);
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickMotorcycleCover();
                Thread.sleep(4000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                // RISK DETAILS

                nimbisPrestigeMotor.clickChangeBtn();
                nimbisUserNavigation.changeFocusVehicle();
                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleSearch(EH.getCellValueSpecific(i,"MM Code"));
                Thread.sleep(2000);
                nimbisPrestigeMotor.clickSearchBtn();
                Thread.sleep(2000);
                captureTestCaseScreenshotMMCode(i);
                Thread.sleep(2000);
                nimbisPrestigeMotor.clickVehicleResult1();

                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleValue("100 000");
                Thread.sleep(1000);
                nimbisPrestigeMotor.clickSelectBtn();


                Thread.sleep(2000);

                elementFunctionality.switchOutOfBrowserFrame();

                nimbisUserNavigation.changeFocus2();

                nimbisPrestigeMotorcycle.enterVINNumber(EH.getCellValueSpecific(i,"VIN Number"));

                nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(i,"Engine Number"));

                nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(i,"Registration Number"));

                if (EH.getCellValueSpecific(i,"Performance enhancing modifications").equals("Yes")){
                    nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
                }

                nimbisPrestigeMotorcycle.clickVehicleCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Vehicle Code"));

                nimbisPrestigeMotorcycle.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(i,"Regular driver/rider driving convictions in the last 5 years"));


                if(EH.getCellValueSpecific(i,"Regular driver/rider driving convictions in the last 5 years").equals("Yes")){
                    nimbisPrestigeMotorcycle.clickDriverConvictionsInTheLast5Years();
                }
                Thread.sleep(2000);
                captureTestCaseScreenshotRiskDetails(i);
                Thread.sleep(1000);

                //CLAIMS

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 12 months, excluding glass damage"));

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));

                Thread.sleep(2000);
                captureTestCaseScreenshotClaimsDetails(i);
                Thread.sleep(1000);


                nimbisPrestigeMotor.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of cover"));

                nimbisPrestigeMotorcycle.clickClaimFreeGroup_DropDown();
                nimbisUserNavigation.selectOption("0");

                nimbisPrestigeMotorcycle.clickVehicleLiability_DropDown();
                nimbisUserNavigation.selectOption("Yes");

                nimbisPrestigeMotorcycle.clickNCB_DropDown();
                nimbisUserNavigation.selectOption("0");

                nimbisPrestigeMotorcycle.clickBasisOfSettlementDropDown();
                nimbisUserNavigation.selectOption("Retail Value");
                if(EH.getCellValueSpecific(i,"Basic Excess").equals("Retail Value Plus")){
                    nimbisPrestigeMotorcycle.enterRetailValuePercentage("0");
                }

                nimbisPrestigeMotorcycle.clickBasicExcessDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Basic Excess"));

                nimbisPrestigeMotorcycle.clickClassOfUseDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Class of Use"));

                ///

                nimbisPrestigeMotorcycle.clickAllowedRiders_DropDown();
                nimbisUserNavigation.selectOption("Insured Only");

                ////

                if (EH.getCellValueSpecific(i,"Is Financed").equals("Yes")){

                    nimbisPrestigeMotor.clickIsFinanced();

                    nimbisPrestigeMotor.enterFinanceHouse("FNB");
                }

                Thread.sleep(2000);
                captureTestCaseScreenshotCoverDetails(i);
                Thread.sleep(1000);

                // SITUATION

                nimbisPrestigeMotor.clickOvernightParkingDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Overnight Parking"));

                Thread.sleep(1000);
                captureTestCaseScreenshotSituation(i);
                Thread.sleep(1000);
                //SPECIFIED ACCESSORIES

                if (EH.getCellValueSpecific(i,"Specified Accessories").equals("Yes")){

                    Thread.sleep(1500);
                    nimbisPrestigeMotor.clickAddSpecifiedAccessories();
                    nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Specified Accessories Name"));
                    Thread.sleep(1500);
                    nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(i,"Specified Accessories Value"));

                    nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
                }

                // DRIVERS

                Thread.sleep(2000);
                nimbisPrestigeMotor.clickEditDriver_Btn();

                nimbisUserNavigation.changeFocusDriver();

                nimbisPrestigeMotor.clickLicenseCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"License Code"));

                nimbisPrestigeMotor.enterLicenseDate(EH.getCellValueSpecific(i,"License Dates"));

                Thread.sleep(1500);
                captureTestCaseScreenshotLicenseCode(i);
                Thread.sleep(1500);

                nimbisPrestigeMotor.clickDriverSave_Btn();

                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();

                // EXTENSIONS
                Thread.sleep(1500);
                if(EH.getCellValueSpecific(i,"Credit shortfall - extended").equals("Yes")){
                    nimbisPrestigeMotorcycle.clickCreditShortfallExtended();
                    nimbisPrestigeMotorcycle.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(i,"Credit shortfall - extended Sum Insured"));
                }

                Thread.sleep(1000);
                captureTestCaseScreenshotExtensions(i);
                Thread.sleep(1000);

                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();
                Thread.sleep(7000);
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(3000);
             //   nimbisUserNavigation.clickCalculatePremiumBtn();
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");

            }catch (Exception e) {
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

    public void captureTestCaseScreenshotMMCode(int i) {
        String[] RatingInfoFields = new String[]{"MM Code"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotRiskDetails(int i) {
        String[] RatingInfoFields = new String[]{"VIN Number","Engine Number","Registration Number","Vintage motorcycle applicable","Performance enhancing modifications","Vehicle Code","Restricted Driver","Regular driver/rider driving convictions in the last 5 years","Regular driver retired"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotClaimsDetails(int i) {
        String[] RatingInfoFields = new String[]{ "Regular Driver number of claims in the last 12 months, excluding glass damage","Regular Driver number of claims in the last 13 - 24 months, excluding glass damage","Regular Driver number of claims in the last 25 - 36 months, excluding glass damage","Is Financed"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotCoverDetails(int i) {
        String[] RatingInfoFields = new String[]{"Type of cover","Class of use","Basic Excess","Basis of Settlement","Is Financed","Financial Institution"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotSituation(int i) {
        String[] RatingInfoFields = new String[]{"Overnight Parking"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotSpecifiedAccessories(int i) {
        String[] RatingInfoFields = new String[]{"Specified Accessories Value"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotLicenseCode(int i) {
        String[] RatingInfoFields = new String[]{"License Code"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotExtensions(int i) {
        String[] RatingInfoFields = new String[]{"Credit shortfall - extended","Credit shortfall - extended Sum Insured","Reduction in value"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }





}
