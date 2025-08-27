package NIMBIS_Prestige_Motor;
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

public class Motor extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
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
    @Test(priority = 1, description = "Add Home Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB,Device);

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
        nimbisUserNavigation.clickMotorCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();

        // RISK DETAILS

        nimbisPrestigeMotor.clickChangeBtn();
        nimbisUserNavigation.changeFocusVehicle();
        nimbisPrestigeMotor.enterVehicleSearch(EH.getCellValueSpecific(1,"MMCode"));
        nimbisPrestigeMotor.clickSearchBtn();
        nimbisPrestigeMotor.clickVehicleResult1();
        nimbisPrestigeMotor.clickSelectBtn();


        Thread.sleep(2000);

        elementFunctionality.switchOutOfBrowserFrame();

        nimbisUserNavigation.changeFocus2();

        nimbisPrestigeMotor.clickVehicleTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Vehicle Type"));

        nimbisPrestigeMotor.enterVINNumber(EH.getCellValueSpecific(1,"VIN Number"));

        nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(1,"Engine Number"));

        nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(1,"Registration Number"));

        if (EH.getCellValueSpecific(1,"Performance enhancing modifications").equals("Yes")){
            nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
        }


        nimbisPrestigeMotor.clickVehicleColourDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Vehicle Colour"));

        nimbisPrestigeMotor.clickVehicleCodeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Vehicle Code"));

        //SECURITY

        nimbisPrestigeMotor.clickFirstTrackingDeviceRequiredDDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"First tracking device required"));

        if (EH.getCellValueSpecific(1,"Second Tracking Device required").equals("Yes")){
            nimbisPrestigeMotor.clickSecondTrackingDeviceRequired();
        }

        nimbisPrestigeMotor.clickFirstTrackingDeviceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"First tracking device type"));

        nimbisPrestigeMotor.clickSecondTrackingDeviceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Second tracking device type"));

        // SITUATION

        nimbisPrestigeMotor.clickOvernightParkingDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Overnight Parking"));

        // COVER DETAILS

        nimbisPrestigeMotor.clickBasisOfSettlementDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Basis of Settlement"));

        nimbisPrestigeMotor.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Cover Type"));

        nimbisPrestigeMotor.clickClassOfUseDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Class of Use"));

        if (EH.getCellValueSpecific(1,"Supported business").equals("Yes")){
            nimbisPrestigeMotor.clickSupportedBusiness();
        }


        //EXCESS

        nimbisPrestigeMotor.clickBasicExcessDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Basic Excess"));

        nimbisPrestigeMotor.enterAdditionalExcess(EH.getCellValueSpecific(1,"Additional Excess"));

        //DISCLOUSERS

        nimbisPrestigeMotor.clickAllowedDriversDropDown();
        nimbisUserNavigation.selectOption("Regular Driver");

        if(EH.getCellValueSpecific(1,"Regular driver/rider driving convictions in the last 5 years").equals("Yes")){
            nimbisPrestigeMotor.clickDriverConvictionsInTheLast5Years();
        }

        nimbisPrestigeMotor.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(1,"Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));
        nimbisPrestigeMotor.enterRegisteredOwner(EH.getCellValueSpecific(1,"Registered Owner"));


        // DRIVER
        if(EH.getCellValueSpecific(1,"Advanced Driver").equals("Yes")){
            nimbisPrestigeMotor.clickAdvancedDriver();

        }

        //CLAIMS

        nimbisPrestigeMotor.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 12 months, excluding glass damage"));

        nimbisPrestigeMotor.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

        nimbisPrestigeMotor.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(1,"Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));


        //FIANANCE
        if (EH.getCellValueSpecific(1,"Is Financed").equals("Yes")){

            nimbisPrestigeMotor.clickIsFinanced();

            nimbisPrestigeMotor.enterFinanceHouse("FNB");
        }

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // DRIVERS

        Thread.sleep(2000);
        nimbisPrestigeMotor.clickEditDriver_Btn();

        nimbisUserNavigation.changeFocusDriver();

        nimbisPrestigeMotor.clickLicenseCodeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"License Codes"));

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
            nimbisPrestigeMotor.clickCreditShortfallExtended();
            nimbisPrestigeMotor.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(1,"Credit shortfall - extended Sum Insured"));
        }


        if(EH.getCellValueSpecific(1,"Reduction in value").equals("Yes")){
            nimbisPrestigeMotor.clickReductionInValue();
            nimbisPrestigeMotor.enterReductionInValueSumInsured(EH.getCellValueSpecific(1,"Reduction in value Sum Insured"));
        }

        if(EH.getCellValueSpecific(1,"Off-road driving (4x4)").equals("Yes")){
            nimbisPrestigeMotor.clickOffRoadDriving();
        }

        if(EH.getCellValueSpecific(1,"Tyre cover").equals("Yes")){
            nimbisPrestigeMotor.clickTyreCover();
            nimbisPrestigeMotor.enterTyreCoverSumInsured(EH.getCellValueSpecific(1,"Tyre cover"));
        }

        //SPECIFIED ACCESSORIES

        if (EH.getCellValueSpecific(1,"Specified Accessories").equals("Yes")){

            Thread.sleep(1500);
            nimbisPrestigeMotor.clickAddSpecifiedAccessories();
            nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Specified Accessories Name"));
            Thread.sleep(1500);
            nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(1,"Specified Accessories Value"));

            nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
        }

        //CAR HIRE
        Thread.sleep(2000);
        if(EH.getCellValueSpecific(1,"Car Hire").equals("Yes")){
            nimbisPrestigeMotor.clickCarHire();
            nimbisPrestigeMotor.clickCarHireOptionDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Car Hire Option"));
            nimbisPrestigeMotor.clickCarHireDaysDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1,"Car Hire Days"));
        }
        Thread.sleep(5000);
        nimbisUserNavigation.clickSaveBtn();
    }






}
