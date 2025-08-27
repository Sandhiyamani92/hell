package NIMBIS_Prestige_Contents;


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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

import java.util.concurrent.TimeUnit;

public class Contents extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
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
        EH = new ExcelHandler(Sheet, "Content Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
        commonFunctions = new common_functions1(testB, Device, Sheet);

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
        // nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(1000);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        for (int i = 1; i <= 30; i++) {
            try {
                Thread.sleep(2000);

                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(3000);
                nimbisUserNavigation.changeFocus2();

                //Cover Detail

                nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(i, "Sum insured"));

                nimbisPrestigeContents.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of Cover"));
                elementFunctionality.captureScreenshotOnDevice("cover details");
                //risk details

                nimbisPrestigeContents.clickTypeOfHomeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of home"));

                if (EH.getCellValueSpecific(i, "Unoccupied for more than 90 days").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickDaysUnoccupied90Days();
                }

                nimbisPrestigeContents.clickTypeOfRoofConstructionDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of roof construction"));

                nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Type of wall construction"));

                if (EH.getCellValueSpecific(i, "Lightning Conductor (SABS)").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickLightningConductorSABS();
                }

                if (EH.getCellValueSpecific(i, "Fire retardant (SABS)").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickFireRetardantSABS();
                }

                if (EH.getCellValueSpecific(i, "Surge Protection (SANS)").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickSurgeProtectionSANS();
                }

                nimbisPrestigeContents.clickResidenceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Residence Type"));

                nimbisPrestigeContents.clickUseOfPremisesDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Use of premises"));

                elementFunctionality.captureScreenshotOnDevice("Risk details");

//Disclosures
                nimbisPrestigeContents.clickNCB_DropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "NCB"));

                nimbisPrestigeContents.clickIncreasedRiskBusinessType();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Increased risk business type"));

                if (EH.getCellValueSpecific(i, "Thatch or non-standard structure more than 15% of main building").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickThatch15OfMainBuilding();
                }

                if (EH.getCellValueSpecific(i, "Renewable energy equipment").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickRenewableEnergyEquipment();
                }

                nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(i, "Years of previous uninterrupted contents insurance cover"));

                if (EH.getCellValueSpecific(i, "Plot, smallholding or farm").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickPlotSmallHoldingOrFarm();
                }

                if (EH.getCellValueSpecific(i, "commune").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickCommune();
                }

                    nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
                Thread.sleep(500);
                    nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(i, "Use of adjoining land"));
                    //  nimbisPrestigeContents.enter
Thread.sleep(5000);


                if (EH.getCellValueSpecific(i, "Within 100m of a water body").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickWithin100mOfaWaterBody();
                }

                if (EH.getCellValueSpecific(i, "Survey completed").equalsIgnoreCase("Yes")) {
                   // nimbisPrestigeContents.surv();
                }
                elementFunctionality.captureScreenshotOnDevice("disclosures");
                    //security
                    nimbisPrestigeContents.clickElectricFence_DropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Electric Fence"));

                if (EH.getCellValueSpecific(i, "Burglar bars on all opening windows").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickBurglarBarsOpeningWindows();
                }

                if (EH.getCellValueSpecific(i, "Alarm linked to armed response").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickAlarmLinkedToArmedResponse();
                }

                if (EH.getCellValueSpecific(i, "24 hour security guard").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickTwentyFourHourSecurityGuard();
                }

                if (EH.getCellValueSpecific(i, "Access controlled area").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickAccessControlledArea();
                }

                if (EH.getCellValueSpecific(i, "All doors protected by security gates").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickAllDoorsProtectedBySecurityGates();
                }

                    nimbisPrestigeContents.clickpermiterProtection_DD();
                    Thread.sleep(2000);
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Perimeter protection"));

                if (EH.getCellValueSpecific(i, "High-security estate/complex").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickHighSecurityEstateComplex();
                }

                if (EH.getCellValueSpecific(i, "CCTV camera").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickCCTVCamera();
                }

                if (EH.getCellValueSpecific(i, "Laser beams in garden").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickLaserBeamsInGarden();
                }
                elementFunctionality.captureScreenshotOnDevice("Security");
                    //claims

                    nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 12 months"));

                    nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 13 to 24 months"));

                    nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i, "Number of Contents claims in the last 25 to 36 months"));

                elementFunctionality.captureScreenshotOnDevice("Claims");
                    //excess options

                nimbisPrestigeContents.enterAdditionalExcess_Txt(EH.getCellValueSpecific(i, "Additional Excess"));

                      nimbisPrestigeContents.clickBasicExcessDropDown();
                Thread.sleep(1000);
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basic Excess"));

                elementFunctionality.captureScreenshotOnDevice("Excess options");
                Thread.sleep(1500);

                //Extensions
               // nimbisPrestigeContents.clickItemsOutAndAbout();

                if (EH.getCellValueSpecific(i, "Items out").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickItemsOutAndAbout();
                  //  Thread.sleep(2000);
                   // nimbisNonRoadVehicle.enternonroadFinacialHouse(EH.getCellValueSpecific(i, "Financial Institution"));
                }
               /* if (EH.getCellValueSpecific(i, "Items out").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickItemsOutAndAbout();
                    Thread.sleep(1000);
                  nimbisPrestigeContents.clickItemsabout_DD();
                  nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Items out and about"));

                }
*/
                if (EH.getCellValueSpecific(i, "Bed and Breakfast").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickBedAndBreakfast();
                }

                if (EH.getCellValueSpecific(i, "Business contents").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickBusinessContentsExtendedCover();
                    Thread.sleep(1000);
                    nimbisPrestigeContents.enterBusiness_contents(EH.getCellValueSpecific(i, "Business contents: extended cover"));
                }

                if (EH.getCellValueSpecific(i, "Marquee hire").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickMarqueeHire();
                }

                if (EH.getCellValueSpecific(i, "Power").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickpowersurge();
                    Thread.sleep(1000);
                    nimbisPrestigeContents.clickpowersurge_DD();
                    Thread.sleep(1000);
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Power Surge"));
                }

                if (EH.getCellValueSpecific(i, "Garden and outdoor items").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickGardenAndOutdoorItemsExtendedCover();
                    Thread.sleep(1000);
                    nimbisPrestigeContents.enterAGarden_and_outdoor_items(EH.getCellValueSpecific(i, "Garden and outdoor items - extended cover"));
                }

                elementFunctionality.captureScreenshotOnDevice("Extensions");
                   //addons
                if (EH.getCellValueSpecific(i, "Average waiver").equalsIgnoreCase("Yes")) {
                    nimbisPrestigeContents.clickAverage_waiver();
                }

                elementFunctionality.captureScreenshotOnDevice("addons");
             //   commonFunctions.calculatePremium();
                nimbisUserNavigation.clickSaveBtn();
                    Thread.sleep(2000);
                nimbisUserNavigation.changeFocusToBrowser();
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                    System.err.println("TEST CASE " + i + " Passed");
                Thread.sleep(2000);
                } catch(Exception e){
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



