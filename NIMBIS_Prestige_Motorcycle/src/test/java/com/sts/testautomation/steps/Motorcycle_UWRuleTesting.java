package com.sts.testautomation.steps;
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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Motorcycle_UWRuleTesting extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private NIMBIS_Prestige_Motorcycle nimbisPrestigeMotorcycle;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private ExcelHandler EH;
    private String Sheet;
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;

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
        nimbisPrestigeMotorcycle = new NIMBIS_Prestige_Motorcycle(testB,Device);

        EH = new ExcelHandler(Sheet, "Motorcycle", 0, 0);


        for(int i = 3 ; i <= 4;i++){
            try{
                nimbisUserNavigation.enterSearchText("George Zwane");
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
                String section = "Yes";
                if(section.equals("Yes")){
                    addHomeSection(i);
                }
                Thread.sleep(4000);
                nimbisUserNavigation.clickMotorcycleCover();
                Thread.sleep(4000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();
                EH = new ExcelHandler(Sheet, "Motorcycle", 0, 0);

                // RISK DETAILS

                nimbisPrestigeMotor.clickChangeBtn();
                nimbisUserNavigation.changeFocusVehicle();
                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleSearch(EH.getCellValueSpecific(i,"MM Code"));
                Thread.sleep(2000);
                nimbisPrestigeMotor.clickSearchBtn();
                Thread.sleep(2000);

                Thread.sleep(2000);
                nimbisPrestigeMotor.clickVehicleResult1();

                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleValue(EH.getCellValueSpecific(i,"Sum Insured"));
                Thread.sleep(1000);
                nimbisPrestigeMotor.clickSelectBtn();


                Thread.sleep(2000);

                elementFunctionality.switchOutOfBrowserFrame();

                nimbisUserNavigation.changeFocus2();

                nimbisPrestigeMotorcycle.enterVINNumber(EH.getCellValueSpecific(i,"VIN Number"));

                nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(i,"Engine Number"));

                nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(i,"Registration Number"));

                if (EH.getCellValueSpecific(i,"Performance enhancing modifications").equals("Yes")){
                    nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
                }

                nimbisPrestigeMotorcycle.clickVehicleCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Vehicle Code"));

                nimbisPrestigeMotorcycle.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(i,"Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));


                if(EH.getCellValueSpecific(i,"Regular driver/rider driving convictions in the last 5 years").equals("Yes")){
                    nimbisPrestigeMotorcycle.clickDriverConvictionsInTheLast5Years();
                }


                Thread.sleep(1000);

                //CLAIMS

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 12 months, excluding glass damage"));

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

                nimbisPrestigeMotorcycle.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i,"Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));

                Thread.sleep(2000);

                Thread.sleep(1000);


                nimbisPrestigeMotor.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Type of cover"));

                nimbisPrestigeMotorcycle.clickClaimFreeGroup_DropDown();
                nimbisUserNavigation.selectOption("0");

                nimbisPrestigeMotorcycle.clickVehicleLiability_DropDown();
                nimbisUserNavigation.selectOption("Yes");

                nimbisPrestigeMotorcycle.clickNCB_DropDown();
                nimbisUserNavigation.selectOption("0");

                nimbisPrestigeMotorcycle.clickBasisOfSettlementDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Basis of Settlement"));
                if(EH.getCellValueSpecific(i,"Basis of Settlement").equals("Retail Value Plus")){
                    nimbisPrestigeMotorcycle.enterRetailValuePercentage(EH.getCellValueSpecific(i,"Retail Value Adjustment Percentage"));
                }

                nimbisPrestigeMotorcycle.clickBasicExcessDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Basic Excess"));

                nimbisPrestigeMotorcycle.clickClassOfUseDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Class of Use"));

                ///

                nimbisPrestigeMotorcycle.clickAllowedRiders_DropDown();
                nimbisUserNavigation.selectOption("Insured Only");

                ////

                if (EH.getCellValueSpecific(i,"Is Financed").equals("Yes")){

                    nimbisPrestigeMotor.clickIsFinanced();

                    nimbisPrestigeMotor.enterFinanceHouse("FNB");
                }

                Thread.sleep(2000);


                // SITUATION

                nimbisPrestigeMotor.clickOvernightParkingDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Overnight Parking"));

                Thread.sleep(1000);

                Thread.sleep(1000);
                //SPECIFIED ACCESSORIES

                if (EH.getCellValueSpecific(i,"Specified Accessories").equals("Yes")){

                    Thread.sleep(1500);
                    nimbisPrestigeMotor.clickAddSpecifiedAccessories();
                    nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Specified Accessories Name"));
                    Thread.sleep(1500);
                    nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(i,"Specified Accessories Value"));

                    nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
                }

                // DRIVERS

                Thread.sleep(2000);
                nimbisPrestigeMotor.clickEditDriver_Btn();

                nimbisUserNavigation.changeFocusDriver();

                nimbisPrestigeMotor.clickLicenseCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"License Code"));

                nimbisPrestigeMotor.enterLicenseDate(EH.getCellValueSpecific(i,"License Dates"));

                Thread.sleep(1500);
                Thread.sleep(1500);

                nimbisPrestigeMotor.clickDriverSave_Btn();

                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();

                // EXTENSIONS
                Thread.sleep(1500);
                if(EH.getCellValueSpecific(i,"Credit shortfall - extended").equals("Yes")){
                    nimbisPrestigeMotorcycle.clickCreditShortfallExtended();
                    nimbisPrestigeMotorcycle.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(i,"Credit shortfall - extended Sum Insured"));
                }

                Thread.sleep(1000);
                Thread.sleep(1000);

                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();
                Thread.sleep(7000);
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(3000);
                nimbisUserNavigation.clickCalculatePremiumBtn();
                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                List<WebElement> textAreas = testB.findElements(By.xpath("//td//div[@class='rwDialogText']"));
                String messageToWrite = "No Message is Displayed"; // default

                if (!textAreas.isEmpty()) {
                    WebElement textArea = textAreas.get(0);

                    if (textArea.isDisplayed()) {
                        List<WebElement> listItems = textArea.findElements(By.tagName("li"));
                        StringBuilder combinedText = new StringBuilder();

                        for (WebElement item : listItems) {
                            System.out.println(item.getText());
                            combinedText.append(item.getText()).append(", ");
                        }

                        if (combinedText.length() > 0) {
                            combinedText.setLength(combinedText.length() - 2); // remove last comma
                            messageToWrite = combinedText.toString();
                        }
                        nimbisUserNavigation.clickOkBtn();
                    }
                }

                write_Extracted_rule_to_Sheet(
                        "C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx",
                        "Motorcycle", i, 4, messageToWrite
                );








                //  nimbisUserNavigation.changeFocus2();

                //   nimbisUserNavigation.clickSaveBtn2();

                //     nimbisUserNavigation.clickOkBtnMesseagePopup();

                //
                Thread.sleep(3000);
                nimbisUserNavigation.changeFocusToBrowser();

                nimbisUserNavigation.clickCloseBtn();


                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                nimbisUserNavigation.clickLogsTabBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickPremiumBlackBoxTabBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickLogsViewFirstDetails();


                Thread.sleep(1000);

                nimbisUserNavigation.changeFocus2();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxInput();
                Thread.sleep(1000);
                String textIn =  testB.findElement(By.id("ContentPlaceHolder1_txtBBXMLInput")).getAttribute("value");
                System.out.println(textIn);
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Motorcycle",i ,5,textIn);


                nimbisUserNavigation.clickBlackBoxRawViewIn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxOutput();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxRawViewOut();
                Thread.sleep(1000);

                String textOut =  testB.findElement(By.id("ContentPlaceHolder1_txtBBXMLOutput")).getAttribute("value");
                System.out.println(textOut);
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Motorcycle",i ,6,textOut);





                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();

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

    public void addHomeSection(int i ) throws Exception {
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB,Device);
      //  EH = new ExcelHandler(Sheet, "Home Test Cases", 0, 0);


        nimbisUserNavigation.clickHomeCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisPrestigeHome.enterHomeSumInsured("800000");
        nimbisPrestigeHome.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption("Full Cover");

        nimbisPrestigeHome.clickTypeOfHomeDropDown();
        nimbisUserNavigation.selectOption("Flat Above Ground");
        Thread.sleep(1000);

        // nimbisPrestigeHome.enterDescription("Home");
        //Thread.sleep(1000);

        if(EH.getCellValueSpecific(i,"Unoccupied for more than 90 days").equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickDaysUnoccupied90Days();
        }
        Thread.sleep(1000);
        nimbisPrestigeHome.clickTypeOfWallConstructionDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("Standard");

        Thread.sleep(1000);
        nimbisPrestigeHome.clickTypeOfRoofConstructionDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("Standard");

        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickLightningConductorSABS();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickFireRetardantSABS();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickSurgeProtectionSANS();
        }


        nimbisPrestigeHome.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption("Main Residence");

        nimbisPrestigeHome.clickUseOfPremisesDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("Residential only");
        Thread.sleep(1000);
        // elementFunctionality.scrollToElementBrowser(testB.findElement(By.xpath("")));


        Thread.sleep(1000);

        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickThatch15OfMainBuilding();
        }

        //nimbisPrestigeHome.clickIsFinanced();

        nimbisPrestigeHome.clickNCB_DropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("0");

        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickRenewableEnergyEquipment();
        }


        Thread.sleep(1000);
        nimbisPrestigeHome.clickPreviousUninterruptedBuildingsInsurance("0");

        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickIncreasedRiskBusinessType();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickPlotSmallHoldingOrFarm();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickCommune();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickWithin100mOfaWaterBody();
        }

        Thread.sleep(1000);

        // elementFunctionality.scrollToElementBrowser(testB.findElement(By.xpath("//button[@id='ctl00_ContentPlaceHolder1_DynamicQuestions1_NonStandard_7224']")));
        // elementFunctionality.scrollByPercentage(30.0, "DOWN");






        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickBurglarBarsOpeningWindows();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickAlarmLinkedToArmedResponse();
        }


        Thread.sleep(1000);
        nimbisPrestigeHome.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption("None");
        Thread.sleep(1000);
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickTwentyFourHourSecurityGuard();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickAccessControlledArea();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickAllDoorsProtectedBySecurityGates();
        }

        Thread.sleep(1000);
        nimbisPrestigeHome.clickPerimeterProtection_DropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("Wire fence");
        Thread.sleep(1000);
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickHighSecurityEstateComplex();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickCCTVCamera();
        }
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickLaserBeamsInGarden();
        }

        Thread.sleep(1000);


        //  js.executeScript("window.scrollTo(20, document.body.scrollHeight);");
        Thread.sleep(3000);
        nimbisPrestigeHome.enterNumberOfClaimsLast12month("0");
        nimbisPrestigeHome.enterNumberOfClaimsLast24month("0");
        nimbisPrestigeHome.enterNumberOfClaimsLast36month("0");
        Thread.sleep(1000);
        Thread.sleep(1000);

        nimbisPrestigeHome.enterAdditionalExcess_Txt("0");
        Thread.sleep(1000);
        nimbisPrestigeHome.clickBasicExcessDropDown();
        Thread.sleep(1000);
        nimbisUserNavigation.selectOption("5 000");
        Thread.sleep(1000);



        Thread.sleep(1000);
        nimbisPrestigeHome.enterNoOfElectricGeyser("0");
        Thread.sleep(1000);
        nimbisPrestigeHome.enterNoOfGasGeysers("0");
        Thread.sleep(1000);
        nimbisPrestigeHome.enterNoOfHeatPumpGeysers("0");
        Thread.sleep(1000);
        nimbisPrestigeHome.enterNoOfSolarGeysers("0");
        Thread.sleep(1000);


        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickPowerSurge();
            nimbisPrestigeHome.clickPowerSurgeSumInsuredDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Power surge Sum Insured"));
        }

        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickGardenAndLandscapingExtendedCover();
            nimbisPrestigeHome.clickGardenAndLandscapingSumInsuredDropDown();
            nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Garden and landscaping - extended cover Sum Insured"));
        }
        Thread.sleep(1000);
        Thread.sleep(1000);
        if("No".equalsIgnoreCase("Yes")){
            nimbisPrestigeHome.clickSubsidenceLandslipOrGroundHeaveExtendedCove();
        }

        Thread.sleep(1000);
        nimbisUserNavigation.clickSaveBtn();

        nimbisUserNavigation.changeFocusToBrowser();
    }
    public void write_Extracted_rule_to_Sheet(String FilePath, String SheetName, int rowNum, int colNum, String element) throws Exception {

        try {


            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int numRows = ExcelWSheet.getLastRowNum() + 1;

            ExcelWSheet.getRow(rowNum).createCell(colNum).setCellValue(element);

            ExcelWBook.write(new FileOutputStream(FilePath));

            FileOutputStream fileOut = new FileOutputStream(FilePath);
            ExcelWBook.write(fileOut);
            fileOut.close();
            ExcelWBook.close();
            System.out.println("Completed writing extracted rule");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
        }


    }



}
