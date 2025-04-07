package com.sts.testautomation.deviceConfig;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

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
