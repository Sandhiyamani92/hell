package com.sts.testautomation.utilities;

import com.sts.testautomation.utilities.Excel.ExcelData;
import com.sts.testautomation.utilities.Excel.ExcelHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public final class Util {

    public static String DATA_PATH = "";
    public static String SHEET_NAME = "";

    public static void setDataPath(String dataPath) {
        DATA_PATH = dataPath;
    }

    public static void setSheetName(String sheetName) {
        SHEET_NAME = sheetName;
    }

    public static List<ExcelData> getData() {
        return new ExcelHandler().getSheet(SHEET_NAME).getData();
    }

    public static List<ExcelData> getData(int headerRow) {
        return new ExcelHandler().getSheet(SHEET_NAME, headerRow).getData();
    }

    public static String base64Screenshot(WebDriver driver) {
        return "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
    }

    public static String getCurrentDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String getCurrentDate() {
        return getCurrentDateAndTime().split(" ")[0];
    }

    public static String getCurrentTime() {
        return getCurrentDateAndTime().split(" ")[1];
    }
}
