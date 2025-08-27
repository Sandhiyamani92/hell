package NIMBIS_Prestige_vintage;
import NIMBISSharedClasses.BaseTest;
import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
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
public class Watercraft extends BaseTest {


    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private  NIMBIS_Prestige_Watercraft nimbisPrestigeWatercraft;
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
    @Test(priority = 1, description = "Add Watercraft Section")
    public void addWatercraftSection(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB,Device);
        nimbisPrestigeWatercraft = new NIMBIS_Prestige_Watercraft(testB,Device);

        EH = new ExcelHandler(Sheet, "Motor Test Cases", 0, 0);

        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(5000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(5000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickWatercraftCover();
        Thread.sleep(4000);
        nimbisUserNavigation.clickAddNewItemBtn();
        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        // ===== CRAFT MOTOR DETAILS =====

      //  nimbisPrestigeWatercraft.enterSumInsured(EH.getCellValueSpecific();


        nimbisPrestigeWatercraft.enterNumberOfMotor("1");
      //  nimbisPrestigeWatercraft.clickMotorMake();
        //nimbisUserNavigation.selectOptionWatercraft("Honda");
        // ===== FINANCE =====
        nimbisPrestigeWatercraft.enterCreditShortfall("0.00");
        // ===== VESSEL =====
        nimbisPrestigeWatercraft.enterCraftMakeAndModel("MAKEMODEL");
        nimbisPrestigeWatercraft.enterCraftName("UNITEDSTAND");
        if("Yes".equals("Yes")){
            nimbisPrestigeWatercraft.clickGlitterFinish();
        }
        nimbisPrestigeWatercraft.enterYearOfManufacture("2010");
        nimbisPrestigeWatercraft.clickCraftType();
        nimbisUserNavigation.selectOption("Canoe");
        nimbisPrestigeWatercraft.clickHullConstruction();
        nimbisUserNavigation.selectOption("Wood");
        nimbisPrestigeWatercraft.enterSumInsured("10000000");
        nimbisPrestigeWatercraft.enterLengthOfVessel("10");
        // ===== DISCLOSURES =====
        if("Yes".equals("Yes")){
            nimbisPrestigeWatercraft.clickModifications();
        }
        // ===== SITUATION =====
        nimbisPrestigeWatercraft.clickUseOfCraft();
        nimbisUserNavigation.selectOption("Personal");
        // ===== COVER OPTIONS =====
        nimbisPrestigeWatercraft.clickTypeOfCover();
        nimbisUserNavigation.selectOption("Comprehensive");

        nimbisPrestigeWatercraft.clickWaterCraftLiability();
        nimbisUserNavigation.selectOption("Yes");

        nimbisPrestigeWatercraft.clickAreaOfUse();
        nimbisUserNavigation.selectOption("Coastal");

        nimbisPrestigeWatercraft.clickStorageMethod();
        nimbisUserNavigation.selectOption("Boat club open air");

        if("Yes".equals("Yes")){
            nimbisPrestigeWatercraft.clickCraftSurfLaunched();
        }

        //SPECIFIED ACCESSORIES

        if ("No".equals("Yes")){

            Thread.sleep(1500);
            nimbisPrestigeMotor.clickAddSpecifiedAccessories();
            nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
            nimbisUserNavigation.selectOption("Bluetooth Kit");
            Thread.sleep(1500);
            nimbisPrestigeMotor.enterSpecifiedAccessoriesValue("100");

            nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
        }

        nimbisPrestigeWatercraft.clickAddEngineBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.changeFocus4();
        nimbisPrestigeWatercraft.clickEngineType();
        nimbisUserNavigation.selectOption("Other");

        nimbisPrestigeWatercraft.enterEngineSumInsured("10000");

        nimbisUserNavigation.clickSaveBtn2();
        Thread.sleep(2000);
        elementFunctionality.switchOutOfBrowserFrame();
        Thread.sleep(1000);
        nimbisUserNavigation.changeFocus2();


        Thread.sleep(1000);
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(7000);
        elementFunctionality.switchOutOfBrowserFrame();
        Thread.sleep(3000);
        nimbisUserNavigation.clickCalculatePremiumBtn();



    }


}
