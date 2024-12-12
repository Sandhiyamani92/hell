package com.sts.testautomation;

import com.sts.testautomation.deviceConfig.BrowserNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.pages.web.*;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreatePersonalComputerNewQuote extends BaseTest {
	ExcelHandler excelHandler = new ExcelHandler();

	private String Sheet;
	private LoginPage loginPage;
	private ElementFunctionality automationUtilities;
	private ExcelHandler EH;

	private CreateQuotesBuilding createQuotesBuilding;


	@Parameters({ "URL", "Device", "NimbisTestData" })
	@BeforeClass(description = "Instantiate Grid")
	public void setupTest(String URL, String device, String datasheet) {
		try {
			HashSetup.SetUpBrowser();

			System.out.println("Instantiating Nodes");
			url = URL;
			Device = device;
			Sheet = datasheet;

			// Loop runs through all the Nodes in the Grid and performs the tests on them
			for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
				if (currentNode.getKey().equals(Device)) {
					// Browsers
					if (currentNode.getValue() instanceof BrowserNode) {
						try {
							BrowserNode bNode = ((BrowserNode) currentNode.getValue());
							System.out.println("Hollard Nimbis Test started on " + currentNode.getKey());

							//WebDriverManager.chromedriver().setup();
							System.out.println("Creation of driver");

							ChromeOptions options = new ChromeOptions();
							options.addArguments("headless");
							// testB = new ChromeDriver(options);
							testB = new ChromeDriver();
							System.out.println("Navigation to Hollard Nimbis");
							testB.navigate().to(url);
							testB.manage().window().maximize();
							testB.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

							System.out.println("Navigation to Nimbis");

					
							loginPage = new LoginPage(testB, Device);
							createQuotesBuilding = new CreateQuotesBuilding(testB, Device);
						

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

	@Test(priority = 0, enabled = true, description = "Login to Nimbis")
	public void Login() {
		try {
			// Loop runs through all the Nodes in the Grid and performs the tests on them
			for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
				if (currentNode.getKey().equals(Device)) {

					// Browsers
					if (currentNode.getValue() instanceof BrowserNode) {
						ElementFunctionality test = null;
						try {

							EH = new ExcelHandler(Sheet, "LoginSuccess", 0, 0);

							
								loginPage.enterUsername(EH.getCellValueSpecific(1, "Username"));
								loginPage.clickContinueButton();
								
								loginPage.enterPassword(EH.getCellValueSpecific(1, "Password"));
	
								loginPage.clickLoginButton();
					

						} catch (Exception e) {
							e.printStackTrace();

						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			// Assert.fail();

		}

	}

	@Test(priority = 1, enabled = true, description = "Add new client and personal computer")
    public void addNewClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "PersonalComputer", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 13; i <= 13; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "PersonalComputerResults", timeStamp);
                			Thread.sleep(8000);
                			createQuotesBuilding.changeFocusToBrowser();
                			createQuotesBuilding.hoverOverQuotationElement();
                			createQuotesBuilding.clickAddNewQuote();
                			
                		//	Thread.sleep(4000);
                		//	createQuotesBuilding.clickBroker();
                		//	Thread.sleep(4000);
                		//	createQuotesBuilding.clickOnNextBtn();
                		//	Thread.sleep(4000);
                		//	createQuotesBuilding.clickOnPrivatePortfolioCheckbx();
                			createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(4000);
                			
                			//	Thread.sleep(4000);
                			
                        		createQuotesBuilding.enterClientSearch(EH.getCellValueSpecific(i, "identification"));
                        		createQuotesBuilding.clickOnSearchBtn();
                        		Thread.sleep(3000);
                        		createQuotesBuilding.clickOnClientBtn();
                        		Thread.sleep(8000);
                			createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(4000);
                			Thread.sleep(5000);
                		//	createQuotesBuilding.clickEditQuote();
                			/*
        					createQuotesBuilding.enterClientFirstNameTxtBx(EH.getCellValueSpecific(i, "firstName"));
        					createQuotesBuilding.enterClientLastNameTxtBx(EH.getCellValueSpecific(i, "lastName"));
        					createQuotesBuilding.enterClientIdentification(EH.getCellValueSpecific(i, "identification"));
        					createQuotesBuilding.enterEmploymentStatus(EH.getCellValueSpecific(i, "employmentStatus"));
        					createQuotesBuilding.enterLanguage(EH.getCellValueSpecific(i, "language"));
        					createQuotesBuilding.enterMaritalStatus(EH.getCellValueSpecific(i, "maritalStatus"));
        					createQuotesBuilding.enterOccupation(EH.getCellValueSpecific(i, "occupation"));

        					createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(2000);
        					createQuotesBuilding.enterComplex(EH.getCellValueSpecific(i, "complexAddress"));
        					createQuotesBuilding.enterBuilding(EH.getCellValueSpecific(i, "buildingAddress"));
        					createQuotesBuilding.enterStreet(EH.getCellValueSpecific(i, "streetAddress"));
        					createQuotesBuilding.enterCity(EH.getCellValueSpecific(i, "city"));

        					createQuotesBuilding.enterPostalCode(EH.getCellValueSpecific(i, "postCode"));
        					createQuotesBuilding.clickPostalCode() ;
                			Thread.sleep(2000);
        					createQuotesBuilding.enterProvince(EH.getCellValueSpecific(i, "province"));

        					createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(5000);
        					createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(3000);
        					createQuotesBuilding.clickOpenQuote();
        					Thread.sleep(2000);
        					createQuotesBuilding.clickOpenQuote();
        					Thread.sleep(2000);
        					*/
                			Thread.sleep(8000);
        					setExcelData(Sheet, i, 7, "PersonalComputerResults", createQuotesBuilding.quoteNumber());
        					Thread.sleep(5000);
        				
        					createQuotesBuilding.clickCover();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickPersonalComputer();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickAddNewItem();
        					Thread.sleep(1000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(1000);
        					createQuotesBuilding.enterPersonalComputerSumInsured(EH.getCellValueSpecific(i, "personalComputerSumInsured"));
        					createQuotesBuilding.enterAllRiskCategory(EH.getCellValueSpecific(i, "allRisksCategory"));
        					createQuotesBuilding.enterMakeDescription(EH.getCellValueSpecific(i, "makeDescription"));
        					createQuotesBuilding.enterManufacturer(EH.getCellValueSpecific(i, "manufacturer"));
        					createQuotesBuilding.enterSerialNumber(EH.getCellValueSpecific(i, "serialNumber"));

        					
        					
        					if(EH.getCellValueSpecific(i, "electricBreakdown").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickElectricBreakdown();
        						createQuotesBuilding.enterElectronicBreakdownSumInsured(EH.getCellValueSpecific(i, "electricBreakdownSumInsured"));
        					}
        					if(EH.getCellValueSpecific(i, "reinstatementOfData").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickReinstatementOfData();
        						createQuotesBuilding.enterReinstatementOfDataSumInsured(EH.getCellValueSpecific(i, "reinstatementOfDataSumInsured"));
        						
        					}
        					if(EH.getCellValueSpecific(i, "ensureCompatibility").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickEnsureCompatibility();
        						createQuotesBuilding.enterEnsureCompatibilitySuminsured(EH.getCellValueSpecific(i, "ensureCompatibilitySumInsured"));
        					}
        					
        					Thread.sleep(13000);
            					createQuotesBuilding.clickSaveBuilding();
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(8000);
            					createQuotesBuilding.clickCalculatePremiums();
            					Thread.sleep(8000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(5000);
            					setExcelData(Sheet, i, 20, "PersonalComputerResults", createQuotesBuilding.finalPremiumPC());
            					setExcelData(Sheet, i, 19, "PersonalComputerResults", createQuotesBuilding.basePremiumPC());
            					Thread.sleep(5000);
            					createQuotesBuilding.clickSavePremium();
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(5000);
        						
        					
        					
        					
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "PersonalComputerResults", timeStamp2);

        					
                		}catch(Exception e) {
    							e.printStackTrace();
    						//	setExcelData(Sheet, i, 85, "Buildings", "Failed");
    						} 
                       }

                        } catch (Exception e) {
                            e.printStackTrace();


                        }

                    }

                }
            }
            
            


        }catch(Exception e){
		e.printStackTrace();
		// Assert.fail();

	}

}
	

	
	
	
	@AfterTest
	public void closeBrowser() throws Throwable {
		try {
			// Loop runs through all the Nodes in the Grid and performs the tests on them
			for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
				if (currentNode.getKey().equals(Device)) {

					// Browsers
					// if (currentNode.getValue() instanceof BrowserNode) {
					try {

						// testB.quit();

					} catch (Exception e) {
						e.printStackTrace();
						Assert.fail();
					}

				}

			}
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
