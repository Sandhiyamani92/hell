package NIMBIS_Prestige_AssestsSpecified;

import NIMBISSharedClasses.BaseTest;
import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
import NIMBIS_SharedClasses.pages.web.*;
import NIMBIS_SharedClasses.utilities.ElementFunctionality;
import NIMBIS_SharedClasses.utilities.ExcelHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Assests_Specified_UnderWritingRule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
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

                         //   WebDriverManager.edgedriver().setup();
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
        EH = new ExcelHandler(Sheet, "Content Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);


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
    }

    @Parameters({"URL"})
    @Test(priority = 2, description = "UR612-Building on a property within 100m of a body of water")
    public void UWRule(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAssetsSpecifiedCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(1, "Sum insured"));
        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "cover details"));
        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "NCB"));
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));
        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(1, "Use of adjoining land"));
        nimbisPrestigeContents.clickWithin100mOfaWaterBody();
        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));
        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(3000);

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
     String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("The building is situated closer than 100m to a body of water. Please check the altitude in the Grip report and if it is less than 15m, the cover request must be approved by Hollard.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 3, description = "UR614-Wall construction is Asbestos")
    public void UR614(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(1, "Sum insured"));
        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "cover details"));
        nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(27, "Wall type"));
        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "NCB"));
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));
        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(1, "Use of adjoining land"));

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));
        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(3000);

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("We do not cover buildings with walls made of asbestos. The cover request is declined.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 4, description = "UR622-Building use of premises residential and business")
    public void UR622(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(1, "Sum insured"));
        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "cover details"));
        nimbisPrestigeContents.clickUseOfPremisesDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(48, "Use of premises"));

        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "NCB"));
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));
        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(1, "Use of adjoining land"));

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));
        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(3000);

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("The building is used for residential and business purposes. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 5, description = "UR627-Contents at Home which is a holiday home and no main residence on the same policy")
    public void UR627(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(1, "Sum insured"));
        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "cover details"));
        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(45, "Residence type"));

        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "NCB"));
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));
        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(1, "Use of adjoining land"));

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));
        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(3000);

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("Contents are kept at a holiday home. Because there is no main residence on the same policy. The cover request must be approved by Hollard.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 6, description = "UR628-Contents at Home which is not a holiday home and is unoccupied for more than 90 days per year")
    public void UR628(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeContents.enterContentsSumInsured(EH.getCellValueSpecific(1, "Sum insured"));
        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "cover details"));
        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(45, "Residence type"));
        nimbisPrestigeHome.clickDaysUnoccupied90Days();
        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "NCB"));
        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance(EH.getCellValueSpecific(1, "Years of previous uninterrupted contents insurance cover"));
        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionradiobox(EH.getCellValueSpecific(1, "Use of adjoining land"));

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));
        nimbisPrestigeContents.clickpermiterProtection_DD();
        Thread.sleep(3000);

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

        //claims

        nimbisPrestigeContents.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 12 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisPrestigeContents.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("The Contents are kept in a Home which is not a Holiday Home and is unoccupied for more than 90 days. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }



}
