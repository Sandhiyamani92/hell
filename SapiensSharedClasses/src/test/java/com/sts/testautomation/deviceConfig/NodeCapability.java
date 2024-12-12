package com.sts.testautomation.deviceConfig;
 
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import static org.openqa.selenium.remote.Browser.*;
 
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
				return new DesiredCapabilities(CHROME.browserName(), "", Platform.ANY);
				//return cap.merge(permission);
				
			
			}
			case "firefox":
			{
				return new DesiredCapabilities(FIREFOX.browserName(), "", Platform.ANY);
				//return cap.merge(permission);
			}
 
			case "edge":
			{
				return new DesiredCapabilities(EDGE.browserName(), "", Platform.ANY);
				//return cap.merge(permission);
			}
			case "safari":
			{
				return new DesiredCapabilities(SAFARI.browserName(), "", Platform.ANY);
				//return cap.merge(permission);
			}
		}
		return null;
		
		
	}
 
	
		
 
 
 
}