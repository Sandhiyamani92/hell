package com.sts.testautomation.deviceConfig;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class NodeCapability
{

	private DesiredCapabilities cap;
	
	public NodeCapability() 
	{
		cap = new DesiredCapabilities();
	}
	//Setting the capabilities for browsers
	public DesiredCapabilities BrowserNodeCapability(String Browser) 
	{
		//DesiredCapabilities permission = new DesiredCapabilities();
		//permission.setCapability("autoGrantPermissions", true);
		
		switch(Browser)
		{
			case "chrome":
			{
				return cap.chrome();
				//return cap.merge(permission);
				
			
			}
			case "firefox":
			{
				return cap.firefox();
				//return cap.merge(permission);
			}
			case "ie":
			{
				return cap.internetExplorer();
				//return cap.merge(permission);
			}
			case "edge":
			{
				return cap.edge();
				//return cap.merge(permission);
			}
			case "safari":
			{
				return cap.safari();
				//return cap.merge(permission);
			}
		}
		return null;
		
		
	}
	
	//Setting the capabilities for Android devices
	public DesiredCapabilities MobileNodeCapability(String deviceName, String platformVersion, String port) 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.UDID, deviceName);
		//caps.setCapability(MobileCapabilityType.APP, "https://bitrise-prod-build-storage.s3.amazonaws.com/builds/573f78c7cb555c46/artifacts/16172903/discoveryConsumerApp-discovery-qa-bitrise-signed.apk?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIV2YZWMVCNWNR2HA%2F20190531%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190531T101805Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=3c539a94a771fcf55a54b6d03ff5e8af9c152940cea7fb368f2187a88ec899aa");
		caps.setCapability("appPackage", "za.co.discovery.consumer");
		caps.setCapability("appActivity", "za.co.discovery.consumer.activity.common.StartActivity");
		caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, port);
		caps.setCapability("autoGrantPermissions", true);
		caps.setCapability(MobileCapabilityType.NO_RESET, false);
	
		return caps;
		
		
	}
	
	//Setting the capabilities for iOS devices
	public DesiredCapabilities iOSNodeCapability(String deviceName, String platformVersion, String port) 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		caps.setCapability(MobileCapabilityType.NO_RESET, false);
		caps.setCapability(MobileCapabilityType.UDID, deviceName);
		//caps.setCapability("autoAcceptAlerts", true);
		caps.setCapability("buildID","za.co.discovery.Discovery101");
		caps.setCapability("app", "/Users/STS/Desktop/sts/Discovery.ipa");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		caps.setCapability("xcodeOrgId", "393KS45LJ6");
		caps.setCapability("xcodeSigningId", "iPhone Developer");
		caps.setCapability("wdaLocalPort",port);
		return caps;
	}
	
	//Setting the capabilities for Browser on Android devices
	public DesiredCapabilities MobileBrowserNodeCapability(String deviceName, String platformVersion, String BrowserName) 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserName);
		caps.setCapability(MobileCapabilityType.UDID, deviceName);
		caps.setCapability("autoAcceptAlerts", true);
		
		return caps;
		
		
	}
	
	//Setting the capabilities for Browser on iOS device Browser
	public DesiredCapabilities iOSNodeCapabilityBrowser(String deviceName, String platformVersion, String port, String Browser, String iwdp) 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		caps.setCapability(MobileCapabilityType.NO_RESET, "true");
		caps.setCapability(MobileCapabilityType.UDID, deviceName);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, Browser);
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		caps.setCapability("startIWDP",true);
		caps.setCapability("webkitDebugProxyPort",iwdp);
		caps.setCapability("xcodeOrgId", "393KS45LJ6");
		caps.setCapability("xcodeSigningId", "iPhone Developer");
		caps.setCapability("wdaLocalPort",port);
		//caps.setCapability("autoAcceptAlerts", true);
		return caps;
	}
	
	
		



}
