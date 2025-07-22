package com.sts.testautomation.steps;

import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.pages.web.NIMBIS_Login;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Client;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Home;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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


public class Client_UWRuleTesting extends BaseTest {
private NIMBIS_Login nimbisLogin;
private NIMBIS_Prestige_Client nimbisPrestigeClient;
private NIMBIS_UserNavigation nimbisUserNavigation;
private ElementFunctionality elementFunctionality;
private ExcelHandler EH;
private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;

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
    @Test(priority = 1, description = "Create Client")
    public void CreateClient(String URL) throws Exception {
        url = URL;


        nimbisLogin = new NIMBIS_Login(testB,Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB,Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB,Device);
        elementFunctionality = new ElementFunctionality(testB,Device);
        EH = new ExcelHandler(Sheet, "Clients", 0, 0);
      //     EH = new ExcelHandler("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS.xlsx", " Client Test cases", 0, 0);


        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        for (int i = 7 ; i <= 7 ; i++){
            try {
                nimbisUserNavigation.clickQuotation_DD();
                nimbisUserNavigation.clickAddNewQuote_DD();
                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                nimbisUserNavigation.clickNextBtn();
                nimbisUserNavigation.clickNextBtn();

                nimbisPrestigeClient.enterFirstName(EH.getCellValueSpecific(i,"Policyholder Name"));
                nimbisPrestigeClient.enterLastName(EH.getCellValueSpecific(i,"Policyholder Surname"));

                nimbisPrestigeClient.clickTitle();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Policyholder Title"));

                nimbisPrestigeClient.clickPolicyHolderType();
                nimbisUserNavigation.selectOption("Natural person");

                nimbisPrestigeClient.selectITCPermission(EH.getCellValueSpecific(i,"ITC check consent"));

                nimbisPrestigeClient.clickEmploymentStatusDropDown();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Employment status"));

                nimbisPrestigeClient.enterIdentificationNumber(EH.getCellValueSpecific(i,"Policyholder ID number"));
                //  JavascriptExecutor js = (JavascriptExecutor) testB;
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");





                nimbisPrestigeClient.clickMaritalStatus();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Policyholder marital status"));


                nimbisPrestigeClient.selectSequestration(EH.getCellValueSpecific(i,"Policyholder currently under sequestration or curatorship"));
                nimbisPrestigeClient.selectPreviousInsurance(EH.getCellValueSpecific(i,"Policyholder previous insurance"));
                nimbisPrestigeClient.selectCriminalOffenceConvictions(EH.getCellValueSpecific(i,"Policyholder criminal offence convictions in the last 5 years"));
                nimbisPrestigeClient.selectPreviousInsuranceCancelled(EH.getCellValueSpecific(i,"Policyholder previous insurance cancelled"));

                nimbisPrestigeClient.enterEmailAddress("testingemail@email.com");

                nimbisPrestigeClient.enterPhoneNumberTxt1("832");

                nimbisPrestigeClient.enterPhoneNumberTxt2("987650");

                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(3000);
                nimbisPrestigeClient.enterPostalCode("Lenasia");
                Thread.sleep(2000);
                nimbisUserNavigation.selectAddress() ;

                nimbisPrestigeClient.enterStreet(EH.getCellValueSpecific(i,"Residential Address Line 1"));
                nimbisPrestigeClient.enterBuilding(EH.getCellValueSpecific(i,"Residential Address Line 2"));

                nimbisPrestigeClient.enterComplex("Estate Complex");
                nimbisPrestigeClient.enterTown("Johannesburg");

                nimbisUserNavigation.clickNextBtn();

                nimbisUserNavigation.clickOpenQuote();


                Thread.sleep(2000);
                nimbisUserNavigation.clickCoverBtn();

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
                        "Clients", i, 4, messageToWrite
                );
                System.out.print(messageToWrite);








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
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Clients",i ,5,textIn);


                nimbisUserNavigation.clickBlackBoxRawViewIn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxOutput();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxRawViewOut();
                Thread.sleep(1000);

                String textOut =  testB.findElement(By.id("ContentPlaceHolder1_txtBBXMLOutput")).getAttribute("value");
                System.out.println(textOut);
                write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS UWRules.xlsx","Clients",i ,6,textOut);





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

