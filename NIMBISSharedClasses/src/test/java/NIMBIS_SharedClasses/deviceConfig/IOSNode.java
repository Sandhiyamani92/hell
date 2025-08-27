package NIMBIS_SharedClasses.deviceConfig;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class IOSNode extends Node
{
	private IOSDriver<MobileElement> iosDriver;
	
	public IOSDriver<MobileElement> getiOSDriver() 
	{
		return iosDriver;
	}

	public void setiOSDriver(IOSDriver<MobileElement> iosDriver) 
	{
		this.iosDriver = iosDriver;
	}


	public IOSNode(IOSDriver<MobileElement> IosDriver, DesiredCapabilities nodeCapabilities, String hostURL) 
	{
		super(nodeCapabilities,hostURL);
		setiOSDriver(IosDriver);
	}

}
