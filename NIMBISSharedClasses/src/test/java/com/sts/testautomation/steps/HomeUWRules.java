//package steps;
//
//import com.relevantcodes.extentreports.LogStatus;
//import com.sts.testautomation.deviceConfig.AndroidNode;
//import com.sts.testautomation.deviceConfig.BrowserNode;
//import com.sts.testautomation.deviceConfig.IOSNode;
//import com.sts.testautomation.deviceConfig.Node;
//import com.sts.testautomation.extentReports.ExtentTestManager;
//import com.sts.testautomation.pages.web.tial.*;
//import com.sts.testautomation.steps.BaseTest;
//import com.sts.testautomation.utilities.ElementFunctionality;
//import com.sts.testautomation.utilities.ExcelHandler;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class HomeUWRules extends BaseTest {
//
//    private TialLogin tialLogin;
//    private UserDiary_Nav userDiary_Nav;
//    private TialGeneralDetails generalDetails;
//    private ContactDetails contactDetails;
//    private TialInsuranceGeneralDetails tialInsuranceGeneralDetails;
//    private RolePlayers rolePlayers;
//    private Premium premium;
//    private Payment_Details payment_Details;
//    private HouseHoldContents_GeneralDetails householdContents_GeneralDetails;
//    private TialSecurityItems tialSecurityItems;
//    private HouseHoldCont_AdditionalInfo_Prvt houseHoldCont_AdditionaInfo_Prvt;
//    private HouseHoldCont_Extensions_Prvt houseHoldCont_Extensions_Prvt;
//    private UW_Questions uw_Questions;
//    private HouseholdCont_Endorsement householdCont_Endorsement;
//    private Buildings_Geyser_Prestige buildings_Geyser_Prestige;
//    private ElectricEquipment_Prvt electricEquipment_Prvt;
//    private Buildings_AdditionalInfo buildingsAdditionalInfo;
//    private ExcelHandler EH, EH_Option, EH1;
//    private MM_Results results;
//    private ExcelHandler EH_Results;
//    private UW_Questions uw_questions;
//    private static XSSFSheet ExcelWSheet;
//    private static XSSFWorkbook ExcelWBook;
//
//    private Motor_Vehicle_Details Motor_Vehicle_Details;
//
//    private ElementFunctionality elementFunctionality;
//
//    private Optional_Covers optionalcover;
//
//    private Insurance_History Insurance_History;
//    private Calender calender;
//
//
//
//
//    @Parameters({"URL", "Device"})
//    @BeforeClass(description = "Instantiate Grid")
//    public void setupTest(String URL, String device) {
//        try {
//            HashSetup.SetUpBrowser();
//
//            System.out.println("Instantiating Nodes");
//            url = URL;
//            Device = device;
//
//            //Loop runs through all the Nodes in the Grid and performs the tests on them
//            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
//                if (currentNode.getKey().equals(Device)) {
//                    //Android
//                    if (currentNode.getValue() instanceof AndroidNode) {
//                        try {
//
//                            //Focus here
//
//                        } catch (Exception e) {
//                            Assert.fail();
//                            e.printStackTrace();
//
//                        }
//
//                    }
//
//                    //iOS
//                    else if (currentNode.getValue() instanceof IOSNode) {
//                        try {
//
//                        }    //Here
//
//                        catch (Exception e) {
//                            e.printStackTrace();
//                            Assert.fail();
//
//
//                        }
//
//
//                    }
//
//                    //Browsers
//                    else if (currentNode.getValue() instanceof BrowserNode) {
//                        try {
//                            BrowserNode bNode = ((BrowserNode) currentNode.getValue());
//                            System.out.println("Tial Test started on " + currentNode.getKey());
//
//                            System.setProperty("webdriver.chrome.driver", "C:\\Users\\NathanielS\\Downloads\\New folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//
//                            ChromeOptions options = new ChromeOptions();
//
//
//                            //options.addArguments("--headless");
//                            //  options.addArguments("--window-size");
//                            testB = new ChromeDriver();
//                            testB.get(URL);
//                            testB.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//                            testB.manage().window().maximize();
//                            System.out.println("Chromedriver Setup Complete");
//                            options.addArguments("Zoom 80%");
//                            options.addArguments("Zoom 80%");
//
//                            options.addArguments("Zoom 80%");
//
//
//                        } catch (Exception e) {
//                            Assert.fail();
//                            e.printStackTrace();
//
//                        }
//
//                    }
//
//                }
//            }
//
//
//        } catch (Exception e) {
//            Assert.fail();
//            e.printStackTrace();
//
//        }
//
//    }
//    @Parameters({"URL"})
//    @Test(priority = 0, description = "Logging in to Tial")
//    public void Login(String URL) {
//        url = URL;
//        try {
//            //Loop runs through all the Nodes in the Grid and performs the tests on them
//            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
//                if (currentNode.getKey().equals(Device)) {
//                    //Android
//                    if (currentNode.getValue() instanceof AndroidNode) {
//                        try {
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Assert.fail();
//                            System.out.println(e.getMessage());
//                            testA.quit();
//
//                        }
//
//                    }
//
//                    //iOS
//                    else if (currentNode.getValue() instanceof IOSNode) {
//                        try {
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Assert.fail();
//
//
//                        }
//
//
//                    }
//
//                    //Browsers
//                    else if (currentNode.getValue() instanceof BrowserNode) {
//                        try {
//
//                            elementFunctionality = new ElementFunctionality(testB, Device);
//                            tialLogin = new TialLogin(testB, Device);
//                            userDiary_Nav = new UserDiary_Nav(testB, Device);
//                            generalDetails = new TialGeneralDetails(testB, Device);
//                            contactDetails = new ContactDetails(testB, Device);
//                            tialInsuranceGeneralDetails = new TialInsuranceGeneralDetails(testB, Device);
//                            rolePlayers = new RolePlayers(testB, Device);
//                            premium = new Premium(testB, Device);
//                            payment_Details = new Payment_Details(testB, Device);
//                            householdContents_GeneralDetails = new HouseHoldContents_GeneralDetails(testB, Device);
//                            tialSecurityItems = new TialSecurityItems(testB, Device);
//                            houseHoldCont_AdditionaInfo_Prvt = new HouseHoldCont_AdditionalInfo_Prvt(testB, Device);
//                            houseHoldCont_Extensions_Prvt = new HouseHoldCont_Extensions_Prvt(testB, Device);
//                            uw_Questions = new UW_Questions(testB, Device);
//                            householdCont_Endorsement = new HouseholdCont_Endorsement(testB, Device);
//                            Motor_Vehicle_Details = new Motor_Vehicle_Details(testB, Device);
//                            results = new MM_Results(testB, Device);
//                            electricEquipment_Prvt = new ElectricEquipment_Prvt(testB, Device);
//                            optionalcover = new Optional_Covers(testB, Device);
//                            Insurance_History = new Insurance_History(testB, Device);
//                            calender = new Calender(testB, Device);
//                            buildingsAdditionalInfo = new Buildings_AdditionalInfo(testB, Device);
//
//                            System.out.print("------------Test Start--------------------");
//                            EH = new ExcelHandler("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\Tial_FrontEnd Fields.xlsx", "Clients Test Cases", 0, 0);
//                            EH1 = new ExcelHandler("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\Tial_FrontEnd Fields.xlsx", "Buildings Test cases", 0, 0);
//                            DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                            Date dateend = new Date();
////									 // Now format the date
//                            String date3 = dateFormat1.format(dateend);
//
//
//                            for (int i = 95 ; i <= 108; i++) {
//                                try {
//                                    Thread.sleep(8000);
//
//                                    String username = "Nathaniel.Smith";
//                                    String password = "ghp_Ny6Bo0d4EB4a8MSxZlLWSyjn6w";
//                                    int TestCaseNum = Integer.parseInt(EH1.getCellValueSpecific(i, "TTC NO."));
//                                    ExtentTestManager.getTest().log(LogStatus.INFO, "TEST CASE NUMBER : " + TestCaseNum);
//                                    ExtentTestManager.getTest().log(LogStatus.INFO, "TEST CASE OBJECTIVE  : " + EH1.getCellValueSpecific(i, "TC OBJECTIVE"));
//
//
//                                    tialLogin.enterUserName_txt(username);
//
//
//                                    tialLogin.enterPassword_txt(password);
//
//                                    tialLogin.clickOkayButton();
//                                    //userDiary_Nav.clickSearchIcon("Insured / Policy Search");
//
//                                    //userDiary_Nav.clickSearchbutton();
//                                    Random random = new Random();
//                                    Thread.sleep(4000);
//
//                                    // Generate a random number between 1 and 35
//                                    int randomNumber = random.nextInt(35) + 1;
//
//                                    userDiary_Nav.clickSearchIcon("Insured / Policy Search");
//                                    userDiary_Nav.clickRecentSavedPoliciesButton();
//                                    userDiary_Nav.clickNewInsuredButton();
//
//
//                                    // elementFunctionality.captureScreenshotOnDevice("General");
//                                    write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\FrontEnd Fields (1).xlsx", "Buildings Test cases", i, 70, date3);
//
//                                    Thread.sleep(1000);
////							Create Client
//                                    generalDetails.clickTitle01();
//                                    householdContents_GeneralDetails.SelectOption(EH.getCellValueSpecific(randomNumber, "Title"));
//
//                                    generalDetails.enterFistNameTxtBox(EH.getCellValueSpecific(randomNumber, "First Name "));
//                                    Thread.sleep(1000);
//                                    generalDetails.enterSurnameTxtBox(EH.getCellValueSpecific(randomNumber, "Surname"));
//                                    generalDetails.clickDropDownMari();
//                                    generalDetails.clickItems(EH.getCellValueSpecific(randomNumber, "Marital status"));
//                                    generalDetails.enterPassportNumberTxTBox(EH.getCellValueSpecific(randomNumber, "ID number"));
//
//                                    generalDetails.clickIdNumberButton();
//
//                                    generalDetails.clickYes();
//
//                                    //Thread.sleep(2000);
//                                    generalDetails.clickITCCheckBox();
//                                    Thread.sleep(2000);
//                                    generalDetails.clickYes();
//                                    // elementFunctionality.captureScreenshotOnDevice("General");
//                                    Thread.sleep(2000);
//                                    generalDetails.clickContacttab();
//
//                                    //ADDRESS AND CONTACT DETAILS
//                                    contactDetails.enterEmail_txt(EH.getCellValueSpecific(randomNumber, "Email Address"));
//                                    contactDetails.enterCellPhone_txt(EH.getCellValueSpecific(randomNumber, "Cell Phone Number"));
//                                    contactDetails.enterPreferredMethodCommunication_txt("E-Mail Address");
//
//
//                                    contactDetails.enterNumber_txt(EH.getCellValueSpecific(randomNumber, "Number"));
//                                    contactDetails.enterStreet_txt(EH.getCellValueSpecific(randomNumber, "Street"));
//
//                                    contactDetails.enterSuburb_txt("POTTIES HILL");
//                                    Thread.sleep(1000);
//                                    contactDetails.clickSuburbIcon();
//                                    contactDetails.clickSuburbIcon();
//                                    Thread.sleep(1000);
//                                    electricEquipment_Prvt.clickItems("POTTIES HILL");
//                                    contactDetails.enterErfDetails_txt(EH.getCellValueSpecific(randomNumber, "erf Number"));
//
//                                    //houseHoldCont_AdditionaInfo_Prvt.enterPostalCode("4567");
//                                    //	contactDetails.clickPostalSameAsResAddress_cb();
//                                    contactDetails.clickPostaLAddressTab();
//                                    //	contactDetails.
//                                    Thread.sleep(2000);
//                                    contactDetails.enterPnumber_txt(EH.getCellValueSpecific(randomNumber, "Number"));
//                                    contactDetails.enterPstreet_txt(EH.getCellValueSpecific(randomNumber, "Street"));
//
//                                    //	contactDetails.enterSuburb_txt("POTTIES HILL");
//                                    contactDetails.enterSuburb1_txt("POTTIES HILL");
//                                    Thread.sleep(1000);
//                                    contactDetails.clickSuburbIconPost();
//                                    contactDetails.clickSuburbIconPost();
//                                    Thread.sleep(1000);
//                                    electricEquipment_Prvt.clickItems2Occurance("POTTIES HILL");
//                                    contactDetails.enterPerfDetails_txt(EH.getCellValueSpecific(randomNumber, "erf Number"));
//                                    //	contactDetails.enterPosPostalCode_txt("4567");
//
//                                    userDiary_Nav.clickSecondRoundOptionHouseHold_icon();
//
//                                    generalDetails.clickinsuranceHistroy();
//
//                                    //  elementFunctionality.captureScreenshotOnDevice("Insurance History");
//                                    //Thread.sleep(1000);
//                                    Insurance_History.clickInsurerRefusedCheckBox();
//                                    Thread.sleep(3000);
//                                    Insurance_History.clickInsurerRefusedCheckBox();
//                                    //  userDiary_Nav.clickGeneralDetailsNextButton();
//                                    //  Thread.sleep(1000);
//                                    userDiary_Nav.clickPolicyHistoryOKButton();
//
//                                    int age = 38;
//                                    if (age > 60) {
//                                        // if age is > 60
//                                        userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                        //Thread.sleep(2000);
//                                    }
//                                    userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickPolicyHistoryPopUpNoButton();
//
//                                    // elementFunctionality.captureScreenshotOnDevice("Product Selection");
//                                    Thread.sleep(2000);
//                                    tialInsuranceGeneralDetails.clickBouquet();
//                                    Thread.sleep(2000);
//                                    tialInsuranceGeneralDetails.SelectBouquetDropdownSelection();
//                                    Thread.sleep(1000);
//                                    tialInsuranceGeneralDetails.clickProduct();
//                                    Thread.sleep(2000);
////									tialInsuranceGeneralDetails.SelectProductDropdownSelection();
//                                    tialInsuranceGeneralDetails.selectProductDropdownSelectionPrestige();
//                                    Thread.sleep(3000);
//                                    // elementFunctionality.captureScreenshotOnDevice("Product Details");
//                                    userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//
//                                    String ProductInfo = testB.findElement(By.xpath("(//div[contains(@name,'labelfield')])[6]")).getText();
//
//                                    System.out.println("--------------Inception Date---------------");
//                                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                                    //get current date time with Date()
//                                    Date date = new Date();
//                                    DateFormat inceptiondate = new SimpleDateFormat("yyyy/MM/dd");
//                                    String date2 = inceptiondate.format(date);
//                                    //	calender.enterinceptiondate(date2);
//
//
//                                    //String PolicyNumber = testB.findElement(By.xpath("(//div[@name='title'])[3]")).getText();
//                                    //Thread.sleep(5000);
//                                    //	System.out.println(PolicyNumber););
//                                    //write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\FrontEnd Fields (1).xlsx","Buildings Test cases",i ,72, PolicyNumber);
//
//
//                                    userDiary_Nav.clickGeneralDetailsNextButton();
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickRolePlayersTab();
//                                    rolePlayers.clickSearchBroker();
//                                    //Thread.sleep(2000);
//                                    rolePlayers.clickBrokerNumberOption();
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickGeneralDetailsNextButton();
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickPremiumTab();
//                                    premium.selectReviewFrequencyDropdown();
//                                    Thread.sleep(2000);
//                                    premium.selectReviewFrequencyOptionDropdown();
//                                    //Thread.sleep(2000)
////							try{
////								premium.clickPopUpOk();
////							}
////							catch (Exception e){
////
////							}
//
//                                    Thread.sleep(2000);
//
//                                    premium.ClickcmbPaymentFreq("Annual");
//
//                                    Thread.sleep(12000);
//                                    userDiary_Nav.clickGeneralDetailsNextButton();
//
//                                    userDiary_Nav.clickPaymentDetailsTab();
//                                    payment_Details.selectMethodDropdown();
//                                    payment_Details.clickPaymentOption();
//                                    Thread.sleep(1000);
//                                    payment_Details.selectDayDropdown("28");
//                                    //Thread.sleep(3000);
//                                    userDiary_Nav.clickBuildingsPrestige();
//                                    Thread.sleep(2000);
//                                    userDiary_Nav.clickDetailstab();
//                                    Thread.sleep(2000);
//                                    // String PolicyNumber = testB.findElement(By.xpath("(//div[@name='title'])[3]")).getText();
//                                    Thread.sleep(5000);
//                                    //	System.out.println(PolicyNumber););
//                                    // write_Extracted_rule_to_Sheet("C:\\Users\\NathanielS\\Documents\\GitHub\\Hollard_Earnix_Tial\\src\\FrontEnd Fields (1).xlsx", "Buildings Test cases", i, 72, PolicyNumber);
//                                    Thread.sleep(1000);
//                                    householdContents_GeneralDetails.enterSumInsuredTextBox("5000000");
//                                    householdContents_GeneralDetails.clickinflationTab();
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickPolicyHistoryOKButton2();
//                                    Thread.sleep(1000);
//                                    householdContents_GeneralDetails.clickpremiumTab();
//                                    Thread.sleep(1000);
//                                    householdContents_GeneralDetails.clickRoofCmb1(EH1.getCellValueSpecific(i, "Roof Type"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Roof Type"));
//
//                                    Thread.sleep(1000);
//
//                                    buildingsAdditionalInfo.clicktypeOfPremisesCmb1(EH1.getCellValueSpecific(i, "Type Of Premises"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Type Of Premises"));
//                                    Thread.sleep(1000);
//
//                                    buildingsAdditionalInfo.clicktypeOfBordersCmb1(EH1.getCellValueSpecific(i,"Borders"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i,"Borders"));
//                                    Thread.sleep(1000);
//
//                                    householdContents_GeneralDetails.clickWall1(EH1.getCellValueSpecific(i, "Wall Type"));
//                                    householdContents_GeneralDetails.SelectOptionWall(EH1.getCellValueSpecific(i, "Wall Type"));
//                                    Thread.sleep(1000);
//
//                                    householdContents_GeneralDetails.ResidenceTypebtn(EH1.getCellValueSpecific(i, "Residence Type"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Residence Type"));
//
//                                    Thread.sleep(1000);
//                                    buildingsAdditionalInfo.clickDwellingTypeCmb1(EH1.getCellValueSpecific(i, "Dwelling Type"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Dwelling Type"));
//                                    Thread.sleep(1000);
//                                    buildingsAdditionalInfo.clickDwellingUsageCmb1(EH1.getCellValueSpecific(i, "Dwelling Usage"));
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Dwelling Usage"));
//
//
//                                    Thread.sleep(2000);
//                                    buildingsAdditionalInfo.selectNCB();
//                                    householdContents_GeneralDetails.SelectOptionNCB(EH1.getCellValueSpecific(i,"NCB"));
//                                    //generalDetails.clickItems("2");
//                                    Thread.sleep(2000);
//
//
//                                    //Thread.sleep(2000);
//                                    householdContents_GeneralDetails.clickPerimiterWall();
//                                    //Thread.sleep(2000);
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Perimeter Wall"));
//
//                                    householdContents_GeneralDetails.clickCoverType();
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Cover Type"));
//                                    householdContents_GeneralDetails.clicktypeOfPremises();
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Type Of Premises"));
//                                    householdContents_GeneralDetails.clickDaysOccupiedCmb();
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Occupancy "));
//
//
//
//                                    //Thread.sleep(2000);
//                                    //householdContents_GeneralDetails.enterSumInsuredTextBox("5000000");
//
//                                    //	householdContents_GeneralDetails.clicktypeOfPremises();
//                                    //householdContents_GeneralDetails.SelectOption("Secure Complex");
//                                    Thread.sleep(1000);
//                                    //elementFunctionality.captureScreenshotOnDevice("Buildings Details");
//
//                                    ;
//                                    Thread.sleep(1000);
//                                    //	householdContents_GeneralDetails.clicktypeOfPremises();
//                                    //	householdContents_GeneralDetails.SelectOption("Secure Complex");
//
//
//                                    userDiary_Nav.clickNext();
//
//
//                                    userDiary_Nav.clickHouseHoldSecurityItemsTab();
//                                    Thread.sleep(2000);
//                                    if (EH1.getCellValueSpecific(i, "Complex/Estate/Village").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectComplexEstate_ss(EH1.getCellValueSpecific(i, "Complex/Estate/Village"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Alarm linked to 24-hour armed response").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectAlarmLinked24_ss(EH1.getCellValueSpecific(i, "Alarm linked to 24-hour armed response"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Burglar bars fitted to all opening windows louvres and skyline").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectBurglarBars_ss(EH1.getCellValueSpecific(i, "Burglar bars fitted to all opening windows louvres and skyline"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Electric fence ").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectElectricfence_ss(EH1.getCellValueSpecific(i, "Electric fence "));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Security gates fitted to all exiting doors ").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectSecurityGatesFittied_ss(EH1.getCellValueSpecific(i, "Security gates fitted to all exiting doors "));
//                                    }
//
//                                    // elementFunctionality.captureScreenshotOnDevice("Security Items");
//                                    //captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//
//                                    userDiary_Nav.clickNext();
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickNext();
//                                    ///Endorsments
//                                    Thread.sleep(2000);
//                                    if (EH1.getCellValueSpecific(i, "Basic excess waiver").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectBasicExcessWaiver_end(EH1.getCellValueSpecific(i, "Basic excess waiver"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Chimneys warranty/guarantee").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectChimneyswarranty_end(EH1.getCellValueSpecific(i, "Chimneys warranty/guarantee"));
//                                    }
//
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Limited cover – Theft excluded").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectLimitedCoverTheftExcluded_end("Yes");
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Limited cover – Storm and fire excluded").equals("Yes")) {
//                                        buildingsAdditionalInfo.selectLimitedCoverStormFireExcluded_end("Yes");
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Noting the interest of financial institution ").equals("Yes")) {
//                                        // buildings_AdditionalInfo.scrollDownElement(testB,500);
//                                        // buildingsAdditionalInfo.scrollDownElement(testB,1000);
//                                        buildingsAdditionalInfo.selectNotingFinancialInstitution_end(EH1.getCellValueSpecific(i,"Noting the interest of financial institution "));
//                                    }
//                                    // elementFunctionality.captureScreenshotOnDevice("Endorsements");
//                                    // captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//
//                                    userDiary_Nav.clickNext();
//
//                                    //
//
//                                    Thread.sleep(2000);
//                                    if (EH1.getCellValueSpecific(i, "Garden and landscaping - extended cover").equals("Yes")) {
//                                        houseHoldCont_Extensions_Prvt.clickGardenLandscapingExtendedCoverBuildings(EH1.getCellValueSpecific(i, "Garden and landscaping - extended cover - sum insured "), EH1.getCellValueSpecific(i, "Garden and landscaping - extended cover"));
//                                    }
//                                    Thread.sleep(2000);
//                                    if (EH1.getCellValueSpecific(i, "Power Surge ").equals("Yes")) {
//                                        houseHoldCont_Extensions_Prvt.clickPowerSurge(EH1.getCellValueSpecific(i, "Power Surge - sum insured"), EH1.getCellValueSpecific(i, "Power Surge "));
//                                    }
//                                    Thread.sleep(2000);
//                                    if (EH1.getCellValueSpecific(i, "Subsidence , landslip and heave  - extended cover").equals("Yes")) {
//                                        houseHoldCont_Extensions_Prvt.clickSubsidenceExtendedCoverBuildings(EH1.getCellValueSpecific(i, "Subsidence , landslip and heave - extended cover - sum insured"), EH1.getCellValueSpecific(i, "Subsidence , landslip and heave  - extended cover"));
//
//                                    }
//
//
//                                    //elementFunctionality.captureScreenshotOnDevice("Extensions");
//                                    //  captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickNext();
//
//                                    //add additional claims
//                                    buildingsAdditionalInfo.selectAmountOfClaimsZeroToTwelve_dd("0");
//
//                                    Thread.sleep(1000);
//                                    buildingsAdditionalInfo.selectAmountOfClaimsThirteenToTwentyFour_dd(EH1.getCellValueSpecific(i, "13-24 Months "));
//                                    Thread.sleep(1000);
//
//                                    buildingsAdditionalInfo.selectAmountOfClaimsTwentyFiveToThirtySix_dd(EH1.getCellValueSpecific(i, "25-36 Months "));
//                                    //elementFunctionality.captureScreenshotOnDevice("Additional Info");
//                                    // captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickNext();
//
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickNext();
//                                    if (EH1.getCellValueSpecific(i, "Fire retardant (SABS)").equals("Yes")) {
//                                        uw_Questions.clickFireRetardantCheckBox(EH1.getCellValueSpecific(i, "Fire retardant (SABS)"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Lightning Conductor (SABS)").equals("Yes")) {
//                                        uw_Questions.clickLightningConductorCheckBox(EH1.getCellValueSpecific(i, "Lightning Conductor (SABS)"));
//                                    }
//
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Surge protection (SANS)").equals("Yes")) {
//                                        uw_Questions.clickSurgeProtectionCheckBox(EH1.getCellValueSpecific(i, "Surge protection (SANS)"));
//                                    }
//                                    Thread.sleep(1000);
//                                    if (EH1.getCellValueSpecific(i, "Geo Tech / Eng Report ? ").equals("Yes")) {
//                                        uw_Questions.clickGEOTECHCheckBox(EH1.getCellValueSpecific(i, "Geo Tech / Eng Report ? "));
//                                    }
//
//
//
//                                    userDiary_Nav.clickUWQustionsTab();
//                                    // elementFunctionality.captureScreenshotOnDevice("UW Questions");
//                                    // captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//
//                                    //	uw_Questions.clickFireRetardantCheckBox();
//                                    //Thread.sleep(2000);
//                                    userDiary_Nav.clickBuildingsContentsNextButton();
//                                    Thread.sleep(2000);
//                                    //		userDiary_Nav.clickDeductiblesExcessesTab();
//
////									if ("Nil".equalsIgnoreCase("Nil")) {
////
////										optionalcover.selectbasicexcess();
////
////									}
//                                    if (EH1.getCellValueSpecific(i, "TC OBJECTIVE").equals("Excess")) {
//                                        buildingsAdditionalInfo.selectExcess("Yes", EH1.getCellValueSpecific(i, "Basic Excess"));
//                                    }
//                                    Thread.sleep(1000);
//                                    //elementFunctionality.captureScreenshotOnDevice("Excess");
//                                    //captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickBuildingsContentsNextButton();
//                                    householdContents_GeneralDetails.clickAddGeyserBtn();
//                                    householdContents_GeneralDetails.clickGeyserTypeDropDown();
//                                    householdContents_GeneralDetails.SelectOption(EH1.getCellValueSpecific(i, "Geyser Type"));
//                                    householdContents_GeneralDetails.enterNumberOfGeysers("1");
//                                    captureTestCaseScreenshotGeyser(i);
//                                    Thread.sleep(2000);
//                                    householdContents_GeneralDetails.clickSaveGeysers();
//                                    Thread.sleep(1000);
//                                    // elementFunctionality.captureScreenshotOnDevice("Geysers");
//                                    //captureTestCaseScreenshot(i);
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickBuildingsContentsNextButton();
//
//                                    userDiary_Nav.clickAutoRateButton();
//
//
//                                    Thread.sleep(9000);
//                                    userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                    Thread.sleep(1000);
//                                    //elementFunctionality.captureScreenshotOnDevice("Geysers");
//                                    // captureTestCaseScreenshot(i);
//                                    Thread.sleep(4000);
//                                    //  userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                    // userDiary_Nav.clickPopUpYes();
//                                    Motor_Vehicle_Details.clickMainButtonSave();
//                                    Thread.sleep(1000);
//                                    userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                    userDiary_Nav.clickPolicyHistoryPopUpOKButton();
//                                    Thread.sleep(9000);
//                                    DateFormat dateFormat111 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                                    Date dateend11 = new Date();
////									 // Now format the date
//                                    String date311 = dateFormat111.format(dateend11);
//                                    ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE " + i + "Passed");
//
//
//
//                                } catch (Exception e) {
//                                    DateFormat dateFormat11 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                                    Date dateend1 = new Date();
////									 // Now format the date
//                                    String date31 = dateFormat11.format(dateend1);
//
//                                    System.out.println(" ");
//                                    elementFunctionality.captureScreenshotOnDevice("");
//                                    ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE " + i + "Failed");
//                                    System.err.println("TEST CASE " + i + " Declined");
//                                    Thread.sleep(2000);
//                                    userDiary_Nav.goToHomePage();
//                                    System.out.println(" ");
//                                }
//
//                            }
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Assert.fail();
//
//
//                        }
//
//                    }
//
//                }
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//    }
//
//
//    @AfterTest
//    public void closeBrowser() throws Throwable {
//        try {
//            //Loop runs through all the Nodes in the Grid and performs the tests on them
//            for (Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet()) {
//                if (currentNode.getKey().equals(Device)) {
//                    //Android
//                    if (currentNode.getValue() instanceof AndroidNode) {
//                        try {
//
//
//                        } catch (Exception e) {
//                            Assert.fail();
//                            e.printStackTrace();
//
//
//                        }
//
//
//                    }
//
//
//                    //iOS
//                    else if (currentNode.getValue() instanceof IOSNode) {
//                        try {
//
//
//                        } catch (Exception e) {
//                            Assert.fail();
//                            e.printStackTrace();
//
//
//                        }
//
//
//                    }
//
//
//                    //Browsers
//                    else if (currentNode.getValue() instanceof BrowserNode) {
//                        try {
//
//
//                            testB.quit();
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Assert.fail();
//
//
//                        }
//
//
//                    }
//
//
//                }
//            }
//
//
//        } catch (Exception e) {
//            Assert.fail();
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public void write_Extracted_rule_to_Sheet(String FilePath, String SheetName, int rowNum, int colNum, String element) throws Exception {
//
//        try {
//
//
//            FileInputStream ExcelFile = new FileInputStream(FilePath);
//
//            // Access the required test data sheet
//
//            ExcelWBook = new XSSFWorkbook(ExcelFile);
//
//            ExcelWSheet = ExcelWBook.getSheet(SheetName);
//
//            int numRows = ExcelWSheet.getLastRowNum() + 1;
//
//            ExcelWSheet.getRow(rowNum).createCell(colNum).setCellValue(element);
//
//            ExcelWBook.write(new FileOutputStream(FilePath));
//
//            FileOutputStream fileOut = new FileOutputStream(FilePath);
//            ExcelWBook.write(fileOut);
//            fileOut.close();
//            ExcelWBook.close();
//            System.out.println("Completed writing extracted rule");
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something went wrong");
//        }
//
//
//    }
//
//
//    public void captureTestCaseScreenshotBuildingDetails(int i) {
//        String[] RatingInfoFields = new String[]{"Residence Type", "Roof Type", "Wall Type", "Cover Type", "Dwelling Type", "Dwelling Usage", "Type Of Premises", "Perimeter Wall", "Borders", "Occupancy ", "NCB" ,"Geyser Type"};
//        for (String RatingInfoField : RatingInfoFields) {
//            if (EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
//                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH1.getCellValue(Integer.toString(i), RatingInfoField));
//                break;
//            }
//        }
//    }
//    public void captureTestCaseScreenshotGeyser(int i) {
//        String[] RatingInfoFields = new String[]{"Geyser Type"};
//        for (String RatingInfoField : RatingInfoFields) {
//            if (EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
//                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE") + ", Selected option : " + EH1.getCellValue(Integer.toString(i), RatingInfoField));
//                break;
//            }
//        }
//    }
//
//    public void captureTestCaseScreenshot(int i, String value) {
//        String[] RatingInfoFields = new String[]{"Security Items","Endorsement ","UW Questions ","Geyser Type"};
//        for (String RatingInfoField : RatingInfoFields) {
//            if (EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
//                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + value + " " + ", Selected option : " + EH1.getCellValue(Integer.toString(i), value));
//                break;
//            }
//        }
//    }
//    public void captureTestCaseScreenshotExtensions(int i, String cover, String sumInsured) {
//        String[] RatingInfoFields = new String[]{"Optional Cover/Extensions "};
//        for (String RatingInfoField : RatingInfoFields) {
//            if (EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
//                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + cover + " " + ", Selected option : " +EH1.getCellValue(Integer.toString(i),cover)+" - Sum Insured - " +EH1.getCellValue(Integer.toString(i),sumInsured));
//                break;
//            }
//        }
//    }
//    public void captureTestCaseScreenshotExcess(int i, String cover, String sumInsured) {
//        String[] RatingInfoFields = new String[]{"Excess"};
//        for (String RatingInfoField : RatingInfoFields) {
//            if (EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE").equalsIgnoreCase(RatingInfoField)) {
//                elementFunctionality.captureScreenshotOnDevice("Field Name : " + EH1.getCellValue(Integer.toString(i), "TC OBJECTIVE") + " - " + cover + " " + ", Selected option : " + EH1.getCellValue(Integer.toString(i),sumInsured));
//                break;
//            }
//        }
//    }
//
//}
