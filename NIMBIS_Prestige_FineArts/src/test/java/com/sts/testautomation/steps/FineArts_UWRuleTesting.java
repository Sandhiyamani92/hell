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
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FineArts_UWRuleTesting extends BaseTest{

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_FineArts nimbisPrestigeFineArts;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
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

                            String projectPath = System.getProperty("user.dir");
                            File currentDir = new File(projectPath);
                            File parentDir = currentDir.getParentFile();
                            String basePath = parentDir.getAbsolutePath();
                            System.out.println("Base path: " + basePath);
                            String relativePath = "Browser" + File.separator + "edgedriver_win64" + File.separator + "msedgedriver.exe";
                            String driverPath = basePath + File.separator + relativePath;

                            System.setProperty("webdriver.edge.driver", driverPath);


                        //    WebDriverManager.edgedriver().setup();
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
    @Test(priority = 1, description = "Add Fine Arts Section")
    public void addFineArtsSection(String URL) throws Exception {

        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeFineArts = new NIMBIS_Prestige_FineArts(testB,Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);

        EH = new ExcelHandler(Sheet, "Fine Arts Test Cases", 0, 0);
        for (int i = 66; i <= 157; i++) {
            try {
                nimbisUserNavigation.enterSearchText("Vukani Shembe ");
                nimbisUserNavigation.clickSearchBtn();

                Thread.sleep(5000);
                nimbisUserNavigation.clickClientResultName();
                Thread.sleep(5000);
                nimbisUserNavigation.clickAddNewQuote();
                Thread.sleep(2000);

                nimbisUserNavigation.clickPrestigeV2_Chkbox();
                Thread.sleep(2000);

                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickPopUpOkBtn();
                Thread.sleep(2000);

                JavascriptExecutor js = (JavascriptExecutor) testB;
                //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                nimbisUserNavigation.clickNextBtn();
                Thread.sleep(2000);

                nimbisUserNavigation.clickOpenQuote();
                Thread.sleep(2000);
                nimbisUserNavigation.clickCoverBtn();
                Thread.sleep(2000);
                String section = "Yes";
                if(section.equals("Yes")){
                    addContents();
                }
                Thread.sleep(4000);
                nimbisUserNavigation.clickFineArtsCover();
                Thread.sleep(4000);
                nimbisUserNavigation.clickAddNewItemBtn();
                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();

                //RISK DETAILS

                nimbisPrestigeFineArts.clickResidenceType();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Residence Type"));

                if (EH.getCellValueSpecific(1, "Unoccupied for more than 90 days").equals("Yes")) {
                    nimbisPrestigeFineArts.clickDaysUnoccupied90Days();
                }

                nimbisPrestigeFineArts.clickTypeOfRoofConstruction();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Roof construction"));

                nimbisPrestigeFineArts.clickTypeOfWallConstruction();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Wall construction"));

                nimbisPrestigeFineArts.clickFineArtCategory();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Fine arts category"));

                //COVER DETAILS

                nimbisPrestigeFineArts.clickTypeOfCover();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Type of cover"));

                //SERCURITY MEASURES

                if (EH.getCellValueSpecific(1, "Security gates on all exiting doors").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAllDoorsProtectedBySecurityGates();
                }

                if (EH.getCellValueSpecific(1, "Burglar bars on all opening windows").equals("Yes")) {
                    nimbisPrestigeFineArts.clickBurglarBarsOpeningWindows();
                }

                if (EH.getCellValueSpecific(1, "High-security estate/complex").equals("Yes")) {
                    nimbisPrestigeFineArts.clickHighSecurityEstateComplex();
                }

                if (EH.getCellValueSpecific(1, "Alarm linked to 24-hour armed response service").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAlarmLinkedToArmedResponse();
                }

                nimbisPrestigeFineArts.clickElectricFence();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Electric Fence"));

                if (EH.getCellValueSpecific(1, "Access controlled area").equals("Yes")) {
                    nimbisPrestigeFineArts.clickAccessControlledArea();
                }

                if (EH.getCellValueSpecific(1, "24-hour security guards on property").equals("Yes")) {
                    nimbisPrestigeFineArts.clickTwentyFourHourSecurityGuard();
                }

                if (EH.getCellValueSpecific(1, "Monitored by CCTV cameras").equals("Yes")) {
                    nimbisPrestigeFineArts.clickCctvCamera();
                }

                if (EH.getCellValueSpecific(1, "Outdoor beams linked to armed response").equals("Yes")) {
                    nimbisPrestigeFineArts.clickLaserBeamsInGarden();
                }

                nimbisPrestigeFineArts.clickAlarmType();
                nimbisUserNavigation.selectOptionWatercraft(EH.getCellValueSpecific(1, "Alarm Type"));

                nimbisPrestigeFineArts.clickPerimeterProtection();
                nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Perimeter protection"));

                ///


                if (EH.getCellValueSpecific(1, "Exhibition").equals("Yes")) {
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(1, "Exhibition Sum Insured"));
                }

                if (EH.getCellValueSpecific(1, "Art at a temporary location").equals("Yes")) {
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(1, "Art at a temporary location Sum Insured"));
                }

                if (EH.getCellValueSpecific(1, "Art in transit in South Africa").equals("Yes")) {
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(1, "Art in transit in South Africa Sum Insured"));
                }

                if (EH.getCellValueSpecific(1, "Defective title").equals("Yes")) {
                    nimbisPrestigeFineArts.clickExhibition();
                    nimbisPrestigeFineArts.enterExhibitionSumInsured(EH.getCellValueSpecific(1, "Defective title Sum Insured"));
                }


                Thread.sleep(1000);
                nimbisUserNavigation.clickSaveBtn();
                Thread.sleep(7000);
                elementFunctionality.switchOutOfBrowserFrame();
                Thread.sleep(3000);
                nimbisUserNavigation.clickCalculatePremiumBtn();
                Thread.sleep(6000);
                nimbisUserNavigation.changeFocus2();


                Actions actions = new Actions(testB);
                WebElement textArea = testB.findElement(By.xpath("//td//div[@class='rwDialogText']"));


                List<WebElement> listItems = textArea.findElements(By.tagName("li"));

                for (WebElement item : listItems) {
                    System.out.println(item.getText());
                }



                nimbisUserNavigation.clickOkBtn();

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

                nimbisUserNavigation.clickBlackBoxRawViewIn();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxOutput();
                Thread.sleep(1000);
                nimbisUserNavigation.clickBlackBoxRawViewOut();
                Thread.sleep(1000);

                String textOut =  testB.findElement(By.id("ContentPlaceHolder1_txtBBXMLOutput")).getAttribute("value");
                System.out.println(textOut);

                Thread.sleep(1000);
                testB.findElement(By.xpath("//button[@id='ctl00_ContentPlaceHolder1_btnClose']")).click();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(3000);




                ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + 1 + "Passed");
                System.err.println("TEST CASE " + 1 + " Passed");



            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void addContents() throws InterruptedException {

        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB,Device);
        nimbisPrestigeWatercraft = new NIMBIS_Prestige_Watercraft(testB,Device);

        nimbisUserNavigation.clickContentsCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();

        nimbisPrestigeContents.enterContentsSumInsured("10000");

        nimbisPrestigeContents.clickCoverTypeDropDown();
        nimbisUserNavigation.selectOption("Full Cover");

        nimbisPrestigeContents.clickTypeOfHomeDropDown();
        nimbisUserNavigation.selectOption("Flat Above Ground");

        nimbisPrestigeContents.clickDaysUnoccupied90Days();

        nimbisPrestigeContents.clickTypeOfRoofConstructionDropDown();
        nimbisUserNavigation.selectOption("Standard");

        nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();
        nimbisUserNavigation.selectOption("Standard");

        nimbisPrestigeContents.clickLightningConductorSABS();

        nimbisPrestigeContents.clickFireRetardantSABS();

        nimbisPrestigeContents.clickSurgeProtectionSANS();

        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption("Main Residence");

        nimbisPrestigeContents.clickUseOfPremisesDropDown();
        nimbisUserNavigation.selectOption("Residential only");


        nimbisPrestigeContents.clickNCB_DropDown();
        nimbisUserNavigation.selectOption("0");

        nimbisPrestigeContents.clickIncreasedRiskBusinessType();

        nimbisPrestigeContents.clickPreviousUninterruptedBuildingsInsurance("0");

        nimbisPrestigeContents.clickThatch15OfMainBuilding();

        nimbisPrestigeContents.clickRenewableEnergyEquipment();

        nimbisPrestigeContents.clickUseOfAdjoiningLandDropDown();
        nimbisUserNavigation.selectOptionWatercraft("Retail");


        //  nimbisPrestigeContents.enter

        nimbisPrestigeContents.clickPlotSmallHoldingOrFarm();

        nimbisPrestigeContents.clickWithin100mOfaWaterBody();

        nimbisPrestigeContents.clickElectricFence_DropDown();
        nimbisUserNavigation.selectOption("None");

        nimbisPrestigeContents.clickBurglarBarsOpeningWindows();

        nimbisPrestigeContents.clickAlarmLinkedToArmedResponse();

        nimbisPrestigeContents.clickTwentyFourHourSecurityGuard();

        nimbisPrestigeContents.clickAccessControlledArea();

        nimbisPrestigeContents.clickAllDoorsProtectedBySecurityGates();

        nimbisPrestigeContents.clickPerimeterProtection_DropDown();
        nimbisUserNavigation.selectOption("Wire fence");

        nimbisPrestigeContents.clickHighSecurityEstateComplex();

        nimbisPrestigeContents.clickCCTVCamera();

        nimbisPrestigeContents.clickLaserBeamsInGarden();

        nimbisPrestigeContents.enterNumberOfClaimsLast12month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast24month("0");

        nimbisPrestigeContents.enterNumberOfClaimsLast36month("0");





        Thread.sleep(1000);
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(2000);
        try{
            nimbisUserNavigation.clickOkBtn();
        }
        catch(ElementNotSelectableException e){
            System.out.println(e.toString());
        }


        nimbisUserNavigation.changeFocusToBrowser();



    }

}
