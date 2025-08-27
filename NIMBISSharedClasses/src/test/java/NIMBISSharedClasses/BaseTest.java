package NIMBISSharedClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;
import NIMBIS_SharedClasses.deviceConfig.SetUpHashMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseTest 
{
    public WebDriverWait wait;
	public String url; 
	public HashMap<String,Node> SeleniumGrid;
	public SetUpHashMap HashSetup; 
	public String Device;
	public WebDriver testB;
	public 	AndroidDriver<MobileElement> testA;
	public IOSDriver<MobileElement> testI;

	public String Sheet;
	public int currentTestCase;
	public static int stopTestCase;
	public static int currentRow;
	
    public WebDriver getDriver() 
    {
    	WebDriver web = null;
		for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
		{
			if(currentNode.getKey().equals(Device))
			{
				//Android
				if(currentNode.getValue() instanceof AndroidNode)
				{
					
					
					web = returnAndoridDriver();
				}
			
				//iOS
				else if(currentNode.getValue() instanceof IOSNode)
				{
					
					web = returnIOSDriver();
				}
				//Browser
				else if(currentNode.getValue() instanceof BrowserNode)
				{
					
					web = returnWebDriver(); 
				}
				else
				{
					web = null;
				}
					
			}
		}
		return web;
		
        
    }
	public static String getExcelData(int rownum, int cellnum, int sheetnum) throws IOException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\NathanielS\\Documents\\GitHub\\qa-automation-nimbus\\src\\NIMBIS.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);

		String Text = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return Text;
	}

	public static String setExcelData(String sheetPath, int rowNum, int cellNum, String sheetName, String text)throws IOException {
		FileInputStream fis = new FileInputStream(sheetPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFCell cellToWrite = sheet.getRow(rowNum).getCell(cellNum);
		if(cellToWrite == null || cellToWrite.getCellType() == CellType.BLANK) {
			cellToWrite = sheet.getRow(rowNum).createCell(cellNum);
		}
		cellToWrite.setCellValue(text);
		FileOutputStream fileOutputStream = new FileOutputStream(sheetPath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();

		return sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
	}


	public AndroidDriver<MobileElement> returnAndoridDriver()
    {
    	return testA;
    }
    
    public IOSDriver<MobileElement> returnIOSDriver()
    {
    	return testI;
    }
    
    public WebDriver returnWebDriver()
    {
    	return testB;
    }
    
    @BeforeClass (description = "Initialize Grid")
    public void setup () 
    {
    	System.out.println("Initializing Nodes");
		
		SeleniumGrid = new HashMap<>();
		HashSetup = new SetUpHashMap(SeleniumGrid);
		
		try
		{
			
			HashSetup.SetUpBrowser();
			
			HashSetup.SetUpAndroidDevices();
			
			HashSetup.SetUpiOSDevices();
			
		}
		
		catch (Exception e) 
		{
			Assert.fail();
			e.printStackTrace();
		} 
    }

   
}
