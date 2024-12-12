package com.sts.testautomation.core.tests;

import com.sts.testautomation.utilities.FailureUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.LocalDate;

public class BaseTest {

    private WebDriver driver;
    private WebDriver ieDriver;
    private WebDriver firefoxDriver;
    private WebDriver edgeDriver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("headless", "false");
        String headless = System.getProperty("headless");

        WebDriverManager.chromedriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();

        // ieDriver = new InternetExplorerDriver();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("--headless");
//            firefoxDriver = new FirefoxDriver(firefoxOptions);
//
//            EdgeOptions edgeOptions = new EdgeOptions();
//            // edgeOptions.addArguments("--headless");
//            edgeDriver = new EdgeDriver(edgeOptions);
        } else {
            driver = new ChromeDriver();
//            firefoxDriver = new FirefoxDriver();
//            edgeDriver = new EdgeDriver();
        }
    }

    @AfterSuite
    public void tearDown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }

//        if(ieDriver != null) {
//            ieDriver.close();
//            ieDriver.quit();
//        }
//
//        if(firefoxDriver != null) {
//            firefoxDriver.close();
//            firefoxDriver.quit();
//        }
//
//        if(edgeDriver != null) {
//            edgeDriver.close();
//            edgeDriver.quit();
//        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getIeDriver() {
        return ieDriver;
    }

    public WebDriver getFirefoxDriver() {
        return firefoxDriver;
    }

    public WebDriver getEdgeDriver() {
        return edgeDriver;
    }


}
