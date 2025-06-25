package com.sts.testautomation.steps;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Watercraft_FieldValidation extends BaseTest {


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
    @Test(priority = 1, description = "Add Motorcycle Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB,Device);
        nimbisPrestigeWatercraft = new NIMBIS_Prestige_Watercraft(testB,Device);

        EH = new ExcelHandler(Sheet, "Watercraft Test Cases", 0, 0);

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

        nimbisPrestigeWatercraft.enterNumberOfMotor(EH.getCellValueSpecific(1,"Number of Motors"));
        nimbisPrestigeWatercraft.clickMotorMake();
        nimbisUserNavigation.selectOptionWatercraft(EH.getCellValueSpecific(1,"Motor Make"));
        // ===== FINANCE =====
        nimbisPrestigeWatercraft.enterCreditShortfall(EH.getCellValueSpecific(1,"Credit Shortfall"));
        // ===== VESSEL =====
        nimbisPrestigeWatercraft.enterCraftMakeAndModel(EH.getCellValueSpecific(1,"Craft Make and Model"));
        nimbisPrestigeWatercraft.enterCraftName(EH.getCellValueSpecific(1,"Craft Name"));
        if(EH.getCellValueSpecific(1,"Glitter Finish").equals("Yes")){
            nimbisPrestigeWatercraft.clickGlitterFinish();
        }
        nimbisPrestigeWatercraft.enterYearOfManufacture(EH.getCellValueSpecific(1,"Year of manufacture"));
        nimbisPrestigeWatercraft.clickCraftType();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Craft Type"));
        nimbisPrestigeWatercraft.clickHullConstruction();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Hull construction"));
        nimbisPrestigeWatercraft.enterSumInsured(EH.getCellValueSpecific(1,"Sum Insured"));
        nimbisPrestigeWatercraft.enterLengthOfVessel(EH.getCellValueSpecific(1,"Length of vessel"));
        // ===== DISCLOSURES =====
        if(EH.getCellValueSpecific(1,"Modifications").equals("Yes")){
            nimbisPrestigeWatercraft.clickModifications();
        }
        // ===== SITUATION =====
        nimbisPrestigeWatercraft.clickUseOfCraft();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Use of craft"));
        // ===== COVER OPTIONS =====
        nimbisPrestigeWatercraft.clickTypeOfCover();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Type of cover"));

        nimbisPrestigeWatercraft.clickWaterCraftLiability();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Watercraft liability"));

        nimbisPrestigeWatercraft.clickAreaOfUse();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Area of use"));

        nimbisPrestigeWatercraft.clickStorageMethod();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Storage method"));

        if(EH.getCellValueSpecific(1,"Craft surf launched").equals("Yes")){
            nimbisPrestigeWatercraft.clickCraftSurfLaunched();
        }

        //SPECIFIED ACCESSORIES

        if (EH.getCellValueSpecific(1,"Specified Accessories").equals("Yes")){

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
        nimbisUserNavigation.selectOption("Inboard");

        nimbisPrestigeWatercraft.enterEngineSumInsured(EH.getCellValueSpecific(1,"Engine Sum Insured"));

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

    public void captureTestCaseScreenshotRiskDetails(int i) {
        String[] RatingInfoFields = new String[]{"VIN Number","Engine Number","Registration Number","Vintage motorcycle applicable","Performance enhancing modifications","Vehicle Code","Restricted Driver","Regular driver/rider driving convictions in the last 5 years","Regular driver retired"};
        for (String RatingInfoField : RatingInfoFields) {
            if (EH.getCellValue(Integer.toString(i), "Test objective").equalsIgnoreCase(RatingInfoField)) {
                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH.getCellValueSpecific(i, "Test objective") + ", Selected option : " + EH.getCellValueSpecific(i, RatingInfoField));
                break;
            }
        }
    }


}
