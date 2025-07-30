package com.sts.testautomation.utilities;
import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.sts.testautomation.deviceConfig.AndroidNode;
import com.sts.testautomation.deviceConfig.IOSNode;
import com.sts.testautomation.deviceConfig.Node;
import com.sts.testautomation.extentReports.ExtentTestManager;
import com.sts.testautomation.listeners.TestListener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ApplicationManager extends TestListener
{
	private WebDriverWait wait;
	public WebDriver BrowserDriver;
	public IOSDriver<MobileElement> IODriver;
	public String Device;
	public AndroidDriver<MobileElement> AndroidDriver;
	public ElementFunctionality verifyElement;

	public ApplicationManager(WebDriver BrowserDriver, String Device)
	{
		this.BrowserDriver = BrowserDriver;
		this.Device = Device;
		wait = new WebDriverWait(BrowserDriver,50);
		verifyElement = new ElementFunctionality(BrowserDriver, Device);

	}

	public ApplicationManager(IOSDriver<MobileElement> IODriver, String Device)
	{
		this.IODriver = IODriver;
		this.Device = Device;
		wait = new WebDriverWait(IODriver,50);
		verifyElement = new ElementFunctionality(IODriver, Device);
	}

	public ApplicationManager(AndroidDriver<MobileElement> AndroidDriver, String Device)
	{
		this.AndroidDriver = AndroidDriver;
		this.Device = Device;
		wait = new WebDriverWait(AndroidDriver,50);
		verifyElement = new ElementFunctionality(AndroidDriver, Device);
	}

	public void notificationRefresh()
	{

		int width = AndroidDriver.manage().window().getSize().getWidth();
		int height = AndroidDriver.manage().window().getSize().getHeight();

		Point topNav = new Point(width/2, 1);
		Point bottomNav = new Point(width/2,50);

		Point extremeBottom = new Point(width/2, height-1);

		try
		{

			Thread.sleep(5000);
			TouchAction action = new TouchAction(AndroidDriver);
			action.press(PointOption.point(topNav)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(bottomNav)).release().perform();

			/*int result = verifyElement.verifyBrowserElementValue(AndroidDriver.findElement(By.id("com.android.systemui:id/notification_panel")), "Notification Panel");

			if(result==0)
			{
				TouchAction actionUp = new TouchAction(AndroidDriver);
				action.press(PointOption.point(extremeBottom)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(topNav)).release().perform();
			}*/

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void iosLoginGesture()
	{

		int width = IODriver.manage().window().getSize().getWidth();
		int height = IODriver.manage().window().getSize().getHeight();

		Point fingerOne = new Point(width/4, height/2);
		Point fingerTwo = new Point((width/4)*3,height/2);
		int counter = 4;


		try
		{


			while(counter != 0)
			{
				TouchAction firstFinger = new TouchAction(IODriver);
				TouchAction secondFinger = new TouchAction(IODriver);

				firstFinger.press(PointOption.point(fingerOne)).release();
				secondFinger.press(PointOption.point(fingerTwo)).release();

				MultiTouchAction tap = new MultiTouchAction(IODriver);
				tap.add(firstFinger);
				tap.add(secondFinger);
				tap.perform();
				counter--;
			}
			IODriver.findElement(By.name("Test")).click();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void RewardsScrollGesture(WebElement RewardsDiv, String name)
	{
		verifyElement.verifyIOSElement(RewardsDiv, name);
		int width = 0;
		int height= 0;
		int elementWidth = RewardsDiv.getSize().getWidth();
		int elementHeight = RewardsDiv.getSize().getHeight();
		TouchAction action = null;

		try
		{
			Thread.sleep(2000);

			if(IODriver != null)
			{
				width = IODriver.manage().window().getSize().getWidth();
				height = IODriver.manage().window().getSize().getHeight();
				action = new TouchAction(IODriver);
			}


			Point Top = new Point((int)(width/2), (int) (height*0.3));
			Point Bottom = new Point((int)(RewardsDiv.getLocation().getX()+(elementWidth/2)), (int) (RewardsDiv.getLocation().getY()+(elementHeight/2)));

			//System.out.println("I got the points");

			action.press(PointOption.point(Bottom)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(Top)).release().perform();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

	public void RewardsScrollGestureDown(WebElement RewardsDiv, String name)
	{
		verifyElement.verifyIOSElement(RewardsDiv, name);
		int width = 0;
		int height= 0;
		int elementWidth = RewardsDiv.getSize().getWidth();
		int elementHeight = RewardsDiv.getSize().getHeight();
		TouchAction action = null;

		try
		{
			Thread.sleep(2000);

			if(IODriver != null)
			{
				width = IODriver.manage().window().getSize().getWidth();
				height = IODriver.manage().window().getSize().getHeight();
				action = new TouchAction(IODriver);
			}


			Point Top = new Point((int)(width/2), (int) (height*0.085));
			Point Bottom = new Point((int)(RewardsDiv.getLocation().getX()+(elementWidth/2)), (int) (RewardsDiv.getLocation().getY()+(elementHeight/2)));

			//System.out.println("I got the points");

			action.press(PointOption.point(Top)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(Bottom)).release().perform();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}


	public void VitalityActiveRewardsScrollUp()
	{
		int width = 0;
		int height= 0;

		TouchAction action = null;

		try
		{
			Thread.sleep(2000);

			if(IODriver != null)
			{
				width = IODriver.manage().window().getSize().getWidth();
				height = IODriver.manage().window().getSize().getHeight();
				action = new TouchAction(IODriver);
			}


			Point Top = new Point((int)(width/2), (int) (height*0.25));
			Point Bottom = new Point((int)(width/2), (int) (int) (height*0.78));

			action.press(PointOption.point(Bottom)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(Top)).release().perform();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}


	public void clickApplicationTask()
	{
		String Name = "Discovery task Tile";
		char OSVersion;
		int version = 0;

		try
		{


			AndroidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
			Thread.sleep(3000);
			OSVersion = AndroidDriver.getCapabilities().getCapability("platformVersion").toString().charAt(0);

			version = Character.getNumericValue(OSVersion);

			switch (version)
			{
				case 9:
				{
					WebElement element = AndroidDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Discovery']/android.view.View"));
					wait.until(ExpectedConditions.visibilityOf(element));
					assertTrue(element.getSize().getWidth()>0);

					element.click();
					System.out.println(Name+" was clicked on " + Device);
					break;
				}
				case 8:
				{
					WebElement element = AndroidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Discovery']"));
					wait.until(ExpectedConditions.visibilityOf(element));
					assertTrue(element.getSize().getWidth()>0);

					element.click();
					System.out.println(Name+" was clicked on " + Device);
					break;
				}

				case 7:
				{
					WebElement element = AndroidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Discovery']"));
					wait.until(ExpectedConditions.visibilityOf(element));
					assertTrue(element.getSize().getWidth()>0);

					element.click();
					System.out.println(Name+" was clicked on " + Device);
					break;
				}
				case 4:
				{
					WebElement element = AndroidDriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='Discovery']/android.widget.ImageView"));
					wait.until(ExpectedConditions.visibilityOf(element));
					assertTrue(element.getSize().getWidth()>0);

					element.click();
					System.out.println(Name+" was clicked on " + Device);
					break;
				}



				default:
					break;
			}



		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, Name+" element could not be clicked on " + Device);
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}


	}




	public void refreshApplication(Node node)
	{

		try
		{

			if(node instanceof AndroidNode)
			{
				AndroidDriver.runAppInBackground(Duration.ofSeconds(5));
				//AndroidDriver.startActivity(new Activity(node.getNodeCapabilities().getCapability("appPackage").toString(), node.getNodeCapabilities().getCapability("appActivity").toString()));
				AndroidDriver.startActivity(new Activity(node.getNodeCapabilities().getCapability("appPackage").toString(), node.getNodeCapabilities().getCapability("appActivity").toString()));
			}
			else if(node instanceof IOSNode)
			{
				/*IODriver.runAppInBackground(Duration.ofSeconds(10));
				IODriver.startActivity(new Acti);*/
			}
			else
			{

			}
		}
		catch (Exception e)
		{
			e.getStackTrace();
		}


	}

	public File getElementScreenShot(WebElement element, String name)
	{
		File screenshotLocation = null;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			File fullScreenShot;
			BufferedImage fullImage;
			// Get the location of element on the page
			Point elementPoint= element.getLocation();

			// Get width and height of the element
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();


			if(AndroidDriver != null)
			{
				fullScreenShot = ((TakesScreenshot)AndroidDriver).getScreenshotAs(OutputType.FILE);

			}

			else if(IODriver != null)
			{
				fullScreenShot = ((TakesScreenshot)IODriver).getScreenshotAs(OutputType.FILE);
			}

			else
			{
				fullScreenShot = ((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.FILE);
			}


			fullImage = ImageIO.read(fullScreenShot);

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage elementScreenshot= fullImage.getSubimage(elementPoint.getX(), elementPoint.getY(),elementWidth, elementHeight);
			ImageIO.write(elementScreenshot, "png", fullScreenShot);

			// Copy the element screenshot to disk
			screenshotLocation = new File("src/data/"+Device+name+".png");
			FileUtils.copyFile(fullScreenShot, screenshotLocation);
			System.out.println("Screenshot of " + name + " successfully captured on "+Device);

		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			System.out.println("Unable to capture Screenshot of " + name + " on "+Device);
		}

		return screenshotLocation;

	}

	public File getReducedElementScreenShot(WebElement element, double percentageRequired, String name)
	{
		File screenshotLocation = null;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			assertTrue(element.getSize().getWidth()>0);
			File fullScreenShot;
			BufferedImage fullImage;
			// Get the location of element on the page
			Point elementPoint= element.getLocation();

			// Get width and height of the element
			int elementWidth = element.getSize().getWidth();
			int elementHeight = element.getSize().getHeight();

			//Get the size of the new image
			int reducedWidth = (int)(elementWidth*(percentageRequired/100));
			int reducedHeight = (int)(elementHeight*(percentageRequired/100));

			//Get the distance from the starting point to the required size
			int heightDifference = (int)((((100-percentageRequired)/100)*elementHeight)/2);
			int widthDifference = (int)((((100-percentageRequired)/100)*elementWidth)/2);

			//Get the new X and Y starting Coordinates
			int newXPoint = elementPoint.getX()+widthDifference;
			int newYPoint = elementPoint.getY()+heightDifference;


			if(AndroidDriver != null)
			{
				fullScreenShot = ((TakesScreenshot)AndroidDriver).getScreenshotAs(OutputType.FILE);

			}

			else if(IODriver != null)
			{
				fullScreenShot = ((TakesScreenshot)IODriver).getScreenshotAs(OutputType.FILE);
			}

			else
			{
				fullScreenShot = ((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.FILE);
			}


			fullImage = ImageIO.read(fullScreenShot);

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage elementScreenshot= fullImage.getSubimage(newXPoint, newYPoint,reducedWidth, reducedHeight);
			ImageIO.write(elementScreenshot, "png", fullScreenShot);

			// Copy the element screenshot to disk
			screenshotLocation = new File("src/data/"+Device+name+".png");
			FileUtils.copyFile(fullScreenShot, screenshotLocation);
			System.out.println("Screenshot of " + name + " successfully captured on "+Device);

		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			System.out.println("Unable to capture Screenshot of " + name + " on "+Device);
		}

		return screenshotLocation;

	}

}
