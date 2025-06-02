package com.sts.testautomation.steps;

import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Caravan_UnderWritingRule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private ExcelHandler EH;
    private String Sheet;
    private NIMBIS_Caravan nimbisCaravn;


    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {

        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet;

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
    @Test(priority = 2, description = "UR660-Number of Caravan/Trailer claims in the last 12 months")
    public void UR660(String URL) throws Exception {
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickCaravanCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisCaravn.enterCaravanValue(EH.getCellValueSpecific(1, "Caravan Value"));

//Vehicle
        nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(1, "Make"));
        nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(1, "Model"));
        nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(1, "Year"));
        nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(1, "Registeration Number"));
        //claims
        nimbisCaravn.enterCaravanClaim012Months(EH.getCellValueSpecific(15, "Number of Caravan claims in the last 0 - 12 months, excluding glass damage"));
        nimbisCaravn.enterCaravanClaim1324Months(EH.getCellValueSpecific(1, "Number of Caravan claims in the last 13 - 24 months, excluding glass damage"));
        nimbisCaravn.enterCaravanClaim2536Months(EH.getCellValueSpecific(1, "Number of Caravan claims in the last 25 - 36 months, excluding glass damage"));
//extensions
        nimbisCaravn.clickExtension();
        nimbisCaravn.enterExtensionSum(EH.getCellValueSpecific(1, "sum insured"));

        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
     String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("Your client has an adverse caravan/trailer claims history in the last 12 months. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 3, description = "UR662-Number of Caravan/Trailer claims in the last 24 months")
    public void UR662(String URL) throws Exception {
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickCaravanCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisCaravn.enterCaravanValue(EH.getCellValueSpecific(1, "Caravan Value"));

//Vehicle
        nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(1, "Make"));
        nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(1, "Model"));
        nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(1, "Year"));
        nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(1, "Registeration Number"));
        //claims
        nimbisCaravn.enterCaravanClaim012Months(EH.getCellValueSpecific(1, "Number of Caravan claims in the last 0 - 12 months, excluding glass damage"));
        nimbisCaravn.enterCaravanClaim1324Months(EH.getCellValueSpecific(16, "Number of Caravan claims in the last 13 - 24 months, excluding glass damage"));
        nimbisCaravn.enterCaravanClaim2536Months(EH.getCellValueSpecific(1, "Number of Caravan claims in the last 25 - 36 months, excluding glass damage"));
//extensions
        nimbisCaravn.clickExtension();
        nimbisCaravn.enterExtensionSum(EH.getCellValueSpecific(1, "sum insured"));

        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("Your client has an adverse caravan/trailer claims history in the last 24 months. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }
//please update the code after the discussion with ziyanda
    @Parameters({"URL"})
    @Test(priority = 4, description = "UR654-Motor accumulation per risk address exceeds RAL")
    public void UR654(String URL) throws Exception {
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
        warningmsg.equalsIgnoreCase("The combined sum insured of all the vehicles at one address exceeds the RAL limit. The cover request must be approved by Hollard.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }





}
