package com.sts.testautomation.steps;

import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.pages.web.NIMBIS_Login;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Client;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_FineArts;
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

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FineArts_FieldValidation extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_FineArts nimbisPrestigeFineArts;
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
                            System.out.println("Tial Test started on " + currentNode.getKey());
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
    @Test(priority = 1, description = "Add Fine Arts Section")
    public void addFineArtsSection(String URL) throws Exception {


        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeFineArts = new NIMBIS_Prestige_FineArts(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);

        EH = new ExcelHandler(Sheet, "Fine Arts Test Cases", 0, 0);

        System.out.println("Number of Rows : " + EH.numRows);

        for (int i = 1; i <= EH.numRows; i++) {
            try {

                nimbisUserNavigation.enterSearchText("Vukani Shembe ");
                nimbisUserNavigation.clickSearchBtn();

                Thread.sleep(5000);
                nimbisUserNavigation.clickClientResultName();
                Thread.sleep(5000);
                nimbisUserNavigation.clickAddNewQuote();
                Thread.sleep(2000);

                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                Thread.sleep(2000);

                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickPopUpOkBtn();
                Thread.sleep(2000);

                JavascriptExecutor js = (JavascriptExecutor) testB;
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickOpenQuote();
                Thread.sleep(2000);
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(2000);
                Thread.sleep(2000);
                nimbisUserNavigation.clickFineArtsCover();
                Thread.sleep(4000);
                nimbisUserNavigation.clickAddNewItemBtn();
                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                //RISK DETAILS

                nimbisPrestigeFineArts.clickResidenceType();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Residence Type"));

                if (EH.getCellValueSpecific(i, "Unoccupied for more than 90 days").equals("Yes")) {
                    nimbisPrestigeFineArts.clickDaysUnoccupied90Days();
                }

                nimbisPrestigeFineArts.clickTypeOfRoofConstruction();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Roof construction"));

                nimbisPrestigeFineArts.clickTypeOfWallConstruction();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Wall construction"));

                nimbisPrestigeFineArts.clickFineArtCategory();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Fine arts category"));


                //COVER DETAILS

                nimbisPrestigeFineArts.clickTypeOfCover();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of cover"));
                Thread.sleep(2000);
                captureTestCaseScreenshotRiskDetail(i);
                Thread.sleep(1000);

                //SERCURITY MEASURES

                if (EH.getCellValueSpecific(i, "Security gates on all exiting doors").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAllDoorsProtectedBySecurityGates();
                }

                if (EH.getCellValueSpecific(i, "Burglar bars on all opening windows").equals("Yes")) {
                    nimbisPrestigeFineArts.clickBurglarBarsOpeningWindows();
                }

                if (EH.getCellValueSpecific(i, "High-security estate/complex").equals("Yes")) {
                    nimbisPrestigeFineArts.clickHighSecurityEstateComplex();
                }

                if (EH.getCellValueSpecific(i, "Alarm linked to 24-hour armed response service").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAlarmLinkedToArmedResponse();
                }

                nimbisPrestigeFineArts.clickElectricFence();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Electric Fence"));

                if (EH.getCellValueSpecific(i, "Access controlled area").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAccessControlledArea();
                }

                if (EH.getCellValueSpecific(i, "24-hour security guards on property").equals("Yes")) {
                    nimbisPrestigeFineArts.clickTwentyFourHourSecurityGuard();
                }

                if (EH.getCellValueSpecific(i, "Monitored by CCTV cameras").equals("Yes")) {
                    nimbisPrestigeFineArts.clickCctvCamera();
                }

                if (EH.getCellValueSpecific(i, "Outdoor beams linked to armed response").equals("Yes")) {
                    nimbisPrestigeFineArts.clickLaserBeamsInGarden();
                }
                Thread.sleep(2000);
                captureTestCaseScreenshotSERCURITYMEASURES(i);
                Thread.sleep(1000);



                nimbisPrestigeFineArts.clickAlarmType();
                nimbisUserNavigation.selectOptionWatercraft(EH.getCellValueSpecific(i, "Alarm Type"));

                nimbisPrestigeFineArts.clickPerimeterProtection();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Perimeter protection"));

                /// EXTENSIONS

                if(EH.getCellValueSpecific(i,"Exhibition").equals("Yes")){
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(i,"Exhibition Sum Insured"));
                }

                if(EH.getCellValueSpecific(i,"Art at a temporary location").equals("Yes")){
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(i,"Art at a temporary location Sum Insured"));
                }

                if(EH.getCellValueSpecific(i,"Art in transit in South Africa").equals("Yes")){
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(i,"Art in transit in South Africa Sum Insured"));
                }

                if(EH.getCellValueSpecific(i,"Defective title").equals("Yes")){
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(i,"Defective title Sum Insured"));
                }

                Thread.sleep(2000);
                captureTestCaseScreenshotEXTENSIONS(i);
                Thread.sleep(1000);


                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();
                Thread.sleep(7000);
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(3000);
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
    public void captureTestCaseScreenshotRiskDetail(int i) {
        String[] RatingInfoFields = new String[]{"Residence Type", "Unoccupied for more than 90 days", "Roof construction", "Wall construction", "Fine arts category", "Type of cover"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotSERCURITYMEASURES(int i) {
        String[] RatingInfoFields = new String[]{"Security gates on all exiting doors", "Burglar bars on all opening windows", "High-security estate/complex", "Alarm linked to 24-hour armed response service", "Electric Fence", "Access controlled area",
                "Monitored by CCTV cameras", "Outdoor beams linked to armed response"                };
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }
    public void captureTestCaseScreenshotEXTENSIONS(int i) {
        String[] RatingInfoFields = new String[]{"Perimeter protection", "Exhibition", "Exhibition Sum Insured", "Art at a temporary location", "Art at a temporary location Sum Insured", "Art in transit in South Africa",
                "Art in transit in South Africa Sum Insured","Defective title","Defective title Sum Insured" };
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }

}
