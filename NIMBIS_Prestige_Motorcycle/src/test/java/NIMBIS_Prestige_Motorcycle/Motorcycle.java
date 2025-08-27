package NIMBIS_Prestige_Motorcycle;
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
public class Motorcycle extends BaseTest {


    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private NIMBIS_Prestige_Motorcycle nimbisPrestigeMotorcycle;
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
        nimbisPrestigeMotorcycle = new NIMBIS_Prestige_Motorcycle(testB,Device);

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
        nimbisUserNavigation.clickMotorcycleCover();
        Thread.sleep(4000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();

        // RISK DETAILS

        nimbisPrestigeMotor.clickChangeBtn();
        nimbisUserNavigation.changeFocusVehicle();
        Thread.sleep(2000);
        nimbisPrestigeMotor.enterVehicleSearch("17095200");
        Thread.sleep(2000);
        nimbisPrestigeMotor.clickSearchBtn();
        Thread.sleep(2000);
        nimbisPrestigeMotor.clickVehicleResult1();

        Thread.sleep(2000);
        nimbisPrestigeMotor.enterVehicleValue("100 000");
        Thread.sleep(1000);
        nimbisPrestigeMotor.clickSelectBtn();


        Thread.sleep(2000);

        elementFunctionality.switchOutOfBrowserFrame();

        nimbisUserNavigation.changeFocus2();

        nimbisPrestigeMotorcycle.enterVINNumber(EH.getCellValueSpecific(1,"VIN Number"));

        nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(1,"Engine Number"));

        nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(1,"Registration Number"));

        if (EH.getCellValueSpecific(1,"Performance enhancing modifications").equals("Yes")){
            nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
        }

        nimbisPrestigeMotorcycle.clickVehicleCodeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Vehicle Code"));

        nimbisPrestigeMotorcycle.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(1,"Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));


        if(EH.getCellValueSpecific(1,"Regular driver/rider driving convictions in the last 5 years").equals("Yes")){
            nimbisPrestigeMotorcycle.clickDriverConvictionsInTheLast5Years();
        }

        //CLAIMS

        nimbisPrestigeMotorcycle.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 12 months, excluding glass damage"));

        nimbisPrestigeMotorcycle.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

        nimbisPrestigeMotorcycle.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));


        nimbisPrestigeMotor.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Cover Type"));

        nimbisPrestigeMotorcycle.clickClaimFreeGroup_DropDown();
        nimbisUserNavigation.selectOption("0");

        nimbisPrestigeMotorcycle.clickVehicleLiability_DropDown();
        nimbisUserNavigation.selectOption("Yes");

        nimbisPrestigeMotorcycle.clickNCB_DropDown();
        nimbisUserNavigation.selectOption("0");

        nimbisPrestigeMotorcycle.clickBasisOfSettlementDropDown();
        nimbisUserNavigation.selectOption("Retail Value");

        nimbisPrestigeMotorcycle.clickBasicExcessDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Basic Excess"));

        nimbisPrestigeMotorcycle.clickClassOfUseDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Class of Use"));

        ///

        nimbisPrestigeMotorcycle.clickAllowedRiders_DropDown();
        nimbisUserNavigation.selectOption("Insured Only");

        ////

        if (EH.getCellValueSpecific(1,"Is Financed").equals("Yes")){

            nimbisPrestigeMotor.clickIsFinanced();

            nimbisPrestigeMotor.enterFinanceHouse("FNB");
        }

        // SITUATION

        nimbisPrestigeMotor.clickOvernightParkingDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Overnight Parking"));
        //SPECIFIED ACCESSORIES

//        if (EH.getCellValueSpecific(1,"Specified Accessories").equals("Yes")){
//
//            Thread.sleep(1500);
//            nimbisPrestigeMotor.clickAddSpecifiedAccessories();
//            nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
//            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Specified Accessories Name"));
//            Thread.sleep(1500);
//            nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(1,"Specified Accessories Value"));
//
//            nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
//        }

        // DRIVERS

        Thread.sleep(2000);
        nimbisPrestigeMotor.clickEditDriver_Btn();

        nimbisUserNavigation.changeFocusDriver();

        nimbisPrestigeMotor.clickLicenseCodeDropDown();
        nimbisUserNavigation.selectOption("A");

        nimbisPrestigeMotor.enterLicenseDate(EH.getCellValueSpecific(1,"License Dates"));

        nimbisPrestigeMotor.clickDriverSave_Btn();

        elementFunctionality.switchOutOfBrowserFrame();
        Thread.sleep(1500);
        nimbisUserNavigation.changeFocus2();
        elementFunctionality.switchOutOfBrowserFrame();
        Thread.sleep(1500);
        nimbisUserNavigation.changeFocus2();

        // EXTENSIONS
        Thread.sleep(1500);
        if(EH.getCellValueSpecific(1,"Credit shortfall - extended").equals("Yes")){
            nimbisPrestigeMotorcycle.clickCreditShortfallExtended();
            nimbisPrestigeMotorcycle.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(1,"Credit shortfall - extended Sum Insured"));
        }

        Thread.sleep(1000);
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(7000);
        elementFunctionality.switchOutOfBrowserFrame();
        Thread.sleep(3000);
        nimbisUserNavigation.clickCalculatePremiumBtn();



    }


}
