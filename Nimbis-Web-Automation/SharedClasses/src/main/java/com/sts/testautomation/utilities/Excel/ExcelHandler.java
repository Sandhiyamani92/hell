package com.sts.testautomation.utilities.Excel;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.sts.testautomation.utilities.FailureUtil;
import com.sts.testautomation.utilities.Util;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelHandler {
    private List<ExcelData> data;
    private String sheetName = "";
    private String columnName = "";

    public ExcelHandler() {
    }

    public ExcelHandler(String sheet) {
        PoijiOptions options = getPoijiOptions(sheet);
        data = Poiji.fromExcel(new File(Util.DATA_PATH), ExcelData.class,options);
    }

    public ExcelHandler(String sheetName, String columnName) {
        this.sheetName = sheetName;
        this.columnName = columnName;

        PoijiOptions options = getPoijiOptions(sheetName);
        data = Poiji.fromExcel(new File(Util.DATA_PATH), ExcelData.class,options);
    }

    // So you can do something like : List<ExcelData> data = new ExcelHandler().getSheet("MySheet).getData();
    public ExcelHandler getSheet(String sheet) {
        PoijiOptions options = getPoijiOptions(sheet);
        data = Poiji.fromExcel(new File(Util.DATA_PATH), ExcelData.class,options);
        return this;
    }

    public ExcelHandler getSheet(String sheet, int headerRow) {
        PoijiOptions options = getPoijiOptions(sheet, headerRow);
        data = Poiji.fromExcel(new File(Util.DATA_PATH), ExcelData.class,options);
        return this;
    }

    private PoijiOptions getPoijiOptions(String sheetName) {
        return PoijiOptions.PoijiOptionsBuilder
                .settings()
                .sheetName(sheetName)
                .build();
    }

    private PoijiOptions getPoijiOptions(String sheetName, int headerRow) {
        return PoijiOptions.PoijiOptionsBuilder
                .settings()
                .sheetName(sheetName)
                .headerCount(headerRow)
                .build();
    }

    public List<ExcelData> getData() {
        return data;
    }

    public ExcelHandler setCellValue(String sheetName, String columnName, String value, int rowIndex) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(Util.DATA_PATH);
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheet(sheetName);

        HSSFRow headerRow = sheet.getRow(0);

        int colIndex = -1;
        for (Cell cell : headerRow) {
            String result = cell.getStringCellValue();
            if (result.equals(columnName)){
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        if (colIndex == -1) {
            throw new Exception("Could not find the column '"+columnName+"' on the sheet.");
        }

        HSSFRow row = sheet.getRow(rowIndex);
        System.out.println("Running test case " + row.getCell(0).toString());
        HSSFCell hSSFCell = row.getCell(colIndex);
        hSSFCell.setCellValue(value);

        fileInputStream.close();
        FileOutputStream outputStream = new FileOutputStream(Util.DATA_PATH);
        workbook.write(outputStream);
        outputStream.close();
        return this;
    }

    public ExcelHandler setCellValue(String sheetName, String columnName, String value, int rowIndex,int headerIndex) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(Util.DATA_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        XSSFRow headerRow = sheet.getRow(headerIndex);

        int colIndex = -1;
        for (Cell cell : headerRow) {
            String result = cell.getStringCellValue();
            if (result.equals(columnName)){
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        if (colIndex == -1) {
            throw new Exception("Could not find the column '"+columnName+"' on the sheet.");
        }

        XSSFRow row = sheet.getRow(rowIndex);
        System.out.println("Running test case " + row.getCell(0).toString());
        if (row.getCell(colIndex) == null) row.createCell(colIndex);
        XSSFCell hSSFCell = row.getCell(colIndex);
        hSSFCell.setCellValue(value);

        fileInputStream.close();
        FileOutputStream outputStream = new FileOutputStream(Util.DATA_PATH);
        workbook.write(outputStream);
        outputStream.close();
        return this;
    }

    public ExcelHandler setCellValue(String value, int rowIndex,int headerIndex) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(Util.DATA_PATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        XSSFRow headerRow = sheet.getRow(headerIndex);

        int colIndex = -1;
        for (Cell cell : headerRow) {
            String result = cell.getStringCellValue();
            if (result.equals(columnName)){
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        if (colIndex == -1) {
            throw new Exception("Could not find the column '"+columnName+"' on the sheet.");
        }

        XSSFRow row = sheet.getRow(rowIndex);
        System.out.println("Running test case " + row.getCell(0).toString());
        XSSFCell hSSFCell = row.getCell(colIndex);
        hSSFCell.setCellValue(value);

        fileInputStream.close();
        FileOutputStream outputStream = new FileOutputStream(Util.DATA_PATH);
        workbook.write(outputStream);
        outputStream.close();
        return this;
    }

//    public ExcelHandler setCellValueNoOverwrite(String sheetName, String columnName, String value, int rowIndex) {
//        try {
//            FileInputStream fileInputStream = new FileInputStream(Util.DATA_PATH);
//            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
//            HSSFSheet sheet = workbook.getSheet(sheetName);
//
//            HSSFRow headerRow = sheet.getRow(0);
//
//            int colIndex = -1;
//            for (Cell cell : headerRow) {
//                String result = cell.getStringCellValue();
//                if (result.equals(columnName)){
//                    colIndex = cell.getColumnIndex();
//                    break;
//                }
//            }
//
//            if (colIndex == -1) {
//                throw new Exception("Could not find the column '"+columnName+"' on the sheet.");
//            }
//
//            HSSFRow row = sheet.getRow(rowIndex);
//            while(!isRowEmpty(row)) { rowIndex++; }
//
//            System.out.println("Running test case " + row.getCell(0).toString());
//            HSSFCell hSSFCell = row.getCell(colIndex);
//            hSSFCell.setCellValue(value);
//
//            fileInputStream.close();
//            FileOutputStream outputStream = new FileOutputStream(Util.DATA_PATH);
//            workbook.write(outputStream);
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return this;
//    }

    private boolean isRowEmpty(XSSFRow row) {
        if (row == null) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public ExcelHandler logFailure(FailureUtil failureUtil) {
        try {
            FileInputStream fileInputStream = new FileInputStream(Util.DATA_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet("Error Report");

            int index = failureUtil.getRowIndex();

            XSSFRow row = sheet.getRow(index);

            while(row != null) {
                index++;
                row = sheet.getRow(index);
            }
            row = sheet.createRow(index);

            row.createCell(0);
            XSSFCell testCase = row.getCell(0);
            testCase.setCellValue(failureUtil.getRowIndex());

            row.createCell(1);
            XSSFCell date = row.getCell(1);
            date.setCellValue(failureUtil.getDate());

            row.createCell(2);
            XSSFCell time = row.getCell(2);
            time.setCellValue(failureUtil.getTime());

            row.createCell(3);
            XSSFCell description = row.getCell(3);
            description.setCellValue(failureUtil.getDescription());

            row.createCell(4);
            XSSFCell errorType = row.getCell(4);
            errorType.setCellValue(failureUtil.getError());

            row.createCell(5);
            XSSFCell message = row.getCell(5);
            message.setCellValue(failureUtil.getMessage());

            fileInputStream.close();
            FileOutputStream outputStream = new FileOutputStream(Util.DATA_PATH);
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
