package NIMBIS_Prestige_caravan;



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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Caravan extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private NIMBIS_Caravan nimbisCaravn;
    private ExcelHandler EH;
    private String Sheet;

    String projectPath = System.getProperty("user.dir");
    File currentDir = new File(projectPath);
    File parentDir = currentDir.getParentFile();
    String basePath = parentDir.getAbsolutePath();
    String excelPath = basePath + File.separator + "src" + File.separator + "NIMBIS.xlsx";
    @Parameters({"URL", "Device", "NIMBIS"})
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
        Thread.sleep(6000);
    }


    @Parameters({"URL"})
    @Test(priority = 1, description = "Search Client")
    public void CreateClient(String URL) throws Exception {
        EH = new ExcelHandler(Sheet, "Caravan Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);

        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        url = URL;


        Thread.sleep(3000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(3000);
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

                nimbisUserNavigation.clickCaravanCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(3000);
                nimbisUserNavigation.changeFocus2();

                nimbisCaravn.enterCaravanValue(EH.getCellValueSpecific(i, "Caravan Value"));

//Vehicle
                nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(i, "Make"));
                nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(i, "Model"));
                nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(i, "Year"));
                nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(i, "Registeration Number"));
                //claims
                nimbisCaravn.enterCaravanClaim012Months(EH.getCellValueSpecific(i, "Number of Caravan claims in the last 0 - 12 months, excluding glass damage"));
                nimbisCaravn.enterCaravanClaim1324Months(EH.getCellValueSpecific(i, "Number of Caravan claims in the last 13 - 24 months, excluding glass damage"));
                nimbisCaravn.enterCaravanClaim2536Months(EH.getCellValueSpecific(i, "Number of Caravan claims in the last 25 - 36 months, excluding glass damage"));
//extensions
                nimbisCaravn.clickExtension();
                nimbisCaravn.enterExtensionSum(EH.getCellValueSpecific(i, "sum insured"));

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
                ExtentTestManager.getTest().log( LogStatus.PASS,"TEST CASE " + i + "Passed");
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
                System.err.println("TEST CASE " + i + " Failed");
            }
        }


    }
}

