package com.sts.testautomation.deviceConfig;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import java.util.HashMap;

public class SetUpHashMap 
{
 
	private HashMap<String,Node> SeleniumGrid;
	private NodeCapability node = new NodeCapability();
	private WebDriver chromeDriver, firefoxDriver, operaDriver, edgeDriver, ieDriver, safariDriver;
	/**
	 * @return the seleniumGrid
	 */
	public HashMap<String, Node> getSeleniumGrid() {
		return SeleniumGrid;
	}
 
 
	/**
	 * @param seleniumGrid the seleniumGrid to set
	 */
	public void setSeleniumGrid(HashMap<String, Node> seleniumGrid) {
		SeleniumGrid = seleniumGrid;
	}
 
 
	//Constructor 
	public SetUpHashMap(HashMap<String,Node> SeleniumGrid) 
	{
		setSeleniumGrid(SeleniumGrid);
	}
	//Function for setting up the browsers
	public void SetUpBrowser() 
	{
		//Setting up the capabilities
		DesiredCapabilities ChromeCap = node.BrowserNodeCapability("chrome");
		DesiredCapabilities FireFoxCap = node.BrowserNodeCapability("firefox");
		DesiredCapabilities OperaCap = node.BrowserNodeCapability("opera");
		DesiredCapabilities IECap = node.BrowserNodeCapability("ie");
		DesiredCapabilities EdgeCap = node.BrowserNodeCapability("edge");
		DesiredCapabilities SafariCap = node.BrowserNodeCapability("safari");
		//operaOptions.setBinary("C:\\Selenium\\operadriver.exe");
		//OperaCap.merge(operaOptions);
		//Setting up the nodes
		BrowserNode chrome = new BrowserNode(chromeDriver, ChromeCap , "http://localhost:4899/wd/hub");
		BrowserNode firefox = new BrowserNode(firefoxDriver, FireFoxCap , "http://localhost:4900/wd/hub");
		BrowserNode opera = new BrowserNode(operaDriver, OperaCap , "http://localhost:4904/wd/hub");
		BrowserNode ie = new BrowserNode(ieDriver, IECap, "http://localhost:4902/wd/hub");
		BrowserNode edge = new BrowserNode(edgeDriver, EdgeCap , "http://localhost:4901/wd/hub");
		BrowserNode safari = new BrowserNode(safariDriver, SafariCap , "http://localhost:4898/wd/hub");
 
		
		//Adding the nodes to the HashMap
		SeleniumGrid.put("Safari", safari);
		SeleniumGrid.put("Chrome", chrome);
		SeleniumGrid.put("Firefox", firefox);
		SeleniumGrid.put("Opera", opera);
		SeleniumGrid.put("Internet Explorer", ie);
		SeleniumGrid.put("Microsoft Edge", edge);
	}
	//Function for setting up the Android Devices
 
}