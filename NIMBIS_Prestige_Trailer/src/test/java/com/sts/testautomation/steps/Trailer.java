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
import org.apache.commons.math3.stat.descriptive.moment.SemiVariance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.server.handler.interactions.touch.Down;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import java.util.concurrent.TimeUnit;
public class Trailer extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private ExcelHandler EH;
    private String Sheet;
    private NIMBIS_Caravan nimbisCaravn;
    private NIMBIS_Trailer nimbisTrailer;



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
    @Test(priority = 1, description = "Add Trailer Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;

        EH = new ExcelHandler(Sheet, "Trailer Test Cases", 0, 0);

        nimbisLogin = new NIMBIS_Login(testB,Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB,Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB,Device);
        elementFunctionality = new ElementFunctionality(testB,Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB,Device);


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
    for(int i = 1 ; i < EH.numRows ; i ++){
        try{
            nimbisUserNavigation.clickCoverBtn();
            nimbisUserNavigation.clickTrailerCover();
            Thread.sleep(2000);
            nimbisUserNavigation.clickAddNewItemBtn();

            Thread.sleep(6000);
            nimbisUserNavigation.changeFocus2();
            //details
            nimbisTrailer.clickFinaced();
            nimbisTrailer.enterFinanceHouse(EH.getCellValueSpecific(i, "Finance House"));
            nimbisTrailer.enterFinancePeriod(EH.getCellValueSpecific(i, "Period finance"));
            nimbisTrailer.enterTrailerSum(EH.getCellValueSpecific(i, "Trailer Sum Insured"));
            //Vehicle
            nimbisCaravn.enterCaravanMake(EH.getCellValueSpecific(i, "Make"));
            nimbisCaravn.enterCaravanModel(EH.getCellValueSpecific(i, "Model"));
            nimbisCaravn.enterCaravanYear(EH.getCellValueSpecific(i, "Year"));
            nimbisCaravn.enterRegisterNumber(EH.getCellValueSpecific(i, "Registration Number"));
            //claims
            nimbisCaravn.enterCaravanClaim012Months(EH.getCellValueSpecific(i, "Number of Trailer claims in the last 12 months, excluding glass damage"));
            nimbisCaravn.enterCaravanClaim1324Months(EH.getCellValueSpecific(i, "Number of Trailer claims in the last 13 - 24 months, excluding glass damage"));
            nimbisCaravn.enterCaravanClaim2536Months(EH.getCellValueSpecific(i, "Number of Trailer claims in the last 25 - 36 months, excluding glass damage"));
//extensions
            nimbisCaravn.clickExtension();
            nimbisCaravn.enterExtensionSum(EH.getCellValueSpecific(i, "sum insured"));

            nimbisUserNavigation.clickSaveBtn();
            Thread.sleep(2000);
            // nimbisUserNavigation.changeFocus2();
            WebElement premiumBtn=  testB.findElement(By.xpath("//span[@class='rtbText' and normalize-space()='Calculate Coverage Premiums']"));

            js.executeScript("arguments[0].click();",premiumBtn);
            //  nimbisUserNavigation.clickCalculatePremiumBtn();
            Thread.sleep(500);
            // nimbisUserNavigation.changeFocusToAlert();
            nimbisUserNavigation.clickPopUpOkRateBtn();
            Thread.sleep(1000);

            Thread.sleep(1000);
            nimbisUserNavigation.clickSaveBtn();

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
}































