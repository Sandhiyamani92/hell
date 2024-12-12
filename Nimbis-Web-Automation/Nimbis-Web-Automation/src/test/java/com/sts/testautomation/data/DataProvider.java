package com.sts.testautomation.data;

import com.sts.testautomation.utilities.Excel.ExcelData;
import com.sts.testautomation.utilities.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DataProvider {

    // private static final String userPath = System.getProperty("user.dir");

    @org.testng.annotations.DataProvider(name = "Create Clients")
    public static Object[][] getClientData() {
        Map<String, List<ExcelData>> clientData = new HashMap<>();

        Util.setDataPath("src/test/resources/data/Create Clients.xlsx");

        Util.setSheetName("Client Information");
        List<ExcelData> clientInformation = Util.getData();
        clientData.put("ClientInformation", clientInformation);

        return new Object[][]{{ clientData }};
    }

    @org.testng.annotations.DataProvider(name = "Motor Test Cases")
    public static Object[][] getMotorData() {
        Map<String, List<ExcelData>> motorData = new HashMap<>();

        Util.setDataPath("src/test/resources/data/new_test_cases/Motor Test Cases v1.3 - September 2021 vehicle values.xlsx");

        Util.setSheetName("Create Client");
        List<ExcelData> clientData = Util.getData();
        motorData.put("ClientData", clientData);

        Util.setSheetName("Test Cases");
        List<ExcelData> testCases = Util.getData();
        motorData.put("TestCases", testCases);

        return new Object[][]{{ motorData }};
    }

    @org.testng.annotations.DataProvider(name = "All Risk Test Cases")
    public static Object[][] getAllRiskData() {
        Map<String, List<ExcelData>> riskData = new HashMap<>();

        Util.setDataPath("src/test/resources/data/new_test_cases/All Risk Test Cases.xlsx");

        Util.setSheetName("Create Client");
        List<ExcelData> clientData = Util.getData();
        riskData.put("ClientData", clientData);

        Util.setSheetName("Test cases");
        List<ExcelData> testCases = Util.getData();
        riskData.put("TestCases", testCases);

        Util.setDataPath("src/test/resources/data/new_test_cases/Contents Test Cases.xlsx");

        Util.setSheetName("Test cases");
        List<ExcelData> contentData = Util.getData();
        riskData.put("ContentData", contentData);

        Util.setSheetName("Create Client");
        List<ExcelData> contentClientData = Util.getData();
        riskData.put("ContentClientData", contentClientData);

        // reset data path to All Risks
        Util.setDataPath("src/test/resources/data/new_test_cases/All Risk Test Cases.xlsx");

        return new Object[][]{{ riskData }};
    }

    @org.testng.annotations.DataProvider(name = "Contents Test Cases")
    public static Object[][] getContentsData() {
        Map<String, List<ExcelData>> contentsData = new HashMap<>();

        Util.setDataPath("src/test/resources/data/new_test_cases/Contents Test Cases.xlsx");

        Util.setSheetName("Create Client");
        List<ExcelData> clientData = Util.getData();
        contentsData.put("ClientData", clientData);

        Util.setSheetName("Test cases");
        List<ExcelData> houseHoldGoodsData = Util.getData();
        contentsData.put("HouseHoldGoodsData", houseHoldGoodsData);

        return new Object[][]{{ contentsData }};
    }

    @org.testng.annotations.DataProvider(name = "Building Test Cases")
    public static Object[][] getBuildingData() {
        Map<String, List<ExcelData>> buildingData = new HashMap<>();

        Util.setDataPath("src/test/resources/data/new_test_cases/Buildings Test Cases v1.1.xlsx");

        Util.setSheetName("Test cases");
        List<ExcelData> HouseOwnersData = Util.getData();
        buildingData.put("HouseOwnersData", HouseOwnersData);

        Util.setSheetName("Create Client");
        List<ExcelData> clientData = Util.getData();
        buildingData.put("ClientData", clientData);

        return new Object[][]{{ buildingData }};
    }
 }
