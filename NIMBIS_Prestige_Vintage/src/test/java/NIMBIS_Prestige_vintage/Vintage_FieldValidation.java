package NIMBIS_Prestige_vintage;
import NIMBISSharedClasses.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
import NIMBIS_SharedClasses.extentReports.ExtentTestManager;
import NIMBIS_SharedClasses.nimbisutilities.common_functions1;
import NIMBIS_SharedClasses.pages.web.*;
import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import NIMBIS_SharedClasses.utilities.ExcelHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Vintage_FieldValidation extends BaseTest {


    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private  NIMBIS_Vintage nimbisVintage;
    private ExcelHandler EH;
    private String Sheet;
    private common_functions1 commonFunctions;

    String projectPath = System.getProperty("user.dir");
    File currentDir = new File(projectPath);
    File parentDir = currentDir.getParentFile();
    String basePath = parentDir.getAbsolutePath();
    String excelPath = basePath + File.separator + "src" + File.separator + "NIMBIS.xlsx";

    @Parameters({"URL", "Device"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = excelPath ;

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
    @Test(priority = 1, description = "Add Vintage Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB,Device);
        nimbisVintage = new NIMBIS_Vintage(testB,Device);
        commonFunctions=new common_functions1(testB,Device,Sheet);

        EH = new ExcelHandler(Sheet, "Vintage Test Cases", 0, 0);
        nimbisUserNavigation.enterSearchText("Vukani Shembe");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        // nimbisUserNavigation.clickPopUpOkBtn();
        JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickVintageCover();

        for(int i = 1 ; i <= EH.numRows;i++){
            try{

        Thread.sleep(4000);
        nimbisUserNavigation.clickAddNewItemBtn();
        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        // ===== VEHICLE DETAILS =====//

                if (EH.getCellValueSpecific(i, "Performance enhancing modifications").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickPerformanceModification();
                    elementFunctionality.captureScreenshotOnDevice("Performance enhancing modifications");
                }

                nimbisVintage.enterModel(EH.getCellValueSpecific(i,"Model"));

                nimbisVintage.enterMake(EH.getCellValueSpecific(i,"Make"));

                nimbisVintage.enterYear(EH.getCellValueSpecific(i,"Year"));

                nimbisVintage.entervin(EH.getCellValueSpecific(i,"Vin"));

                nimbisVintage.enterengineNum(EH.getCellValueSpecific(i,"Engine Number"));

                nimbisVintage.enterRegisterationNum(EH.getCellValueSpecific(i,"Registration Number"));

                nimbisVintage.clickVehicle_Code_DD();

                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Vehicle Code"));
// ===== INSURED VALUE =====//

                nimbisVintage.entervintageSumInsured(EH.getCellValueSpecific(i,"Sum Insured"));
// ===== Disclosures =====//
                if (EH.getCellValueSpecific(i, "Regular driver/rider driving convictions in the last 5 years").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickDrivingConvictions();
                    elementFunctionality.captureScreenshotOnDevice("Regular driver/rider driving convictions in the last 5 years");
                }
                nimbisVintage.enterUninteruptedcover(EH.getCellValueSpecific(i,"Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));
                // ===== Claims =====//
                nimbisVintage.enterClaims12(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 12 months, excluding glass damage"));
                Thread.sleep(500);
                nimbisVintage.enterClaims13_24(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));


                // ===== Driver =====//
                nimbisVintage.enterLicense_date(EH.getCellValueSpecific(i,"License Date"));
                nimbisVintage.clickAllowed_driver_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Allowed Drivers"));
                nimbisVintage.enterClaims25_36(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));
                Thread.sleep(1000);
                // ===== Situation =====//
                nimbisVintage.clickParking_Overnight_DD();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Parking Overnight"));
                Thread.sleep(1000);
                // ===== Cover Options =====//
                nimbisVintage.clickClass_Of_uset_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Class of Use"));
                Thread.sleep(1000);
                nimbisVintage.clickCoverType_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Cover Type"));
                if (EH.getCellValueSpecific(i, "Supported business").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickSupportedBusiness();
                    elementFunctionality.captureScreenshotOnDevice("Supported business");
                }
                Thread.sleep(1000);
                nimbisVintage.clickRestricted_Driver_DD();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Restricted Driver"));
                Thread.sleep(1000);
                nimbisVintage.clickaddDriver();
                Thread.sleep(2000);
                nimbisUserNavigation.changeFocusDriver();
                //Client Name
                nimbisVintage.enterPolicyHolderName(EH.getCellValueSpecific(i,"Policyholder surname"));
//Client Details
                nimbisVintage.clickTypeOfPolicyHolderTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Policyholder Type"));
                if (EH.getCellValueSpecific(i, "Policyholder retired").equalsIgnoreCase("Yes")) {
                    nimbisVintage.clickPolicyholderRetired();
                    elementFunctionality.captureScreenshotOnDevice("Policyholder retired");
                }
                nimbisVintage.enterPolicyHolderDateofbith(EH.getCellValueSpecific(i,"Date of Birth"));
                //Thread.sleep(1000);
                nimbisVintage.enterPolicyHolderIdentification(EH.getCellValueSpecific(i,"Identification"));
               // Thread.sleep(1000);
                nimbisVintage.clickTypeOfPolicyHolderGenderDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Gender"));
                nimbisVintage.clickMaritialstatusDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Marital_Status"));
                //Policyholder Representative

                nimbisVintage.enterPolicyHolderPassportNum(EH.getCellValueSpecific(i,"Policyholder representative passport number"));
                //license information

                nimbisVintage.clickTypeOfPolicyHolderLicenceCodeDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"License Code"));
                nimbisVintage.enterPolicyHolderLicenceDate(EH.getCellValueSpecific(i,"License Date"));
                nimbisVintage.clickTypeOfPolicyHolderRelationshipDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Relationshi"));
                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn2();
                Thread.sleep(2000);
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocus2();

                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();
                //  commonFunctions.calculatePremium();

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

    public void captureTestCaseScreenshotInsuredDetails(int i) {
        String[] RatingInfoFields = new String[]{"Number of Motors"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotVesselsDetails(int i) {
        String[] RatingInfoFields = new String[]{"Number of Motors","Motor Make","Craft Make and Model","Glitter Finish","Year of manufacture","Craft Type","Hull construction","Sum Insured","Length of vessel"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotCoverDetails(int i) {
        String[] RatingInfoFields = new String[]{"Modifications","Use of craft","Type of cover","Area of use","Storage method","Craft surf launched"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

    public void captureTestCaseScreenshotEngineDetails(int i) {
        String[] RatingInfoFields = new String[]{"Engine Type","Engine Year of Manufacture","Horse Power","Engine Sum Insured","Engine Manufacture","Serial Number"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }



}
