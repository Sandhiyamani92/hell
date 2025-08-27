package NIMBIS_SharedClasses.deviceConfig;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class SetUpHashMap 
{

	private HashMap<String,Node> SeleniumGrid;
	private NodeCapability node = new NodeCapability();
	private WebDriver chromeDriver, firefoxDriver, edgeDriver, ieDriver, safariDriver;
	private AndroidDriver<MobileElement> A3Driver, A8Driver, GalaxyTabEDriver, GalaxyTab4Driver,S8Driver, VodafoneVFD1100Driver,S4MiniDriver, LenovoK80MDriver,P8LiteDriver,P8LitePersonalDriver,P10Driver,S3Driver;
	private IOSDriver<MobileElement> i6Driver, i8Driver, iXDriver,iPadProDriver, iPad3Driver, iPad2MiniDriver;
	
	
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
		DesiredCapabilities IECap = node.BrowserNodeCapability("ie");
		DesiredCapabilities EdgeCap = node.BrowserNodeCapability("edge");
		DesiredCapabilities SafariCap = node.BrowserNodeCapability("safari");
		
		//Setting up the nodes
		BrowserNode chrome = new BrowserNode(chromeDriver, ChromeCap , "http://localhost:4899/wd/hub");
		BrowserNode firefox = new BrowserNode(firefoxDriver, FireFoxCap , "http://localhost:4900/wd/hub");
		BrowserNode ie = new BrowserNode(ieDriver, IECap, "http://localhost:4902/wd/hub");
		BrowserNode edge = new BrowserNode(edgeDriver, EdgeCap , "http://localhost:4901/wd/hub");
		BrowserNode safari = new BrowserNode(safariDriver, SafariCap , "http://localhost:4898/wd/hub");
		
		//Adding the nodes to the HashMap
		SeleniumGrid.put("Safari", safari);
		SeleniumGrid.put("Chrome", chrome);
		SeleniumGrid.put("Firefox", firefox);
		SeleniumGrid.put("Internet Explorer", ie);
		SeleniumGrid.put("Microsoft Edge", edge);
	}
	
	//Function for setting up the Android Devices
	public void SetUpAndroidDevices() 
	{
		//Declaration of Android Device Capabilities
		DesiredCapabilities A8Cap = node.MobileNodeCapability("5200a8415e92c457", "9.0","8106");
		DesiredCapabilities A3Cap = node.MobileNodeCapability("5203f666522da3fb", "7.0","8107");
		DesiredCapabilities GalaxyTabECap= node.MobileNodeCapability("3100489d924aa400", "4.4.4","8108");
		DesiredCapabilities GalaxyTab4Cap= node.MobileNodeCapability("0ae366cc", "5.0.2","8109");
		DesiredCapabilities S8Cap= node.MobileNodeCapability("ce081718e0aa331402", "8.0","8110");
		DesiredCapabilities VodafoneVFD1100Cap= node.MobileNodeCapability("W4QSNB7DQ485PFZD", "6.0","8111");
		DesiredCapabilities S4MiniCap= node.MobileNodeCapability("e215ee01", "4.2.2","8112");
		DesiredCapabilities LenovoK80MCap= node.MobileNodeCapability("MedfieldD9D18832", "4.4.4","8113");
		DesiredCapabilities P8LiteCap= node.MobileNodeCapability("57U7N18122002017", "8.0","8114");
		DesiredCapabilities P8LitePersonalCap= node.MobileNodeCapability("57U7N17A27007146", "8.0","8115");
		DesiredCapabilities P10Cap= node.MobileNodeCapability("6PQ0217C05000769", "9.0","8116");
		DesiredCapabilities S3Cap= node.MobileNodeCapability("7a68534b", "7.0","8117");
		
		//Firefox Capabilities for Android
		DesiredCapabilities A8CapFireFox = node.MobileBrowserNodeCapability("5200a8415e92c457", "7.1.1","firefox");
		DesiredCapabilities A3CapFireFox = node.MobileBrowserNodeCapability("5203f666522da3fb", "7.0","firefox");
		DesiredCapabilities GalaxyTabECapFireFox= node.MobileBrowserNodeCapability("3100489d924aa400", "4.4.4","firefox");
		DesiredCapabilities GalaxyTab4CapFireFox= node.MobileBrowserNodeCapability("0ae366cc", "5.0.2","firefox");
		DesiredCapabilities S8CapFireFox= node.MobileBrowserNodeCapability("ce081718e0aa331402", "8.0","firefox");
		DesiredCapabilities VodafoneVFD1100CapFireFox= node.MobileBrowserNodeCapability("W4QSNB7DQ485PFZD", "6.0","firefox");
		DesiredCapabilities S4MiniCapFireFox= node.MobileBrowserNodeCapability("e215ee01", "4.2.2","firefox");
		DesiredCapabilities LenovoK80MCapFireFox= node.MobileBrowserNodeCapability("MedfieldD9D18832", "4.4.4","firefox");
		DesiredCapabilities P8LiteCapFireFox= node.MobileBrowserNodeCapability("57U7N18122002017", "7.0","firefox");
		DesiredCapabilities P8LitePersonalCapFireFox= node.MobileBrowserNodeCapability("57U7N17A27007146", "7.0","firefox");
		DesiredCapabilities P10CapFireFox= node.MobileBrowserNodeCapability("6PQ0217C05000769", "8.0","firefox");
		DesiredCapabilities S3CapFireFox= node.MobileBrowserNodeCapability("7a68534b", "7.0","firefox");
		
		//Chrome Capabilities for Android
		DesiredCapabilities A8CapChrome = node.MobileBrowserNodeCapability("5200a8415e92c457", "7.1.1","chrome");
		DesiredCapabilities A3CapChrome = node.MobileBrowserNodeCapability("5203f666522da3fb", "7.0","chrome");
		DesiredCapabilities GalaxyTabECapChrome= node.MobileBrowserNodeCapability("3100489d924aa400", "4.4.4","chrome");
		DesiredCapabilities GalaxyTab4CapChrome= node.MobileBrowserNodeCapability("0ae366cc", "5.0.2","chrome");
		DesiredCapabilities S8CapChrome= node.MobileBrowserNodeCapability("ce081718e0aa331402", "8.0","chrome");
		DesiredCapabilities VodafoneVFD1100CapChrome= node.MobileBrowserNodeCapability("W4QSNB7DQ485PFZD", "6.0","chrome");
		DesiredCapabilities S4MiniCapChrome= node.MobileBrowserNodeCapability("e215ee01", "4.2.2","chrome");
		DesiredCapabilities LenovoK80MCapChrome= node.MobileBrowserNodeCapability("MedfieldD9D18832", "4.4.4","chrome");
		DesiredCapabilities P8LiteCapChrome= node.MobileBrowserNodeCapability("57U7N18122002017", "7.0","chrome");
		DesiredCapabilities P8LitePersonalCapChrome= node.MobileBrowserNodeCapability("57U7N17A27007146", "8.0","chrome");
		DesiredCapabilities P10CapChrome= node.MobileBrowserNodeCapability("6PQ0217C05000769", "8.0","chrome");
		DesiredCapabilities S3CapChrome= node.MobileBrowserNodeCapability("7a68534b", "7.0","chrome");

	
		//Initializing of android nodes
		AndroidNode A8 = new AndroidNode(A8Driver, A8Cap, "http://localhost:4893/wd/hub");
		AndroidNode A3 = new AndroidNode(A3Driver, A3Cap, "http://localhost:4888/wd/hub");
		AndroidNode GalaxyTabE = new AndroidNode(GalaxyTabEDriver, GalaxyTabECap, "http://localhost:4896/wd/hub");
		AndroidNode GalaxyTab4 = new AndroidNode(GalaxyTab4Driver, GalaxyTab4Cap, "http://localhost:4887/wd/hub");
		AndroidNode S8 = new AndroidNode(S8Driver, S8Cap, "http://localhost:4882/wd/hub");
		AndroidNode VodafoneVFD1100= new AndroidNode(VodafoneVFD1100Driver, VodafoneVFD1100Cap, "http://localhost:4889/wd/hub");
		AndroidNode S4Mini= new AndroidNode(S4MiniDriver, S4MiniCap, "http://localhost:4890/wd/hub");
		AndroidNode LenovoK80M= new AndroidNode(LenovoK80MDriver, LenovoK80MCap, "http://localhost:4891/wd/hub");
		AndroidNode P8Lite= new AndroidNode(P8LiteDriver, P8LiteCap, "http://localhost:4894/wd/hub");
		AndroidNode P8LitePersonal= new AndroidNode(P8LitePersonalDriver, P8LitePersonalCap, "http://localhost:6666/wd/hub");
		AndroidNode P10= new AndroidNode(P10Driver, P10Cap, "http://localhost:4895/wd/hub");
		AndroidNode S3= new AndroidNode(S3Driver, S3Cap, "http://localhost:4897/wd/hub");
		
		
		//Initializing of Firefox android nodes
		AndroidNode A8FireFox = new AndroidNode(A8Driver, A8CapFireFox, "http://localhost:4893/wd/hub");
		AndroidNode A3FireFox = new AndroidNode(A3Driver, A3CapFireFox, "http://localhost:4888/wd/hub");
		AndroidNode GalaxyTabEFireFox = new AndroidNode(GalaxyTabEDriver, GalaxyTabECapFireFox, "http://localhost:4896/wd/hub");
		AndroidNode GalaxyTab4FireFox = new AndroidNode(GalaxyTab4Driver, GalaxyTab4CapFireFox, "http://localhost:4887/wd/hub");
		AndroidNode S8FireFox = new AndroidNode(S8Driver, S8CapFireFox, "http://localhost:4882/wd/hub");
		AndroidNode VodafoneVFD1100FireFox= new AndroidNode(VodafoneVFD1100Driver, VodafoneVFD1100CapFireFox, "http://localhost:4889/wd/hub");
		AndroidNode S4MiniFireFox= new AndroidNode(S4MiniDriver, S4MiniCapFireFox, "http://localhost:4890/wd/hub");
		AndroidNode LenovoK80MFireFox= new AndroidNode(LenovoK80MDriver, LenovoK80MCapFireFox, "http://localhost:4891/wd/hub");
		AndroidNode P8LiteFireFox= new AndroidNode(P8LiteDriver, P8LiteCapFireFox, "http://localhost:4894/wd/hub");
		AndroidNode P8LitePersonalFireFox= new AndroidNode(P8LitePersonalDriver, P8LitePersonalCapFireFox, "http://localhost:6666/wd/hub");
		AndroidNode P10FireFox= new AndroidNode(P10Driver, P10CapFireFox, "http://localhost:4895/wd/hub");
		AndroidNode S3FireFox= new AndroidNode(S3Driver, S3CapFireFox, "http://localhost:4897/wd/hub");
		
		//Initializing of Chrome android nodes
		AndroidNode A8Chrome = new AndroidNode(A8Driver, A8CapChrome, "http://localhost:4893/wd/hub");
		AndroidNode A3Chrome = new AndroidNode(A3Driver, A3CapChrome, "http://localhost:4888/wd/hub");
		AndroidNode GalaxyTabEChrome = new AndroidNode(GalaxyTabEDriver, GalaxyTabECapChrome, "http://localhost:4896/wd/hub");
		AndroidNode GalaxyTab4Chrome = new AndroidNode(GalaxyTab4Driver, GalaxyTab4CapChrome, "http://localhost:4887/wd/hub");
		AndroidNode S8Chrome = new AndroidNode(S8Driver, S8CapChrome, "http://localhost:4882/wd/hub");
		AndroidNode VodafoneVFD1100Chrome= new AndroidNode(VodafoneVFD1100Driver, VodafoneVFD1100CapChrome, "http://localhost:4889/wd/hub");
		AndroidNode S4MiniChrome= new AndroidNode(S4MiniDriver, S4MiniCapChrome, "http://localhost:4890/wd/hub");
		AndroidNode LenovoK80MChrome= new AndroidNode(LenovoK80MDriver, LenovoK80MCapChrome, "http://localhost:4891/wd/hub");
		AndroidNode P8LiteChrome= new AndroidNode(P8LiteDriver, P8LiteCapChrome, "http://localhost:4894/wd/hub");
		AndroidNode P8LitePersonalChrome= new AndroidNode(P8LitePersonalDriver, P8LitePersonalCapChrome, "http://localhost:6666/wd/hub");
		AndroidNode P10Chrome= new AndroidNode(P10Driver, P10CapChrome, "http://localhost:4895/wd/hub");
		AndroidNode S3Chrome= new AndroidNode(S3Driver, S3CapChrome, "http://localhost:4897/wd/hub");
		
		//Adding the Android nodes to the HashMap
		SeleniumGrid.put("Samsung A8", A8);
		SeleniumGrid.put("Samsung A3", A3);
		SeleniumGrid.put("Samsung Galaxy Tab E", GalaxyTabE);
		SeleniumGrid.put("Samsung Galaxy Tab 4", GalaxyTab4);
		SeleniumGrid.put("Samsung S8", S8);
		SeleniumGrid.put("Vodafone VFD 1100", VodafoneVFD1100);
		SeleniumGrid.put("Samsung S4 Mini", S4Mini);
		SeleniumGrid.put("Lenovo K80M", LenovoK80M);
		SeleniumGrid.put("Huawei P8Lite", P8Lite);
		SeleniumGrid.put("Huawei P8LitePersonal", P8LitePersonal);
		SeleniumGrid.put("Huawei P10", P10);
		SeleniumGrid.put("Samsung S3", S3);
		
		
		//Adding the Android Firefox nodes to the HashMap
		SeleniumGrid.put("Samsung A8 FireFox", A8FireFox);
		SeleniumGrid.put("Samsung A3 FireFox", A3);
		SeleniumGrid.put("Samsung Galaxy Tab E FireFox", GalaxyTabE);
		SeleniumGrid.put("Samsung Galaxy Tab 4 FireFox", GalaxyTab4);
		SeleniumGrid.put("Samsung S8 FireFox", S8FireFox);
		SeleniumGrid.put("Vodafone VFD 1100 FireFox", VodafoneVFD1100FireFox);
		SeleniumGrid.put("Samsung S4 Mini FireFox", S4MiniFireFox);
		SeleniumGrid.put("Lenovo K80M FireFox", LenovoK80MFireFox);
		SeleniumGrid.put("Huawei P8Lite FireFox", P8LiteFireFox);
		SeleniumGrid.put("Huawei P8LitePersonal FireFox", P8LitePersonalFireFox);
		SeleniumGrid.put("Huawei P10 FireFox", P10FireFox);
		SeleniumGrid.put("Samsung S3 FireFox", S3FireFox);
		
		//Adding the Android Chrome nodes to the HashMap
		SeleniumGrid.put("Samsung A8 Chrome", A8Chrome);
		SeleniumGrid.put("Samsung A3 Chrome", A3Chrome);
		SeleniumGrid.put("Samsung Galaxy Tab E Chrome", GalaxyTabEChrome);
		SeleniumGrid.put("Samsung Galaxy Tab 4 Chrome", GalaxyTab4Chrome);
		SeleniumGrid.put("Samsung S8 Chrome", S8Chrome);
		SeleniumGrid.put("Vodafone VFD 1100 Chrome", VodafoneVFD1100Chrome);
		SeleniumGrid.put("Samsung S4 Mini Chrome", S4MiniChrome);
		SeleniumGrid.put("Lenovo K80M Chrome", LenovoK80MChrome);
		SeleniumGrid.put("Huawei P8Lite Chrome", P8LiteChrome);
		SeleniumGrid.put("Huawei P8LitePersonal Chrome", P8LitePersonalChrome);
		SeleniumGrid.put("Huawei P10 Chrome", P10Chrome);
		SeleniumGrid.put("Samsung S3 Chrome", S3Chrome);
		
		
	}
	
	//Function for setting up the iOS Devices
		public void SetUpiOSDevices() 
		{
			//Declaration of iOS Device Capabilities
			DesiredCapabilities i6Cap = node.iOSNodeCapability("b7e530fa536c90fc70a735f508aba86dc2db2d15", "12.1.4","8102");
			DesiredCapabilities i8Cap = node.iOSNodeCapability("bd1640842b203ea6a53142ba7ea856ba79b292e7", "12.2","8101");
			DesiredCapabilities iXCap = node.iOSNodeCapability("17f29e34ea842488887ff00d569cf6e891f96380", "12.1","8100");
			DesiredCapabilities iPadproCap = node.iOSNodeCapability("27535b2500a679f3dae8b30ef63001229d99262c", "11.1.2","8106");
			DesiredCapabilities iPad3Cap = node.iOSNodeCapability("d71b26273d0513cd78b8ee71792f577cd6ef0b5e", "9.3.5","8103");
			DesiredCapabilities iPad2MiniCap = node.iOSNodeCapability("77729f2253a7784592a927305302e57262447f22", "9.3.5","8105");
			
			//Declaration of iOS Device Capabilities for mobile browser
			DesiredCapabilities i6CapSafari = node.iOSNodeCapabilityBrowser("b7e530fa536c90fc70a735f508aba86dc2db2d15", "12.1.4","8102", "Safari","27754");
			DesiredCapabilities i8CapSafari = node.iOSNodeCapabilityBrowser("bd1640842b203ea6a53142ba7ea856ba79b292e7", "12.1.4","8101", "Safari","27755");
			DesiredCapabilities iXCapSafari = node.iOSNodeCapabilityBrowser("17f29e34ea842488887ff00d569cf6e891f96380", "12.1","8100", "Safari","27756");
			DesiredCapabilities iPadproCapSafari = node.iOSNodeCapabilityBrowser("27535b2500a679f3dae8b30ef63001229d99262c", "11.1.2","8106", "Safari","27757");
			DesiredCapabilities iPad3CapSafari = node.iOSNodeCapabilityBrowser("d71b26273d0513cd78b8ee71792f577cd6ef0b5e", "9.3.5","8103", "Safari","27758");
			DesiredCapabilities iPad2MiniCapSafari = node.iOSNodeCapabilityBrowser("77729f2253a7784592a927305302e57262447f22", "9.3.5","8105", "Safari","27758");
			
			//Initializing iOS nodes
			IOSNode i8 = new IOSNode(i8Driver,i8Cap, "http://localhost:4881/wd/hub");
			IOSNode iX = new IOSNode(iXDriver,iXCap, "http://localhost:4880/wd/hub");
			IOSNode i6 = new IOSNode(i6Driver,i6Cap, "http://localhost:4883/wd/hub");
			IOSNode ipadPro = new IOSNode(iPadProDriver,iPadproCap, "http://localhost:4892/wd/hub");
			IOSNode iPad3 = new IOSNode(iPad3Driver,iPad3Cap, "http://localhost:4884/wd/hub");
			IOSNode iPad2Mini = new IOSNode(iPad2MiniDriver,iPad2MiniCap, "http://localhost:4886/wd/hub");
			
			//Initializing iOS nodes for mobile browser
			IOSNode i8Safari = new IOSNode(i8Driver,i8CapSafari, "http://localhost:4881/wd/hub");
			IOSNode iXSafari = new IOSNode(iXDriver,iXCapSafari, "http://localhost:4880/wd/hub");
			IOSNode i6Safari = new IOSNode(i6Driver,i6CapSafari, "http://localhost:4883/wd/hub");
			IOSNode ipadProSafari = new IOSNode(iPadProDriver,iPadproCapSafari, "http://localhost:4892/wd/hub");
			IOSNode iPad3Safari = new IOSNode(iPad3Driver,iPad3CapSafari, "http://localhost:4884/wd/hub");
			IOSNode iPad2MiniSafari= new IOSNode(iPad2MiniDriver,iPad2MiniCapSafari, "http://localhost:4886/wd/hub");
			
			//Adding the iOS nodes to the HashMap
			SeleniumGrid.put("iPhone 8", i8);
			SeleniumGrid.put("iPhone 6", i6);
			SeleniumGrid.put("iPhone X", iX);
			SeleniumGrid.put("iPad Pro", ipadPro);
			SeleniumGrid.put("iPad 3", iPad3);
			SeleniumGrid.put("iPad 2 Mini", iPad2Mini);
			
			//Adding the iOS nodes to the HashMap for mobile browser
			SeleniumGrid.put("iPhone 8 Safari", i8Safari);
			SeleniumGrid.put("iPhone 6 Safari", i6Safari);
			SeleniumGrid.put("iPhone X Safari", iXSafari);
			SeleniumGrid.put("iPad Pro Safari", ipadProSafari);
			SeleniumGrid.put("iPad 3 Safari", iPad3Safari);
			SeleniumGrid.put("iPad 2 Mini Safari", iPad2MiniSafari);
		}
}
