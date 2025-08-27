package NIMBIS_Prestige_Trailer;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Trailer_Underwriting_Rule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;

    private ExcelHandler EH;
    private String Sheet;
    private NIMBIS_Caravan nimbisCaravn;
    private NIMBIS_Trailer nimbisTrailer;
    private common_functions1 commonFunctions;

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
                            String projectPath = System.getProperty("user.dir");
                            File currentDir = new File(projectPath);
                            File parentDir = currentDir.getParentFile();
                            String basePath = parentDir.getAbsolutePath();
                            System.out.println("Base path: " + basePath);
                            String relativePath = "Browser" + File.separator + "edgedriver_win64" + File.separator + "msedgedriver.exe";
                            String driverPath = basePath + File.separator + relativePath;

                            System.setProperty("webdriver.edge.driver", driverPath);
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
    public void Login(String URL) throws Exception {
        // url = URL;

        nimbisLogin = new NIMBIS_Login(testB, Device);

        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        EH = new ExcelHandler(Sheet, "LoginDetails", 0, 0);
        nimbisLogin.enterUsername(EH.getCellValueSpecific(1, "Username"));
        nimbisLogin.clickContinueBtn();
        nimbisLogin.enterPassword(EH.getCellValueSpecific(1, "Password"));
        nimbisLogin.clickSignInBtn();
        Thread.sleep(4000);
    }


    @Parameters({"URL"})
    @Test(priority = 1, description = "Search Client")
    public void CreateClient(String URL) throws Exception {
        EH = new ExcelHandler(Sheet, "Trailer Test Cases", 0, 0);
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        commonFunctions = new common_functions1(testB, Device, Sheet);
        commonFunctions.searchClientandopenQuote();

    }

    @Parameters({"URL"})
    @Test(priority = 2, description = "UW rule section for Trailer")
    public void UR_for_Trailer(String URL) throws Exception {
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);
        nimbisTrailer = new NIMBIS_Trailer(testB, Device);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        commonFunctions.contentsection();
        int totalRows = EH.numRows;
        System.out.println("Processing " + (totalRows - 1) + " test cases...");
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(6000);
        nimbisUserNavigation.clickTrailerCover();
        Thread.sleep(6000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(3000);
        nimbisUserNavigation.changeFocus2();
        for (int i = 1; i <= EH.numRows; i++) {
            try {
                if (i > 1) {
                    nimbisUserNavigation.clickCoverBtn();
                    Thread.sleep(4000);
                    nimbisUserNavigation.clickTrailerCover();
                    nimbisUserNavigation.clickeditnonroaddetails();
                    nimbisUserNavigation.changeFocus2();
                }
//enter Trailer section

                nimbisTrailer.enterTrailerSum((EH.getCellValueSpecific(i, "Caravan Value")));
                nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(i, "Make"));
                nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(i, "Model"));
                nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(i, "Year"));
                nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(i, "Registration Number"));

                nimbisTrailer.enterTrailerClaim012Months(
                        EH.getCellValueSpecific(i, "Number of Trailer claims in the last 12 months, excluding glass damage"));
                nimbisTrailer.enterTrailerClaim1324Months(
                        EH.getCellValueSpecific(i, "Number of Trailer claims in the last 13 - 24 months, excluding glass damage"));
                nimbisTrailer.enterTrailerClaim2536Months(
                        EH.getCellValueSpecific(i, "Number of Trailer claims in the last 25 - 36 months, excluding glass damage"));


                elementFunctionality.captureScreenshotOnDevice("Claim history");
                // Calculate premium
                commonFunctions.UW_calculatePremium("Caravan", i);
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
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
