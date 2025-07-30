package com.sts.testautomation.steps;

import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.nimbisutilities.common_functions1;
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

public class NonRoad_UnderWritingRule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private NIMBIS_NonRoad_Vehicle nimbisNonRoadVehicle;
    private ExcelHandler EH;
    private String Sheet;
    private common_functions1 commonFunctions;


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
        EH = new ExcelHandler(Sheet, "NonRoad Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
        nimbisNonRoadVehicle= new NIMBIS_NonRoad_Vehicle(testB,Device);
        commonFunctions = new common_functions1(testB, Device, Sheet);
        url = URL;
        commonFunctions.searchClientandopenQuote();
        // JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(2000);
        commonFunctions.contentsection();
    }

    @Parameters({"URL"})
    @Test(priority = 2, description = "UR663-Number of Non-road vehicle claims in the last 12 months")
    public void UWRule(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickNonRoadVehicleCover();
        Thread.sleep(2000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(6000);
        nimbisUserNavigation.changeFocus2();
        nimbisNonRoadVehicle.enternonroadValue(EH.getCellValueSpecific(1, "Sum Insured"));
        //nimbisPrestigeContents.enterContentsSumInsured("10000");

        nimbisNonRoadVehicle.clickVehicleTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(1, "Vehicle Type"));
        // nimbisUserNavigation.selectOption("Full Cover");

        nimbisNonRoadVehicle.enternonroadMake(EH.getCellValueSpecific(1, "Make"));

        nimbisNonRoadVehicle.enternonroadModel(EH.getCellValueSpecific(1, "Model"));

        nimbisNonRoadVehicle.enternonroadYear(EH.getCellValueSpecific(1, "Year"));

        nimbisNonRoadVehicle.enternonroadRegisteredOwner(EH.getCellValueSpecific(1, "Registered Owner"));




        //claims

        nimbisNonRoadVehicle.enternonroadClaims012("2");

        nimbisNonRoadVehicle.enternonroadClaims324(EH.getCellValueSpecific(1, "Number of Contents claims in the last 13 to 24 months"));

        nimbisNonRoadVehicle.enternonroadClaims2536(EH.getCellValueSpecific(1, "Number of Contents claims in the last 25 to 36 months"));

        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
     String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("The building is situated closer than 100m to a body of water. Please check the altitude in the Grip report and if it is less than 15m, the cover request must be approved by Hollard.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 3, description = "UR614-Wall construction is Asbestos")
    public void UR614(String URL) throws Exception {
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
        nimbisPrestigeContents.clickTypeOfWallConstructionDropDown();

        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(27, "Wall type"));
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
        warningmsg.equalsIgnoreCase("We do not cover buildings with walls made of asbestos. The cover request is declined.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 4, description = "UR622-Building use of premises residential and business")
    public void UR622(String URL) throws Exception {
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
        warningmsg.equalsIgnoreCase("The building is used for residential and business purposes. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 5, description = "UR627-Contents at Home which is a holiday home and no main residence on the same policy")
    public void UR627(String URL) throws Exception {
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
        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(45, "Residence type"));

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
        warningmsg.equalsIgnoreCase("Contents are kept at a holiday home. Because there is no main residence on the same policy. The cover request must be approved by Hollard.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 6, description = "UR628-Contents at Home which is not a holiday home and is unoccupied for more than 90 days per year")
    public void UR628(String URL) throws Exception {
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
        nimbisPrestigeContents.clickResidenceTypeDropDown();
        nimbisUserNavigation.selectOption(EH.getCellValueSpecific(45, "Residence type"));
        nimbisPrestigeHome.clickDaysUnoccupied90Days();
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
        warningmsg.equalsIgnoreCase("The Contents are kept in a Home which is not a Holiday Home and is unoccupied for more than 90 days. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }



}
