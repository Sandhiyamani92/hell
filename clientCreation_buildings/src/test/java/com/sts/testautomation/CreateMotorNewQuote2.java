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

public class CreateMotorNewQuote2 extends BaseTest {
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

	@Test(priority = 1, enabled = false, description = "Add new client and motor")
    public void addNewClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Motor", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 34; i <= 33; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "MotorResults", timeStamp);
                    		createQuotesBuilding.changeFocusToBrowser();
                			Thread.sleep(2000);
                			createQuotesBuilding.hoverOverQuotationElement();
                			createQuotesBuilding.clickAddNewQuote();
                			
                			//Thread.sleep(4000);
                			//createQuotesBuilding.clickBroker();
                			//Thread.sleep(4000);
                			createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(4000);
                			//createQuotesBuilding.clickOnPrivatePortfolioCheckbx();
                		//	createQuotesBuilding.clickOnNextBtn();
                		//	Thread.sleep(4000);
                			
                		
                    		Thread.sleep(3000);
                    		createQuotesBuilding.clickOnClientBtn();
                    			Thread.sleep(8000);
                    			createQuotesBuilding.clickOnNextBtn();
                    		//	Thread.sleep(4000);
                			//createQuotesBuilding.clickOnNextBtn();
                			Thread.sleep(8000);
                			
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

        				//	createQuotesBuilding.clickOnNextBtn();
        					Thread.sleep(2000);
        				//	createQuotesBuilding.clickOnNextBtn();
        				//	Thread.sleep(4000);
        					//createQuotesBuilding.clickOpenQuote();
        				//	Thread.sleep(4000);
        					setExcelData(Sheet, i, 7, "MotorResults", createQuotesBuilding.quoteNumber());
        					Thread.sleep(2000);
        					createQuotesBuilding.clickChangeCollectionFrequency();
        					Thread.sleep(3000);
        					
        					createQuotesBuilding.changeFocus2();
        					createQuotesBuilding.enterCollectionFrequency(EH.getCellValueSpecific(i, "collectionFrequency"));
        				
        					Thread.sleep(2000);
        					createQuotesBuilding.clickSaveCollectionFrequency();      					
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(2000);
        					createQuotesBuilding.clickCover();
        					Thread.sleep(2000);
        					createQuotesBuilding.clickMotor();
        					Thread.sleep(2000);
        					createQuotesBuilding.clickAddNewItem();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(2000);
        	
        					
        					createQuotesBuilding.clickChange();
        					Thread.sleep(5000);
        					createQuotesBuilding.changeFocusToCarSelectection();
        					createQuotesBuilding.clickVehicleTab();
        					Thread.sleep(4000);
        					createQuotesBuilding.enterCarSearch(EH.getCellValueSpecific(i, "mmCode"));
        					createQuotesBuilding.hoverSelectVehicle();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickSelectVehicle();
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(5000);
        					createQuotesBuilding.clickChange();
        					Thread.sleep(5000);
        					createQuotesBuilding.changeFocusToCarSelectection();
        					createQuotesBuilding.clickVehicleTab();
        					Thread.sleep(4000);
        					createQuotesBuilding.enterMotorValue(EH.getCellValueSpecific(i, "selectedValue"));
        					Thread.sleep(2000);
        					createQuotesBuilding.hoverSelectVehicle();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickSelectVehicle();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					
        			
        					Thread.sleep(5000);
        					createQuotesBuilding.enterOdometerReading(EH.getCellValueSpecific(i, "OdometerReading"));
        					createQuotesBuilding.enterColour(EH.getCellValueSpecific(i, "Colour"));
        					createQuotesBuilding.enterBasisOfSettlement(EH.getCellValueSpecific(i, "basisOfSettlement"));
        				
        					createQuotesBuilding.enterUninterruptedCover(EH.getCellValueSpecific(i, "PL_UninterruptedCover"));
        					createQuotesBuilding.enterCoverTypeMotor(EH.getCellValueSpecific(i, "CoverType"));
        					createQuotesBuilding.enterCarUse(EH.getCellValueSpecific(i, "carUse"));
        					createQuotesBuilding.enterVoluntaryExcessMotor(EH.getCellValueSpecific(i, "Desc_PL_VoluntaryExcess"));
        					createQuotesBuilding.enterBasicExcessMotor(EH.getCellValueSpecific(i, "Desc_PL_Excess"));
        					createQuotesBuilding.enterOvernightPark(EH.getCellValueSpecific(i, "overnightParking"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterFirstTrackingDevice(EH.getCellValueSpecific(i, "firstTrackingDevice"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterFirstTrackingDeviceType(EH.getCellValueSpecific(i, "firstTrackingDeviceType"));
                			
        					if(EH.getCellValueSpecific(i, "secondTrackingDevice").equalsIgnoreCase("Yes"))
        					{
        						createQuotesBuilding.clickSecondTrackingDevice();
        						createQuotesBuilding.enterSecondTrackingDevice(EH.getCellValueSpecific(i, "firstTrackingDeviceType"));
        						
        					}
        					
        					createQuotesBuilding.enterZeroToTwelveMonthsClaimsMotor(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaimsMotor(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaimsMotor(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterRegisteredOwnerMotor(EH.getCellValueSpecific(i, "RegisteredOwner"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterRegisteredOwnerId(EH.getCellValueSpecific(i, "identification"));
        					
        					
        					if(EH.getCellValueSpecific(i, "EXTLIAB").equalsIgnoreCase("EXTLIAB"))
        					{
        						createQuotesBuilding.clickExtensionOfLiability();
        						
        					}
        					if(EH.getCellValueSpecific(i, "KEYS").equalsIgnoreCase("KEYS"))
        					{
        						createQuotesBuilding.clickKeysMotor();
        						createQuotesBuilding.enterKeysSumInsured(EH.getCellValueSpecific(i, "PL_O_SIKeyLocks"));
        						
        					}
        					if(EH.getCellValueSpecific(i, "4X4").equalsIgnoreCase("4X4"))
        					{
        						createQuotesBuilding.clickFourByFour();
        						
        					}
        					if(EH.getCellValueSpecific(i, "TPLIAB").equalsIgnoreCase("TPLIAB"))
        					{
        						createQuotesBuilding.clickThirdPartyLiability();
        						createQuotesBuilding.enterThirdPartySumInsured(EH.getCellValueSpecific(i, "PL_O_SITPLiability"));
        						
        					}
        					if(EH.getCellValueSpecific(i, "TYRE").equalsIgnoreCase("TYRE"))
        					{
        						createQuotesBuilding.clickTyreCover();
        						
        					}
        					if(EH.getCellValueSpecific(i, "Desc_CARHIRE").equalsIgnoreCase("Car Hire"))
        					{
        						createQuotesBuilding.clickCarHire();
        						createQuotesBuilding.enterCarHireOptions(EH.getCellValueSpecific(i, "Desc_PL_O_CarHireOption"));
        						createQuotesBuilding.enterCarHireDays(EH.getCellValueSpecific(i, "Desc_PL_O_CarHireDuration"));
        					}
        					if(EH.getCellValueSpecific(i, "SHORT").equalsIgnoreCase("SHORT"))
        					{
        						createQuotesBuilding.clickPayingOfYourVehicle();
        						createQuotesBuilding.enterPayingOffVehicleOptions(EH.getCellValueSpecific(i, "Desc_PL_O_PercShortfall"));
        						
        					}
        					
        					
        					
        					Thread.sleep(30000);
        					createQuotesBuilding.clickAddDriver();
        					createQuotesBuilding.changeToDriverWindow();

        					
        					if(EH.getCellValueSpecific(i, "DriverIsPolicyholder").equalsIgnoreCase("Yes"))
        					{
        					createQuotesBuilding.enterDriver(EH.getCellValueSpecific(i, "RegisteredOwner"));
            				Thread.sleep(3000);

        					createQuotesBuilding.enterDriverLicenseCode(EH.getCellValueSpecific(i, "licenseType"));
        					Thread.sleep(3000);
        					createQuotesBuilding.enterDriverLicenseDate(EH.getCellValueSpecific(i, "Licence_Day"));
        					
        					}
        					else {
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverFirstName(EH.getCellValueSpecific(i, "firstName"));
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverLastName(EH.getCellValueSpecific(i, "lastName"));
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverIdentification(EH.getCellValueSpecific(i, "identification"));
        						Thread.sleep(2000);
        						createQuotesBuilding.enterDriverLicenseCode(EH.getCellValueSpecific(i, "licenseType"));
            					Thread.sleep(3000);
            					createQuotesBuilding.enterDriverLicenseDate(EH.getCellValueSpecific(i, "Licence_Day"));
        						
        						
        						createQuotesBuilding.enterDriverRelationship(EH.getCellValueSpecific(i, "driverRelationship"));
        						
        					}
        					Thread.sleep(5000);
        					createQuotesBuilding.clickSaveDriver();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(8000);
        					
        					createQuotesBuilding.clickSaveBuilding();
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(15000);
        					createQuotesBuilding.clickCalculatePremiums();
        					Thread.sleep(10000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(10000);
        					setExcelData(Sheet, i, 20, "MotorResults", createQuotesBuilding.finalPremium());
        					setExcelData(Sheet, i, 19, "MotorResults", createQuotesBuilding.basePremium());
        					createQuotesBuilding.clickSavePremium();
        					createQuotesBuilding.changeFocusToBrowser();
        				
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "MotorResults", timeStamp2);

        					
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
	
	
	@Test(priority = 1, enabled = true, description = "Add new client and motor")
    public void EditClientQuote() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Motor", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 1; i <= 1; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "MotorResults", timeStamp);
                    		createQuotesBuilding.changeFocusToBrowser();
                			Thread.sleep(2000);
                			
                			createQuotesBuilding.enterTextToSearch(EH.getCellValueSpecific(i, "Policy Number"));
                			createQuotesBuilding.clickMainSearchButton();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickQuote();
                			Thread.sleep(3000);
                			
                			createQuotesBuilding.clickPolicyHolderTab();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickEditPolicyHolder();
                			Thread.sleep(3000);
                			createQuotesBuilding.changeFocus2();
                			Thread.sleep(3000);
                		
                			createQuotesBuilding.enterMaritalStatusUpdate(EH.getCellValueSpecific(i, "MaritalStatus"));

                			createQuotesBuilding.enterOccupationUpdate(EH.getCellValueSpecific(i, "employmentStatus"));
                			
                			Thread.sleep(3000);
                			createQuotesBuilding.clickSaveClientDetails();
                			Thread.sleep(3000);
                			createQuotesBuilding.changeFocusToBrowser();
                			createQuotesBuilding.clickCover();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickMotor();               		
                			Thread.sleep(4000);
        					
        					createQuotesBuilding.clickEditItem();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(2000);
        	
        					
        					createQuotesBuilding.clickChange();
        					Thread.sleep(5000);
        					createQuotesBuilding.changeFocusToCarSelectection();
        					createQuotesBuilding.clickVehicleTab();
        					Thread.sleep(4000);
        					
        					
        					if(EH.getCellValueSpecific(i, "VehicleCondition").equalsIgnoreCase("VG"))
        					{
        						createQuotesBuilding.conditionVeryGood();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "VehicleCondition").equalsIgnoreCase("G"))
        					{
        						createQuotesBuilding.conditionGood();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "VehicleCondition").equalsIgnoreCase("E"))
        					{
        						createQuotesBuilding.conditionExcellent();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "VehicleCondition").equalsIgnoreCase("P"))
        					{
        						createQuotesBuilding.conditionPoor();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "VehicleCondition").equalsIgnoreCase("VP"))
        					{
        						createQuotesBuilding.conditionVeryPoor();
        						Thread.sleep(2000);
        					}
        					
        					
        					if(EH.getCellValueSpecific(i, "MileageRange").equalsIgnoreCase("VL"))
        					{
        						createQuotesBuilding.mileageVeryLow();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "MileageRange").equalsIgnoreCase("L"))
        					{
        						createQuotesBuilding.mileageLow();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "MileageRange").equalsIgnoreCase("A"))
        					{
        						createQuotesBuilding.mileageAverage();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "MileageRange").equalsIgnoreCase("H"))
        					{
        						createQuotesBuilding.mileageHigh();
        						Thread.sleep(2000);
        					}
        					if(EH.getCellValueSpecific(i, "MileageRange").equalsIgnoreCase("VH"))
        					{
        						createQuotesBuilding.mileageVeryHigh();
        						Thread.sleep(2000);
        					}
        					
        					
        					Thread.sleep(2000);
        					
        			/*		createQuotesBuilding.enterCarSearch(EH.getCellValueSpecific(i, "mmCode"));
        					createQuotesBuilding.hoverSelectVehicle();
        					Thread.sleep(1000);
        					createQuotesBuilding.clickSelectVehicle();
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(5000);
        					createQuotesBuilding.clickChange();
        					Thread.sleep(5000);
        					createQuotesBuilding.changeFocusToCarSelectection();
        					createQuotesBuilding.clickVehicleTab();*/
        				//	Thread.sleep(4000);
        					
        					
        					createQuotesBuilding.enterMotorValue(EH.getCellValueSpecific(i, "selectedValue"));
        					setExcelData(Sheet, i, 8, "MotorResults", EH.getCellValueSpecific(i, "selectedValue"));
        					Thread.sleep(2000);
        					//createQuotesBuilding.hoverSelectVehicle();
        					Thread.sleep(7000);
        				//	createQuotesBuilding.clickSelectVehicle();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					
        			
        					Thread.sleep(5000);
        					createQuotesBuilding.enterOdometerReading(EH.getCellValueSpecific(i, "OdometerReading"));
        					createQuotesBuilding.enterColour(EH.getCellValueSpecific(i, "Colour"));
        					createQuotesBuilding.enterCarBodyType(EH.getCellValueSpecific(i, "body"));
        					createQuotesBuilding.enterBasisOfSettlement(EH.getCellValueSpecific(i, "basisOfSettlement"));
        				
        					createQuotesBuilding.enterUninterruptedCover(EH.getCellValueSpecific(i, "PL_UninterruptedCover"));
        					createQuotesBuilding.enterCoverTypeMotor(EH.getCellValueSpecific(i, "CoverType"));
        					createQuotesBuilding.enterCarUse(EH.getCellValueSpecific(i, "carUse"));
        					createQuotesBuilding.enterVoluntaryExcessMotor(EH.getCellValueSpecific(i, "Desc_PL_VoluntaryExcess"));
        					createQuotesBuilding.enterBasicExcessMotor(EH.getCellValueSpecific(i, "Desc_PL_Excess"));
        					createQuotesBuilding.enterOvernightPark(EH.getCellValueSpecific(i, "overnightParking"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterFirstTrackingDevice(EH.getCellValueSpecific(i, "firstTrackingDevice"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterFirstTrackingDeviceType(EH.getCellValueSpecific(i, "firstTrackingDeviceType"));
                			
        					if(EH.getCellValueSpecific(i, "secondTrackingDevice").equalsIgnoreCase("Yes"))
        					{
        						createQuotesBuilding.clickSecondTrackingDevice();
        						Thread.sleep(2000);
        						createQuotesBuilding.enterSecondTrackingDevice(EH.getCellValueSpecific(i, "firstTrackingDeviceType"));
        						
        					}
        					
        					createQuotesBuilding.enterZeroToTwelveMonthsClaimsMotor(EH.getCellValueSpecific(i, "zeroToTwelveMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterThirteenToTwentyFourMonthsClaimsMotor(EH.getCellValueSpecific(i, "thirteenToTwentyFourMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterTwentyFiveToThirtySixMonthsClaimsMotor(EH.getCellValueSpecific(i, "twentyFiveToThirtySixMonthsClaims"));
        					Thread.sleep(1000);
        					createQuotesBuilding.enterRegisteredOwnerMotor(EH.getCellValueSpecific(i, "RegisteredOwner"));
        					Thread.sleep(1000);
        				//	createQuotesBuilding.enterRegisteredOwnerId(EH.getCellValueSpecific(i, "identification"));
        					Thread.sleep(1000);
        					if(EH.getCellValueSpecific(i, "TPLIAB").equalsIgnoreCase("TPLIAB"))
        					{
        						//createQuotesBuilding.clickThirdPartyLiability();
        						createQuotesBuilding.enterThirdPartySumInsured(EH.getCellValueSpecific(i, "PL_O_SITPLiability"));
        						
        					}
        					Thread.sleep(2000);
        					if(EH.getCellValueSpecific(i, "EXTLIAB").equalsIgnoreCase("EXTLIAB"))
        					{
        						//createQuotesBuilding.clickExtensionOfLiability();
        						
        					}
        					Thread.sleep(2000);
        					if(EH.getCellValueSpecific(i, "KEYS").equalsIgnoreCase("KEYS"))
        					{
        						//createQuotesBuilding.clickKeysMotor();
        						//createQuotesBuilding.enterKeysSumInsured(EH.getCellValueSpecific(i, "PL_O_SIKeyLocks"));
        						
        					}
        					Thread.sleep(2000);
        					if(EH.getCellValueSpecific(i, "4X4").equalsIgnoreCase("4X4"))
        					{
        						//createQuotesBuilding.clickFourByFour();
        						
        					}
        					Thread.sleep(2000);
        					if(EH.getCellValueSpecific(i, "TYRE").equalsIgnoreCase("TYRE"))
        					{
        						createQuotesBuilding.clickTyreCover();
        						
        					}
        					Thread.sleep(2000);
        					if(EH.getCellValueSpecific(i, "Desc_CARHIRE").equalsIgnoreCase("Car Hire"))
        					{
        						//createQuotesBuilding.clickCarHire();
        						Thread.sleep(2000);
        						createQuotesBuilding.enterCarHireOptions(EH.getCellValueSpecific(i, "Desc_PL_O_CarHireOption"));
        						createQuotesBuilding.enterCarHireDays(EH.getCellValueSpecific(i, "Desc_PL_O_CarHireDuration"));
        					}
        					if(EH.getCellValueSpecific(i, "SHORT").equalsIgnoreCase("SHORT"))
        					{
        					//	createQuotesBuilding.clickPayingOfYourVehicle();
        						createQuotesBuilding.enterPayingOffVehicleOptions(EH.getCellValueSpecific(i, "Desc_PL_O_PercShortfall"));
        						
        					}
        					
        					Thread.sleep(2000);
        					
        					Thread.sleep(30000);
        					createQuotesBuilding.clickAddDriver();
        					createQuotesBuilding.changeToDriverWindow();

        					
        					if(EH.getCellValueSpecific(i, "DriverIsPolicyholder").equalsIgnoreCase("Yes"))
        					{
        					createQuotesBuilding.enterDriver(EH.getCellValueSpecific(i, "RegisteredOwner"));
            				Thread.sleep(3000);

        					createQuotesBuilding.enterDriverLicenseCode(EH.getCellValueSpecific(i, "licenseType"));
        					Thread.sleep(3000);
        					createQuotesBuilding.enterDriverLicenseDate(EH.getCellValueSpecific(i, "Licence_Day"));
        					
        					}
        					else {
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverFirstName(EH.getCellValueSpecific(i, "firstName"));
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverLastName(EH.getCellValueSpecific(i, "lastName"));
        						Thread.sleep(1000);
        						createQuotesBuilding.enterDriverIdentification(EH.getCellValueSpecific(i, "identification"));
        						Thread.sleep(2000);
        						createQuotesBuilding.enterDriverLicenseCode(EH.getCellValueSpecific(i, "licenseType"));
            					Thread.sleep(3000);
            					createQuotesBuilding.enterDriverLicenseDate(EH.getCellValueSpecific(i, "Licence_Day"));
        						
        						
        						createQuotesBuilding.enterDriverRelationship(EH.getCellValueSpecific(i, "driverRelationship"));
        						
        					}
        					
        					Thread.sleep(7000);
        					createQuotesBuilding.clickSaveDriver();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocusToBrowser();
        					createQuotesBuilding.changeFocus2();
        					
        					Thread.sleep(4000);
        					
        					createQuotesBuilding.clickSaveBuilding();
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(15000);
        					createQuotesBuilding.clickCalculatePremiums();
        					Thread.sleep(10000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(10000);
        					setExcelData(Sheet, i, 20, "MotorResults", createQuotesBuilding.finalPremium());
        				//	setExcelData(Sheet, i, 19, "MotorResults", createQuotesBuilding.basePremium());
        					createQuotesBuilding.clickSavePremium();
        					createQuotesBuilding.changeFocusToBrowser();
        				
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "MotorResults", timeStamp2);

        					
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
	
	@Test(priority = 1, enabled = false, description = "Add new client and motor")
    public void EditClientBodyQuote() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Motor", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i = 166; i <= 169; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			

                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "MotorResults", timeStamp);
                    		createQuotesBuilding.changeFocusToBrowser();
                			Thread.sleep(2000);
                			
                			createQuotesBuilding.enterTextToSearch(EH.getCellValueSpecific(i, "Policy Number"));
                			createQuotesBuilding.clickMainSearchButton();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickQuote();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickCover();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickMotor();               		
                			Thread.sleep(4000);
        					
        					createQuotesBuilding.clickEditItem();
        					Thread.sleep(2000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(2000);
        	
        					
        					createQuotesBuilding.enterCarBodyType(EH.getCellValueSpecific(i, "body"));
        					createQuotesBuilding.enterRegisteredOwnerMotor(EH.getCellValueSpecific(i, "RegisteredOwner"));
        					Thread.sleep(12000);
        					
        					createQuotesBuilding.clickSaveBuilding();
        					createQuotesBuilding.changeFocusToBrowser();
        					Thread.sleep(8000);
        					createQuotesBuilding.clickCalculatePremiums();
        					Thread.sleep(8000);
        					createQuotesBuilding.changeFocus2();
        					Thread.sleep(5000);
        					setExcelData(Sheet, i, 20, "MotorResults", createQuotesBuilding.finalPremium());
        				//	setExcelData(Sheet, i, 19, "MotorResults", createQuotesBuilding.basePremium());
        					createQuotesBuilding.clickSavePremium();
        					createQuotesBuilding.changeFocusToBrowser();
        				
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "MotorResults", timeStamp2);

        					
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
	

	
	@Test(priority = 2, enabled = false, description = "Find existing quote and rerate")
    public void rateExistingClient() {
        try {
            //Loop runs through all the Nodes in the Grid and performs the tests on them
            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
                if (currentNode.getKey().equals(Device)) {

                    //Browsers
                    if (currentNode.getValue() instanceof BrowserNode) {
                        ElementFunctionality test = null;
                        try {

                        	EH = new ExcelHandler(Sheet, "Motor", 0, 0);
                        	
                        	int numberOfRows = EH.numRows;
                        	
                        	for (int i =1 ; i <=1; i++) {
                        		
                        try {

                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");	
                			System.out.println("Start Test Case "+ i);						
                			System.out.println("-----------------------------------------------------------------------------------------------------------------------");			
                			createQuotesBuilding.changeFocusToBrowser();
                			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 1, "MotorResults", timeStamp);
                			Thread.sleep(2000);
                			
                			createQuotesBuilding.enterTextToSearch(EH.getCellValueSpecific(i, "Policy Number"));
                			createQuotesBuilding.clickMainSearchButton();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickQuote();
                			Thread.sleep(3000);
                			createQuotesBuilding.clickCover();
                			Thread.sleep(4000);
                			createQuotesBuilding.clickMotor();               		
                			Thread.sleep(4000);
                			createQuotesBuilding.clickCalculatePremiums();
                    
        					Thread.sleep(8000);
        				
        					createQuotesBuilding.changeFocus2();
        			//		setExcelData(Sheet, i, 21, "MotorResults", createQuotesBuilding.bbWarning() );
        			//		Thread.sleep(2000);
        			//		createQuotesBuilding.clickCloseWarning();
        					setExcelData(Sheet, i, 20, "MotorResults", createQuotesBuilding.finalPremium());
        					createQuotesBuilding.clickSavePremium();
        					Thread.sleep(4000);
        					createQuotesBuilding.changeFocusToBrowser();
        					

        					String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                    		setExcelData(Sheet, i, 2, "MotorResults", timeStamp2);
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
