package NIMBIS_Prestige_Motor;
import NIMBISSharedClasses.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
import NIMBIS_SharedClasses.extentReports.ExtentTestManager;
import NIMBIS_SharedClasses.pages.web.*;
import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import NIMBIS_SharedClasses.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Motor_FronEndValidation extends BaseTest {

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
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB, Device);

        EH = new ExcelHandler(Sheet, "Motor Test Cases", 0, 0);
        for (int i = 1; i <= 157; i++) {
            try {
                Thread.sleep(2000);

                nimbisUserNavigation.enterSearchText(EH.getCellValueSpecific(i,"Driver ID"));
                nimbisUserNavigation.clickSearchBtn();

                Thread.sleep(5000);
                nimbisUserNavigation.clickClientResultName2(EH.getCellValueSpecific(i,"Driver ID"));
                Thread.sleep(5000);
                nimbisUserNavigation.clickAddNewQuote();
                Thread.sleep(1000);
                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickPopUpOkBtn();
                Thread.sleep(1000);
                JavascriptExecutor js = (JavascriptExecutor) testB;
                Thread.sleep(1000);
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickOpenQuote();
                Thread.sleep(2000);
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickMotorCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                // RISK DETAILS

                nimbisPrestigeMotor.clickChangeBtn();
                nimbisUserNavigation.changeFocusVehicle();
                nimbisPrestigeMotor.enterVehicleSearch(EH.getCellValueSpecific(i, "MMCode"));
                nimbisPrestigeMotor.clickSearchBtn();
                nimbisPrestigeMotor.clickVehicleResult1();
                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleValue("100 000");
                Thread.sleep(1000);
                nimbisPrestigeMotor.clickSelectBtn();



                Thread.sleep(2000);

                elementFunctionality.switchOutOfBrowserFrame();

                nimbisUserNavigation.changeFocus2();

                nimbisPrestigeMotor.clickVehicleTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Type"));

                nimbisPrestigeMotor.enterVINNumber(EH.getCellValueSpecific(i, "VIN Number"));

                nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(i, "Engine Number"));

                nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(i, "Registration Number"));

                if (EH.getCellValueSpecific(i, "Performance enhancing modifications").equals("Yes")) {
                    nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
                }


                nimbisPrestigeMotor.clickVehicleColourDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Colour"));

                nimbisPrestigeMotor.clickVehicleCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Code"));
                Thread.sleep(1000);
                captureTestCaseScreenshotRiskDetails(i);
                Thread.sleep(1000);


                //SECURITY

                nimbisPrestigeMotor.clickFirstTrackingDeviceRequiredDDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "First tracking device required"));

                if (EH.getCellValueSpecific(i, "Second Tracking Device required").equals("Yes")) {
                    nimbisPrestigeMotor.clickSecondTrackingDeviceRequired();
                }

                nimbisPrestigeMotor.clickFirstTrackingDeviceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "First tracking device type"));

                nimbisPrestigeMotor.clickSecondTrackingDeviceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Second tracking device type"));

                Thread.sleep(1000);
                captureTestCaseScreenshotSecurity(i);
                Thread.sleep(1000);

                // SITUATION

                nimbisPrestigeMotor.clickOvernightParkingDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Overnight Parking"));
                Thread.sleep(1000);
                captureTestCaseScreenshotSituation(i);
                Thread.sleep(1000);
                // COVER DETAILS

                nimbisPrestigeMotor.clickBasisOfSettlementDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basis of Settlement"));

                nimbisPrestigeMotor.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Cover Type"));

                nimbisPrestigeMotor.clickClassOfUseDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Class of Use"));

                if (EH.getCellValueSpecific(i, "Supported business").equals("Yes")) {
                    nimbisPrestigeMotor.clickSupportedBusiness();
                }

                Thread.sleep(1000);
                captureTestCaseScreenshotCoverDetails(i);
                Thread.sleep(1000);

                //EXCESS

                nimbisPrestigeMotor.clickBasicExcessDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basic Excess"));

                nimbisPrestigeMotor.enterAdditionalExcess(EH.getCellValueSpecific(i, "Additional Excess"));

                Thread.sleep(1000);
                captureTestCaseScreenshotExcess(i,"Basic Excess", "Basic Excess");
                Thread.sleep(1000);

                //DISCLOUSERS

                nimbisPrestigeMotor.clickAllowedDriversDropDown();
                nimbisUserNavigation.selectOption("Regular Driver");

                if (EH.getCellValueSpecific(i, "Regular driver/rider driving convictions in the last 5 years").equals("Yes")) {
                    nimbisPrestigeMotor.clickDriverConvictionsInTheLast5Years();
                }

                nimbisPrestigeMotor.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(i, "Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));
                nimbisPrestigeMotor.enterRegisteredOwner(EH.getCellValueSpecific(i, "Registered Owner"));


                // DRIVER
                if (EH.getCellValueSpecific(i, "Advanced Driver").equals("Yes")) {
                    nimbisPrestigeMotor.clickAdvancedDriver();

                }

                //CLAIMS

                nimbisPrestigeMotor.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 12 months, excluding glass damage"));

                nimbisPrestigeMotor.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

                nimbisPrestigeMotor.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));


                //FIANANCE
                if (EH.getCellValueSpecific(i, "Is Financed").equals("Yes")) {

                    nimbisPrestigeMotor.clickIsFinanced();

                    nimbisPrestigeMotor.enterFinanceHouse("FNB");
                }
                Thread.sleep(1000);
                captureTestCaseScreenshotClaimsDetails(i);
                Thread.sleep(1000);

                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                // DRIVERS

                Thread.sleep(2000);
                nimbisPrestigeMotor.clickEditDriver_Btn();

                nimbisUserNavigation.changeFocusDriver();

                nimbisPrestigeMotor.clickLicenseCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "License Codes"));

                nimbisPrestigeMotor.enterLicenseDate(EH.getCellValueSpecific(i, "License Dates"));

                Thread.sleep(1000);
                captureTestCaseScreenshotLicenseCode(i);
                Thread.sleep(1000);
                nimbisPrestigeMotor.clickDriverSave_Btn();

                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();


                // EXTENSIONS
                Thread.sleep(1500);
                if (EH.getCellValueSpecific(i, "Credit shortfall - extended").equals("Yes")) {
                    nimbisPrestigeMotor.clickCreditShortfallExtended();
                    nimbisPrestigeMotor.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(i, "Credit shortfall - extended Sum Insured"));
                }


                if (EH.getCellValueSpecific(i, "Reduction in value").equals("Yes")) {
                    nimbisPrestigeMotor.clickReductionInValue();
                    nimbisPrestigeMotor.enterReductionInValueSumInsured(EH.getCellValueSpecific(i, "Reduction in value Sum Insured"));
                }

                if (EH.getCellValueSpecific(i, "Off-road driving (4x4)").equals("Yes")) {
                    nimbisPrestigeMotor.clickOffRoadDriving();
                }

                if (EH.getCellValueSpecific(i, "Tyre cover").equals("Yes")) {
                    nimbisPrestigeMotor.clickTyreCover();
                    nimbisPrestigeMotor.enterTyreCoverSumInsured(EH.getCellValueSpecific(i, "Tyre cover"));
                }
                Thread.sleep(1000);
                captureTestCaseScreenshotExtensions(i);
                Thread.sleep(1000);

                //SPECIFIED ACCESSORIES

                if (EH.getCellValueSpecific(i, "Specified Accessories").equals("Yes")) {

                    Thread.sleep(1500);
                    nimbisPrestigeMotor.clickAddSpecifiedAccessories();
                    nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Specified Accessories Name"));
                    Thread.sleep(1500);
                    nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(i, "Specified Accessories Value"));
                    Thread.sleep(1000);
                    captureTestCaseScreenshotSpecifiedAccessories(i);
                    Thread.sleep(1000);

                    nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
                }

                //CAR HIRE
                Thread.sleep(2000);
                if (EH.getCellValueSpecific(i, "Car Hire").equals("Yes")) {
                    nimbisPrestigeMotor.clickCarHire();
                    nimbisPrestigeMotor.clickCarHireOptionDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Car Hire Option"));
                    nimbisPrestigeMotor.clickCarHireDaysDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Car Hire Days"));
                }
                Thread.sleep(1000);
                captureTestCaseScreenshotCarHire(i);
                Thread.sleep(5000);
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

    public void captureTestCaseScreenshotRiskDetails(int i) {
        String[] RatingInfoFields = new String[]{"Vehicle Type", "VIN Number", "Registration Number", "Odometer Reading", "Engine Number", "Performance enhancing modifications", "Vehicle Colour", "Vehicle Code"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotSecurity(int i) {
        String[] RatingInfoFields = new String[]{"First tracking device required", "First tracking device type", "Second Tracking Device required", "Second tracking device type"};
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
    public void captureTestCaseScreenshotCoverDetails(int i) {
        String[] RatingInfoFields = new String[]{"Basis of Settlement","Cover Type","Class of Use","Supported business"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotExcess(int i, String cover, String sumInsured) {
        String[] RatingInfoFields = new String[]{"Basic Excess"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + " - " + cover + " " + ", Selected option : " + EH.getCellValueSpecific(i,sumInsured));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotClaimsDetails(int i) {
        String[] RatingInfoFields = new String[]{"Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover", "Regular driver/rider driving convictions in the last 5 years",
                "Advanced Driver", "Regular Driver number of claims in the last 12 months, excluding glass damage","Regular Driver number of claims in the last 13 - 24 months, excluding glass damage","Regular Driver number of claims in the last 25 - 36 months, excluding glass damage","Is Financed"};
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
    public void captureTestCaseScreenshotSpecifiedAccessories(int i) {
        String[] RatingInfoFields = new String[]{"Specified Accessories Name","Specified Accessories Value"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotExtensions(int i) {
        String[] RatingInfoFields = new String[]{"Credit shortfall - extended","Credit shortfall - extended Sum Insured","Reduction in value","Reduction in value Sum Insured"
        ,"Off-road driving (4x4)","Tyre cover","Tyre Cover Sum Insured"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotCarHire(int i) {
        String[] RatingInfoFields = new String[]{"Car Hire","Car Hire Option","Car Hire Days"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValue(Integer.toString(i), "Test objective") + ", Selected option : " + EH.getCellValue(Integer.toString(i), RatingInfoField));
                break;
            }
        }
    }



}


