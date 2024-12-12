package com.sts.testautomation.utilities;
 
import com.sts.testautomation.listeners.TestListener;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
 
import static org.testng.Assert.assertTrue;
 
public class ApplicationManager extends TestListener
{
	private WebDriverWait wait;
	public WebDriver BrowserDriver;
	public String Device;
	public ElementFunctionality verifyElement;
 
	public ApplicationManager(WebDriver BrowserDriver, String Device)
	{
		this.BrowserDriver = BrowserDriver;
		this.Device = Device;
		wait = new WebDriverWait(BrowserDriver,Duration.ofSeconds(50));
		verifyElement = new ElementFunctionality(BrowserDriver, Device);
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

 
				fullScreenShot = ((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.FILE);

 
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

 
				fullScreenShot = ((TakesScreenshot)BrowserDriver).getScreenshotAs(OutputType.FILE);

 
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