package com.sts.testautomation.steps;

import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Trailer_Underwriting_Rule extends BaseTest {

    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private NIMBIS_Prestige_Contents nimbisPrestigeContents;
    private ExcelHandler EH;
    private String Sheet;
    private NIMBIS_Caravan nimbisCaravn;
    private NIMBIS_Trailer nimbisTrailer;

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
        Thread.sleep(4000);
    }


    @Parameters({"URL"})
    @Test(priority = 1, description = "Search Client")
    public void CreateClient(String URL) throws Exception {
        EH = new ExcelHandler(Sheet, "Trailer Test Cases", 0, 0);
        url = URL;
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        nimbisPrestigeContents = new NIMBIS_Prestige_Contents(testB, Device);
        searchClient();

    }

    @Parameters({"URL"})
    @Test(priority = 2, description = "UR660-Number of Caravan/Trailer claims in the last 12 months")
    public void UR660(String URL) throws Exception {
        nimbisCaravn = new NIMBIS_Caravan(testB, Device);
        nimbisTrailer = new NIMBIS_Trailer(testB, Device);
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(6000);
        nimbisUserNavigation.clickTrailerCover();
        Thread.sleep(6000);
        nimbisUserNavigation.clickAddNewItemBtn();

        Thread.sleep(3000);
        nimbisUserNavigation.changeFocus2();

//caravan
        caravandetails();

        Thread.sleep(500);
        nimbisUserNavigation.changeWarningFrame();
        String warningmsg=   testB.findElement(By.xpath("//div[@id='alert1748804661282_message']")).getText();
        warningmsg.equalsIgnoreCase("Your client has an adverse caravan/trailer claims history in the last 12 months. The cover request must be approved by a manager.");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    @Parameters({"URL"})
    @Test(priority = 3,enabled = false, description = "UR662-Number of Caravan/Trailer claims in the last 24 months")
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
    @Test(priority = 4,enabled = false, description = "UR654-Motor accumulation per risk address exceeds RAL")
    public void UR654(String URL) throws Exception {
        nimbisUserNavigation.clickCoverBtn();
        Thread.sleep(2000);
        nimbisUserNavigation.clickTrailerCover();
        Thread.sleep(3000);
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
        warningmsg.equalsIgnoreCase("The combined sum insured of all the vehicles at one address exceeds the RAL limit. The cover request must be approved by Hollard.");
        elementFunctionality.captureScreenshotOnDevice("UR654-Motor accumulation per risk address exceeds RAL-for the UW rule");
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickCloseBtn();

    }

    public void caravandetails() throws InterruptedException {
        nimbisTrailer.enterTrailerSum(EH.getCellValueSpecific(1, "Trailer Sum Insured"));

//Vehicle
        nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(1, "Make"));
        nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(1, "Model"));
        nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(1, "Year"));
        nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(1, "Registration Number"));
        //claims
        nimbisTrailer.enterTrailerClaim012Months("3");
        nimbisTrailer.enterTrailerClaim1324Months(EH.getCellValueSpecific(1, "Number of Trailer claims in the last 13 - 24 months, excluding glass damage"));
        nimbisTrailer.enterTrailerClaim2536Months(EH.getCellValueSpecific(1, "Number of Trailer claims in the last 25 - 36 months, excluding glass damage"));
//extensions
        nimbisTrailer.clickTrailerExtension();
        nimbisTrailer.enterTrailerExtensionSum(EH.getCellValueSpecific(1, "sum insured"));
        nimbisUserNavigation.clickSaveBtn();
        Thread.sleep(30000);
        System.out.println("after save");
       // WebDriverWait wait = new WebDriverWait(testB, Duration.ofSeconds(15));
        WebElement moreMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[contains(@class, 'rtbMore') and contains(@style, 'display')]")
        ));

        Actions actions = new Actions(testB);
        actions.moveToElement(moreMenu).perform();

        // nimbisUserNavigation.clickCalculatePremiumBtn();
        Thread.sleep(500);
    }


    public void searchClient() throws InterruptedException {
        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();
        Thread.sleep(3000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(3000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
    }



}
