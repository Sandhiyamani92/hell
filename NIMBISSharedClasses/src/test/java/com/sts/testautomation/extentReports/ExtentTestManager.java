package com.sts.testautomation.extentReports;

import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestManager {
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }

    // Log methods with different status levels
    public static void logInfo(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logPass(String message) {
        getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public static void logFail(String message) {
        getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void logWarning(String message) {
        getTest().log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.ORANGE));
    }

    public static void logSkip(String message) {
        getTest().log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.GREY));
    }

    // Screenshot methods - CORRECTED SYNTAX
    public static void logInfoWithScreenshot(String message, String base64Screenshot) {
        try {
            getTest().log(Status.INFO, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            getTest().log(Status.INFO, message);
            getTest().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    public static void logPassWithScreenshot(String message, String base64Screenshot) {
        try {
            // Log with label first
            getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));

            // Then attach screenshot
            getTest().log(Status.PASS,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
            getTest().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    public static void logFailWithScreenshot(String message, String base64Screenshot) {
        try {
            getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
            getTest().log(Status.FAIL,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
            getTest().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
        }
    }

    // Method to add screenshot from path
    public static void addScreenshot(String screenshotPath) {
        try {
            getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            logWarning("Failed to attach screenshot: " + e.getMessage());
        }
    }

    // Method to assign categories
    public static void assignCategory(String... categories) {
        getTest().assignCategory(categories);
    }

    // Method to assign author
    public static void assignAuthor(String... authors) {
        getTest().assignAuthor(authors);
    }

    // Method to assign device
    public static void assignDevice(String device) {
        getTest().assignDevice(device);
    }

    // Additional helper methods for direct ExtentTest access
    public static void log(Status status, String details) {
        getTest().log(status, details);
    }

    public static void log(Status status, Throwable t) {
        getTest().log(status, t);
    }
}