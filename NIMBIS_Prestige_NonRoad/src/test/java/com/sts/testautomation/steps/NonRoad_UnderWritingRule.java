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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NonRoad_UnderWritingRule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private NIMBIS_NonRoad_Vehicle nimbisNonRoadVehicle;
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
            Sheet = excelPath;

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

                            System.out.println("Creation of driver");

                           // WebDriverManager.edgedriver().setup();
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
    public void Login() throws Exception {


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
        EH = new ExcelHandler(Sheet, "Non road", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
        nimbisNonRoadVehicle= new NIMBIS_NonRoad_Vehicle(testB,Device);
        commonFunctions = new common_functions1(testB, Device, Sheet);
        url = URL;
        commonFunctions.searchClientandopenQuote();
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        commonFunctions.contentsection();
        int totalRows = EH.numRows;
        System.out.println("Processing " + (totalRows - 1) + " test cases...");
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(4000);
        nimbisUserNavigation.clickNonRoadVehicleCover();
        Thread.sleep(3000);
        System.out.println("add");
        nimbisUserNavigation.clickAddNewItemBtn();
        Thread.sleep(3000);
        nimbisUserNavigation.changeFocus2();
        for (int i = 1; i <= EH.numRows; i++)
        {
            try {
                if (i > 1) {
                    nimbisUserNavigation.clickCoverBtn();
                    Thread.sleep(4000);
                    nimbisUserNavigation.clickNonRoadVehicleCover();
                    nimbisUserNavigation.clickeditnonroaddetails();
                    nimbisUserNavigation.changeFocus2();
                }

                // Fill form with data from Excel
                nimbisNonRoadVehicle.enternonroadValue(EH.getCellValueSpecific(i, "Sum Insured"));
                nimbisNonRoadVehicle.clickVehicleTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Type"));
                nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(i, "Make"));
                nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(i, "Model"));
                nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(i, "Year of manufacture"));
                nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(i, "Registered Owner"));
                elementFunctionality.captureScreenshotOnDevice("Vehicle details");
                nimbisNonRoadVehicle.enternonroadClaims012(EH.getCellValueSpecific(i, "Number of Non-road Vehicles claims in the last 12 months"));
                nimbisNonRoadVehicle.enternonroadClaims324(EH.getCellValueSpecific(i, "Number of Non-road Vehicles claims in the last 13 to 24 months"));
                nimbisNonRoadVehicle.enternonroadClaims2536(EH.getCellValueSpecific(i, "Number of Non-road Vehicles claims in the last 25 to 36 months"));
                elementFunctionality.captureScreenshotOnDevice("Claim history");
                // Calculate premium
                commonFunctions.UW_calculatePremium("Non road",i);
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
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

}
