package NIMBIS_Prestige_PersonalLiability;



import NIMBISSharedClasses.BaseTest;
import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
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

public class Personal_Liability extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Personal_liability nimbisPrestigePersonalLiabity;
    private ExcelHandler EH;
    private String Sheet;
    private common_functions1 common;

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

                         //  WebDriverManager.edgedriver().setup();
                          testB = new EdgeDriver();
                         testB.get(URL);
                           testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                          testB.manage().window().maximize();

                          //  WebDriverManager.edgedriver().setup();
                         //   Map<String, Object> edgeOptionsMap = new HashMap<>();
                          //  edgeOptionsMap.put("args", Arrays.asList("--headless", "--disable-gpu", "--window-size=1920,1080"));
                         //   EdgeOptions options = new EdgeOptions();options.setCapability("ms:edgeOptions", edgeOptionsMap);
                         //   testB = new EdgeDriver(options);
                         //   testB.get(URL);


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
        EH = new ExcelHandler(Sheet, "Personal Liabitity Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigePersonalLiabity = new NIMBIS_Prestige_Personal_liability(testB, Device);


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
                nimbisUserNavigation.clickPersonalLiabilityCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();
                nimbisPrestigePersonalLiabity.enterpersonalSumInsured(EH.getCellValueSpecific(i, "Total Sum Insured"));


                if (EH.getCellValueSpecific(i, "Extended Personal Liability").equalsIgnoreCase("Yes")) {
                    nimbisPrestigePersonalLiabity.clickExtension();
                }
                common.calculatePremium();
                Thread.sleep(1000);
               // ExtentTestManager.getTest().pass("TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
            } catch (Exception e) {
                nimbisUserNavigation.changeFocusToBrowser();
                System.out.println(e.toString());
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                System.out.println("Test Case  : " + i);
               // ExtentTestManager.getTest().fail( "TEST CASE " + i + "Failed");
                System.err.println("TEST CASE " + i + " Failed");
            }
        }


    }
}



