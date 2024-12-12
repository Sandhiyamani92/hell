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

public class CreateBuildingsNewQuote extends BaseTest {
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

	@Test(priority = 1, enabled = false, description = "Add new client and building")
    public void addNewClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Buildings", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 7; i <= 7; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "BuildingsResults", timeStamp);
                			Thread.sleep(2000);
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
                			createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(4000);
                			
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
        					Thread.sleep(8000);
        					createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(3000);
        					createQuotesBuilding.clickOpenQuote();
        					Thread.sleep(2000);
        					setExcelData(Sheet, i, 8, "BuildingsResults", createQuotesBuilding.quoteNumber());
        					Thread.sleep(5000);
        					createQuotesBuilding.clickChangeCollectionFrequency();
        					Thread.sleep(3000);
        					
        					createQuotesBuilding.changeFocus2();
        					createQuotesBuilding.enterCollectionFrequency(EH.getCellValueSpecific(i, "collectionFrequency"));
        				
        					Thread.sleep(2000);
        					createQuotesBuilding.clickSaveCollectionFrequency();      					
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickCover();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickBuilding();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickAddNewItem();
        					Thread.sleep(1000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(1000);
        	
        					createQuotesBuilding.enterPropertySumInsured(EH.getCellValueSpecific(i, "propertySumInsured"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterTypeOfHome(EH.getCellValueSpecific(i, "typeOfHome"));
        					createQuotesBuilding.enterTypeOfRoof(EH.getCellValueSpecific(i, "typeOfRoof"));
        					createQuotesBuilding.enterTypeOfWall(EH.getCellValueSpecific(i, "typeOfWall"));
        					createQuotesBuilding.enterLocality(EH.getCellValueSpecific(i, "Locality"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterBasicExcess(EH.getCellValueSpecific(i, "basicExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterCompulsaryExcess(EH.getCellValueSpecific(i, "compulsaryExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterVoluntaryExcess(EH.getCellValueSpecific(i, "voluntaryExcess"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterZeroToTwelveMonthsClaims(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims"));
        					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaims(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims"));
        					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaims(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims"));
        					createQuotesBuilding.enterFinancialInstitution(EH.getCellValueSpecific(i, "financialInstitution"));
        					createQuotesBuilding.enterRegisteredOwner(EH.getCellValueSpecific(i, "registeredOwner"));

        					if(EH.getCellValueSpecific(i, "ACCDAM").equalsIgnoreCase("ACCDAM"))
        					{
        						createQuotesBuilding.clickAccidentalBuildingsCover();
        						createQuotesBuilding.enterAccidentalBuildingsCoverSumInsured(EH.getCellValueSpecific(i, "ACCDAM_sumInsured"));
        						
        					}
        					if(EH.getCellValueSpecific(i, "ACCDAMFXD").equalsIgnoreCase("ACCDAMFXD"))
        					{
        						createQuotesBuilding.clickAccidentalFixedCover();
        						
        					}
        					if(EH.getCellValueSpecific(i, "GEYSER").equalsIgnoreCase("GEYSER"))
        					{
        						createQuotesBuilding.clickGeyserCover();
        						
        					}
        					if(EH.getCellValueSpecific(i, "Keys").equalsIgnoreCase("Keys"))
        					{
        						createQuotesBuilding.clickKeysCover();
        						
        					}
        					if(EH.getCellValueSpecific(i, "PSURGE").equalsIgnoreCase("PSURGE"))
        					{
        						createQuotesBuilding.clickPowerSurgeCover();
        						createQuotesBuilding.enterPowerSurgeSumInsured(EH.getCellValueSpecific(i, "PSURGE_sumInsured"));
        					}
        				
        					createQuotesBuilding.clickSaveBuilding();
        					Thread.sleep(10000);
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(10000);
        					createQuotesBuilding.clickCalculatePremiums();
        					Thread.sleep(10000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(10000);
        					setExcelData(Sheet, i, 21, "BuildingsResults", createQuotesBuilding.finalPremium());
        					createQuotesBuilding.clickSavePremium();
        					createQuotesBuilding.changeFocusToBrowser();
        					
        					//Two or more buildings
        					Thread.sleep(3000);
        					if((EH.getCellValueSpecific(i, "building2").equalsIgnoreCase("1"))) {
        						
        						
            					Thread.sleep(1000);
            					createQuotesBuilding.clickBuilding();
            					Thread.sleep(1000);
            					createQuotesBuilding.clickAddNewItem();
            					Thread.sleep(1000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(1000);
            					createQuotesBuilding.clickOnNewAddress();
            					Thread.sleep(4000);
            					createQuotesBuilding.changeFocusAddressWindow();
            					
            					createQuotesBuilding.enterComplex2(EH.getCellValueSpecific(i, "complexAddress2"));
            					createQuotesBuilding.enterBuilding2(EH.getCellValueSpecific(i, "buildingAddress2"));
            					createQuotesBuilding.enterStreet2(EH.getCellValueSpecific(i, "streetAddress2"));
            					createQuotesBuilding.enterCity2(EH.getCellValueSpecific(i, "city2"));
            					createQuotesBuilding.enterPostalCode2(EH.getCellValueSpecific(i, "postCode2"));
            					createQuotesBuilding.clickPostalCode() ;
                    			Thread.sleep(2000);
            					createQuotesBuilding.clickAddNewAddress();
            					Thread.sleep(5000);
            					createQuotesBuilding.changeFocusToBrowser();
            					createQuotesBuilding.changeFocus2();
            				//	createQuotesBuilding.enterNewAddress(EH.getCellValueSpecific(i, "complexAddress2"));
            					createQuotesBuilding.enterPropertySumInsured(EH.getCellValueSpecific(i, "propertySumInsured2"));
            				/*	Thread.sleep(1000);
            					createQuotesBuilding.enterTypeOfHome(EH.getCellValueSpecific(i, "typeOfHome"));
            					Thread.sleep(1000);*/
            					createQuotesBuilding.enterTypeOfRoof(EH.getCellValueSpecific(i, "typeOfRoof2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterTypeOfWall(EH.getCellValueSpecific(i, "typeOfWall2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterLocality(EH.getCellValueSpecific(i, "Locality"));
            					createQuotesBuilding.enterBasicExcess(EH.getCellValueSpecific(i, "basicExcess2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterCompulsaryExcess(EH.getCellValueSpecific(i, "compulsaryExcess2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterVoluntaryExcess(EH.getCellValueSpecific(i, "voluntaryExcess2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterZeroToTwelveMonthsClaims(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims2"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaims(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims2"));
            					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaims(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims2"));
            					createQuotesBuilding.enterZeroToTwelveMonthsClaims(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims2"));
            				
            					Thread.sleep(2000);
            					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaims(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims2"));

            					createQuotesBuilding.enterFinancialInstitution(EH.getCellValueSpecific(i, "financialInstitution2"));
            					createQuotesBuilding.enterRegisteredOwner(EH.getCellValueSpecific(i, "registeredOwner2"));

            					if(EH.getCellValueSpecific(i, "ACCDAM").equalsIgnoreCase("ACCDAM2"))
            					{
            						createQuotesBuilding.clickAccidentalBuildingsCover();
            						createQuotesBuilding.enterAccidentalBuildingsCoverSumInsured(EH.getCellValueSpecific(i, "ACCDAM_sumInsured2"));
            						
            					}
            					if(EH.getCellValueSpecific(i, "ACCDAMFXD2").equalsIgnoreCase("ACCDAMFXD"))
            					{
            						createQuotesBuilding.clickAccidentalFixedCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "GEYSER2").equalsIgnoreCase("GEYSER"))
            					{
            						createQuotesBuilding.clickGeyserCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "GEYSER2").equalsIgnoreCase("GEYSER"))
            					{
            						createQuotesBuilding.clickGeyserCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "Keys2").equalsIgnoreCase("Keys"))
            					{
            						createQuotesBuilding.clickKeysCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "PSURGE2").equalsIgnoreCase("PSURGE"))
            					{
            						createQuotesBuilding.clickPowerSurgeCover();
            						createQuotesBuilding.enterPowerSurgeSumInsured(EH.getCellValueSpecific(i, "PSURGE_sumInsured2"));
            					}
            					Thread.sleep(4000);
            					createQuotesBuilding.clickSaveBuilding();
            					
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(10000);
            					createQuotesBuilding.clickCalculatePremiums();
            					Thread.sleep(10000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(10000);
            					setExcelData(Sheet, i+1, 21, "BuildingsResults", createQuotesBuilding.finalPremium2());
            					createQuotesBuilding.clickSavePremium();
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(5000);
        					}
        					
        					
        					if((EH.getCellValueSpecific(i, "building3").equalsIgnoreCase("1"))) {
        						
        						
            					Thread.sleep(5000);
            					createQuotesBuilding.clickBuilding();
            					Thread.sleep(1000);
            					createQuotesBuilding.clickAddNewItem();
            					Thread.sleep(1000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(1000);
            					createQuotesBuilding.clickOnNewAddress();
            					Thread.sleep(4000);
            					createQuotesBuilding.changeFocusAddressWindow();
            					
            					createQuotesBuilding.enterComplex2(EH.getCellValueSpecific(i, "complexAddress3"));
            					createQuotesBuilding.enterBuilding2(EH.getCellValueSpecific(i, "buildingAddress3"));
            					createQuotesBuilding.enterStreet2(EH.getCellValueSpecific(i, "streetAddress3"));
            					createQuotesBuilding.enterCity2(EH.getCellValueSpecific(i, "city3"));
            					createQuotesBuilding.enterPostalCode2(EH.getCellValueSpecific(i, "Suburb3"));
            					createQuotesBuilding.clickPostalCode() ;
                    			Thread.sleep(3000);
            					createQuotesBuilding.clickAddNewAddress();
            					Thread.sleep(5000);
            					createQuotesBuilding.changeFocusToBrowser();
            					createQuotesBuilding.changeFocus2();
            				//	createQuotesBuilding.enterNewAddress(EH.getCellValueSpecific(i, "complexAddress3"));
            					createQuotesBuilding.enterPropertySumInsured(EH.getCellValueSpecific(i, "propertySumInsured3"));
            				/*	Thread.sleep(1000);
            					createQuotesBuilding.enterTypeOfHome(EH.getCellValueSpecific(i, "typeOfHome"));
            					Thread.sleep(1000);*/
            					createQuotesBuilding.enterTypeOfRoof(EH.getCellValueSpecific(i, "typeOfRoof3"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterTypeOfWall(EH.getCellValueSpecific(i, "typeOfWall3"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterBasicExcess(EH.getCellValueSpecific(i, "basicExcess3"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterCompulsaryExcess(EH.getCellValueSpecific(i, "compulsaryExcess3"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterVoluntaryExcess(EH.getCellValueSpecific(i, "voluntaryExcess3"));
            					Thread.sleep(1000);
            					createQuotesBuilding.enterZeroToTwelveMonthsClaims(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims3"));
            					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaims(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims3"));
            					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaims(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims3"));
            					createQuotesBuilding.enterFinancialInstitution(EH.getCellValueSpecific(i, "financialInstitution3"));
            					createQuotesBuilding.enterRegisteredOwner(EH.getCellValueSpecific(i, "registeredOwner3"));

            					if(EH.getCellValueSpecific(i, "ACCDAM").equalsIgnoreCase("ACCDAM3"))
            					{
            						createQuotesBuilding.clickAccidentalBuildingsCover();
            						createQuotesBuilding.enterAccidentalBuildingsCoverSumInsured(EH.getCellValueSpecific(i, "ACCDAM_sumInsured3"));
            						
            					}
            					if(EH.getCellValueSpecific(i, "ACCDAMFXD3").equalsIgnoreCase("ACCDAMFXD"))
            					{
            						createQuotesBuilding.clickAccidentalFixedCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "GEYSER3").equalsIgnoreCase("GEYSER"))
            					{
            						createQuotesBuilding.clickGeyserCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "GEYSER3").equalsIgnoreCase("GEYSER"))
            					{
            						createQuotesBuilding.clickGeyserCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "Keys3").equalsIgnoreCase("Keys"))
            					{
            						createQuotesBuilding.clickKeysCover();
            						
            					}
            					if(EH.getCellValueSpecific(i, "PSURGE3").equalsIgnoreCase("PSURGE"))
            					{
            						createQuotesBuilding.clickPowerSurgeCover();
            						createQuotesBuilding.enterPowerSurgeSumInsured(EH.getCellValueSpecific(i, "PSURGE_sumInsured3"));
            					}
            				
            					createQuotesBuilding.clickSaveBuilding();
            					createQuotesBuilding.changeFocusToBrowser();
            					Thread.sleep(10000);
            					createQuotesBuilding.clickCalculatePremiums();
            					Thread.sleep(10000);
            					createQuotesBuilding.changeFocus2();
            					Thread.sleep(10000);
            					setExcelData(Sheet, i+2, 20, "BuildingsResults", createQuotesBuilding.finalPremium3());
            					createQuotesBuilding.clickSavePremium();
            					createQuotesBuilding.changeFocusToBrowser();
        						
        					}
        					
        					
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "BuildingsResults", timeStamp2);

        					
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

                        	EH = new ExcelHandler(Sheet, "BuildingsResults", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 4; i <= 10; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			
                			createQuotesBuilding.changeFocusToBrowser();
                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "BuildingsResults", timeStamp);
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
        					setExcelData(Sheet, i, 20, "BuildingsResults", createQuotesBuilding.basePremium() );
        					setExcelData(Sheet, i, 21, "BuildingsResults", createQuotesBuilding.finalPremium());
        					createQuotesBuilding.clickSavePremium();
        					Thread.sleep(4000);
        					createQuotesBuilding.changeFocusToBrowser();
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "BuildingsResults", timeStamp2);
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
