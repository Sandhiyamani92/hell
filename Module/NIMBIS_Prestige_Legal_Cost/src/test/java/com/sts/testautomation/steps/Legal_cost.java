package com.sts.testautomation.steps;


import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.nimbisutilities.common_functions1;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Legal_cost extends BaseTest {
    private NIMBIS_Login nimbisLogin;
    private NIMBIS_Prestige_Client nimbisPrestigeClient;
    private NIMBIS_UserNavigation nimbisUserNavigation;
    private ElementFunctionality elementFunctionality;
    private NIMBIS_Prestige_Home nimbisPrestigeHome;
    private ExcelHandler EH;
    private String Sheet;
    private NIMBIS_Legal_cost legalCost;
    private common_functions1 common;


    @Parameters({"URL", "Device", "NIMBIS"})
    @BeforeClass(description = "Instantiate Grid")
    public void setupTest(String URL, String device, String datasheet) {
        try {
            HashSetup.SetUpBrowser();
            System.out.println("Instantiating Nodes");
            url = URL;
            Device = device;
            Sheet = datasheet;

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
    @Test(priority = 1, description = "Add Legal Cost Section")
    public void CreateClient(String URL) throws Exception {
        url = URL;
        EH = new ExcelHandler(Sheet, "Legal Cost Test Cases", 0, 0);
        nimbisLogin = new NIMBIS_Login(testB, Device);
        nimbisPrestigeClient = new NIMBIS_Prestige_Client(testB, Device);
        nimbisUserNavigation = new NIMBIS_UserNavigation(testB, Device);
        elementFunctionality = new ElementFunctionality(testB, Device);
        nimbisPrestigeHome = new NIMBIS_Prestige_Home(testB, Device);
        legalCost = new NIMBIS_Legal_cost(testB, Device);
        nimbisUserNavigation.enterSearchText("Vukani Shembe ");
        nimbisUserNavigation.clickSearchBtn();

        Thread.sleep(2000);
        nimbisUserNavigation.clickClientResultName();
        Thread.sleep(4000);
        nimbisUserNavigation.clickAddNewQuote();
        nimbisUserNavigation.clickPrestigeV2_Chkbox();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickPopUpOkBtn();
        JavascriptExecutor js = (JavascriptExecutor) testB;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        nimbisUserNavigation.clickNextBtn();
        nimbisUserNavigation.clickOpenQuote();
        Thread.sleep(1500);
        for (int i = 1; i <= EH.numRows; i++) {
            try {
                nimbisUserNavigation.clickCoverBtn();
                nimbisUserNavigation.clickLegalCostCover();
                Thread.sleep(2000);
                nimbisUserNavigation.clickAddNewItemBtn();
                Thread.sleep(2000);
                nimbisUserNavigation.changeFocus2();

                //  legalCost.clickLegalSumDropDown();
                Thread.sleep(1000);
                boolean selectionSuccess=   selectByIndex(i);
                //  nimbisUserNavigation.selectOption(EH.getCellValueSpecific(i,"Legal costs sum insured"));
                common.calculatePremium();
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                ExtentTestManager.getTest().pass("TEST CASE " + i + "Passed");
                System.err.println("TEST CASE " + i + " Passed");
            } catch (Exception e) {
                nimbisUserNavigation.changeFocusToBrowser();
                System.out.println(e.toString());
                Thread.sleep(1000);
                nimbisUserNavigation.clickCloseBtn();
                Thread.sleep(1000);
                nimbisUserNavigation.changeFocusToBrowser();
                Thread.sleep(1000);
                System.out.println("Test Case  : " + i);
                ExtentTestManager.getTest().fail("TEST CASE " + i + "Failed");
                System.err.println("TEST CASE " + i + " Failed");
            }
        }
    }

    public boolean selectByIndex(int index) {
        try {


            System.out.println("Attempting to select item at index: " + index);

            // First, try to find the dropdown container
            WebElement dropdownContainer = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.className("rcbList")));

            if (!dropdownContainer.isDisplayed()) {
                System.out.println("Dropdown is not visible. Trying to open it...");
                // Try to click on the dropdown to open it
                WebElement dropdownTrigger = testB.findElement(By.className("rcbInputCell"));
                dropdownTrigger.click();
                Thread.sleep(1000);
            }

            // Get all li elements with better locator
            List<WebElement> listItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector(".rcbList .rcbItem")));

            System.out.println("Found " + listItems.size() + " dropdown items");

            // Print all available options for debugging
            for (int i = 0; i < listItems.size(); i++) {
                System.out.println("Item " + i + ": " + listItems.get(i).getText());
            }

            if (index >= 0 && index < listItems.size()) {
                WebElement targetItem = listItems.get(index);

                // Scroll to element if needed
                ((JavascriptExecutor) testB).executeScript("arguments[0].scrollIntoView(true);", targetItem);
                Thread.sleep(500);

                // Click the item
                targetItem.click();
                System.out.println("Successfully selected item at index: " + index + " with text: " + targetItem.getText());
                return true;

            } else {
                System.out.println("Index " + index + " is out of bounds. Available items: " + listItems.size());
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error in selectByIndexImproved: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}










