package NIMBIS_Prestige_Motor;

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
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
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

public class Motor_UWRuleTesting extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Motor nimbisPrestigeMotor;
    private  NIMBIS_Prestige_Watercraft nimbisPrestigeWatercraft;

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
        nimbisPrestigeMotor = new NIMBIS_Prestige_Motor(testB, Device);

        EH = new ExcelHandler(Sheet, "Motor", 0, 0);
        for (int i = 42; i <= 42; i++) {
            try {
                Thread.sleep(2000);
                nimbisUserNavigation.enterSearchText(EH.getCellValueSpecific(i,"Driver ID"));
                nimbisUserNavigation.clickSearchBtn();

                Thread.sleep(5000);
                nimbisUserNavigation.clickClientResultName2(EH.getCellValueSpecific(i,"Driver ID"));
                Thread.sleep(5000);
                nimbisUserNavigation.clickAddNewQuote();
                Thread.sleep(1000);
                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(1000);
                try{
                    nimbisUserNavigation.clickPopUpOkBtn();
                    Thread.sleep(1000);
                    JavascriptExecutor js = (JavascriptExecutor) testB;
                    Thread.sleep(1000);
                }
                catch (ElementNotSelectableException e){
                    System.out.print(e.toString());
                }


                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.clickOpenQuote();
                Thread.sleep(2000);

                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(1000);
                if(EH.getCellValueSpecific(i, "Watercraft").equals("Y")){
                   addWatercraftSection(i);
                }
                Thread.sleep(1000);
                nimbisUserNavigation.clickMotorCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();

                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                // RISK DETAILS

                nimbisPrestigeMotor.clickChangeBtn();
                nimbisUserNavigation.changeFocusVehicle();
                Thread.sleep(2000);

                nimbisPrestigeMotor.enterVehicleSearch(EH.getCellValueSpecific(i, "MMCode"));
                nimbisPrestigeMotor.clickSearchBtn();
                nimbisPrestigeMotor.clickVehicleResult1();
                Thread.sleep(3000);
                nimbisPrestigeMotor.clickCarYearOfManufacturerDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Car Year"));
                Thread.sleep(2000);
                nimbisPrestigeMotor.enterVehicleValue(EH.getCellValueSpecific(i,"Sum Insured"));

                nimbisPrestigeMotor.clickSelectBtn();



                Thread.sleep(2000);

                elementFunctionality.switchOutOfBrowserFrame();

                nimbisUserNavigation.changeFocus2();

                nimbisPrestigeMotor.clickVehicleTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Type"));

                nimbisPrestigeMotor.enterVINNumber(EH.getCellValueSpecific(i, "VIN Number"));

                nimbisPrestigeMotor.enterEngineNumber(EH.getCellValueSpecific(i, "Engine Number"));

                nimbisPrestigeMotor.enterRegistrationNumber(EH.getCellValueSpecific(i, "Registration Number"));

                if (EH.getCellValueSpecific(i, "Performance enhancing modifications").equals("Yes")) {
                    nimbisPrestigeMotor.clickPerformanceEnhancingModifications();
                }


                nimbisPrestigeMotor.clickVehicleColourDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Colour"));

                nimbisPrestigeMotor.clickVehicleCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Vehicle Code"));
                Thread.sleep(1000);

                Thread.sleep(1000);


                //SECURITY

                nimbisPrestigeMotor.clickFirstTrackingDeviceRequiredDDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "First tracking device required"));

                if (EH.getCellValueSpecific(i, "Second Tracking Device required").equals("Yes")) {
                    nimbisPrestigeMotor.clickSecondTrackingDeviceRequired();
                }

                nimbisPrestigeMotor.clickFirstTrackingDeviceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "First tracking device type"));

                nimbisPrestigeMotor.clickSecondTrackingDeviceTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Second tracking device type"));

                Thread.sleep(1000);

                Thread.sleep(1000);

                // SITUATION

           //     nimbisPrestigeMotor.clickRiskAddressDropDown();
             //   nimbisUserNavigation.selectOptionRiskAddress(EH.getCellValueSpecific(i, "Province"));

                nimbisPrestigeMotor.clickOvernightParkingDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Overnight Parking"));
                Thread.sleep(1000);

                Thread.sleep(1000);
                // COVER DETAILS

                nimbisPrestigeMotor.clickBasisOfSettlementDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basis of Settlement"));

                nimbisPrestigeMotor.clickCoverTypeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Cover Type"));

                nimbisPrestigeMotor.clickClassOfUseDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Class of Use"));

                if (EH.getCellValueSpecific(i, "Supported business").equals("Yes")) {
                    nimbisPrestigeMotor.clickSupportedBusiness();
                }

                Thread.sleep(1000);

                Thread.sleep(1000);

                //EXCESS

                nimbisPrestigeMotor.clickBasicExcessDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Basic Excess"));

                nimbisPrestigeMotor.enterAdditionalExcess(EH.getCellValueSpecific(i, "Additional Excess"));

                Thread.sleep(1000);

                Thread.sleep(1000);

                //DISCLOUSERS

                nimbisPrestigeMotor.clickAllowedDriversDropDown();
                nimbisUserNavigation.selectOption("Regular Driver");

                if (EH.getCellValueSpecific(i, "Regular driver/rider driving convictions in the last 5 years").equals("Yes")) {
                    nimbisPrestigeMotor.clickDriverConvictionsInTheLast5Years();
                }

                nimbisPrestigeMotor.enterPreviousUninterruptedVehicleInsurance(EH.getCellValueSpecific(i, "Regular Driver's number of years of previous uninterrupted Comprehensive vehicle insurance cover"));
                nimbisPrestigeMotor.enterRegisteredOwner(EH.getCellValueSpecific(i, "Registered Owner"));


                // DRIVER
                if (EH.getCellValueSpecific(i, "Advanced Driver").equals("Yes")) {
                    nimbisPrestigeMotor.clickAdvancedDriver();

                }

                //CLAIMS

                nimbisPrestigeMotor.enterNumberOfClaimsLast12month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 12 months, excluding glass damage"));

                nimbisPrestigeMotor.enterNumberOfClaimsLast24month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 13 - 24 months, excluding glass damage"));

                nimbisPrestigeMotor.enterNumberOfClaimsLast36month(EH.getCellValueSpecific(i, "Regular Driver number of claims in the last 25 - 36 months, excluding glass damage"));


                //FIANANCE
                if (EH.getCellValueSpecific(i, "Is Financed").equals("Yes")) {

                    nimbisPrestigeMotor.clickIsFinanced();

                    nimbisPrestigeMotor.enterFinanceHouse("FNB");
                }
                Thread.sleep(1000);

                Thread.sleep(1000);

                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                // DRIVERS

                Thread.sleep(2000);
                nimbisPrestigeMotor.clickEditDriver_Btn();

                nimbisUserNavigation.changeFocusDriver();

                nimbisPrestigeMotor.clickLicenseCodeDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "License Codes"));

                nimbisPrestigeMotor.enterLicenseDate(EH.getCellValueSpecific(i, "License Dates"));

              //  nimbisPrestigeMotor.enterDriverIdentification(EH.getCellValueSpecific(i, "Driver ID"));

               // nimbisPrestigeMotor.enterDriverDOB(EH.getCellValueSpecific(i, "Driver DOB"));

                Thread.sleep(1000);

                Thread.sleep(1000);
                nimbisPrestigeMotor.clickDriverSave_Btn();

                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(1500);
                nimbisUserNavigation.changeFocus2();


                // EXTENSIONS
                Thread.sleep(1500);
                if (EH.getCellValueSpecific(i, "Credit shortfall - extended").equals("Yes")) {
                    nimbisPrestigeMotor.clickCreditShortfallExtended();
                    nimbisPrestigeMotor.enterCreditShortfallExtendedSumInsured(EH.getCellValueSpecific(i, "Credit shortfall - extended Sum Insured"));
                }


                if (EH.getCellValueSpecific(i, "Reduction in value").equals("Yes")) {
                    nimbisPrestigeMotor.clickReductionInValue();
                    nimbisPrestigeMotor.enterReductionInValueSumInsured(EH.getCellValueSpecific(i, "Reduction in value Sum Insured"));
                }

                if (EH.getCellValueSpecific(i, "Off-road driving (4x4)").equals("Yes")) {
                    nimbisPrestigeMotor.clickOffRoadDriving();
                }

                if (EH.getCellValueSpecific(i, "Tyre cover").equals("Yes")) {
                    nimbisPrestigeMotor.clickTyreCover();
                    nimbisPrestigeMotor.enterTyreCoverSumInsured(EH.getCellValueSpecific(i, "Tyre cover"));
                }
                Thread.sleep(1000);
                Thread.sleep(1000);

                //SPECIFIED ACCESSORIES

                if (EH.getCellValueSpecific(i, "Specified Accessories").equals("Yes")) {

                    Thread.sleep(1500);
                    nimbisPrestigeMotor.clickAddSpecifiedAccessories();
                    nimbisPrestigeMotor.clickSpecifiedAccessoriesName();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Specified Accessories Name"));
                    Thread.sleep(1500);
                    nimbisPrestigeMotor.enterSpecifiedAccessoriesValue(EH.getCellValueSpecific(i, "Specified Accessories Value"));
                    Thread.sleep(1000);

                    Thread.sleep(1000);

                    nimbisPrestigeMotor.clickSaveSpecifiedAccessories();
                }

                //CAR HIRE
                Thread.sleep(2000);
                if (EH.getCellValueSpecific(i, "Car Hire").equals("Yes")) {
                    nimbisPrestigeMotor.clickCarHire();
                    nimbisPrestigeMotor.clickCarHireOptionDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Car Hire Option"));
                    nimbisPrestigeMotor.clickCarHireDaysDropDown();
                    nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i, "Car Hire Days"));
                }
                Thread.sleep(1000);

                Thread.sleep(5000);
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
                        "Motor", i, 4, messageToWrite
                );
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
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Motor",i ,5,textIn);


                nimbisUserNavigation.clickBlackBoxRawViewIn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxOutput();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxRawViewOut();
                Thread.sleep(1000);

                String textOut =  testB.findElement(By.id("ContentPlaceHolder1_txtBBXMLOutput")).getAttribute("value");
                System.out.println(textOut);
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Motor",i ,6,textOut);








                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(3000);
                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
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
                ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE " + i + "Failed");
                System.err.println("TEST CASE " + i + " Failed");
            }


        }


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
    public void addWatercraftSection(int i ) throws Exception {

        nimbisPrestigeWatercraft = new NIMBIS_Prestige_Watercraft(testB,Device);

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
        if("No".equals("Yes")){
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

    }




}


