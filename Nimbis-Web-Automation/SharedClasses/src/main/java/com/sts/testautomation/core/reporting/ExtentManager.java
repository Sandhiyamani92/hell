package com.sts.testautomation.core.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports getExtentReports() {
        String workingDir = System.getProperty("user.dir");
        String time = LocalDateTime.now().toString().replace(":","-");
        ExtentSparkReporter reporter = new ExtentSparkReporter(workingDir + "/ExtentReports/ExtentReportResults_"+time+".html");
        reporter.config().setReportName("Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Client Name", "Hollard");
        extentReports.setSystemInfo("Author", "STS Holdings");
        return extentReports;
    }
}
