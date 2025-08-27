package NIMBIS_Prestige_Watercraft;
import NIMBISSharedClasses.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
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

        EH = new ExcelHandler(Sheet, "Watercraft", 0, 0);

        for(int i = 1 ; i <= EH.numRows;i++){
            try{
        nimbisUserNavigation.enterSearchText("9609137884085 ");
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


        nimbisPrestigeWatercraft.enterSumInsured(EH.getCellValueSpecific(i,"Sum Insured"));

                Thread.sleep(1000);
                captureTestCaseScreenshotInsuredDetails(i);
                Thread.sleep(1000);

        nimbisPrestigeWatercraft.enterNumberOfMotor(EH.getCellValueSpecific(i,"Number of Motors"));
      //  nimbisPrestigeWatercraft.clickMotorMake();
       // nimbisUserNavigation.selectOptionWatercraft(EH.getCellValueSpecific(i,"Motor Make"));
        // ===== FINANCE =====
        nimbisPrestigeWatercraft.enterCreditShortfall(EH.getCellValueSpecific(i,"Credit Shortfall"));
        // ===== VESSEL =====
        nimbisPrestigeWatercraft.enterCraftMakeAndModel(EH.getCellValueSpecific(i,"Craft Make and Model"));
        nimbisPrestigeWatercraft.enterCraftName(EH.getCellValueSpecific(i,"Craft Name"));
        if(EH.getCellValueSpecific(i,"Glitter Finish").equals("Yes")){
            nimbisPrestigeWatercraft.clickGlitterFinish();
        }
        nimbisPrestigeWatercraft.enterYearOfManufacture(EH.getCellValueSpecific(i,"Year of manufacture"));
        nimbisPrestigeWatercraft.clickCraftType();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Craft Type"));
        nimbisPrestigeWatercraft.clickHullConstruction();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Hull construction"));
        nimbisPrestigeWatercraft.enterLengthOfVessel(EH.getCellValueSpecific(i,"Length of vessel"));
                Thread.sleep(1000);

                captureTestCaseScreenshotVesselsDetails(i);
                Thread.sleep(1000);

                // ===== DISCLOSURES =====
        if(EH.getCellValueSpecific(i,"Modifications").equals("Yes")){
            nimbisPrestigeWatercraft.clickModifications();
        }
        // ===== SITUATION =====
        nimbisPrestigeWatercraft.clickUseOfCraft();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Use of craft"));
        // ===== COVER OPTIONS =====
        nimbisPrestigeWatercraft.clickTypeOfCover();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of cover"));

        nimbisPrestigeWatercraft.clickWaterCraftLiability();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Watercraft liability"));

        nimbisPrestigeWatercraft.clickAreaOfUse();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Area of use"));

        nimbisPrestigeWatercraft.clickStorageMethod();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Storage method"));

        if(EH.getCellValueSpecific(i,"Craft surf launched").equals("Yes")){
            nimbisPrestigeWatercraft.clickCraftSurfLaunched();
        }

                Thread.sleep(1000);
                captureTestCaseScreenshotCoverDetails(i);
                Thread.sleep(1000);

        //SPECIFIED ACCESSORIES

        if (EH.getCellValueSpecific(i,"Specified Accessories").equals("Yes")){

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
        nimbisPrestigeWatercraft.enterEngineManufacturer(EH.getCellValueSpecific(i,"Engine Year of Manufacture"));
        nimbisPrestigeWatercraft.enterEngineHorsePower(EH.getCellValueSpecific(i,"Horse Power"));
        nimbisPrestigeWatercraft.enterEngineSerialNumber(EH.getCellValueSpecific(i,"Engine Manufacture"));
        nimbisPrestigeWatercraft.enterEngineYearOfManufacture(EH.getCellValueSpecific(i,"Serial Number"));


        nimbisPrestigeWatercraft.enterEngineSumInsured(EH.getCellValueSpecific(i,"Engine Sum Insured"));
        Thread.sleep(1000);
        captureTestCaseScreenshotEngineDetails(i);
        Thread.sleep(1000);
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
