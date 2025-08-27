package NIMBIS_SharedClasses.deviceConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidNode extends Node
{
	private AndroidDriver<MobileElement> androidDriver;
	
	
	/**
	 * @return the androidDriver
	 */
	public AndroidDriver<MobileElement> getAndroidDriver() 
	{
		return androidDriver;
	}


	/**
	 * @param androidDriver the androidDriver to set
	 */
	public void setAndroidDriver(AndroidDriver<MobileElement> androidDriver) 
	{
		this.androidDriver = androidDriver;
	}


	public AndroidNode(AndroidDriver<MobileElement> AndroidDriver, DesiredCapabilities nodeCapabilities, String hostURL) 
	{
		super(nodeCapabilities,hostURL);
		setAndroidDriver(AndroidDriver);
	}

}
