package com.sts.testautomation.steps;

import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.NIMBIS_Login;
import com.sts.testautomation.pages.web.NIMBIS_Prestige_Client;
import com.sts.testautomation.pages.web.NIMBIS_UserNavigation;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import java.util.concurrent.TimeUnit;



public class CreateClient_NIMBIS extends BaseTest {

private NIMBIS_Login nimbisLogin;
private NIMBIS_Prestige_Client nimbisPrestigeClient;
private NIMBIS_UserNavigation nimbisUserNavigation;
private ElementFunctionality elementFunctionality;
private ExcelHandler EH;



    @Parameters({"URL", "Device"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device) {
        try {
            HashSetup.SetUpBrowser();

            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;

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
    public void Login(String URL) throws InterruptedException {
        url = URL;

        nimbisLogin = new NIMBIS_Login(testB,Device);

        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        nimbisLogin.enterUsername("nathaniel.smith");
        nimbisLogin.clickContinueBtn();
        nimbisLogin.enterPassword("9c)i[3m#080LsPA");
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
   //     EH = new ExcelHandler("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\Tial_FrontEnd Fields.xlsx", "Clients Test Cases", 0, 0);


        //  testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        for (int i = 0 ; i < 2 ; i++){
            nimbisUserNavigation.clickQuotation_DD();
            nimbisUserNavigation.clickAddNewQuote_DD();
            nimbisUserNavigation.clickPrestigeV2_Chkbox();
            nimbisUserNavigation.clickNextBtn();
            nimbisUserNavigation.clickNextBtn();

            nimbisPrestigeClient.enterFirstName("Mark");
            nimbisPrestigeClient.enterLastName("Delap");

            nimbisPrestigeClient.enterIdentificationNumber("9208148266182");
            JavascriptExecutor js = (JavascriptExecutor) testB;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            nimbisPrestigeClient.clickTitle();
            nimbisUserNavigation.selectOption("Mr");

            nimbisPrestigeClient.selectITCPermission("Yes");
            nimbisPrestigeClient.selectSequestration("Yes");
            nimbisPrestigeClient.selectPreviousInsurance("Yes");
            nimbisPrestigeClient.selectCriminalOffenceConvictions("Yes");
            nimbisPrestigeClient.selectPreviousInsuranceCancelled("Yes");

            nimbisPrestigeClient.enterEmailAddress("testingemail@email.com");

            nimbisUserNavigation.clickNextBtn();
            Thread.sleep(3000);
            nimbisPrestigeClient.enterPostalCode("Lenasia");
            nimbisUserNavigation.selectOption("Lenasia");

            nimbisPrestigeClient.enterStreet("Protea Street");
            nimbisPrestigeClient.enterBuilding("13567");

            nimbisUserNavigation.clickNextBtn();




        }


    }
}

