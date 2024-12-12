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

public class CreateAllRiskNewQuote extends BaseTest {
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

	@Test(priority = 1, enabled = false, description = "Add new client and All Risk")
    public void addNewClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "AllRisks", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 32; i <= 34 ; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "AllRiskResults", timeStamp);
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
                			Thread.sleep(6000);
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
                			Thread.sleep(3000);
        					setExcelData(Sheet, i, 7, "AllRiskResults", createQuotesBuilding.quoteNumber());
        				//	Thread.sleep(5000);
        				//	createQuotesBuilding.clickChangeCollectionFrequency();
        					Thread.sleep(3000);
        			//		
        			//		createQuotesBuilding.changeFocus2();
        			//		createQuotesBuilding.enterCollectionFrequency(EH.getCellValueSpecific(i, "collectionFrequency"));
        				
        			//		Thread.sleep(2000);
        					//createQuotesBuilding.clickSaveCollectionFrequency();      					
        			//		Thread.sleep(2000);
        			//		createQuotesBuilding.changeFocusToBrowser();
        				//	Thread.sleep(1000);
        					createQuotesBuilding.clickCover();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickAllRisk();        				
        					Thread.sleep(1000);
        					createQuotesBuilding.clickAddNewItem();
        					Thread.sleep(1000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(1000);
        					createQuotesBuilding.enterAllRiskSumInsured(EH.getCellValueSpecific(i, "allRiskSumInsured"));
        					createQuotesBuilding.enterAllRiskCategoryAR(EH.getCellValueSpecific(i, "allRisksCategory"));
        					createQuotesBuilding.enterMakeDescriptionAR(EH.getCellValueSpecific(i, "makeDescription"));
        					createQuotesBuilding.enterManufacturerAR(EH.getCellValueSpecific(i, "manufacturer"));
        					createQuotesBuilding.enterSerialNumberAR(EH.getCellValueSpecific(i, "serialNumber"));

        					
        					
        					Thread.sleep(10000);
            					createQuotesBuilding.clickSaveBuilding();
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(8000);
            					
            					if(EH.getCellValueSpecific(i, "remoteBlocker").equalsIgnoreCase("1"))
            					{
            						
            						createQuotesBuilding.clickRemoteBlocker();
            						Thread.sleep(3000);
            						createQuotesBuilding.clickSaveExtensionsAllRisk();
            						
            					}
            					
            					Thread.sleep(4000);
            					createQuotesBuilding.clickCalculatePremiums();
            					Thread.sleep(8000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(5000);
            				//	setExcelData(Sheet, i, 19, "AllRiskResults", createQuotesBuilding.basePremiumAR());
            					setExcelData(Sheet, i, 20, "AllRiskResults", createQuotesBuilding.finalPremium2());
            					Thread.sleep(5000);
            					createQuotesBuilding.clickSavePremium();
            					Thread.sleep(5000);
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(5000);
        						
        					
        					
        					
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "AllRiskResults", timeStamp2);

        					
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
	
	@Test(priority = 1, enabled = true, description = "Find existing quote and rerate")
    public void rateExistingClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "AllRiskResults", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 47; i <= 47; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			
                			createQuotesBuilding.changeFocusToBrowser();
                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "AllRiskResults", timeStamp);
                			Thread.sleep(2000);
                			
                			createQuotesBuilding.enterTextToSearch(EH.getCellValueSpecific(i, "Policy Number"));
                			createQuotesBuilding.clickMainSearchButton();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickQuote();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickCover();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickAllRisk();
                			Thread.sleep(5000);
                			      
                			createQuotesBuilding.clickCalculatePremiums();
                    
        					Thread.sleep(10000);
        				
        					createQuotesBuilding.changeFocus2();
        				//	setExcelData(Sheet, i, 19, "ContentsResults", createQuotesBuilding.basePremium() );
        					setExcelData(Sheet, i, 20, "AllRiskResults", createQuotesBuilding.finalPremium2());
        					createQuotesBuilding.clickSavePremium();
        					Thread.sleep(4000);
        					createQuotesBuilding.changeFocusToBrowser();
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "AllRiskResults", timeStamp2);
                    		Thread.sleep(5000);
        					
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
        }
		// Assert.fail();

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
