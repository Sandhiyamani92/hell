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

public class CreateContentsNewQuote extends BaseTest {
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
							System.out.println("Hollard Sapiens Test started on " + currentNode.getKey());

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

	@Test(priority = 1, enabled = false, description = "Add new client and contents")
    public void addNewClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Contents", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 48 ;i <= 48; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i+1, 1, "ContentsResults", timeStamp);
                			Thread.sleep(8000);
                			createQuotesBuilding.hoverOverQuotationElement();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickAddNewQuote();
                			
                			//Thread.sleep(4000);
                		//	createQuotesBuilding.clickBroker();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(4000);
                			//createQuotesBuilding.clickOnPrivatePortfolioCheckbx();
                		//	createQuotesBuilding.clickOnNextBtn();
                		//	Thread.sleep(4000);
                		//	
                		//	Thread.sleep(4000);
                			
                		createQuotesBuilding.enterClientSearch(EH.getCellValueSpecific(i, "identification"));
                		createQuotesBuilding.clickOnSearchBtn();
                		Thread.sleep(3000);
                		createQuotesBuilding.clickOnClientBtn();
                			Thread.sleep(8000);
                			createQuotesBuilding.clickOnNextBtn();
                			
                		//	createQuotesBuilding.clickCloseAlertBtn();
                			Thread.sleep(8000);
                		//	createQuotesBuilding.clickEditQuote();
                		//	createQuotesBuilding.clickOnNextBtn();
                			/*
        					createQuotesBuilding.enterClientFirstNameTxtBx(EH.getCellValueSpecific(i, "firstName"));
        					createQuotesBuilding.enterClientLastNameTxtBx(EH.getCellValueSpecific(i, "lastName"));
        					createQuotesBuilding.enterClientIdentification(EH.getCellValueSpecific(i, "identification"));
        					createQuotesBuilding.enterEmploymentStatus(EH.getCellValueSpecific(i, "employmentStatus"));
        					createQuotesBuilding.enterLanguage(EH.getCellValueSpecific(i, "language"));
        					createQuotesBuilding.enterMaritalStatus(EH.getCellValueSpecific(i, "maritalStatus"));
        					createQuotesBuilding.enterOccupation(EH.getCellValueSpecific(i, "occupation"));

                		//	Thread.sleep(3000);
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
*/
                			//Thread.sleep(5000);
        				//	createQuotesBuilding.clickOnNextBtn();
                		//	Thread.sleep(5000);
        					//createQuotesBuilding.clickOnNextBtn();
        					//Thread.sleep(4000);
        					//createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(7000);
        					//createQuotesBuilding.clickOpenQuote();
        					Thread.sleep(5000);
                		
        					setExcelData(Sheet, i+1, 7, "ContentsResults", createQuotesBuilding.quoteNumber());
        					Thread.sleep(5000);
        					//createQuotesBuilding.clickChangeCollectionFrequency();
        				//	Thread.sleep(3000);
        					
        					//createQuotesBuilding.changeFocus2();
        					//createQuotesBuilding.enterCollectionFrequency(EH.getCellValueSpecific(i, "collectionFrequency"));
        				
        				//	Thread.sleep(2000);
        				//	createQuotesBuilding.clickSaveCollectionFrequency();      					
        				//	Thread.sleep(2000);
        				//	createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickCover();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickContents();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickAddNewItem();
        					Thread.sleep(1000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(1000);
        	
        					createQuotesBuilding.enterPropertySumInsured(EH.getCellValueSpecific(i, "propertySumInsured"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterTypeOfHome(EH.getCellValueSpecific(i, "typeOfHome"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterTypeOfRoof(EH.getCellValueSpecific(i, "typeOfRoof"));
        					Thread.sleep(8000);
        					createQuotesBuilding.enterTypeOfWall(EH.getCellValueSpecific(i, "typeOfWall"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterCoverTypeContent(EH.getCellValueSpecific(i, "coverType"));
        					createQuotesBuilding.enterBasicExcessContents(EH.getCellValueSpecific(i, "basicExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterCompulsaryExcessContents(EH.getCellValueSpecific(i, "compulsaryExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterVoluntaryExcessContents(EH.getCellValueSpecific(i, "voluntaryExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterZeroToTwelveMonthsClaimsContents(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims"));
        					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaimsContents(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims"));
        					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaimsContents(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims"));
        				
        					if(EH.getCellValueSpecific(i, "burglarBars").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickBurglarBars();
        						
        					}
        					
        					
        					if(EH.getCellValueSpecific(i, "securityGates").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickSecurityGates();
        						
        					}
        					if(EH.getCellValueSpecific(i, "electricFence").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickElectricFence();
        						
        					}
        					if(EH.getCellValueSpecific(i, "highSecurityComplex").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickHighSecurityComplex();
        						
        					}
        					if(EH.getCellValueSpecific(i, "alarmArmedResponse").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickAlarmLinked();
        						
        					}
        					
        					if(EH.getCellValueSpecific(i, "ACCDAM").equalsIgnoreCase("ACCDAM"))
        					{
        						createQuotesBuilding.clickAccidentalCoverContents();
        						createQuotesBuilding.enterAccidentalCoverContentsSumInsured(EH.getCellValueSpecific(i, "ACCDAM_sumInsured"));
        						
        					}
        					if(EH.getCellValueSpecific(i, "ACCDAMFXD").equalsIgnoreCase("ACCDAMFXD"))
        					{
        						createQuotesBuilding.clickAccidentalInsideCover();
        						
        					}
        					
        					if(EH.getCellValueSpecific(i, "bedAndBreakfast").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickBedAndBreakfast();
        						createQuotesBuilding.enterBedAndBreakfastSumInsured(EH.getCellValueSpecific(i, "ACCDAM_sumInsured"));
        					}
        					
        					if(EH.getCellValueSpecific(i, "homeBasedBusinessStock").equalsIgnoreCase("1"))
        					{
        						createQuotesBuilding.clickHomeBasedBusinessStock();
        						
        					}
        					
        					
        					if(EH.getCellValueSpecific(i, "Keys").equalsIgnoreCase("Keys"))
        					{
        						createQuotesBuilding.clickKeysContents();
        						
        					}
        					if(EH.getCellValueSpecific(i, "PSURGE").equalsIgnoreCase("PSURGE"))
        					{
        						createQuotesBuilding.clickPowerSurgeContents();
        						createQuotesBuilding.enterPowerSurgeContentsSumInsured(EH.getCellValueSpecific(i, "PSURGE_sumInsured"));
        					}
        					
        					if(EH.getCellValueSpecific(i, "SUBSIDE").equalsIgnoreCase("SUBSIDE"))
        					{
        						createQuotesBuilding.clickSubsidenceContents();
        					}
        					
        					Thread.sleep(10000);        				
        					createQuotesBuilding.clickSaveBuilding();
        					Thread.sleep(5000);
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(9000);
        					createQuotesBuilding.clickCalculatePremiums();
        					Thread.sleep(10000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(10000);
        					setExcelData(Sheet, i+1, 20, "ContentsResults", createQuotesBuilding.finalPremium());
        					createQuotesBuilding.clickSavePremium();
        					createQuotesBuilding.changeFocusToBrowser();
        				
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i+1, 2, "ContentsResults", timeStamp2);

        					
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

                        	EH = new ExcelHandler(Sheet, "ContentsResults", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 79; i <= 79; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			
                			createQuotesBuilding.changeFocusToBrowser();
                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "ContentsResults", timeStamp);
                			Thread.sleep(2000);
                			
                			createQuotesBuilding.enterTextToSearch(EH.getCellValueSpecific(i, "Policy Number"));
                			createQuotesBuilding.clickMainSearchButton();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickQuote();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickCover();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickContents();
                			Thread.sleep(8000);
                			createQuotesBuilding.clickCalculatePremiums();
                    
        					Thread.sleep(10000);
        				
        					createQuotesBuilding.changeFocus2();
        				//	setExcelData(Sheet, i, 19, "ContentsResults", createQuotesBuilding.basePremium() );
        					setExcelData(Sheet, i, 21, "ContentsResults", createQuotesBuilding.finalPremium());
        					createQuotesBuilding.clickSavePremium();
        					Thread.sleep(4000);
        					createQuotesBuilding.changeFocusToBrowser();
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "ContentsResults", timeStamp2);
                    		Thread.sleep(5000);
        					
                		}catch(Exception e) {
    							e.printStackTrace();
    						
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
